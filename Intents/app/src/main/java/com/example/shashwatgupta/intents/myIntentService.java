package com.example.shashwatgupta.intents;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class myIntentService extends IntentService{

    private static final String TAG = "com.example.shashwatgupta.intents";

    public myIntentService() {
        super("myIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //this is what the service does
        Log.i(TAG, "IntentService called");
    }
}
