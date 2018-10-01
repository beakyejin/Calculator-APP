package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrintStarActivity extends AppCompatActivity {
    private EditText pr_edit;
    private TextView pr_text;
    private Button pr_btn;
    private String star = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_star);
        getSupportActionBar().setTitle("별찍기");
        init();
    }

    /*public void prBtn(View v) {
        pr_edit = findViewById(R.id.pr_edit);
        pr_text = findViewById(R.id.pr_text);
        String input = pr_edit.getText().toString();
        Log.d(input, "pr_edit.getText");

        if(input.getBytes().length == 0){
            pr_text.setText("숫자를 입력해 주세요!");
        }else if(!input.equals("") && input.length()!=0){
            int n = Integer.parseInt(input.toString());

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    star += "*";
                }
                star += "\n";
            }
            pr_text.setText(star);
        }
    }*/

    private int checkInteger(String v){
     int result = 0;
     try{
         result = Integer.parseInt(v);
     }catch (Exception e){}
     return  result;
    }

    private void init(){
        pr_edit = findViewById(R.id.pr_edit);
        pr_text = findViewById(R.id.pr_text);
        pr_btn  = findViewById(R.id.pr_btn);

        pr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = pr_edit.getText().toString();
                int no = checkInteger(value);

                if(no > 0){
                    String result = "";
                    for(int i=1; i<=no; i++){
                        for(int j=0; j<i; j++){
                            result += "*";
                        }
                        result += "\n";
                    }
                    pr_text.setText(result);
                }
                pr_edit.setText("");
            }
        });
    }

}

