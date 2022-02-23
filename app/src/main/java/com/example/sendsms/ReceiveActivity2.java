package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity2 extends AppCompatActivity {

    TextView sendView,receiveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive2);

        Intent intent=getIntent();
        sendView=findViewById(R.id.sendtext);
        receiveView=findViewById(R.id.receiveText);

        String str1=intent.getStringExtra("SentMessage");


        sendView.setText(str1);
//        pass.setText(str2);
    }
}