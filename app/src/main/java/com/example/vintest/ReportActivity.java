package com.example.vintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        TextView txtname = findViewById(R.id.txtName);
        TextView atmp = findViewById(R.id.txtattempted);
        TextView totalscore = findViewById(R.id.txtcorrect);

        TextView wrong = findViewById(R.id.txtincorrect);
        Button finish = findViewById(R.id.btnFinish);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        txtname.setText("Name : " + name);

        Intent i = getIntent();
        String correct = i.getStringExtra(HomeActivity.EXTRA_MESSAGE);
        String wrong1 = i.getStringExtra(HomeActivity.EXTRA_MESSAGE1);
        totalscore.setText("Total Score : " + correct);
        atmp.setText("Questions Attempted : 3");
        wrong.setText("Wrong Answer : "+wrong1);
    }
}
