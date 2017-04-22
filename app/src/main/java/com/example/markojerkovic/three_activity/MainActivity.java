package com.example.markojerkovic.three_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    static final public String MYPREFS = "myprefs";
    static final private String LOG_TAG = "Three_MainActivity";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //*******Temp*******
        appInfo.setSTR1("foo");
        appInfo.setSTR2("bru");
        appInfo.setSTR3("ayy");
        ////////////////////

        // Get all of the text boxes so you can add the stored text to them
        EditText edv1 = (EditText) findViewById(R.id.edit_text_1);
        TextView tv2 = (TextView) findViewById(R.id.text_2);
        TextView tv3 = (TextView) findViewById(R.id.text_3);
        // set all of the text boxes to the strings stored in app info
        if (appInfo.sharedString1 != null) {
            edv1.setText(appInfo.sharedString1);
        }
        tv2.setText(appInfo.sharedString2);
        tv3.setText(appInfo.sharedString3);
    }

    //enter button was pressed so update appInfo.sharedString1
    public void onEnter(View V) {
        EditText edv1 = (EditText) findViewById(R.id.edit_text_1);
        String temp_text = edv1.getText().toString();
        appInfo.setSTR1(temp_text);
    }

    //Go to second activity
    public void goActTwo(View V) {
        Log.d(LOG_TAG, "goActTwo called");
        //Intent intent = new Intent(this, SecondActivity.class);
        //startActivity(intent);
    }

    //Go to third activity
    public void goActThree(View V) {
        Log.d(LOG_TAG, "goActThree called");
        //Intent intent = new Intent(this, ThirdActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //Do nothing because already in mainActivity
    }
}
