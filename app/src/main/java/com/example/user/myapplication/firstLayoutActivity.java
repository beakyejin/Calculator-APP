package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class firstLayoutActivity extends AppCompatActivity {
    private Button dd1, dd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);
        init();
    }

    private void init() {
        dd1 = findViewById(R.id.btn_1);
        dd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이벤트 연결 확인 toast
                Toast.makeText(firstLayoutActivity.this, "버튼1", Toast.LENGTH_SHORT).show();

                //화면 이동하기
                Intent intent = new Intent(firstLayoutActivity.this, TowActivity.class);
                startActivity(intent);
            }
        });

        dd2 = findViewById(R.id.btn_2);
        dd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(firstLayoutActivity.this, "버튼2", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(firstLayoutActivity.this, ThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}
