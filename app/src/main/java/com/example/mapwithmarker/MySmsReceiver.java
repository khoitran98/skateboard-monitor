package com.example.mapwithmarker;

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
    private static final String TAG =
            MySmsReceiver.class.getSimpleName();
    public static final String pdu_type = "pdus";
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the SMS message.

        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs;
        String strMessage = "";
        String format = bundle.getString("format");
        // Retrieve the SMS message received.
        Object[] pdus = (Object[]) bundle.get(pdu_type);
        if (pdus != null) {
            // Check the Android version.
            boolean isVersionM =
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
            // Fill the msgs array.
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                // Check Android version and use appropriate createFromPdu.
                if (isVersionM) {
                    // If Android version M or newer:
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                } else {
                    // If Android version L or older:
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                if (!msgs[i].getOriginatingAddress().equals("+14694680064")) {
                    return;
                }
                // Build the message to show.55
                strMessage += msgs[i].getMessageBody();
                // Log and display the SMS message.
                String delims = "[ ]+";
                String[] tokens = strMessage.split(delims);
                Intent intentMap = new Intent(context.getApplicationContext(), MapsMarkerActivity.class);
                intentMap.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentMap.putExtra("LAT", tokens[0]);
                intentMap.putExtra("LONG", tokens[1]);
                context.startActivity(intentMap);
            }
        }
    }
}
