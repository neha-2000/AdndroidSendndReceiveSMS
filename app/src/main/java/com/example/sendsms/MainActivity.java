package com.example.sendsms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.number);
        editText2 = findViewById(R.id.message);
        Button send = findViewById(R.id.send);

    }

    public void btn_send(View view){
        int permissioncheck= ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissioncheck == PackageManager.PERMISSION_GRANTED){
            MyMessage();
        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
        }

    }

    private void MyMessage() {
        String phonenumber=editText1.getText().toString().trim();
        String message=editText2.getText().toString().trim();

        if(!editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phonenumber,null,message,null,null);
            Toast.makeText(this,"Message sent", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(MainActivity.this,ReceiveActivity2.class);
            intent.putExtra("SentMessage",editText2.getText().toString());
            startActivity(intent);

        }
        else{
            Toast.makeText(this,"Message Not  sent Sorry", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        {
            switch (requestCode){
                case 0 :
                    if(grantResults.length >= 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        MyMessage();
                    }
                    else{
                        Toast.makeText(this,"You dont have permission", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }


}