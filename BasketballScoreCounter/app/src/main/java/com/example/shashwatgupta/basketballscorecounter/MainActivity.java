package com.example.shashwatgupta.basketballscorecounter;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int score_a=0;
    int score_b=0;
    long elapsedtime=0;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View v){
        score_a+=3;
        displayForTeamA(score_a);
    }

/*    public void displayTime(long time){

    } */

    public void addTwoForTeamA(View v){
        score_a+=2;
        displayForTeamA(score_a);
    }

    public void addOneForTeamA(View v){
        score_a+=1;
        displayForTeamA(score_a);
    }

    public void addNegativeForTeamA(View v){
        if(score_a>0)
        score_a-=1;
        displayForTeamA(score_a);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View v){
        score_b+=3;
        displayForTeamB(score_b);
    }

    public void addTwoForTeamB(View v){
        score_b+=2;
        displayForTeamB(score_b);
    }

    public void addOneForTeamB(View v){
        score_b+=1;
        displayForTeamB(score_b);
    }

    public void addNegativeForTeamB(View v){
        if(score_b>0)
        score_b-=1;
        displayForTeamB(score_b);
    }

    public void resetButton(View v){
        score_a=0;
        score_b=0;
        displayForTeamA(score_a);
        displayForTeamB(score_b);
        chronometer.stop();
        elapsedtime=0;
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    public void startTime(View v){
        chronometer.setBase(SystemClock.elapsedRealtime()-elapsedtime);
        chronometer.start();
    }

    public void pauseTime(View v){

        elapsedtime=SystemClock.elapsedRealtime()-chronometer.getBase();
        chronometer.stop();
    }

    public void resetTime(View v){
        elapsedtime=0;
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    public void foulSheet(View v){

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
