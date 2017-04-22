package com.example.markojerkovic.three_activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by markojerkovic on 4/22/17.
 */

public class AppInfo {
    private static AppInfo instance = null;
    private Context my_context;

    // shared string key names
    private static final String STR1 = "string1";
    private static final String STR2 = "string2";
    private static final String STR3 = "string3";

    // shared string values
    public String sharedString1;
    public String sharedString2;
    public String sharedString3;

    protected AppInfo() {
        // Exists only to defeat instantiation.
    }

    public static AppInfo getInstance(Context context) {
        if(instance == null) {
            instance = new AppInfo();
            instance.my_context = context;
            SharedPreferences settings = context.getSharedPreferences(MainActivity.MYPREFS, 0);
            instance.sharedString1 = settings.getString(STR1, null);
            instance.sharedString2 = settings.getString(STR2, null);
            instance.sharedString3 = settings.getString(STR3, null);
        }
        return instance;
    }

    public void setSTR1 (String str) {
        instance.sharedString1 = str;
        SharedPreferences settings = my_context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(STR1, str);
        editor.commit();
    }

    public void setSTR2 (String str) {
        instance.sharedString2 = str;
        SharedPreferences settings = my_context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(STR2, str);
        editor.commit();
    }

    public void setSTR3 (String str) {
        instance.sharedString3 = str;
        SharedPreferences settings = my_context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(STR3, str);
        editor.commit();
    }
}
