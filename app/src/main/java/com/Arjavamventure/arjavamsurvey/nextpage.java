package com.Arjavamventure.arjavamsurvey;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class nextpage extends AppCompatActivity {
    Toolbar nexttoolbar;
     private FirebaseAuth mAuth;
    Spinner desk,sport,medical,food,toylet2,water,electricity,teachar,sporttype,problem,computer,computerstudent;
    String Desk[]={"Yes","No"};
    String Sport[]={"Yes","No"};
    String Medical[]={"Yes","No"};
    String Food[]={"Yes","No"};
    String Toylet2[]={"Yes","No"};
    String Water[]={"Tap(नल)","Tubewell(नलकूप)","Tanker(टैंकर)"," None(कोई नहीं)"};
    String Electricity[]={"Yes","No"};
    String Teachar[]={"Yes","No"};
   String Sporttype[]={"Yes","No"};
   String Problem[]={"Yes","No"};
   String Computer[]={"Yes","No"};
   String Computerstudent[]={"Yes","No"};
   EditText nameofschool,plotarea,noofbuilding,noofroom,noofteacher,madhyanbhojan,noofcomputer,noofcomputerstudent,lkgtotal,lkggirls,lkgboys,ukgtotal,ukggirls,ukgboys,onetotal,onegirls,oneboys,twototal,twogirls,twoboys,threetotal,threegirls,threeboys,fourtotal,fourgirls,fourboys,
    fivetotal,fivegirls,fiveboys,sixtotal,sixgirls,sixboys,seventotal,sevengirls,sevenboys,eighttotal,eightgirls,eightboys,ninetotal,ninegirls,nineboys,tentotal,tengirls,tenboys,
           eleventotal,elevengirls,elevenboys,twalvtotal,twalvgirls,twalvboys,schoollkgtotal,schoollkggirls,schoollkgboys,schoolukgtotal,schoolukggirls,schoolukgboys,schoolonetotal,schoolonegirls,schooloneboys,schooltwototal,schooltwogirls,schooltwoboys,schoolthreetotal,schoolthreegirls,schoolthreeboys,schoolfourtotal,schoolfourgirls,schoolfourboys,
           schoolfivetotal,schoolfivegirls,schoolfiveboys,schoolsixtotal,schoolsixgirls,schoolsixboys,schoolseventotal,schoolsevengirls,schoolsevenboys,schooleighttotal,schooleightgirls,schooleightboys,schoolninetotal,schoolninegirls,schoolnineboys,schooltentotal,schooltengirls,schooltenboys,
           schooleleventotal,schoolelevengirls,schoolelevenboys,schooltwalvtotal,schooltwalvgirls,schooltwalvboys;

    String des,spot,medica,foo,toyle,wate,electric,teache,sporttyp,proble,compute,computerstuden;
   Button submit;
   DatabaseReference nextreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);
       mAuth=FirebaseAuth.getInstance();
        nexttoolbar=findViewById(R.id.nexttoolbar);
        setSupportActionBar(nexttoolbar);
        getSupportActionBar().setTitle("For School");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        submit=findViewById(R.id.submit);
        desk=findViewById(R.id.desk);
        sport=findViewById(R.id.sport);
        medical=findViewById(R.id.medical);
        food=findViewById(R.id.food);
        toylet2=findViewById(R.id.toilet2);
        water=findViewById(R.id.sourceofwater);
        electricity=findViewById(R.id.electocity);
        teachar=findViewById(R.id.teachar);
        sporttype=findViewById(R.id.sporttype);
        problem=findViewById(R.id.problem);
        computer=findViewById(R.id.computer);
        computerstudent=findViewById(R.id.computerstudent);
        nameofschool=findViewById(R.id.nameofschool);
        plotarea=findViewById(R.id.plotarea);
        noofbuilding=findViewById(R.id.noofbuilding);
        noofroom=findViewById(R.id.noofroom);
        noofteacher=findViewById(R.id.noofteacher);
        madhyanbhojan=findViewById(R.id.madhyanbhojan);
        noofcomputer=findViewById(R.id.noofcomputer);
        noofcomputerstudent=findViewById(R.id.noofcomputerstudent);
       lkgtotal=findViewById(R.id.lkgtotal);
       lkggirls=findViewById(R.id.lkggirls);
       lkgboys=findViewById(R.id.lkgboys);
       ukgtotal=findViewById(R.id.ukgtotal);
       ukggirls=findViewById(R.id.ukggirls);
       ukgboys=findViewById(R.id.ukgboys);
       onetotal=findViewById(R.id.onetotal);
       onegirls=findViewById(R.id.onegirls);
       oneboys=findViewById(R.id.oneboys);
       twototal=findViewById(R.id.twototal);
       twogirls=findViewById(R.id.twogirls);
       twoboys=findViewById(R.id.twoboys);
       threetotal=findViewById(R.id.threetotal);
       threegirls=findViewById(R.id.threegirls);
       threeboys=findViewById(R.id.threeboys);
       fourtotal=findViewById(R.id.fourtotal);
       fourgirls=findViewById(R.id.fourgirls);
       fourboys=findViewById(R.id.fourboys);
       fivetotal=findViewById(R.id.fifthtotal);
       fivegirls=findViewById(R.id.fifthgirls);
       fiveboys=findViewById(R.id.fifthboys);
       sixtotal=findViewById(R.id.sixtotal);
       sixgirls=findViewById(R.id.sixgirls);
       sixboys=findViewById(R.id.sixboys);
       seventotal=findViewById(R.id.seventotal);
       sevengirls=findViewById(R.id.sevengirls);
       sevenboys=findViewById(R.id.sevenboys);
       eighttotal=findViewById(R.id.eighttotal);
       eightgirls=findViewById(R.id.eightgirls);
       eightboys=findViewById(R.id.eightboys);
       ninetotal=findViewById(R.id.ninetotal);
       ninegirls=findViewById(R.id.ninegirls);
       nineboys=findViewById(R.id.nineboys);
       tentotal=findViewById(R.id.tentotal);
       tengirls=findViewById(R.id.tengirls);
       tenboys=findViewById(R.id.tenboys);
       eleventotal=findViewById(R.id.eleventotal);
       elevengirls=findViewById(R.id.elevengirls);
       elevenboys=findViewById(R.id.elevenboys);
       twalvtotal=findViewById(R.id.twalbtotal);
       twalvgirls=findViewById(R.id.twalbgirls);
       twalvboys=findViewById(R.id.twalbboys);
        schoollkgtotal=findViewById(R.id.schoollkgtotal);
        schoollkggirls=findViewById(R.id.schoollkggirls);
        schoollkgboys=findViewById(R.id.schoollkgboys);
        schoolukgtotal=findViewById(R.id.schoolukgtotal);
        schoolukggirls=findViewById(R.id.schoolukggirls);
        schoolukgboys=findViewById(R.id.schoolukgboys);
        schoolonetotal=findViewById(R.id.schoolonetotal);
        schoolonegirls=findViewById(R.id.schoolonegirls);
        schooloneboys=findViewById(R.id.schooloneboys);
        schooltwototal=findViewById(R.id.schooltwototal);
        schooltwogirls=findViewById(R.id.schooltwogirls);
        schooltwoboys=findViewById(R.id.schooltwoboys);
        schoolthreetotal=findViewById(R.id.schoolthreetotal);
        schoolthreegirls=findViewById(R.id.schoolthreegirls);
        schoolthreeboys=findViewById(R.id.schoolthreeboys);
        schoolfourtotal=findViewById(R.id.schoolfourtotal);
        schoolfourgirls=findViewById(R.id.schoolfourgirls);
        schoolfourboys=findViewById(R.id.schoolfourboys);
        schoolfivetotal=findViewById(R.id.schoolfifthtotal);
        schoolfivegirls=findViewById(R.id.schoolfifthgirls);
        schoolfiveboys=findViewById(R.id.schoolfifthboys);
        schoolsixtotal=findViewById(R.id.schoolsixtotal);
        schoolsixgirls=findViewById(R.id.schoolsixgirls);
        schoolsixboys=findViewById(R.id.schoolsixboys);
        schoolseventotal=findViewById(R.id.schoolseventotal);
        schoolsevengirls=findViewById(R.id.schoolsevengirls);
        schoolsevenboys=findViewById(R.id.schoolsevenboys);
        schooleighttotal=findViewById(R.id.schooleighttotal);
        schooleightgirls=findViewById(R.id.schooleightgirls);
        schooleightboys=findViewById(R.id.schooleightboys);
        schoolninetotal=findViewById(R.id.schoolninetotal);
        schoolninegirls=findViewById(R.id.schoolninegirls);
        schoolnineboys=findViewById(R.id.schoolnineboys);
        schooltentotal=findViewById(R.id.schooltentotal);
        schooltengirls=findViewById(R.id.schooltengirls);
        schooltenboys=findViewById(R.id.schooltenboys);
        schooleleventotal=findViewById(R.id.schooleleventotal);
        schoolelevengirls=findViewById(R.id.schoolelevengirls);
        schoolelevenboys=findViewById(R.id.schoolelevenboys);
        schooltwalvtotal=findViewById(R.id.schooltwalbtotal);
        schooltwalvgirls=findViewById(R.id.schooltwalbgirls);
        schooltwalvboys=findViewById(R.id.schooltwalbboys);

       ArrayAdapter<String> desk1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Desk);
        desk.setAdapter(desk1);
        ArrayAdapter<String>sport1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Sport);
        sport.setAdapter(sport1);
        ArrayAdapter<String>medical1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Medical);
        medical.setAdapter(medical1);
        ArrayAdapter<String>food1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Food);
        food.setAdapter(food1);
        ArrayAdapter<String>tolet=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Toylet2);
        toylet2.setAdapter(tolet);
       ArrayAdapter<String>sourceofwater=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Water);
       water.setAdapter(sourceofwater);
       ArrayAdapter<String>electricity1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Electricity);
       electricity.setAdapter(electricity1);
       ArrayAdapter<String>teacher1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Teachar);
       teachar.setAdapter(teacher1);
       ArrayAdapter<String>sporttype1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Sporttype);
       sporttype.setAdapter(sporttype1);
       ArrayAdapter<String>problem1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Problem);
      problem.setAdapter(problem1);
      ArrayAdapter<String>computer1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Computer);
      computer.setAdapter(computer1);
     ArrayAdapter<String>computerstudent1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,Computerstudent);
     computerstudent.setAdapter(computerstudent1);
     desk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             des=desk.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     sport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             spot=sport.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     medical.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             medica=medical.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     food.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             foo=food.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     toylet2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             toyle=toylet2.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     water.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             wate=water.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     electricity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             electric=electricity.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     teachar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             teache=teachar.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     sporttype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             sporttyp=sporttype.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     problem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             proble=problem.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     computer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             compute=computer.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
     computerstudent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             computerstuden=computerstudent.getSelectedItem().toString();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });

     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String Nameofschool = nameofschool.getText().toString();
             String Plotarea = plotarea.getText().toString();
             String Noofbuilding = noofbuilding.getText().toString();
             String Noofroom = noofroom.getText().toString();
             String Noofteacher = noofteacher.getText().toString();
             String Madhyanbhojan = madhyanbhojan.getText().toString();
             String Noofcomputer = noofcomputer.getText().toString();
             String Noofcomputerstudent = noofcomputerstudent.getText().toString();
             String Lkgtotal = lkgtotal.getText().toString();
             String Lkggirls = lkggirls.getText().toString();
             String Lkgboys = lkgboys.getText().toString();
             String Ukgtotal = ukgtotal.getText().toString();
             String Ukggirls = ukggirls.getText().toString();
             String Ukgboys = ukgboys.getText().toString();
             String Onetotal = onetotal.getText().toString();
             String Onegirls = onegirls.getText().toString();
             String Oneboys = oneboys.getText().toString();
             String Twototal = twototal.getText().toString();
             String Twogirls = twogirls.getText().toString();
             String Twoboys = twoboys.getText().toString();
             String Threetotal = threetotal.getText().toString();
             String Threegirls = threegirls.getText().toString();
             String Threeboys = threeboys.getText().toString();
             String Fourtotal = fourtotal.getText().toString();
             String Fourgirls = fourgirls.getText().toString();
             String Fourboys = fourboys.getText().toString();
             String Fivetotal = fivetotal.getText().toString();
             String Fivegirls = fivegirls.getText().toString();
             String Fiveboys = fiveboys.getText().toString();
             String Sixtotal = sixtotal.getText().toString();
             String Sixgirls = sixgirls.getText().toString();
             String Sixboys = sixboys.getText().toString();
             String Seventotal = seventotal.getText().toString();
             String Sevengirls = sevengirls.getText().toString();
             String Sevenboys = sevenboys.getText().toString();
             String Eighttotal = eighttotal.getText().toString();
             String Eightgirls = eightgirls.getText().toString();
             String Eightboys = eightboys.getText().toString();
             String Ninetotal = ninetotal.getText().toString();
             String Ninegirls = ninegirls.getText().toString();
             String Nineboys = nineboys.getText().toString();
             String Tentotal = tentotal.getText().toString();
             String Tengirls = tengirls.getText().toString();
             String Tenboys = tenboys.getText().toString();
             String Eleventotal = eleventotal.getText().toString();
             String Elevengirls = elevengirls.getText().toString();
             String Elevenboys = elevenboys.getText().toString();
             String Twalbtotal = twalvtotal.getText().toString();
             String Twalbgirls = twalvgirls.getText().toString();
             String Twalbboys = twalvboys.getText().toString();
             String SchoolLkgtotal = schoollkgtotal.getText().toString();
             String SchoolLkggirls = schoollkggirls.getText().toString();
             String SchoolLkgboys = schoollkgboys.getText().toString();
             String SchoolUkgtotal = schoolukgtotal.getText().toString();
             String SchoolUkggirls = schoolukggirls.getText().toString();
             String SchoolUkgboys = schoolukgboys.getText().toString();
             String SchoolOnetotal = schoolonetotal.getText().toString();
             String SchoolOnegirls = schoolonegirls.getText().toString();
             String SchoolOneboys = schooloneboys.getText().toString();
             String SchoolTwototal = schooltwototal.getText().toString();
             String SchoolTwogirls = schooltwogirls.getText().toString();
             String SchoolTwoboys = schooltwoboys.getText().toString();
             String SchoolThreetotal = schoolthreetotal.getText().toString();
             String SchoolThreegirls = schoolthreegirls.getText().toString();
             String SchoolThreeboys = schoolthreeboys.getText().toString();
             String SchoolFourtotal = schoolfourtotal.getText().toString();
             String SchoolFourgirls = schoolfourgirls.getText().toString();
             String SchoolFourboys = schoolfourboys.getText().toString();
             String SchoolFivetotal = schoolfivetotal.getText().toString();
             String SchoolFivegirls = schoolfivegirls.getText().toString();
             String SchoolFiveboys = schoolfiveboys.getText().toString();
             String SchoolSixtotal = schoolsixtotal.getText().toString();
             String SchoolSixgirls = schoolsixgirls.getText().toString();
             String SchoolSixboys = schoolsixboys.getText().toString();
             String SchoolSeventotal = schoolseventotal.getText().toString();
             String SchoolSevengirls = schoolsevengirls.getText().toString();
             String SchoolSevenboys = schoolsevenboys.getText().toString();
             String SchoolEighttotal = schooleighttotal.getText().toString();
             String SchoolEightgirls = schooleightgirls.getText().toString();
             String SchoolEightboys = schooleightboys.getText().toString();
             String SchoolNinetotal = schoolninetotal.getText().toString();
             String SchoolNinegirls = schoolninegirls.getText().toString();
             String SchoolNineboys = schoolnineboys.getText().toString();
             String SchoolTentotal = schooltentotal.getText().toString();
             String SchoolTengirls = schooltengirls.getText().toString();
             String SchoolTenboys = schooltenboys.getText().toString();
             String SchoolEleventotal = schooleleventotal.getText().toString();
             String SchoolElevengirls = schoolelevengirls.getText().toString();
             String SchoolElevenboys = schoolelevenboys.getText().toString();
             String SchoolTwalbtotal = schooltwalvtotal.getText().toString();
             String SchoolTwalbgirls = schooltwalvgirls.getText().toString();
             String SchoolTwalbboys = schooltwalvboys.getText().toString();

             if (Nameofschool.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the name of school", Toast.LENGTH_SHORT).show();
             } else if (Plotarea.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the Plotarea in sqr", Toast.LENGTH_SHORT).show();
             } else if (Noofbuilding.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please Enter the number of building", Toast.LENGTH_SHORT).show();
             } else if (Noofroom.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the no of rooms", Toast.LENGTH_SHORT).show();
             } else if (Noofteacher.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the number of teachers", Toast.LENGTH_SHORT).show();
             } else if (Madhyanbhojan.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the schedule of week in mid-day", Toast.LENGTH_SHORT).show();
             } else if (Noofcomputer.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the no of computer", Toast.LENGTH_SHORT).show();
             } else if (Noofcomputerstudent.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the no of computer in student", Toast.LENGTH_SHORT).show();
             } else if (Lkgtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the lkg total student number", Toast.LENGTH_SHORT).show();
             } else if (Lkggirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the lkg  girls number", Toast.LENGTH_SHORT).show();
             } else if (Lkgboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the lkg boys number", Toast.LENGTH_SHORT).show();
             }else if (Ukgtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the ukg total student number", Toast.LENGTH_SHORT).show();
             } else if (Ukggirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the ukg  girls number", Toast.LENGTH_SHORT).show();
             } else if (Ukgboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the Ukg boys number", Toast.LENGTH_SHORT).show();
             }else if (Onetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 1th total student number", Toast.LENGTH_SHORT).show();
             } else if (Onegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 1th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Oneboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 1th boys number", Toast.LENGTH_SHORT).show();
             }else if (Twototal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 2nd total student number", Toast.LENGTH_SHORT).show();
             } else if (Twogirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 2nd  girls number", Toast.LENGTH_SHORT).show();
             } else if (Twoboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 2nd boys number", Toast.LENGTH_SHORT).show();
             }else if (Threetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 3rd total student number", Toast.LENGTH_SHORT).show();
             } else if (Threegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 3rd  girls number", Toast.LENGTH_SHORT).show();
             } else if (Threeboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 3rd boys number", Toast.LENGTH_SHORT).show();
             }else if (Fourtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 4th total student number", Toast.LENGTH_SHORT).show();
             } else if (Fourgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 4th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Fourboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 4th boys number", Toast.LENGTH_SHORT).show();
             }else if (Fivetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 5th total student number", Toast.LENGTH_SHORT).show();
             } else if (Fivegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 5th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Fiveboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 5th boys number", Toast.LENGTH_SHORT).show();
             }else if (Sixtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 6th total student number", Toast.LENGTH_SHORT).show();
             } else if (Sixgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 6th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Sixboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 6th boys number", Toast.LENGTH_SHORT).show();
             }else if (Seventotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 7th total student number", Toast.LENGTH_SHORT).show();
             } else if (Sevengirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 7th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Sevenboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 7th boys number", Toast.LENGTH_SHORT).show();
             }else if (Eighttotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 8th total student number", Toast.LENGTH_SHORT).show();
             } else if (Eightgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 8th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Eightboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 8th boys number", Toast.LENGTH_SHORT).show();
             }else if (Ninetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 9th total student number", Toast.LENGTH_SHORT).show();
             } else if (Ninegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 9th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Nineboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 9th boys number", Toast.LENGTH_SHORT).show();
             }else if (Tentotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 10th total student number", Toast.LENGTH_SHORT).show();
             } else if (Tengirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 10th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Tenboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 10th boys number", Toast.LENGTH_SHORT).show();
             }else if (Eleventotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 11th total student number", Toast.LENGTH_SHORT).show();
             } else if (Elevengirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 11th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Elevenboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 11th boys number", Toast.LENGTH_SHORT).show();
             }else if (Twalbtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 12th total student number", Toast.LENGTH_SHORT).show();
             } else if (Twalbgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 12th  girls number", Toast.LENGTH_SHORT).show();
             } else if (Twalbboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the 12th boys number", Toast.LENGTH_SHORT).show();
             } else if (SchoolLkgtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio lkg total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolLkggirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio lkg  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolLkgboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio lkg boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolUkgtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio ukg total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolUkggirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio ukg  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolUkgboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio Ukg boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolOnetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 1th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolOnegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 1th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolOneboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 1th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolTwototal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 2nd total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolTwogirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 2nd  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolTwoboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 2nd boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolThreetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 3rd total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolThreegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 3rd  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolThreeboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 3rd boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolFourtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 4th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolFourgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 4th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolFourboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 4th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolFivetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 5th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolFivegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 5th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolFiveboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 5th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolSixtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 6th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolSixgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 6th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolSixboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 6th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolSeventotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 7th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolSevengirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 7th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolSevenboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 7th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolEighttotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 8th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolEightgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 8th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolEightboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 8th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolNinetotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 9th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolNinegirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 9th girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolNineboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 9th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolTentotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 10th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolTengirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 10th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolTenboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 10th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolEleventotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 11th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolElevengirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 11th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolElevenboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 11th boys number", Toast.LENGTH_SHORT).show();
             }else if (SchoolTwalbtotal.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 12th total student number", Toast.LENGTH_SHORT).show();
             } else if (SchoolTwalbgirls.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 12th  girls number", Toast.LENGTH_SHORT).show();
             } else if (SchoolTwalbboys.isEmpty()) {
                 Toast.makeText(nextpage.this, "Please enter the drop out ratio 12th boys number", Toast.LENGTH_SHORT).show();
             }
             else{
                 final ProgressDialog dialog=new ProgressDialog(nextpage.this);
                 dialog.setCanceledOnTouchOutside(false);
                 dialog.setCancelable(false);
                 dialog.setMessage("Please wait data inserted");
                 dialog.show();

                 FirebaseUser user1=mAuth.getCurrentUser();
                 String uid=user1.getUid();

                 nextreference = FirebaseDatabase.getInstance().getReference("school").child(uid).push();

                 HashMap<String,Object>map=new HashMap<>();
                 map.put("name_Of_school",Nameofschool);
                 map.put("School_plotarea",Plotarea);
                 map.put("nunber_of_buliding",Noofbuilding);
                 map.put("number_of_rooms",Noofroom);
                 map.put("number_of_teachers",Noofteacher);
                 map.put("desk",des);
                 map.put("sport",spot);
                 map.put("medical",medica);
                 map.put("madhyanbhojan",Madhyanbhojan);
                 map.put("food",foo);
                 map.put("toilet",toyle);
                 map.put("water",wate);
                 map.put("electricity",electric);
                 map.put("teacher",teache);
                 map.put("sport_type",sporttyp);
                 map.put("problem",proble);
                 map.put("computer_in_teachers",compute);
                 map.put("no_of_computer_Teachers",Noofcomputer);
                 map.put("computer_in_student",computerstuden);
                 map.put("no_of_computer_student",Noofcomputerstudent);
                 map.put("lkg_total",Lkgtotal);
                 map.put("lkg_girls",Lkggirls);
                 map.put("lkg_boys",Lkgboys);
                 map.put("ukg_total",Ukgtotal);
                 map.put("ukg_girls",Ukggirls);
                 map.put("ukg_boys",Ukgboys);
                 map.put("one_total",Onetotal);
                 map.put("one_girls",Onegirls);
                 map.put("one_boys",Oneboys);
                 map.put("two_total",Twototal);
                 map.put("two_girls",Twogirls);
                 map.put("two_boys",Twoboys);
                 map.put("three_total",Threetotal);
                 map.put("three_girls",Threegirls);
                 map.put("three_boys",Threeboys);
                 map.put("four_total",Fourtotal);
                 map.put("four_girls",Fourgirls);
                 map.put("four_boys",Fourboys);
                 map.put("five_total",Fivetotal);
                 map.put("five_girls",Fivegirls);
                 map.put("five_boys",Fiveboys);
                 map.put("six_total",Sixtotal);
                 map.put("six_girls",Sixgirls);
                 map.put("six_boys",Sixboys);
                 map.put("seven_total",Seventotal);
                 map.put("seven_girls",Sevengirls);
                 map.put("seven_boys",Sevenboys);
                 map.put("eight_total",Eighttotal);
                 map.put("eight_girls",Eightgirls);
                 map.put("eight_boys",Eightboys);
                 map.put("nine_total",Ninetotal);
                 map.put("nine_girls",Ninegirls);
                 map.put("nine_boys",Nineboys);
                 map.put("ten_total",Tentotal);
                 map.put("teng_irls",Tengirls);
                 map.put("ten_boys",Tenboys);
                 map.put("eleven_total",Eleventotal);
                 map.put("eleven_girls",Elevengirls);
                 map.put("eleven_boys",Elevenboys);
                 map.put("twelve_total",Twalbtotal);
                 map.put("twelve_girls",Twalbgirls);
                 map.put("twelve_boys",Twalbboys);
                 map.put("dropOut_lkg_total",SchoolLkgtotal);
                 map.put("dropOut_lkg_girls",SchoolLkggirls);
                 map.put("dropOut_lkg_boys",SchoolLkgboys);
                 map.put("dropOut_ukg_total",SchoolUkgtotal);
                 map.put("dropOut_ukg_girls",SchoolUkggirls);
                 map.put("dropOut_ukg_boys",SchoolUkgboys);
                 map.put("dropOut_one_total",SchoolOnetotal);
                 map.put("dropOut_one_girls",SchoolOnegirls);
                 map.put("dropOut_one_boys",SchoolOneboys);
                 map.put("dropOut_two_total",SchoolTwototal);
                 map.put("dropOut_two_girls",SchoolTwogirls);
                 map.put("dropOut_two_boys",SchoolTwoboys);
                 map.put("dropOut_three_total",SchoolThreetotal);
                 map.put("dropOut_three_girls",SchoolThreegirls);
                 map.put("dropOut_three_boys",SchoolThreeboys);
                 map.put("dropOut_four_total",SchoolFourtotal);
                 map.put("dropOut_four_girls",SchoolFourgirls);
                 map.put("dropOut_four_boys",SchoolFourboys);
                 map.put("dropOut_five_total",SchoolFivetotal);
                 map.put("dropOut_five_girls",SchoolFivegirls);
                 map.put("dropOut_five_boys",SchoolFiveboys);
                 map.put("dropOut_six_total",SchoolSixtotal);
                 map.put("dropOut_six_girls",SchoolSixgirls);
                 map.put("dropOut_six_boys",SchoolSixboys);
                 map.put("dropOut_seven_total",SchoolSeventotal);
                 map.put("dropOut_seven_girls",SchoolSevengirls);
                 map.put("dropOut_seven_boys",SchoolSevenboys);
                 map.put("dropOut_eight_total",SchoolEighttotal);
                 map.put("dropOut_eight_girls",SchoolEightgirls);
                 map.put("dropOut_eight_boys",SchoolEightboys);
                 map.put("dropOut_nine_total",SchoolNinetotal);
                 map.put("dropOut_nine_girls",SchoolNinegirls);
                 map.put("dropOut_nine_boys",SchoolNineboys);
                 map.put("dropOut_ten_total",SchoolTentotal);
                 map.put("dropOut_teng_irls",SchoolTengirls);
                 map.put("dropOut_ten_boys",SchoolTenboys);
                 map.put("dropOut_eleven_total",SchoolEleventotal);
                 map.put("dropOut_eleven_girls",SchoolElevengirls);
                 map.put("dropOut_eleven_boys",SchoolElevenboys);
                 map.put("dropOut_twelve_total",SchoolTwalbtotal);
                 map.put("dropOut_twelve_girls",SchoolTwalbgirls);
                 map.put("dropOut_twelve_boys",SchoolTwalbboys);


              nextreference.setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                      if (task.isSuccessful()){
                          dialog.dismiss();
                          Toasty.success(getApplicationContext(),"Data inserted Successfully",Toasty.LENGTH_LONG,true).show();

                          nameofschool.setText("");
                          plotarea.setText("");
                          noofbuilding.setText("");
                          noofroom.setText("");
                          noofteacher.setText("");
                          madhyanbhojan.setText("");
                          noofcomputer.setText("");
                          noofcomputerstudent.setText("");
                          lkgtotal.setText("");
                          lkggirls.setText("");
                          lkgboys.setText("");
                          ukgtotal.setText("");
                          ukggirls.setText("");
                          ukgboys.setText("");
                          onetotal.setText("");
                          onegirls.setText("");
                          oneboys.setText("");
                          twototal.setText("");
                          twogirls.setText("");
                          twoboys.setText("");
                          threetotal.setText("");
                          threegirls.setText("");
                          threeboys.setText("");
                          fourtotal.setText("");
                          fourgirls.setText("");
                          fourboys.setText("");
                          fivetotal.setText("");
                          fivegirls.setText("");
                          fiveboys.setText("");
                          sixtotal.setText("");
                          sixgirls.setText("");
                          sixboys.setText("");
                          seventotal.setText("");
                          sevengirls.setText("");
                          sevenboys.setText("");
                          eighttotal.setText("");
                          eightgirls.setText("");
                          eightboys.setText("");
                          ninetotal.setText("");
                          ninegirls.setText("");
                          nineboys.setText("");
                          tentotal.setText("");
                          tengirls.setText("");
                          tenboys.setText("");
                          eleventotal.setText("");
                          elevengirls.setText("");
                          elevenboys.setText("");
                          twalvtotal.setText("");
                          twalvgirls.setText("");
                          twalvboys.setText("");
                          schoollkgtotal.setText("");
                          schoollkggirls.setText("");
                          schoollkgboys.setText("");
                          schoolukgtotal.setText("");
                          schoolukggirls.setText("");
                          schoolukgboys.setText("");
                          schoolonetotal.setText("");
                          schoolonegirls.setText("");
                          schooloneboys.setText("");
                          schooltwototal.setText("");
                          schooltwogirls.setText("");
                          schooltwoboys.setText("");
                          schoolthreetotal.setText("");
                          schoolthreegirls.setText("");
                          schoolthreeboys.setText("");
                          schoolfourtotal.setText("");
                          schoolfourgirls.setText("");
                          schoolfourboys.setText("");
                          schoolfivetotal.setText("");
                          schoolfivegirls.setText("");
                          schoolfiveboys.setText("");
                          schoolsixtotal.setText("");
                          schoolsixgirls.setText("");
                          schoolsixboys.setText("");
                          schoolseventotal.setText("");
                          schoolsevengirls.setText("");
                          schoolsevenboys.setText("");
                          schooleighttotal.setText("");
                          schooleightgirls.setText("");
                          schooleightboys.setText("");
                          schoolninetotal.setText("");
                          schoolninegirls.setText("");
                          schoolnineboys.setText("");
                          schooltentotal.setText("");
                          schooltengirls.setText("");
                          schooltenboys.setText("");
                          schooleleventotal.setText("");
                          schoolelevengirls.setText("");
                          schoolelevenboys.setText("");
                          schooltwalvtotal.setText("");
                          schooltwalvgirls.setText("");
                          schooltwalvboys.setText("");
                      }
                      else{
                          dialog.hide();
                          Toasty.error(getApplicationContext(),"Data  is not inserted",Toasty.LENGTH_LONG,true).show();
                      }
                  }
              });
             }
         }

     });

   }
}
