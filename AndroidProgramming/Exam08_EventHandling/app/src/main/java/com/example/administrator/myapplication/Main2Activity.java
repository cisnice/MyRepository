package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout itemContainer2;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        itemContainer2 = (LinearLayout)findViewById(R.id.itemContainer2);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems() {

        int[] arrImage =  {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };

        String[] arrTitle = {
                "Name1",
                "Name2",
                "Name3",
                "Name4",
                "Name5"
        };

        String[] arrPrice = {
                "35,000 Won",
                "15,000 Won",
                "25,000 Won",
                "30,000 Won",
                "60,000 Won"
        };

        String[] arrContent = {
                "Information",
                "about",
                "popular",
                "Korean food dishes",
                "local restaurant listias in the Tri-state area."
        };

        for (int i=0; i<5; i++) {

            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.light_item2, null);

            ImageView img1 = (ImageView) itemLayout.findViewById(R.id.img1);
            img1.setImageResource(arrImage[i]);

            TextView title1 = (TextView) itemLayout.findViewById(R.id.title1);
            title1.setText(arrTitle[i]);

            TextView price1 = (TextView) itemLayout.findViewById(R.id.price1);
            price1.setText(arrPrice[i]);

            TextView content1 = (TextView) itemLayout.findViewById(R.id.content1);
            content1.setText(arrContent[i]);

            itemContainer2.addView(itemLayout);
        }
    }
}
