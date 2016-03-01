package com.iit.glidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {


    private  Button mButton;
    private TextView mTopText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("iit", "onCreate called");
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mTopText= (TextView) findViewById(R.id.top_text);

    }

    protected void onStart(){
        super.onStart();
        Log.v("iit", "Activity2 onStart called");
    }



    protected void onResume(){
        super.onResume();
        Log.v("iit", "Activity2 onResume called");
    }

    protected void onPause(){
        super.onPause();
        Log.v("iit", "Activity2 onPause called");
    }

    protected void onStop(){
        super.onStop();
        Log.v("iit", "Activity2 onStop called");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.v("iit", "Activity2 onDestroy called");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                buttonClicked();
                break;
            case R.id.top_text:

                break;
        }
    }

    private void buttonClicked() {
        Toast.makeText(this, "buttonclicked", Toast.LENGTH_LONG).show();
    }







}
