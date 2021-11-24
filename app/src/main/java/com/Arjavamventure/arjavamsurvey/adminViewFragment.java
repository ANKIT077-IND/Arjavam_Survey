package com.Arjavamventure.arjavamsurvey;

import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;


/**
 * A simple {@link Fragment} subclass.
 */
public class adminViewFragment extends Fragment {
     RecyclerView recview;
     String cast,gen,occu,source,toi,yestoi,kit;

    public adminViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_admin_view, container, false);
         FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
         String uid=user.getUid();
        recview=view.findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<fatchdatamodel> options =
                new FirebaseRecyclerOptions.Builder<fatchdatamodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("households").child(uid), fatchdatamodel.class)
                        .build();


        FirebaseRecyclerAdapter<fatchdatamodel,fatchdataviewholder>adapter=new FirebaseRecyclerAdapter<fatchdatamodel,fatchdataviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull fatchdataviewholder holder, int position, @NonNull fatchdatamodel model) {
                holder.age.setText(model.getOwner_age());
                holder.agriculter.setText(model.getAgriculture());
                holder.cast.setText(model.getOwner_caste());
                holder.cattle.setText(model.getCattle_number());
                holder.childno.setText(model.getChildren_number());
                holder.disablechild.setText(model.getDisable_children_number());
                holder.educationlevel.setText(model.getQualification());
                holder.gender.setText(model.getOwner_gender());
                holder.houseno.setText(model.getHouse_number());
                holder.income.setText(model.getMonthly_income());
                holder.issue.setText(model.getParticular_issue());
                holder.kitchan.setText(model.getKitchen());
                holder.nameofowner.setText(model.getOwner_name());
                holder.noofbulid.setText(model.getNumber_of_building());
                holder.nooffemalechildren.setText(model.getNumber_of_female_children());
                holder.nooffemalemumbers.setText(model.getNumber_of_female_member());
                holder.noofmalechildren.setText(model.getNumber_of_male_children());
                holder.noofmalemumbers.setText(model.getNumber_of_male_member());
                holder.noofroom.setText(model.getNumber_of_rooms());
                holder.noofsotry.setText(model.getNumber_of_story());
                holder.numberhousehold.setText(model.getHouseholds_number());
                holder.occupation.setText(model.getOccupation());
                holder.plot.setText(model.getPlot());
                holder.plotinsqr.setText(model.getPlotarea());
                holder.toilet.setText(model.getToilet());
                holder.watersoure.setText(model.getWater_source());
                holder.yestoilet.setText(model.getToilet_typw());


                holder.edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final DialogPlus dialog = DialogPlus.newDialog(getContext())
                                .setContentHolder(new ViewHolder(R.layout.updatedata))
                                .setGravity(Gravity.CENTER)
                                .setMargin(20,100,20,70)
                                .setExpanded(false)
                                .create();


                        View view1=(RelativeLayout)dialog.getHolderView();
                       final Spinner category1,gender,occupation,watersource,toilet,yestoilet,kitchen;
                        String category[]={"General","ST","SC","OBC"};
                        String Gender[]={"Male","Female","Other"};
                        String Occupation[]={"Student","Farmer","Employee","Self-Employee","Business","Service"};
                        String Watersource[]={"Tap(नल)","Tubewell(नलकूप)","Tanker(टैंकर)"," None(कोई नहीं)"};
                        String Toilet[]={"Yes","No"};
                        String Yestoilet[]={"built by the owner","PMAY scheme"};
                        String Kitchen[]={"Yes","No"};
                       final EditText houseno,numberhousehold,nameofowner,age,qualification,noofmalemember,nooffemalemember,noofmalechildren,nooffemalechildren,childno,disablechild,agriculter,incom,cattle,noofroomh,plot,noofbulid,noofsotry,plotinsqr,issue;
                        Button Update;

                        category1=view1.findViewById(R.id.cast);
                        gender=view1.findViewById(R.id.gender);
                        occupation=view1.findViewById(R.id.occupation);
                        watersource=view1.findViewById(R.id.watersoure);
                        toilet=view1.findViewById(R.id.toilet);
                        yestoilet=view1.findViewById(R.id.yestoilet);
                        kitchen=view1.findViewById(R.id.kitchan);
                        houseno=view1.findViewById(R.id.houseno);
                        numberhousehold=view1.findViewById(R.id.numberhousehold);
                        nameofowner=view1.findViewById(R.id.nameofowner);
                        age=view1.findViewById(R.id.age);
                        qualification=view1.findViewById(R.id.educationlevel);
                        noofmalemember=view1.findViewById(R.id.noofmalemumbers);
                        nooffemalemember=view1.findViewById(R.id.nooffemalemumbers);
                        noofmalechildren=view1.findViewById(R.id.noofmalechildren);
                        nooffemalechildren=view1.findViewById(R.id.nooffemalechildren);
                        childno=view1.findViewById(R.id.childno);
                        disablechild=view1.findViewById(R.id.disablechild);
                        agriculter=view1.findViewById(R.id.agriculter);
                        incom=view1.findViewById(R.id.incom);
                        cattle=view1.findViewById(R.id.cattle);
                        noofroomh=view1.findViewById(R.id.noofroomh);
                        plot=view1.findViewById(R.id.plot);
                        noofbulid=view1.findViewById(R.id.noofbulid);
                        noofsotry=view1.findViewById(R.id.noofsotry);
                        plotinsqr=view1.findViewById(R.id.plotinsqr);
                        issue=view1.findViewById(R.id.issue);
                        Update=view1.findViewById(R.id.updatedata);
                        ArrayAdapter<String> categary=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,category);
                        category1.setAdapter(categary);
                        ArrayAdapter<String>gender1=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,Gender);
                        gender.setAdapter(gender1);
                        ArrayAdapter<String>occupation1=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,Occupation);
                        occupation.setAdapter(occupation1);
                        ArrayAdapter<String> water=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,Watersource);
                        watersource.setAdapter(water);
                        ArrayAdapter<String>toilet1=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,Toilet);
                        toilet.setAdapter(toilet1);
                        ArrayAdapter<String>yestolet=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,Yestoilet);
                        yestoilet.setAdapter(yestolet);
                        ArrayAdapter<String>kitchen1=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,Kitchen);
                        kitchen.setAdapter(kitchen1);
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
                       age.setText(model.getOwner_age());
                       agriculter.setText(model.getAgriculture());
                        cattle.setText(model.getCattle_number());
                        childno.setText(model.getChildren_number());
                        disablechild.setText(model.getDisable_children_number());
                       qualification.setText(model.getQualification());
                        houseno.setText(model.getHouse_number());
                        incom.setText(model.getMonthly_income());
                        issue.setText(model.getParticular_issue());
                        nameofowner.setText(model.getOwner_name());
                        noofbulid.setText(model.getNumber_of_building());
                        nooffemalechildren.setText(model.getNumber_of_female_children());
                        nooffemalemember.setText(model.getNumber_of_female_member());
                        noofmalechildren.setText(model.getNumber_of_male_children());
                        noofmalemember.setText(model.getNumber_of_male_member());
                        noofroomh.setText(model.getNumber_of_rooms());
                        noofsotry.setText(model.getNumber_of_story());
                        numberhousehold.setText(model.getHouseholds_number());
                        plot.setText(model.getPlot());
                        plotinsqr.setText(model.getPlotarea());

                        Update.setOnClickListener(new View.OnClickListener() {
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
                                FirebaseUser user1=FirebaseAuth.getInstance().getCurrentUser();
                                String uid=user1.getUid();
                                FirebaseDatabase.getInstance().getReference().child("households").child(uid).child(getRef(position).getKey()).updateChildren(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                       if (task.isSuccessful()){
                                           Toasty.success(getContext(),"Data Updated Successfully",Toasty.LENGTH_LONG,true).show();
                                       }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toasty.error(getContext(),"Data is not Updated ",Toasty.LENGTH_LONG,true).show();
                                    }
                                });

                            }
                        });

                        dialog.show();

                    }
                });

                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseUser user2=FirebaseAuth.getInstance().getCurrentUser();
                        String uid=user2.getUid();
                        FirebaseDatabase.getInstance().getReference().child("households").child(uid).child(getRef(position).getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                             if (task.isSuccessful()){
                                 Toasty.success(getContext(),"Data Deleted Successfully",Toasty.LENGTH_LONG,true).show();

                             }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toasty.error(getContext(),"Data is not Deleted ",Toasty.LENGTH_LONG,true).show();

                            }
                        });

                    }
                });
            }

            @NonNull
            @Override
            public fatchdataviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.fatchdatarow,parent,false);
              return new fatchdataviewholder(view1);

            }
        };


        recview.setAdapter(adapter);
        adapter.startListening();

        return view;
    }
}
