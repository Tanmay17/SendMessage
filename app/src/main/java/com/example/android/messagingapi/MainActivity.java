package com.example.android.messagingapi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    TextView tv;
    Button b1,b2;
    String msg,cnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.EditText1);
        et2 = (EditText) findViewById(R.id.editText4);
        tv = (TextView) findViewById(R.id.TextView1);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String string=et1.getText().toString();
                int len=string.length();
                tv.setText(len+"/160");
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    msg=et1.getText().toString();
                    cnt=et2.getText().toString();
                    new MyThread().start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public class MyThread extends Thread{
        @Override
        public void run() {
            try{
                msg=msg.replace(" ","%20");
                String url="http://api.mvaayoo.com/mvaayooapi/MessageCompose?user=tanmays321@gmail.com:tanmay@123&senderID=TEST%20SMS&receipientno="+cnt+"&dcs=0&msgtxt="+msg+"&state=4";
                URL u=new URL(url);
                u.openStream();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
