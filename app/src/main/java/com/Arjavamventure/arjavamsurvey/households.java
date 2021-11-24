package com.Arjavamventure.arjavamsurvey;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class households extends AppCompatActivity {
    Toolbar housetoolbar;
    Spinner category1,gender,occupation,watersource,toilet,yestoilet,kitchen;
    String category[]={"General","ST","SC","OBC"};
    String Gender[]={"Male","Female","Other"};
    String Occupation[]={"Student","Farmer","Employee","Self-Employee","Business","Service"};
    String Watersource[]={"Tap(नल)","Tubewell(नलकूप)","Tanker(टैंकर)"," None(कोई नहीं)"};
    String Toilet[]={"Yes","No"};
    String Yestoilet[]={"built by the owner","PMAY scheme"};
    String Kitchen[]={"Yes","No"};
    EditText houseno,numberhousehold,nameofowner,age,qualification,noofmalemember,nooffemalemember,noofmalechildren,nooffemalechildren,childno,disablechild,agriculter,incom,cattle,noofroomh,plot,noofbulid,noofsotry,plotinsqr,issue;
    Button submit;
    DatabaseReference sendreference;
    String cast,gen,occu,source,toi,yestoi,kit;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_households);

        mAuth=FirebaseAuth.getInstance();
        housetoolbar=findViewById(R.id.housetoolbar);
        setSupportActionBar(housetoolbar);
        getSupportActionBar().setTitle("For Households");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        category1=findViewById(R.id.cast);
        gender=findViewById(R.id.gender);
        occupation=findViewById(R.id.occupation);
        watersource=findViewById(R.id.watersoure);
        toilet=findViewById(R.id.toilet);
        yestoilet=findViewById(R.id.yestoilet);
        kitchen=findViewById(R.id.kitchan);
        houseno=findViewById(R.id.houseno);
        numberhousehold=findViewById(R.id.numberhousehold);
        nameofowner=findViewById(R.id.nameofowner);
        age=findViewById(R.id.age);
        qualification=findViewById(R.id.educationlevel);
        noofmalemember=findViewById(R.id.noofmalemumbers);
        nooffemalemember=findViewById(R.id.nooffemalemumbers);
        noofmalechildren=findViewById(R.id.noofmalechildren);
        nooffemalechildren=findViewById(R.id.nooffemalechildren);
        childno=findViewById(R.id.childno);
        disablechild=findViewById(R.id.disablechild);
        agriculter=findViewById(R.id.agriculter);
        incom=findViewById(R.id.incom);
        cattle=findViewById(R.id.cattle);
        noofroomh=findViewById(R.id.noofroomh);
        plot=findViewById(R.id.plot);
        noofbulid=findViewById(R.id.noofbulid);
        noofsotry=findViewById(R.id.noofsotry);
        plotinsqr=findViewById(R.id.plotinsqr);
        issue=findViewById(R.id.issue);
        ArrayAdapter<String> categary=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,category);
        category1.setAdapter(categary);
        ArrayAdapter<String>gender1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Gender);
        gender.setAdapter(gender1);
        ArrayAdapter<String>occupation1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Occupation);
        occupation.setAdapter(occupation1);
        ArrayAdapter<String> water=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Watersource);
        watersource.setAdapter(water);
        ArrayAdapter<String>toilet1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Toilet);
        toilet.setAdapter(toilet1);
        ArrayAdapter<String>yestolet=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Yestoilet);
        yestoilet.setAdapter(yestolet);
        ArrayAdapter<String>kitchen1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Kitchen);
        kitchen.setAdapter(kitchen1);
        submit=findViewById(R.id.submit);
        category1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cast=category1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gen=gender.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                occu=occupation.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        watersource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                source=watersource.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toilet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toi=toilet.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        yestoilet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                yestoi=yestoilet.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        kitchen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kit=kitchen.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Houseno=houseno.getText().toString();
                String noofhousehold=numberhousehold.getText().toString();
                String Nameofowner=nameofowner.getText().toString();
                String Age=age.getText().toString();
                String Qualification=qualification.getText().toString();
                String Noofmalemumber=nooffemalemember.getText().toString();
                String Nooffemalemumber=nooffemalemember.getText().toString();
                String Noofmalechildren=noofmalechildren.getText().toString();
                String Nooffemalechildren=nooffemalechildren.getText().toString();
                String Childno=childno.getText().toString();
                String Disablechild=disablechild.getText().toString();
                String Agriculter=agriculter.getText().toString();
                String Incom=incom.getText().toString();
                String Cattle=cattle.getText().toString();
                String Noofroom=noofroomh.getText().toString();
                String Plot=plot.getText().toString();
                String Noofbuilding=noofbulid.getText().toString();
                String Noofstory=noofsotry.getText().toString();
                String Plotinsqr=plotinsqr.getText().toString();
                String Issue=issue.getText().toString();
                 if (Houseno.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the House number",Toasty.LENGTH_SHORT,true).show();
                }

                else if(noofhousehold.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of households",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Nameofowner.isEmpty()){
                     Toasty.error(getApplicationContext(),"Please enter the Name of Owner",Toasty.LENGTH_SHORT,true).show();

                 }
                else if (Age.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the age",Toasty.LENGTH_SHORT,true).show();

                }
                 else if (Qualification.isEmpty()){
                     Toasty.error(getApplicationContext(),"Please enter the Qualification",Toasty.LENGTH_SHORT,true).show();

                 }else if (Noofmalemumber.isEmpty()){
                     Toasty.error(getApplicationContext(),"Please enter the number the male mumbers",Toasty.LENGTH_SHORT,true).show();

                 }else if (Nooffemalemumber.isEmpty()){
                     Toasty.error(getApplicationContext(),"Please enter the number of female mumber",Toasty.LENGTH_SHORT,true).show();

                 }else if (Noofmalechildren.isEmpty()){
                     Toasty.error(getApplicationContext(),"Please enter the Number of male children",Toasty.LENGTH_SHORT,true).show();

                 }else if (Nooffemalechildren.isEmpty()){
                     Toasty.error(getApplicationContext(),"Please enter the number of female children",Toasty.LENGTH_SHORT,true).show();

                 }

                else if (Childno.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of childs",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Disablechild.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of desable childs",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Agriculter.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the agriculter area in sqr",Toasty.LENGTH_SHORT,true).show();

                }
                else if (Incom.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the Avg. monthly incom",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Cattle.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of cattle",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Noofroom.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of rooms",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Plot.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the plotarea in households",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Noofbuilding.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of building",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Noofstory.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of story",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Plotinsqr.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the plotarea in sqr",Toasty.LENGTH_SHORT,true).show();
                }
                else if (Issue.isEmpty()){
                    Toasty.error(getApplicationContext(),"Please enter the number of households",Toasty.LENGTH_SHORT,true).show();
                }
                else {
                      final ProgressDialog dialog=new ProgressDialog(households.this);
                      dialog.setCanceledOnTouchOutside(false);
                     dialog.setCancelable(false);
                      dialog.setMessage("Please wait data inserted....");
                      dialog.show();

                      FirebaseUser user2=FirebaseAuth.getInstance().getCurrentUser();
                      String uid=user2.getUid();

                      sendreference=FirebaseDatabase.getInstance().getReference().child("households").child(uid).push();


                     HashMap<String,Object> usermap = new HashMap<>();
                     usermap.put("house_number", Houseno);
                     usermap.put("households_number", noofhousehold);
                     usermap.put("owner_name", Nameofowner);
                     usermap.put("owner_caste", cast);
                     usermap.put("owner_gender", gen);
                     usermap.put("owner_age", Age);
                     usermap.put("qualification", Qualification);
                     usermap.put("number_of_male_member", Noofmalemumber);
                     usermap.put("number_of_female_member", Nooffemalemumber);
                     usermap.put("number_of_male_children", Noofmalechildren);
                     usermap.put("number_of_female_children", Nooffemalechildren);
                     usermap.put("occupation", occu);
                     usermap.put("children_number", Childno);
                     usermap.put("disable_children_number", Disablechild);
                     usermap.put("water_source", source);
                     usermap.put("agriculture", Agriculter);
                     usermap.put("monthly_income", Incom);
                     usermap.put("cattle_number", Cattle);
                     usermap.put("toilet", toi);
                     usermap.put("toilet_typw", yestoi);
                     usermap.put("number_of_rooms", Noofroom);
                     usermap.put("kitchen", kit);
                     usermap.put("Plot", Plot);
                     usermap.put("number_of_building", Noofbuilding);
                     usermap.put("number_of_story", Noofstory);
                     usermap.put("plotarea", Plotinsqr);
                     usermap.put("particular_issue", Issue);

                  sendreference.setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                      @Override
                      public void onComplete(@NonNull Task<Void> task) {
                      if (task.isSuccessful()){
                          dialog.dismiss();
                          Toasty.success(getApplicationContext(),"Data inserted Successfully",Toasty.LENGTH_LONG,true).show();

                          houseno.setText("");
                          numberhousehold.setText("");
                          nameofowner.setText("");
                          age.setText("");
                          qualification.setText("");
                          noofmalemember.setText("");
                          nooffemalemember.setText("");
                          noofmalechildren.setText("");
                          nooffemalechildren.setText("");
                          childno.setText("");
                          disablechild.setText("");
                          agriculter.setText("");
                          incom.setText("");
                          cattle.setText("");
                          noofroomh.setText("");
                          plot.setText("");
                          noofbulid.setText("");
                          noofsotry.setText("");
                          plotinsqr.setText("");
                          issue.setText("");

                      }

                      }
                  }).addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          dialog.hide();
                     Toasty.error(getApplicationContext(),"Data inserted failed try again",Toasty.LENGTH_LONG).show();
                      }
                  });



                      }
            }
        });

    }
}
