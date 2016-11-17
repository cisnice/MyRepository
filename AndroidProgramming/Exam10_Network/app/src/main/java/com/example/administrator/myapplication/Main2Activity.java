package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageLarge;
    private ListView restaurantList;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        restaurantList = (ListView) findViewById(R.id.restaurantList);
        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Restaurant restaurant = (Restaurant) restaurantAdapter.getItem(position);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(restaurant.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);
                            }
                        });

                    }
                };
                thread.start();
            }
        });

        fillItems();
    }

    public void fillItems() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.28:8080/myandroid/restaurantList");
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

                        final List<Restaurant> list = parseJson(strJson);

                        restaurantList.post(new Runnable() {
                            @Override
                            public void run() {
                                restaurantAdapter = new RestaurantAdapter(Main2Activity.this);
                                restaurantAdapter.setList(list);
                                restaurantList.setAdapter(restaurantAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
            }
        };
        thread.start();
    }

    public List<Restaurant> parseJson(String strJson) {

        List<Restaurant> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Restaurant restaurant = new Restaurant();
                restaurant.setImage(getBitmap(jsonObject.getString("image")));

                if(i==0) {
                    restaurant.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }

                restaurant.setImageFileName(jsonObject.getString("image"));
                restaurant.setImageLargeFileName(jsonObject.getString("imageLarge"));
                restaurant.setTitle(jsonObject.getString("title"));
                restaurant.setPrice(jsonObject.getString("price"));
                restaurant.setContent(jsonObject.getString("content"));
                list.add(restaurant);
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
