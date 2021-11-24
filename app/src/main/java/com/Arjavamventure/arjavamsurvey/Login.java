package com.Arjavamventure.arjavamsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Login extends AppCompatActivity {

 Toolbar toolbar;
 TextView Registernow;

    RadioButton user,admin;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        user=findViewById(R.id.user);
        admin=findViewById(R.id.admin);
        radioGroup=findViewById(R.id.radio);
        Registernow=findViewById(R.id.register_now);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.user:
                   Intent intent=new Intent(getApplicationContext(),userlogin.class);
                   startActivity(intent);
                   finish();
                   break;

                   case R.id.admin:
                        Intent adminintent=new Intent(getApplicationContext(),admin.class);
                        startActivity(adminintent);
                        finish();
                        break;

                }
            }
        });

       Registernow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             Intent intent=new Intent(Login.this,Registernow.class);
             startActivity(intent);
           }
       });


    }
}
