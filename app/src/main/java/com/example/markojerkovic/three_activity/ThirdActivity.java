package com.example.markojerkovic.three_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    static final private String LOG_TAG = "Three_ThirdActivity";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Get all of the text boxes so you can add the stored text to them
        TextView tv1 = (TextView) findViewById(R.id.text_1);
        TextView tv2 = (TextView) findViewById(R.id.text_2);
        EditText edv3 = (EditText) findViewById(R.id.text_3);
        // set all of the text boxes to the strings stored in app info
        if (appInfo.sharedString3 != null) {
            edv3.setText(appInfo.sharedString3);
        }
        tv1.setText(appInfo.sharedString1);
        tv2.setText(appInfo.sharedString2);
    }

    //enter button was pressed so update appInfo.sharedString3
    public void onEnter(View V) {
        EditText edv3 = (EditText) findViewById(R.id.text_3);
        String temp_text = edv3.getText().toString();
        appInfo.setSTR3(temp_text);
    }

    //Go to main activity
    public void goActOne(View V) {
        Log.d(LOG_TAG, "goActOne called");
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    //Go to second activity
    public void goActTwo(View V) {
        Log.d(LOG_TAG, "goActTwo called");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}