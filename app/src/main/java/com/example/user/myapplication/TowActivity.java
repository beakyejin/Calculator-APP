package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TowActivity extends AppCompatActivity {
    private EditText et_no1, et_no2;
    private TextView tv_calc, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tow);
        init();
    }

    private void init() {
        getSupportActionBar().setTitle("계산기");
        et_no1 = findViewById(R.id.et_no1);
        et_no1.setShowSoftInputOnFocus(false);

        et_no2 = findViewById(R.id.et_no2);
        et_no2.setShowSoftInputOnFocus(false);

        tv_calc = findViewById(R.id.tv_calc);
        tv_result = findViewById(R.id.tv_result);
    }

    public void clkRightBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v; //강제 형변환
            String str = b.getText().toString();

            if(str.equals("C")){
                et_no1.setText(null);
                et_no2.setText(null);
                tv_calc.setText(null);
                tv_result.setText(null);
            }else {
                if(tv_calc.getText().toString().getBytes().length > 0){
                    tv_calc.setText(tv_calc.getText().toString());
                }else {
                    tv_calc.setText(str);
                }
            }
        }
    }

    public void clkLeftBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v;
            String get_no1 = et_no1.getText().toString();
            String get_no2 = et_no2.getText().toString();

            if(tv_calc.getText().toString().getBytes().length > 0){
                String str = b.getText().toString();
                get_no2 += str;
                et_no2.setText(get_no2);
            }else{
                String str = b.getText().toString();
                get_no1 += str;
                et_no1.setText(get_no1);
            }
        }
    }

    public void resultBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v;
            String str = b.getText().toString();
            int n1, n2;

            String get_no1 = et_no1.getText().toString();
            //값의 길이가 0보다 크면 int형 변환, 0보다 작으면 -1리턴
            n1 = chkNum(get_no1);

            String get_no2 = et_no2.getText().toString();
            n2 = chkNum(get_no2);

            String c = tv_calc.getText().toString();

            //둘 중에 하나라도 값이 -1이면 계산x(incomplement)
            if((n1 == -1) || (n2 == -1)){
                tv_result.setText("incomplement");
            }else{
                if(c.equals("/")){
                    //둘 중 하나라도 값이 0 이면 div0출력
                    if((n1 == 0) || (n2 == 0)){
                        tv_result.setText("div0");
                    }else{
                        tv_result.setText("" + ((double) n1 /  n2));
                    }
                }else if(c.equals("*")){
                    tv_result.setText("" + (n1 * n2));
                }else if(c.equals("-")){
                    tv_result.setText("" + (n1 - n2));
                }else if(c.equals("+")){
                    tv_result.setText("" + (n1 + n2));
                }
            }

        }
    }

    //값의 길이가 0보다 크면 int형 변환, 0보다 작으면 -1리턴
    public int chkNum(String s){
        if(s.getBytes().length>0){
            return Integer.parseInt(s);
        }else {
            return -1;
        }
    }

}
