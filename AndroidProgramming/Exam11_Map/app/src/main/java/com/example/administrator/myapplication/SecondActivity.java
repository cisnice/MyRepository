package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ImageView foodMain;
    private ListView foodList;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        foodMain=(ImageView)findViewById(R.id.foodMain);

        foodList = (ListView)findViewById(R.id.foodList);
        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Food food = (Food) foodAdapter.getItem(position);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(food.getImageLargeFileName());
                        foodMain.post(new Runnable() {
                            @Override
                            public void run() {
                                foodMain.setImageBitmap(bitmap);
                            }
                        });
                    }
                };
                thread.start();
            }
        });
        fillItems();
    }

    public void fillItems()
    {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.21:8080/myandroid/foodList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    if(conn.getResponseCode()==HttpURLConnection.HTTP_OK)
                    {
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(reader);
                        String strJson = "";

                        while (true){
                            String data = br.readLine();
                            if(data==null)
                            {
                                break;
                            }
                            strJson += data;
                        }
                        br.close();
                        reader.close();
                        is.close();

                        final List<Food> list = parseJson(strJson);

                        foodList.post(new Runnable() {
                            @Override
                            public void run() {
                                foodAdapter = new FoodAdapter(SecondActivity.this);
                                foodAdapter.setFoodList(list);
                                foodList.setAdapter(foodAdapter);
                                foodMain.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                    }
                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog",e.getMessage());
                }
            }
        };
        thread.start();
    }

    public List<Food> parseJson(String strJson){
        List<Food> foodList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i=0; i<10; i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Food food = new Food();
                if(i==0)
                {
                    food.setImageLarge(getBitmap(jsonObject.getString("foodMain")));
                }
                food.setImage(getBitmap(jsonObject.getString("image")));
                food.setImageLargeFileName(jsonObject.getString("foodMain"));
                food.setTitle(jsonObject.getString("title"));
                food.setContent(jsonObject.getString("content"));
                food.setPrice(jsonObject.getString("price"));
                foodList.add(food);
            }
        }catch (JSONException e){
            Log.i("mylog",e.getMessage());
        }
        return foodList;
    }

    public Bitmap getBitmap(String ImageLargeFileName){
        Bitmap bitmap = null;
        try {
            URL url = new URL("http://192.168.0.21:8080/myandroid/getImage?fileName="+ImageLargeFileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK)
            {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
            }
            conn.disconnect();
        }catch (Exception e)
        {
            Log.i("mylog",e.getMessage());
        }
        return bitmap;
    }
}
