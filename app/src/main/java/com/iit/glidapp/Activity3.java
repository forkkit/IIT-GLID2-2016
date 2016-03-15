package com.iit.glidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("iit", "Activity3 onCreate called");
        setContentView(R.layout.activity_2_layout);
        mInfoText = (TextView) findViewById(R.id.info_text);
        mInfoText.setText("Activity 3");
    }

    protected void onStart() {
        super.onStart();
        Log.v("iit", "Activity2 onStart called");
    }


    protected void onResume() {
        super.onResume();
        Log.v("iit", "Activity2 onResume called");
    }

    protected void onPause() {
        super.onPause();
        Log.v("iit", "Activity2 onPause called");
    }

    protected void onStop() {
        super.onStop();
        Log.v("iit", "Activity2 onStop called");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.v("iit", "Activity2 onDestroy called");
    }


}
