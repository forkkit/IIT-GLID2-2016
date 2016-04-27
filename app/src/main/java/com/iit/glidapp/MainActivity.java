package com.iit.glidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iit.glidapp.core.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String INFO_KEY = "info";
    public static final int MAIN_ACTIVITY_REQUEST_CODE = 1000;

    private RelativeLayout mMainLayout;
    private Button mButton;
    private EditText mTopText;
    private TextView mBelowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("iit", "onCreate called");
        setContentView(R.layout.activity_main);

        mMainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mTopText = (EditText) findViewById(R.id.top_text);
        mBelowText = (TextView) findViewById(R.id.below_text);
        mBelowText.setOnClickListener(this);

    }

    protected void onStart() {
        super.onStart();
        Log.v("iit", "onStart called");
    }


    protected void onResume() {
        super.onResume();
        Log.v("iit", "onResume called");
    }

    protected void onPause() {
        super.onPause();
        Log.v("iit", "onPause called");
    }

    protected void onStop() {
        super.onStop();
        Log.v("iit", "onStop called");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.v("iit", "onDestroy called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                //createFile();
                //createFileInThread();
                createFileInThreadWithJson();
                break;
            case R.id.action_view:
                Intent intent = new Intent(getApplicationContext(), EnhancedActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                buttonClicked();
                break;
            case R.id.below_text:
                belowTextClicked3();
                break;
        }
    }

    private void buttonClicked() {
        Toast.makeText(this, "buttonclicked", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), Activity2.class);
        //intent.putExtra(INFO_KEY,mTopText.getText().toString());
        Bundle bundle = new Bundle();
        bundle.putString(INFO_KEY, mTopText.getText().toString());
        intent.putExtras(bundle);
//        startActivity(intent);
        startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);
    }

    private void belowTextClicked() {
        Log.v("IIT", "text clicked");
        TextView textView = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(Color.YELLOW);
        textView.setText("salut");


        mMainLayout.addView(textView);
    }

    private void belowTextClicked2() {
        if (mTopText.getVisibility() == View.GONE) {
            mTopText.setVisibility(View.VISIBLE);
        } else {
            mTopText.setVisibility(View.GONE);
        }
    }

    private void belowTextClicked3() {
        //Uri webpage = Uri.parse("http://www.iit-nau.com/");
        //Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        //startActivity(webIntent);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    private void launchActivity3() {

        Intent launchActivity3Intent = new Intent("android.iit.test.activity3");

        startActivity(launchActivity3Intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case MAIN_ACTIVITY_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Log.v("iit", "text contains i");
                } else {
                    Log.v("iit", "text doesn't contain i");
                }
                break;
        }
    }

    private void createFileInThread() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                createFile(mTopText.getText().toString());
                //we can't touch views outside of UI thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTopText.setText("");
                    }
                });
            }
        };

        thread.start();
    }

    private void createFileInThreadWithJson() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                Person person = new Person("test", 20);
                Gson gson = new Gson();
                String s = gson.toJson(person);
                createFile(s);
                //we can't touch views outside of UI thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTopText.setText("");
                    }
                });
            }
        };

        thread.start();
    }

    private void createFile(String text) {

        if (!text.isEmpty()) {
            try {
                String filePath = getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "file" + Calendar.getInstance().getTimeInMillis();
                File file = new File(filePath);
                PrintWriter out = new PrintWriter(file);
                out.println(text);
                out.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
