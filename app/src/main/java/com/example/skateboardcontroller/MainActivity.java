package com.example.skateboardcontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 10;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkForPermission();
    }
//    private void disableSmsButton() {
//        Toast.makeText(this, "SMS usage disabled", Toast.LENGTH_LONG).show();
//        Button smsButton = findViewById(R.id.message_icon);
//        smsButton.setVisibility(View.INVISIBLE);
//        Button retryButton = findViewById(R.id.button_retry);
//        retryButton.setVisibility(View.VISIBLE);
//    }
//    private void enableSmsButton() {
//        Button smsButton = findViewById(R.id.message_icon);
//        smsButton.setVisibility(View.VISIBLE);
//    }
//    public void retryApp(View view) {
//        Intent intent = getPackageManager()
//                .getLaunchIntentForPackage(getPackageName());
//        startActivity(intent);
//    }
    // Check for location and SMS Permission
    private void checkForPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d("send", "permission not granted");
            // Permission not yet granted. Use requestPermissions().
            // MY_PERMISSIONS_REQUEST_SEND_SMS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            // Permission already granted. Enable the SMS button.
         //   enableSmsButton();
        }
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.RECEIVE_SMS) !=
//                PackageManager.PERMISSION_GRANTED){
//            Log.d("receive", "permission not granted");
//            // Permission not yet granted. Use requestPermissions().
//            // MY_PERMISSIONS_REQUEST_RECEIVE_SMS is an
//            // app-defined int constant. The callback method gets the
//             result of the request.
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.RECEIVE_SMS},
//                    MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
//        }
        if (ActivityCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        // Check if permission is granted or not for the request.
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase
                        (Manifest.permission.SEND_SMS)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    Log.d("tag", "Permission Send Granted");
                    // Permission was granted. Enable sms button.
                    // enableSmsButton();
                } else {
                    // Permission denied.
                    Log.d("tag", "Failure to get send permission");
                    Toast.makeText(this,
                            "Failure to get send permission",
                            Toast.LENGTH_LONG).show();
                    // Disable the sms button.
                    //disableSmsButton();
                }
            }
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("tag", "Location Permission Granted");
                }
            }
        }
    }
}
