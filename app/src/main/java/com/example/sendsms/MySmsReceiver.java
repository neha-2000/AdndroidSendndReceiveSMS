package com.example.sendsms;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {
    private  static  String SMS="android.provider.Telephony.SMS_RECEIVED";


//    private static final String TAG =
//            MySmsReceiver.class.getSimpleName();
//    public static final String pdu_type = "pdus";

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the SMS message.
        if(intent.getAction().equals(SMS))
        {
            Bundle bundle=intent.getExtras();
            Object[] objects=(Object[]) bundle.get("pdus");

            SmsMessage[] messages=new SmsMessage[objects.length];
            for(int i=0; i<objects.length;i++){
                messages[i]=SmsMessage.createFromPdu((byte[]) objects[i]);
            }
            Toast.makeText(context, messages[0].getMessageBody(), Toast.LENGTH_SHORT).show();
        }
        else{


        }
    }
}