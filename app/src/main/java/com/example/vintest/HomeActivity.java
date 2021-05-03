package com.example.vintest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE1 = "com.example.android.VinTest.extra.MESSAGE";
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    int total_correct=0;
    int total_wrong=0;
    int que_No = 0;
    public static final String EXTRA_MESSAGE = "com.example.android.VinTest.extra.MESSAGE";

    private Questions question = new Questions();

    private String answer;
    private int questionLength = question.questions.length;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        random = new Random();

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.wlcm);
        textView.setText("Welcome , "+ name +" !");


        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        tv_question = (TextView)findViewById(R.id.tv_question);

//        NextQuestion(random.nextInt(questionLength));
        NextQuestion(0);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    total_correct +=1;
                    que_No +=1;
                    Toast.makeText(HomeActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
//                    NextQuestion(random.nextInt(questionLength));
                    NextQuestion(que_No);
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    total_correct +=1;
                    que_No +=1;
                    Toast.makeText(HomeActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
//                    NextQuestion(random.nextInt(questionLength));
                    NextQuestion(que_No);
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    total_correct +=1;
                    que_No +=1;
                    Toast.makeText(HomeActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    //                    NextQuestion(random.nextInt(questionLength));
                    NextQuestion(que_No);
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    total_correct +=1;
                    que_No +=1;
                    Toast.makeText(HomeActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    //                    NextQuestion(random.nextInt(questionLength));
                    NextQuestion(que_No);
                }else{
                    GameOver();
                }

                break;
        }
    }
    private void GameOver(){
        total_wrong+=1;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
        alertDialogBuilder
                .setMessage("Wrong Answer")
                .setCancelable(false)
                .setPositiveButton("Okay ! Next Question .", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        que_No +=1;
                        NextQuestion(que_No);
//                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();

    }

    private void NextQuestion(int num){

        if(num < (questionLength)){
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);}
        else {
            Intent intent = new Intent(this, ReportActivity.class);
            intent.putExtra(EXTRA_MESSAGE, total_correct);
            intent.putExtra(EXTRA_MESSAGE1, total_wrong);
//            intent.putExtra(EXTRA_MESSAGE, total_correct);
            startActivity(intent);
        }
    }
}
