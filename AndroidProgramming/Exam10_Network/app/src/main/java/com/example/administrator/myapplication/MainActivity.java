package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView lightList;
    private LightAdapter lightAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {        /* button 클릭했을때 이미지 변경 */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Light light = (Light) lightAdapter.getItem(position);

                AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(Void... params) {
                        return getBitmap(light.getImageLargeFileName());
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        imageLarge.setImageBitmap(bitmap);
                    }
                };
                asyncTask.execute();
            }
        });

        testAsyncTask();
        fillItems();
    }

    public void testAsyncTask() {

        Log.i("mylog", "1 : " + Thread.currentThread().getName());              // main 스레드

        /* 아무 타입이 아닌 일반적인 형태의 변수 선언 */
        /* 첫번째 Void 는 doInBackground 의 매개변수 타입, asyncTask.execute("실행매개값") 결정 */
        /* 두번째 Void 는 publishProgress 의 타입, onProgressUpdate 의 매개변수타입 결정  */
        /* 세번째 Void(타입파라미터) 가 doInBackground 의 리턴 타입, onPostExecute 의 매개변수 타입을 결정 */
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {                    /* 백그라운드에서 실행하는 메소드. Void 타입으로 리턴 값이 없다. null 리턴 */
                Log.i("mylog", "2 : " + Thread.currentThread().getName());      // AsyncTask #1. 작업 스레드
                Log.i("mylog", params[0]);
                Log.i("mylog", params[1]);
                Log.i("mylog", params[2]);

                /* publishProgress();                      // 메인 스레드에 onProgressUpdate 호출 요청 */

                for (int i = 0; i <= 100; i++) {
                    if (i == 1) {
                        publishProgress(1);
                    } else if (i == 50) {
                        publishProgress(50);
                    } else if (i == 100) {
                        publishProgress(100);
                    }
                }

                return "작업스레드결과";
            }

            @Override
            protected void onProgressUpdate(Integer... values) {                   /* doInBackground 에서 호출해줘야 실행 됨. 메인 스레드에서 실행됨. UI 변경 가능 */
                Log.i("mylog", "3 : " + Thread.currentThread().getName());
                Log.i("mylog", "작업 진행 정도 : " + values[0]);
            }

            @Override
            protected void onPostExecute(String aVoid) {                        /* doInBackground 가 끝난 후에 실행 */
                Log.i("mylog", "4 : " + Thread.currentThread().getName());      // main 스레드. UI 변경코드 작성
                Log.i("mylog", aVoid);
            }
        };
        asyncTask.execute("실행매개값1", "실행매개값2", "실행매개값3");
    }


    public void fillItems() {

        AsyncTask<Void, Void, List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() {
            @Override
            protected List<Light> doInBackground(Void... params) {
                List<Light> list = null;

                try {
                    URL url = new URL("http://192.168.0.28:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(reader);
                        String strJson = "";

                        while (true) {
                            String data = br.readLine();
                            if (data == null) {
                                break;
                            }
                            strJson += data;
                        }
                        br.close();
                        reader.close();
                        is.close();

                        list = parseJson(strJson);
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Light> lights) {
                lightAdapter = new LightAdapter(MainActivity.this);
                lightAdapter.setList(lights);
                lightList.setAdapter(lightAdapter);
                imageLarge.setImageBitmap(lights.get(0).getImageLarge());
            }
        };
        asyncTask.execute();
    }

    public List<Light> parseJson(String strJson) {

        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Light light = new Light();
                light.setImage(getBitmap(jsonObject.getString("image")));

                if(i==0) {
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }

                light.setImageFileName(jsonObject.getString("image"));
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }
        return list;
    }

    public Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        try {
            URL url = new URL("http://192.168.0.28:8080/myandroid/getImage?fileName=" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
            }

            conn.disconnect();
        } catch (MalformedURLException e) {
            Log.i("mylog", e.getMessage());
        } catch (IOException e) {
            Log.i("mylog", e.getMessage());
        }
        return bitmap;
    }
}


