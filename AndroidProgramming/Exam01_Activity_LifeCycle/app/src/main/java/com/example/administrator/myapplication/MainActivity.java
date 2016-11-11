package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {   // 안드로이드가 자동으로 Main 클래스를 찾아 객체로 만들고 onCreate 를 실행한다.
                                                           // LifeCycle 메소드 - 자동으로 객체가 생성되고 소멸되는 메소드
                                                           // onCreate -> onStart -> onResume -> onPause -> onStop -> onDestroy
    @Override
    protected void onCreate(Bundle savedInstanceState) {  // 화면이 생성 될 때 실행. 화면에서 사용하는 객체들을 초기화
        super.onCreate(savedInstanceState);               // 부모의 onCreate 를 반드시 실행하기 위해 호출
        setContentView(R.layout.activity_main);          // 추가적으로 더 실행하기 위해 기술. setContentView(xml의 식별번호), R->res, R에 의해 식별번호가 결정된다.
        Log.i("myLog", "onCreate()");                   // setContentView - *.xml 을 view로 만든다.
    }

    @Override
    protected void onStart() {                          // 서비스 실행. 음악 재생
        super.onStart();
        Log.i("myLog", "onStart()");
    }

    @Override
    protected void onResume() {                         // 사용자가 서비스를 사용하기 위해 하는 행위. 일시정지된 음악을 다시 재생
        super.onResume();
        Log.i("myLog", "onResume()");
    }

    @Override
    protected void onPause() {                           // 사용자가 당장 화면을 사용할 수 없는 상태. 음악 일시정지
        super.onPause();
        Log.i("myLog", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("myLog", "onStop()");
    }

    @Override
    protected void onDestroy() {                           // 화면이 종료될때 실행
        super.onDestroy();
        Log.i("myLog", "onDestroy()");
    }

    public void onClickBtnSecond(View view) {
        Log.i("myLog", "onClickBtnSecond()");
        Intent intent = new Intent(this, SecondActivity.class);         // SecondActivity 를 만들고 SecondActivity 로 이동해라
        startActivity(intent);
    }

    public void onClickBtnThird(View view) {
        Log.i("myLog", "onClickBtnThird()");
        Intent intent = new Intent(this, ThirdActivity.class);         // ThirdActivity 를 만들고 ThirdActivity 로 이동해라
        startActivity(intent);
    }
}
