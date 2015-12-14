package com.example.shashwatgupta.swiping;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends ActionBarActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private TextView mytext;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytext = (TextView)findViewById(R.id.mytext);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
        mytext.setText("Swipe Me");
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mytext.setText("Single Tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mytext.setText("Double Tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mytext.setText("Double tap event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mytext.setText("On Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        mytext.setText("Show press");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        mytext.setText("Single tap up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mytext.setText("Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mytext.setText("Long Press");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mytext.setText("Fling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
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
