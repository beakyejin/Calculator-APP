
package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonAlignActivity extends AppCompatActivity {
    private TextView tv_content;
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_align);
    }

    public void clkBtn(View v){
        Button btn = (Button) v; //형변환
        tv_content = findViewById(R.id.tv_content);

        tv_content.setText(btn.getText());

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        if(v.getId() == R.id.btn1){
            btn.setText("1");
            btn2.setText("0");
            btn3.setText("0");
        }else if(v.getId() == R.id.btn2){
            btn.setText("2");
            btn1.setText("0");
            btn3.setText("0");
        }else if(v.getId() == R.id.btn3){
            btn.setText("3");
            btn1.setText("0");
            btn2.setText("0");
        }
    }
}
