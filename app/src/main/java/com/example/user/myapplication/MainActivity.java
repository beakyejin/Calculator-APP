package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_hello = null, tv_name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hello = findViewById(R.id.tv_hello); //레이아웃에 있는 객체(아이디) 값을 찾아서 넘겨준다.
        tv_name = findViewById(R.id.tv_name);

        int a = R.string.change;
        tv_hello.setText(a);
        tv_name.setText("nnnnnnnnnnnn");
    }
}
