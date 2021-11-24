package com.Arjavamventure.arjavamsurvey;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class adminpage extends AppCompatActivity {
    Toolbar admintoolbaar;
    BottomNavigationView adminbottomview;
    FrameLayout adminframelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

        admintoolbaar=findViewById(R.id.admintoolbar);
        setSupportActionBar(admintoolbaar);
        getSupportActionBar().setTitle("Read");
        adminbottomview=findViewById(R.id.bottomnavigation);
        adminframelayout=findViewById(R.id.adminframelayout);
        getSupportFragmentManager().beginTransaction().replace(R.id.adminframelayout,new adminViewFragment()).commit();

        adminbottomview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp=null;
                switch (item.getItemId()){
                    case R.id.adminview:temp=new adminViewFragment();
                    break;
                    case R.id.admindelete:temp=new deleteFragment();
                    break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.adminframelayout,temp).commit();

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adminlogout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
     switch(item.getItemId()){
         case R.id.adminlogout:
             FirebaseAuth.getInstance().signOut();
             Logout();
             break;



     }

        return super.onOptionsItemSelected(item);
    }

    private void Logout(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("are you sure want to Logout");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(adminpage.this, "Logout Successfully", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(adminpage.this,Login.class);
                startActivity(intent);
                finish();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.setTitle("Logout");
        dialog.show();
    }
}
