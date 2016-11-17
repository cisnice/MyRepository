package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class LightAdapter extends BaseAdapter {
    private List<Light> list;

    public void setList(List<Light> list) {
        this.list = list;
    }

    private Context context; //범용적으로 생성자주입을 이용하기위해(원래는 mainactivity를 사용한다.) context 사용 // 쉽게 생각하면 Activity라고 보면 된다
    private LayoutInflater layoutInflater;

    public LightAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { // 아이템의 id 를 리턴 혹여나 객체에 id가 없으면 리스트 인덱스수(position)를 리턴 // 결론은 position을 리턴하는 이유가 인덱스가 식별번호가 된다.
        return position;
        //board 객체의 경우 return list.get(position).getbno();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //Light의 객체가 position 이고 convertView는 adapter를 통해 들어오는 Inplation이고  parent는 ListView 이다.
        // convertView는 재사용될 view(객체가) 생기면 매개변수로 들어가고 그전에는 null값이다.
        if(convertView==null)
        {
            //inplation
            convertView = layoutInflater.inflate(R.layout.light_item,null);
        }
        //data setting
        Light light = list.get(position);

        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageBitmap(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lightTitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightContent);
        lightContent.setText(light.getContent());


        return convertView;
    }
}
