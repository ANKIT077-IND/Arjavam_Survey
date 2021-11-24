package com.Arjavamventure.arjavamsurvey;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.dmoral.toasty.Toasty;

public class userlogin extends AppCompatActivity {
Toolbar usertoolbar;
    EditText email,password;
    Button login;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        mAuth=FirebaseAuth.getInstance();
        usertoolbar=findViewById(R.id.usertoolbar);
        setSupportActionBar(usertoolbar);
        getSupportActionBar().setTitle("User Login");
        email=findViewById(R.id.useremail);
        password=findViewById(R.id.userpassword);
        login=findViewById(R.id.userlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog=new ProgressDialog(userlogin.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setMessage("Please wait....");
                dialog.show();

                String gmail=email.getText().toString();
                String Password=password.getText().toString();
                if(gmail.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the Email",Toasty.LENGTH_SHORT,true).show();
                }
                else if(gmail.indexOf('@') <= 0) {
                    Toasty.error(getApplicationContext(), "@ invalid  position", Toasty.LENGTH_SHORT, true).show();
                } else if (gmail.charAt(gmail.length() - 4) != '.' && gmail.charAt(gmail.length() - 3) != '.') {
                    Toasty.error(getApplicationContext(), ". invalid position", Toasty.LENGTH_SHORT, true).show();
                } else if (Password.isEmpty()) {
                    Toasty.error(getApplicationContext(), "Please enter the Password", Toasty.LENGTH_SHORT, true).show();
                } else if (Password.length() <= 5 || Password.length() >= 15) {
                    Toasty.error(getApplicationContext(), "Password length min 5 and max 20 character", Toasty.LENGTH_SHORT, true).show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(gmail,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                dialog.dismiss();
                                Toasty.success(getApplicationContext(),"Login Successfully",Toasty.LENGTH_LONG,true).show();
                                email.setText("");
                                password.setText("");
                                Intent intent=new Intent(userlogin.this,MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.hide();
                            Toasty.error(getApplicationContext(),"user login failed",Toasty.LENGTH_LONG,true).show();
                        }
                    });
                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(userlogin.this,MainActivity.class);
            startActivity(intent);

        }
    }
}
