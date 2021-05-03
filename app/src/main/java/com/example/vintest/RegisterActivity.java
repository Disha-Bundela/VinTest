package com.example.vintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edname, edemail, edcno, edaddress, edpwd;
    Button btnReg;
    String text = "No Option Selected";
    Spinner favSub;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnReg = findViewById(R.id.btn_Reg);
        edname = findViewById(R.id.editName);
        edemail = findViewById(R.id.editEmail);
        edcno = findViewById(R.id.editcno);
        edaddress = findViewById(R.id.editaddress);
        edpwd = findViewById(R.id.editpwd);
        DB = new DBHelper(this);


        favSub= (Spinner)findViewById(R.id.favsub);
        favSub.setOnItemSelectedListener(this);
        List<String> sub_list = new ArrayList<String>();
        sub_list.add("Select Favourite Subject");
        sub_list.add("Mobile Application");
        sub_list.add("Java");
        sub_list.add("Data Mining");
        ArrayAdapter<String> subAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sub_list);
        subAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        favSub.setAdapter(subAdapter);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = edname.getText().toString();
                String emailTXT = edemail.getText().toString();
                String cnoTXT = edcno.getText().toString();
                String addressTXT = edaddress.getText().toString();
                String subjectTXT = text.toString();
                String pwdTXT = edpwd.getText().toString();
                String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                boolean validation= true;
                if( Pattern.compile(EMAIL_STRING).matcher(emailTXT).matches()){
                    validation = true;
                    if(!(text.equals("Select Favourite Subject"))){
                        validation = true;
                    }           else {
                        validation=false;
                        Toast.makeText(RegisterActivity.this, "Select Favourite Subject", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    validation=false;
                    Toast.makeText(RegisterActivity.this, "Invalid Email ID", Toast.LENGTH_SHORT).show();
                }

                if(validation){
                    Boolean checkinsertdata = DB.insertUser(nameTXT, emailTXT, cnoTXT,addressTXT,subjectTXT, pwdTXT);
                    if (checkinsertdata == true)
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
