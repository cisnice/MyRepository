package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantAdapter extends BaseAdapter {

    private List<Restaurant> list;

    public void setList(List<Restaurant> list) {
        this.list = list;
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public RestaurantAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {                     // 보여줄 항목 수, 데이터의 수
        return list.size();
    }

    @Override
    public Object getItem(int position) {       // List 의 인덱스
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            //inplation
            convertView = layoutInflater.inflate(R.layout.light_item, null);
        }

        //data setting
        Restaurant Restaurant = list.get(position);

        ImageView img1 = (ImageView) convertView.findViewById(R.id.img1);
        img1.setImageBitmap(Restaurant.getImage());

        TextView title1 = (TextView) convertView.findViewById(R.id.title1);
        title1.setText(Restaurant.getTitle());

        TextView price1 = (TextView) convertView.findViewById(R.id.price1);
        price1.setText(Restaurant.getPrice());

        TextView lightContent = (TextView) convertView.findViewById(R.id.content1);
        lightContent.setText(Restaurant.getContent());

        return convertView;
    }

}
