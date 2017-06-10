package com.example.android.rugbycounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the rugby score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {
    // Tracks the score for Team A
    int scoreTeamA = 0;
    boolean tryTeamA = true;

    // Tracks the score for Team B
    int scoreTeamB = 0;
    boolean tryTeamB = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /****************** Manage TeamA Score ************************************
     /**
     * Increase the score for Team A by 5 point
     * and lock next Try until conversion kick is done.
     */
    public void addFiveForTeamA(View v) {
        if (tryTeamA) {
            tryTeamA = false;
            scoreTeamA = scoreTeamA + 5;
            displayForTeamA(scoreTeamA);
        }
    }
    /**
     * If a conversion is performed then increase the score for Team A by 2 points
     * and Unlock the next try for Team A.
     */
    public void addTwoForTeamA(View v) {
        if (!tryTeamA) {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA);
            tryTeamA = true;
        }
    }
    /**
     * If a conversion has failed just unlock the next try for Team A.
     */
    public void addZeroForTeamA(View v) {
        if (!tryTeamA) {
            tryTeamA = true;
        }
    }
    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /****************** Manage TeamB Score ************************************
     /**
     * Increase the score for Team B by 5 point
     * and lock next Try until conversion kick is done.
     */
    public void addFiveForTeamB(View v) {
        if (tryTeamB) {
            tryTeamB = false;
            scoreTeamB = scoreTeamB + 5;
            displayForTeamB(scoreTeamB);
        }
    }
    /**
     * If a conversion is performed then increase the score for Team A by 2 points
     * and Unlock the next try for Team A.
     */
    public void addTwoForTeamB(View v) {
        if (!tryTeamB) {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamB(scoreTeamB);
            tryTeamB = true;
        }
    }
    /**
     * If a conversion has failed just unlock the next try for Team A.
     */
    public void addZeroForTeamB(View v) {
        if (!tryTeamB) {
            tryTeamB = true;
        }
    }
    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
