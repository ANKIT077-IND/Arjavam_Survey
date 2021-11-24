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

public class admin extends AppCompatActivity {
    EditText adminmail, adminpassword;
    Button adminlogin;
    Toolbar admintoolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        mAuth = FirebaseAuth.getInstance();
        admintoolbar = findViewById(R.id.admintoolbar);
        setSupportActionBar(admintoolbar);
        getSupportActionBar().setTitle("Admin Login");

        adminmail = findViewById(R.id.adminmail);
        adminpassword = findViewById(R.id.adminPassword);
        adminlogin = findViewById(R.id.loginadmin);
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String gmail = adminmail.getText().toString();
                String password = adminpassword.getText().toString();
                if (gmail.isEmpty()) {
                    Toasty.error(getApplicationContext(), "Please enter the Email", Toasty.LENGTH_SHORT, true).show();
                } else if (gmail.indexOf('@') <= 0) {
                    Toasty.error(getApplicationContext(), "@ invalid  position", Toasty.LENGTH_SHORT, true).show();
                } else if (gmail.charAt(gmail.length() - 4) != '.' && gmail.charAt(gmail.length() - 3) != '.') {
                    Toasty.error(getApplicationContext(), ". invalid position", Toasty.LENGTH_SHORT, true).show();
                } else if (password.isEmpty()) {
                    Toasty.error(getApplicationContext(), "Please enter the Password", Toasty.LENGTH_SHORT, true).show();
                } else if (password.length() <= 5 || password.length() >= 15) {
                    Toasty.error(getApplicationContext(), "Password length min 5 and max 20 character", Toasty.LENGTH_SHORT, true).show();
                } else {
                    ProgressDialog dialog = new ProgressDialog(admin.this);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setMessage("Login Please wait...");
                    dialog.show();

                    mAuth.signInWithEmailAndPassword(gmail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                dialog.dismiss();
                                Toasty.success(getApplicationContext(), "Login Successfully", Toasty.LENGTH_LONG, true).show();
                                adminmail.setText("");
                                adminpassword.setText("");
                                Intent intent = new Intent(admin.this, adminpage.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.hide();
                            Toasty.error(getApplicationContext(), "Admin login failed", Toasty.LENGTH_LONG, true).show();
                        }
                    });
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(admin.this, adminpage.class);
            startActivity(intent);

        }
    }
}