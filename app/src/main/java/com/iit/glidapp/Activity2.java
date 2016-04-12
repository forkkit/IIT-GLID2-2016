package com.iit.glidapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    private TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("iit", "Activity2 onCreate called");
        setContentView(R.layout.activity_2_layout);
        mInfoText = (TextView) findViewById(R.id.info_text);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //String textFromMain = getIntent().getStringExtra(MainActivity.INFO_KEY);
            String textFromMain = bundle.getString(MainActivity.INFO_KEY);
            if (textFromMain != null) {
                mInfoText.setText(textFromMain);
            }
        }

        mInfoText.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        if(mInfoText.getText().toString().contains("i")) {
            setResult(Activity.RESULT_OK);
        }else{
            setResult(Activity.RESULT_CANCELED);
        }
        finish();
    }
}
