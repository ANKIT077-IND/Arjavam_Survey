package com.Arjavamventure.arjavamsurvey;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class Registernow extends AppCompatActivity {
    Toolbar Registertoolbar;
    EditText Email,Password;
   Button Create_Account;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registernow);
        mAuth = FirebaseAuth.getInstance();
        Registertoolbar=findViewById(R.id.Registertoolbar);
        setSupportActionBar(Registertoolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.loginpin);
        Create_Account=findViewById(R.id.createaccount);

        Create_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog=new ProgressDialog(Registernow.this);
                dialog.setMessage("Please wait creating a account...");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();


                String gmail=Email.getText().toString();
                String password=Password.getText().toString();


                if (gmail.isEmpty()) {
                    Toasty.error(getApplicationContext(), "Please enter the email", Toasty.LENGTH_LONG, true).show();
                }
                else if (gmail.indexOf('@') <= 0) {
                    Toasty.error(getApplicationContext(), "@ invalid  position", Toasty.LENGTH_LONG, true).show();
                }
                else if(gmail.charAt(gmail.length() - 4) != '.' && gmail.charAt(gmail.length() - 3) != '.') {
                    Toasty.error(getApplicationContext(), ". invalid position", Toasty.LENGTH_LONG, true).show();
                }
                else if (password.isEmpty()) {
                    Toasty.error(getApplicationContext(), "Please fill Password", Toasty.LENGTH_LONG, true).show();
                }
                else if (password.length() <= 5 || password.length() >= 15) {
                    Toasty.error(getApplicationContext(), "Password length min 5 and max 20 character", Toasty.LENGTH_LONG, true).show();
                }
                else{

                    mAuth.createUserWithEmailAndPassword(gmail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){


                                FirebaseDatabase db=FirebaseDatabase.getInstance();
                                FirebaseUser user=mAuth.getCurrentUser();
                                String uid=user.getUid();
                                DatabaseReference myref=db.getReference().child("Users").child(uid);

                                HashMap<String,Object>usermap=new HashMap<>();

                                usermap.put("Email",gmail);
                                usermap.put("Password",password);

                                myref.setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        dialog.dismiss();
                                        Toasty.success(getApplicationContext(),"Account Creating Successfully",Toasty.LENGTH_LONG,true).show();
                                        Email.setText("");
                                        Password.setText("");
                                        Create_Account.setVisibility(View.INVISIBLE);
                                    }
                                });


                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                             dialog.hide();
                            Toasty.error(getApplicationContext(),"Account Creating Failed ",Toasty.LENGTH_LONG,true).show();

                        }
                    });



                }





            }
        });



   }
}