package com.example.markojerkovic.three_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    static final private String LOG_TAG = "Three_SecondActivity";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Get all of the text boxes so you can add the stored text to them
        TextView tv1 = (TextView) findViewById(R.id.text_1);
        EditText edv2 = (EditText) findViewById(R.id.text_2);
        TextView tv3 = (TextView) findViewById(R.id.text_3);
        // set all of the text boxes to the strings stored in app info
        if (appInfo.sharedString2 != null) {
            edv2.setText(appInfo.sharedString2);
        }
        tv1.setText(appInfo.sharedString1);
        tv3.setText(appInfo.sharedString3);
    }

    //enter button was pressed so update appInfo.sharedString2
    public void onEnter(View V) {
        EditText edv2 = (EditText) findViewById(R.id.text_2);
        String temp_text = edv2.getText().toString();
        appInfo.setSTR2(temp_text);
    }

    //Go to main activity
    public void goActOne(View V) {
        Log.d(LOG_TAG, "goActOne called");
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    //Go to third activity
    public void goActThree(View V) {
        Log.d(LOG_TAG, "goActThree called");
        Intent intent = new Intent(this, ThirdActivity.class);
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
