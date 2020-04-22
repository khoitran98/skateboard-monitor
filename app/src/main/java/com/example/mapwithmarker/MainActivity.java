package com.example.mapwithmarker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button = (Button)findViewById(R.id.button1);
//        Log.d("my tag", "my message0");
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openMap();
//            }
//        });
    }
//    public void openMap(){
//        Log.d("my tag", "my message");
//        Intent intent = new Intent(this, MapsMarkerActivity.class);
//        startActivity(intent);
//        Log.d("my tag", "my message");
//    }
}
