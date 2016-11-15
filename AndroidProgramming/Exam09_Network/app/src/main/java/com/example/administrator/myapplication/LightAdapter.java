package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LightAdapter extends BaseAdapter {          // Adapter 라면 반드시 가지고 있어야 할 메소드들을 정의한 클래스를 상속 받아야한다. 추상메소드

    private List<Light> list;

    public void setList(List<Light> list) {                // setter 주입
        this.list = list;
    }       // setter 주입

    private Context context;                    // 모든 Activity 는 Context 를 구현한다.
    private LayoutInflater layoutInflater;

    public LightAdapter(Context context) {        // 생성자 주입, MainActivity 뿐만 아니라 모든 Activity 를 받을 수 있다.
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
    public long getItemId(int position) {       // 객체의 식별번호, 식별번호가 없을 경우 인덱스
        return position;
        /*return list.get(position).getBno();  Board 객체라면 bno */
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {         // (인덱스, light_item.xml 을 inflation 한 객체, ListView), 해당 위치에 보여주는 아이템의 view?
                                                                                     // convertView 가 첫 화면에서는 null(재사용안함) 로 들어오고 화면이 넘어가서 사라진 객체를 재사용하게 되면 값(null이 아님)이 들어온다.
        if (convertView == null) {
            //inplation
            convertView = layoutInflater.inflate(R.layout.light_item, null);
        }

        //data setting
        Light light = list.get(position);

        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageBitmap(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lighttitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightContent);
        lightContent.setText(light.getContent());

        return convertView;
    }

}
