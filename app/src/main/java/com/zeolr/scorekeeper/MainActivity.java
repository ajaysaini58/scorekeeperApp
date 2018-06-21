package com.zeolr.scorekeeper;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // View reference in activity
    TextView team1TotalScoreTextView;
    TextView team1RaidScoreTextView;
    TextView team1TackleScoreTextView;
    TextView team1ExtraScoreTextView;
    TextView team1AllOutScoreTextView;
    TextView team2TotalScoreTextView;
    TextView team2RaidScoreTextView;
    TextView team2TackleScoreTextView;
    TextView team2ExtraScoreTextView;
    TextView team2AllOutScoreTextView;

    Button team1Raidbutton;
    Button team1TackleButton;
    Button team1ExtraButton;
    Button team1AllOutButton;
    Button team2RaidButton;
    Button team2TackleButton;
    Button team2ExtraButton;
    Button team2AllOutButton;
    Button resetButon;

    ProgressBar raidProgressBar;
    ProgressBar tackleProgressBar;
    ProgressBar extraProgressBar;
    ProgressBar allOutProgressBar;

    //variable to hold different score value
    int team1TotalScore;
    int team1RaidScore;
    int team1TackleScore;
    int team1ExtraScore;
    int team1AllOutScore;
    int team2TotalScore;
    int team2RaidScore;
    int team2TackleScore;
    int team2ExtraScore;
    int team2AllOutScore;

    int raidProgress;
    int tackleProgress;
    int extraProgress;
    int allOutProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intialise total score value
        team1TotalScoreTextView = findViewById(R.id.team1_total_score);
        team2TotalScoreTextView = findViewById(R.id.team2_total_score);

        //intialise team1 textView & Button
        team1RaidScoreTextView = findViewById(R.id.team1_raid_score);
        team1Raidbutton = findViewById(R.id.team1_add_raid_score_button);
        team1TackleScoreTextView = findViewById(R.id.team1_tackle_score);
        team1TackleButton = findViewById(R.id.team1_add_tackle_score_button);
        team1ExtraScoreTextView = findViewById(R.id.team1_extra_score);
        team1ExtraButton = findViewById(R.id.team1_add_extra_score_button);
        team1AllOutScoreTextView = findViewById(R.id.team1_all_out_score);
        team1AllOutButton = findViewById(R.id.team1_add_all_out_score_button);

        //intialise team1 textView & Button
        team2RaidScoreTextView = findViewById(R.id.team2_raid_score);
        team2RaidButton = findViewById(R.id.team2_add_raid_score_button);
        team2TackleScoreTextView = findViewById(R.id.team2_tackle_score);
        team2TackleButton = findViewById(R.id.team2_add_tackle_score_button);
        team2ExtraScoreTextView = findViewById(R.id.team2_extra_score);
        team2ExtraButton = findViewById(R.id.team2_add_extra_score_button);
        team2AllOutScoreTextView = findViewById(R.id.team2_all_out_score);
        team2AllOutButton = findViewById(R.id.team2_add_all_out_score_button);

        //intialise progress bar
        raidProgressBar = findViewById(R.id.raid_progress_bar);
        tackleProgressBar = findViewById(R.id.tacke_score_progress_bar);
        extraProgressBar = findViewById(R.id.extra_score_progress_bar);
        allOutProgressBar = findViewById(R.id.all_out_score_progress_bar);

        //intialise reset button
        resetButon = findViewById(R.id.reset_score_button);

        //team1 raid button click listener
        team1Raidbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1RaidScore +=1;
                updateUserInterface();
            }
        });

        //team1 tackle button click listener
        team1TackleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1TackleScore +=1;
                updateUserInterface();
            }
        });

        //team1 extra score button click listener
        team1ExtraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1ExtraScore +=1;
                updateUserInterface();
            }
        });

        //team1 all out score button click listener
        team1AllOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1AllOutScore +=2;
                updateUserInterface();
            }
        });

        //team2 raid button click listener
        team2RaidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2RaidScore +=1;
                updateUserInterface();
            }
        });

        //team1 tackle button click listener
        team2TackleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2TackleScore +=1;
                updateUserInterface();
            }
        });

        //team1 extra score button click listener
        team2ExtraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2ExtraScore +=1;
                updateUserInterface();
            }
        });

        //team1 all out score button click listener
        team2AllOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2AllOutScore +=2;
                updateUserInterface();
            }
        });

        //reset score button. Remove all values and show winner toast
        resetButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team2TotalScore > team1TotalScore){
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.team2_won), Toast.LENGTH_SHORT).show();
                }
                else if (team2TotalScore < team1TotalScore){
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.team1_won), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.match_draw), Toast.LENGTH_SHORT).show();
                }
                team1TotalScore = 0;
                team1RaidScore = 0;
                team1TackleScore = 0;
                team1ExtraScore = 0;
                team1AllOutScore = 0;
                team2TotalScore = 0;
                team2RaidScore = 0;
                team2TackleScore = 0;
                team2ExtraScore = 0;
                team2AllOutScore = 0;
                updateUserInterface();
            }
        });
    }

    // update the new value in text field and progress bar
    void updateUserInterface(){
        team1TotalScore = team1RaidScore + team1TackleScore + team1ExtraScore + team1AllOutScore;   //team1 total score calculate
        team2TotalScore = team2RaidScore + team2TackleScore + team2ExtraScore + team2AllOutScore;   //team2 total score calculate

        //display updated score in textView
        team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
        team1RaidScoreTextView.setText(String.valueOf(team1RaidScore));
        team1TackleScoreTextView.setText(String.valueOf(team1TackleScore));
        team1ExtraScoreTextView.setText(String.valueOf(team1ExtraScore));
        team1AllOutScoreTextView.setText(String.valueOf(team1AllOutScore));
        team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
        team2RaidScoreTextView.setText(String.valueOf(team2RaidScore));
        team2TackleScoreTextView.setText(String.valueOf(team2TackleScore));
        team2ExtraScoreTextView.setText(String.valueOf(team2ExtraScore));
        team2AllOutScoreTextView.setText(String.valueOf(team2AllOutScore) );

        // display updated progressbar
        if ((team1RaidScore + team2RaidScore) != 0) {
            raidProgress = ((team1RaidScore * 100) / (team1RaidScore + team2RaidScore));
            raidProgressBar.setSecondaryProgress(100);
        }
        else{
            raidProgress = 0;
            raidProgressBar.setSecondaryProgress(0);
        }
        if ((team1TackleScore + team2TackleScore)!=0) {
            tackleProgress = ((team1TackleScore * 100) / (team1TackleScore + team2TackleScore));
            tackleProgressBar.setSecondaryProgress(100);
        }
        else {
            tackleProgress = 0;
            tackleProgressBar.setSecondaryProgress(0);
        }
        if ((team1ExtraScore + team2ExtraScore) != 0) {
            extraProgress = ((team1ExtraScore * 100) / (team1ExtraScore + team2ExtraScore));
            extraProgressBar.setSecondaryProgress(100);
        }
        else
        {
            extraProgress = 0;
            extraProgressBar.setSecondaryProgress(0);
        }
        if ((team1AllOutScore + team2AllOutScore) != 0) {
            allOutProgress = ((team1AllOutScore * 100) / (team1AllOutScore + team2AllOutScore));
            allOutProgressBar.setSecondaryProgress(100);
        }
        else{
            allOutProgress = 0;
            allOutProgressBar.setSecondaryProgress(0);
        }
        // update progress bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            raidProgressBar.setProgress(raidProgress, true);
            tackleProgressBar.setProgress(tackleProgress, true);
            extraProgressBar.setProgress(extraProgress, true);
            allOutProgressBar.setProgress(allOutProgress, true);
        }
        else{
            raidProgressBar.setProgress(raidProgress);
            tackleProgressBar.setProgress(tackleProgress);
            extraProgressBar.setProgress(extraProgress);
            allOutProgressBar.setProgress(allOutProgress);
        }

    }
}
