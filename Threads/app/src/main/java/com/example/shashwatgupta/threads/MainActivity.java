package com.example.shashwatgupta.threads;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends ActionBarActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView myText = (TextView) findViewById(R.id.myText);
            myText.setText("Good Job");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMyButton(View view){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futuretime=System.currentTimeMillis()+5000;
                while(System.currentTimeMillis()<futuretime){
                    synchronized (this){
                        try{
                            wait(futuretime-System.currentTimeMillis());
                        }catch (Exception e){}
                    }
                }
                handler.sendEmptyMessage(0);

            }
        };

        Thread myThread = new Thread(r);
        myThread.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
