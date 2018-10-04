package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        //string.xml 사용해서 타이틀세팅
        getSupportActionBar().setTitle(R.string.calc);

        et_no1 = findViewById(R.id.et_no1);
        et_no1.setShowSoftInputOnFocus(false);

        et_no2 = findViewById(R.id.et_no2);
        et_no2.setShowSoftInputOnFocus(false);

        tv_calc = findViewById(R.id.tv_calc);
        tv_result = findViewById(R.id.tv_result);
    }

    //오른쪽(기호) 버튼 클릭 이벤트
    public void clkRightBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v; //강제 형변환
            String str = b.getText().toString();

            if(str.equals("C")){ //clear
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

    //왼쪽(숫자)버튼 클릭 이벤트
    public void clkLeftBtn(View v){
        Log.i("test", "이벤트 연결 성공!"); //로그 찍기

        if(v instanceof Button){
            Button b = (Button)v;
            String get_no1 = et_no1.getText().toString();
            String get_no2 = et_no2.getText().toString();
            String get_calc = tv_calc.getText().toString();
            String get_result = tv_result.getText().toString();

            if (get_calc.getBytes().length > 0) {
                String str = b.getText().toString();
                get_no2 += str;

                //계산 완료 시 입력X
                if(!(get_result.getBytes().length>0)){
                    et_no2.setText(get_no2);
                }
            } else {
                String str = b.getText().toString();
                get_no1 += str;
                et_no1.setText(get_no1);
            }

            /*
            //선생님 답안
            EditText target = null;

            if(get_calc.equals("")){
                target = et_no1;
            }else {
                target = et_no2;
            }

            if(target != null){
                if(v instanceof  Button){
                    //누른 버튼의 텍스트 값
                    Button b2 = (Button)v;
                    String pressNo = b2.getText().toString();

                    //기존에 있던 텍스트 값 + 누른 버튼의 텍스트 값
                     String existValue = target.getText().toString();
                     existValue += pressNo;

                     target.setText(existValue);
                }
            }*/
        }
    }

    //result(=) 버튼 클릭 이벤트
    public void resultBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v;
            String str = b.getText().toString();
            int n1, n2;

            String get_no1 = et_no1.getText().toString();
            String get_no2 = et_no2.getText().toString();

            String c = tv_calc.getText().toString();

            //값의 길이가 0보다 크면 int형 변환, 0보다 작으면 -1리턴
            n1 = chkNum(get_no1);
            n2 = chkNum(get_no2);

            //둘 중에 하나라도 값이 -1이면 계산x(incomplement)
            if((n1 == -1) || (n2 == -1)){
                tv_result.setText("incomplete");
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
