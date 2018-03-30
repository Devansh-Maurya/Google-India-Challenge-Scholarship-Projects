package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA= 0;
    int scoreTeamB= 0;
    int wicketTeamA= 0;
    int wicketTeamB= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
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

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        if(wicketTeamA < 10)
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA, wicketTeamA);
    }

    /**
     * Increase the score for Team A by 4 points.
     */
    public void addFourForTeamA(View v) {
        if(wicketTeamA < 10)
        scoreTeamA += 4;
        displayForTeamA(scoreTeamA, wicketTeamA);
    }

    /**
     * Increase the score for Team A by 6 points.
     */
    public void addSixForTeamA(View v) {
        if(wicketTeamA < 10)
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA, wicketTeamA);
    }

    public void addWicketForTeamA(View v) {
        if(wicketTeamA < 10)
        wicketTeamA++;
        displayForTeamA(scoreTeamA, wicketTeamA);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score, int wicket) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score) + "/" + String.valueOf(wicket));
    }


    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        if(wicketTeamB < 10)
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB, wicketTeamB);
    }

    /**
     * Increase the score for Team B by 4 points.
     */
    public void addFourForTeamB(View v) {
        if(wicketTeamB < 10)
        scoreTeamB += 4;
        displayForTeamB(scoreTeamB, wicketTeamB);
    }

    /**
     * Increase the score for Team B by 6 points.
     */
    public void addSixForTeamB(View v) {
        if(wicketTeamB < 10)
        scoreTeamB += 6;
        displayForTeamB(scoreTeamB, wicketTeamB);
    }

    public void addWicketForTeamB(View v) {
        if(wicketTeamB < 10)
        wicketTeamB++;
        displayForTeamB(scoreTeamB, wicketTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score, int wicket) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score) + "/" + String.valueOf(wicket));
    }

    public void resetForTeams(View v) {
        scoreTeamA= 0;
        scoreTeamB= 0;
        wicketTeamA= 0;
        wicketTeamB= 0;

        displayForTeamA(scoreTeamA, wicketTeamA);
        displayForTeamB(scoreTeamB, wicketTeamB);
    }

}