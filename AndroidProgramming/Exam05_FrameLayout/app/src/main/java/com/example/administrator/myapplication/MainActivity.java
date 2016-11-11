package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout frame1;
    private LinearLayout frame2;
    private LinearLayout frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                     // inflation - 객체화 시킨다.

        frame1 = (LinearLayout)findViewById(R.id.frame1);           // ID로 각 객체를 구분한다. ID로만 객체를 찾을 수 있다.
        frame2 = (LinearLayout)findViewById(R.id.frame2);           // findViewById의 리턴타입이 View 이기 때문에 LinearLayout 으로 강제 타입변환한다.
        frame3 = (LinearLayout)findViewById(R.id.frame3);
    }

    public void onClickFrame1(View view) {               //
        frame1.setVisibility(View.VISIBLE);             // Frame1 button 을 눌렀을때 frame1 만 보이게한다.
        frame2.setVisibility(View.INVISIBLE);           // setVisibility - 보이게 할 거냐 말거냐
        frame3.setVisibility(View.INVISIBLE);
    }

    public void onClickFrame2(View view) {
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.VISIBLE);
        frame3.setVisibility(View.INVISIBLE);
    }

    public void onClickFrame3(View view) {
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.INVISIBLE);
        frame3.setVisibility(View.VISIBLE);
    }
}
