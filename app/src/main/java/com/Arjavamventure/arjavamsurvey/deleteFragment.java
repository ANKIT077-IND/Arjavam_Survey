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
public class deleteFragment extends Fragment {
    RecyclerView schoolview;
    String des,spot,medica,foo,toyle,wate,electric,teache,sporttyp,proble,compute,computerstuden;
    private FirebaseAuth mAuth;
    public deleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_delete, container, false);
        mAuth=FirebaseAuth.getInstance();
         schoolview=view.findViewById(R.id.schoolview);
         schoolview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String uid=user.getUid();
        FirebaseRecyclerOptions<schoolmodel> options =
                new FirebaseRecyclerOptions.Builder<schoolmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("school").child(uid), schoolmodel.class)
                        .build();


        FirebaseRecyclerAdapter<schoolmodel,schoolviewholder>adapter=new FirebaseRecyclerAdapter<schoolmodel, schoolviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull schoolviewholder holder, int position, @NonNull final schoolmodel model) {
            holder.nameofschool.setText(model.getName_Of_school());
            holder.plotarea.setText(model.getSchool_plotarea());
            holder.noofbuilding.setText(model.getNunber_of_buliding());
            holder.noofroom.setText(model.getNumber_of_rooms());
            holder.noofteacher.setText(model.getNumber_of_teachers());
            holder.desk.setText(model.getDesk());
            holder.sport.setText(model.getSport());
            holder.medical.setText(model.getMedical());
            holder.madhyanbhojan.setText(model.getMadhyanbhojan());
            holder.food.setText(model.getFood());
            holder.toylet2.setText(model.getToilet());
            holder.water.setText(model.getWater());
            holder.electricity.setText(model.getElectricity());
            holder.teachar.setText(model.getTeacher());
            holder.sporttype.setText(model.getSport_type());
            holder.problem.setText(model.getProblem());
            holder.computer.setText(model.getComputer_in_teachers());
            holder.noofcomputer.setText(model.getNo_of_computer_Teachers());
            holder.computerstudent.setText(model.getComputer_in_student());
            holder.noofcomputerstudent.setText(model.getNo_of_computer_student());
            holder.lkgtotal.setText(model.getLkg_total());
            holder.lkggirls.setText(model.getLkg_girls());
            holder.lkgboys.setText(model.getLkg_boys());
            holder.ukgtotal.setText(model.getUkg_total());
            holder.ukggirls.setText(model.getUkg_girls());
            holder.ukgboys.setText(model.getUkg_boys());
            holder.onetotal.setText(model.getOne_total());
            holder.onegirls.setText(model.getOne_girls());
            holder.oneboys.setText(model.getOne_boys());
            holder.twototal.setText(model.getTwo_total());
            holder.twogirls.setText(model.getTwo_girls());
            holder.twoboys.setText(model.getTwo_boys());
            holder.threetotal.setText(model.getThree_total());
            holder.threegirls.setText(model.getThree_girls());
            holder.threeboys.setText(model.getThree_boys());
            holder.fourtotal.setText(model.getFour_total());
            holder.fourgirls.setText(model.getFour_girls());
            holder.fourboys.setText(model.getFour_boys());
            holder.fivetotal.setText(model.getFive_total());
            holder.fivegirls.setText(model.getFive_girls());
            holder.fiveboys.setText(model.getFive_boys());
            holder.sixtotal.setText(model.getSix_total());
            holder.sixgirls.setText(model.getSix_girls());
            holder.sixboys.setText(model.getSix_boys());
            holder.seventotal.setText(model.getSeven_total());
            holder.sevengirls.setText(model.getSeven_girls());
            holder.sevenboys.setText(model.getSeven_boys());
            holder.eighttotal.setText(model.getEight_total());
            holder.eightgirls.setText(model.getEight_girls());
            holder.eightboys.setText(model.getEight_boys());
            holder.ninetotal.setText(model.getNine_total());
            holder.ninegirls.setText(model.getNine_girls());
            holder.nineboys.setText(model.getNine_boys());
            holder.tentotal.setText(model.getTen_total());
            holder.tengirls.setText(model.getTeng_irls());
            holder.tenboys.setText(model.getTen_boys());
            holder.eleventotal.setText(model.getEleven_total());
            holder.elevengirls.setText(model.getEleven_girls());
            holder.elevenboys.setText(model.getEleven_boys());
            holder.twalvtotal.setText(model.getTwelve_total());
            holder.twalvgirls.setText(model.getTwelve_girls());
            holder.twalvboys.setText(model.getTwelve_boys());
                holder.schoollkgtotal.setText(model.getDropOut_lkg_total());
                holder.schoollkggirls.setText(model.getDropOut_lkg_girls());
                holder.schoollkgboys.setText(model.getDropOut_lkg_boys());
                holder.schoolukgtotal.setText(model.getDropOut_ukg_total());
                holder.schoolukggirls.setText(model.getDropOut_ukg_girls());
                holder.schoolukgboys.setText(model.getDropOut_ukg_boys());
                holder.schoolonetotal.setText(model.getDropOut_one_total());
                holder.schoolonegirls.setText(model.getDropOut_one_girls());
                holder.schooloneboys.setText(model.getDropOut_one_boys());
                holder.schooltwototal.setText(model.getDropOut_two_total());
                holder.schooltwogirls.setText(model.getDropOut_two_girls());
                holder.schooltwoboys.setText(model.getDropOut_two_boys());
                holder.schoolthreetotal.setText(model.getDropOut_three_total());
                holder.schoolthreegirls.setText(model.getDropOut_three_girls());
                holder.schoolthreeboys.setText(model.getDropOut_three_boys());
                holder.schoolfourtotal.setText(model.getDropOut_four_total());
                holder.schoolfourgirls.setText(model.getDropOut_four_girls());
                holder.schoolfourboys.setText(model.getDropOut_four_boys());
                holder.schoolfivetotal.setText(model.getDropOut_five_total());
                holder.schoolfivegirls.setText(model.getDropOut_five_girls());
                holder.schoolfiveboys.setText(model.getDropOut_five_boys());
                holder.schoolsixtotal.setText(model.getDropOut_six_total());
                holder.schoolsixgirls.setText(model.getDropOut_six_girls());
                holder.schoolsixboys.setText(model.getDropOut_six_boys());
                holder.schoolseventotal.setText(model.getDropOut_seven_total());
                holder.schoolsevengirls.setText(model.getDropOut_seven_girls());
                holder.schoolsevenboys.setText(model.getDropOut_seven_boys());
                holder.schooleighttotal.setText(model.getDropOut_eight_total());
                holder.schooleightgirls.setText(model.getDropOut_eight_girls());
                holder.schooleightboys.setText(model.getDropOut_eight_boys());
                holder.schoolninetotal.setText(model.getDropOut_nine_total());
                holder.schoolninegirls.setText(model.getDropOut_nine_girls());
                holder.schoolnineboys.setText(model.getDropOut_nine_boys());
                holder.schooltentotal.setText(model.getDropOut_ten_total());
                holder.schooltengirls.setText(model.getDropOut_teng_irls());
                holder.schooltenboys.setText(model.getDropOut_ten_boys());
                holder.schooleleventotal.setText(model.getDropOut_eleven_total());
                holder.schoolelevengirls.setText(model.getDropOut_eleven_girls());
                holder.schoolelevenboys.setText(model.getDropOut_eleven_boys());
                holder.schooltwalvtotal.setText(model.getDropOut_twelve_total());
                holder.schooltwalvgirls.setText(model.getDropOut_twelve_girls());
                holder.schooltwalvboys.setText(model.getDropOut_twelve_boys());

                holder.editdata.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final DialogPlus dialog = DialogPlus.newDialog(getContext())
                                .setContentHolder(new ViewHolder(R.layout.updatedataschool))
                                .setGravity(Gravity.CENTER)
                                .setMargin(20,100,20,70)
                                .setExpanded(false)
                                .create();


                        View view1=(RelativeLayout)dialog.getHolderView();


                        final Spinner desk,sport,medical,food,toylet2,water,electricity,teachar,sporttype,problem,computer,computerstudent;
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
                      final EditText nameofschool,plotarea,noofbuilding,noofroom,noofteacher,madhyanbhojan,noofcomputer,noofcomputerstudent,lkgtotal,lkggirls,lkgboys,ukgtotal,ukggirls,ukgboys,onetotal,onegirls,oneboys,twototal,twogirls,twoboys,threetotal,threegirls,threeboys,fourtotal,fourgirls,fourboys,
                                fivetotal,fivegirls,fiveboys,sixtotal,sixgirls,sixboys,seventotal,sevengirls,sevenboys,eighttotal,eightgirls,eightboys,ninetotal,ninegirls,nineboys,tentotal,tengirls,tenboys,
                                eleventotal,elevengirls,elevenboys,twalvtotal,twalvgirls,twalvboys,schoollkgtotal,schoollkggirls,schoollkgboys,schoolukgtotal,schoolukggirls,schoolukgboys,schoolonetotal,schoolonegirls,schooloneboys,schooltwototal,schooltwogirls,schooltwoboys,schoolthreetotal,schoolthreegirls,schoolthreeboys,schoolfourtotal,schoolfourgirls,schoolfourboys,
                                schoolfivetotal,schoolfivegirls,schoolfiveboys,schoolsixtotal,schoolsixgirls,schoolsixboys,schoolseventotal,schoolsevengirls,schoolsevenboys,schooleighttotal,schooleightgirls,schooleightboys,schoolninetotal,schoolninegirls,schoolnineboys,schooltentotal,schooltengirls,schooltenboys,
                                schooleleventotal,schoolelevengirls,schoolelevenboys,schooltwalvtotal,schooltwalvgirls,schooltwalvboys;

                         Button Updatedata=view1.findViewById(R.id.updatedataschool);
                        desk=view1.findViewById(R.id.desk);
                        sport=view1.findViewById(R.id.sport);
                        medical=view1.findViewById(R.id.medical);
                        food=view1.findViewById(R.id.food);
                        toylet2=view1.findViewById(R.id.toilet2);
                        water=view1.findViewById(R.id.sourceofwater);
                        electricity=view1.findViewById(R.id.electocity);
                        teachar=view1.findViewById(R.id.teachar);
                        sporttype=view1.findViewById(R.id.sporttype);
                        problem=view1.findViewById(R.id.problem);
                        computer=view1.findViewById(R.id.computer);
                        computerstudent=view1.findViewById(R.id.computerstudent);
                        nameofschool=view1.findViewById(R.id.nameofschool);
                        plotarea=view1.findViewById(R.id.plotarea);
                        noofbuilding=view1.findViewById(R.id.noofbuilding);
                        noofroom=view1.findViewById(R.id.noofroom);
                        noofteacher=view1.findViewById(R.id.noofteacher);
                        madhyanbhojan=view1.findViewById(R.id.madhyanbhojan);
                        noofcomputer=view1.findViewById(R.id.noofcomputer);
                        noofcomputerstudent=view1.findViewById(R.id.noofcomputerstudent);
                        lkgtotal=view1.findViewById(R.id.lkgtotal);
                        lkggirls=view1.findViewById(R.id.lkggirls);
                        lkgboys=view1.findViewById(R.id.lkgboys);
                        ukgtotal=view1.findViewById(R.id.ukgtotal);
                        ukggirls=view1.findViewById(R.id.ukggirls);
                        ukgboys=view1.findViewById(R.id.ukgboys);
                        onetotal=view1.findViewById(R.id.onetotal);
                        onegirls=view1.findViewById(R.id.onegirls);
                        oneboys=view1.findViewById(R.id.oneboys);
                        twototal=view1.findViewById(R.id.twototal);
                        twogirls=view1.findViewById(R.id.twogirls);
                        twoboys=view1.findViewById(R.id.twoboys);
                        threetotal=view1.findViewById(R.id.threetotal);
                        threegirls=view1.findViewById(R.id.threegirls);
                        threeboys=view1.findViewById(R.id.threeboys);
                        fourtotal=view1.findViewById(R.id.fourtotal);
                        fourgirls=view1.findViewById(R.id.fourgirls);
                        fourboys=view1.findViewById(R.id.fourboys);
                        fivetotal=view1.findViewById(R.id.fifthtotal);
                        fivegirls=view1.findViewById(R.id.fifthgirls);
                        fiveboys=view1.findViewById(R.id.fifthboys);
                        sixtotal=view1.findViewById(R.id.sixtotal);
                        sixgirls=view1.findViewById(R.id.sixgirls);
                        sixboys=view1.findViewById(R.id.sixboys);
                        seventotal=view1.findViewById(R.id.seventotal);
                        sevengirls=view1.findViewById(R.id.sevengirls);
                        sevenboys=view1.findViewById(R.id.sevenboys);
                        eighttotal=view1.findViewById(R.id.eighttotal);
                        eightgirls=view1.findViewById(R.id.eightgirls);
                        eightboys=view1.findViewById(R.id.eightboys);
                        ninetotal=view1.findViewById(R.id.ninetotal);
                        ninegirls=view1.findViewById(R.id.ninegirls);
                        nineboys=view1.findViewById(R.id.nineboys);
                        tentotal=view1.findViewById(R.id.tentotal);
                        tengirls=view1.findViewById(R.id.tengirls);
                        tenboys=view1.findViewById(R.id.tenboys);
                        eleventotal=view1.findViewById(R.id.eleventotal);
                        elevengirls=view1.findViewById(R.id.elevengirls);
                        elevenboys=view1.findViewById(R.id.elevenboys);
                        twalvtotal=view1.findViewById(R.id.twalbtotal);
                        twalvgirls=view1.findViewById(R.id.twalbgirls);
                        twalvboys=view1.findViewById(R.id.twalbboys);
                        schoollkgtotal=view1.findViewById(R.id.schoollkgtotal);
                        schoollkggirls=view1.findViewById(R.id.schoollkggirls);
                        schoollkgboys=view1.findViewById(R.id.schoollkgboys);
                        schoolukgtotal=view1.findViewById(R.id.schoolukgtotal);
                        schoolukggirls=view1.findViewById(R.id.schoolukggirls);
                        schoolukgboys=view1.findViewById(R.id.schoolukgboys);
                        schoolonetotal=view1.findViewById(R.id.schoolonetotal);
                        schoolonegirls=view1.findViewById(R.id.schoolonegirls);
                        schooloneboys=view1.findViewById(R.id.schooloneboys);
                        schooltwototal=view1.findViewById(R.id.schooltwototal);
                        schooltwogirls=view1.findViewById(R.id.schooltwogirls);
                        schooltwoboys=view1.findViewById(R.id.schooltwoboys);
                        schoolthreetotal=view1.findViewById(R.id.schoolthreetotal);
                        schoolthreegirls=view1.findViewById(R.id.schoolthreegirls);
                        schoolthreeboys=view1.findViewById(R.id.schoolthreeboys);
                        schoolfourtotal=view1.findViewById(R.id.schoolfourtotal);
                        schoolfourgirls=view1.findViewById(R.id.schoolfourgirls);
                        schoolfourboys=view1.findViewById(R.id.schoolfourboys);
                        schoolfivetotal=view1.findViewById(R.id.schoolfifthtotal);
                        schoolfivegirls=view1.findViewById(R.id.schoolfifthgirls);
                        schoolfiveboys=view1.findViewById(R.id.schoolfifthboys);
                        schoolsixtotal=view1.findViewById(R.id.schoolsixtotal);
                        schoolsixgirls=view1.findViewById(R.id.schoolsixgirls);
                        schoolsixboys=view1.findViewById(R.id.schoolsixboys);
                        schoolseventotal=view1.findViewById(R.id.schoolseventotal);
                        schoolsevengirls=view1.findViewById(R.id.schoolsevengirls);
                        schoolsevenboys=view1.findViewById(R.id.schoolsevenboys);
                        schooleighttotal=view1.findViewById(R.id.schooleighttotal);
                        schooleightgirls=view1.findViewById(R.id.schooleightgirls);
                        schooleightboys=view1.findViewById(R.id.schooleightboys);
                        schoolninetotal=view1.findViewById(R.id.schoolninetotal);
                        schoolninegirls=view1.findViewById(R.id.schoolninegirls);
                        schoolnineboys=view1.findViewById(R.id.schoolnineboys);
                        schooltentotal=view1.findViewById(R.id.schooltentotal);
                        schooltengirls=view1.findViewById(R.id.schooltengirls);
                        schooltenboys=view1.findViewById(R.id.schooltenboys);
                        schooleleventotal=view1.findViewById(R.id.schooleleventotal);
                        schoolelevengirls=view1.findViewById(R.id.schoolelevengirls);
                        schoolelevenboys=view1.findViewById(R.id.schoolelevenboys);
                        schooltwalvtotal=view1.findViewById(R.id.schooltwalbtotal);
                        schooltwalvgirls=view1.findViewById(R.id.schooltwalbgirls);
                        schooltwalvboys=view1.findViewById(R.id.schooltwalbboys);


                        ArrayAdapter<String> desk1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Desk);
                        desk.setAdapter(desk1);
                        ArrayAdapter<String>sport1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Sport);
                        sport.setAdapter(sport1);
                        ArrayAdapter<String>medical1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Medical);
                        medical.setAdapter(medical1);
                        ArrayAdapter<String>food1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Food);
                        food.setAdapter(food1);
                        ArrayAdapter<String>tolet=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Toylet2);
                        toylet2.setAdapter(tolet);
                        ArrayAdapter<String>sourceofwater=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Water);
                        water.setAdapter(sourceofwater);
                        ArrayAdapter<String>electricity1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Electricity);
                        electricity.setAdapter(electricity1);
                        ArrayAdapter<String>teacher1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Teachar);
                        teachar.setAdapter(teacher1);
                        ArrayAdapter<String>sporttype1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Sporttype);
                        sporttype.setAdapter(sporttype1);
                        ArrayAdapter<String>problem1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Problem);
                        problem.setAdapter(problem1);
                        ArrayAdapter<String>computer1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Computer);
                        computer.setAdapter(computer1);
                        ArrayAdapter<String>computerstudent1=new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,Computerstudent);
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

                      nameofschool.setText(model.getName_Of_school());
                      plotarea.setText(model.getSchool_plotarea());
                      noofbuilding.setText(model.getNunber_of_buliding());
                      noofroom.setText(model.getNumber_of_rooms());
                      noofteacher.setText(model.getNumber_of_teachers());
                        madhyanbhojan.setText(model.getMadhyanbhojan());
                        noofcomputer.setText(model.getNo_of_computer_Teachers());
                        noofcomputerstudent.setText(model.getNo_of_computer_student());
                        lkgtotal.setText(model.getLkg_total());
                        lkggirls.setText(model.getLkg_girls());
                        lkgboys.setText(model.getLkg_boys());
                        ukgtotal.setText(model.getUkg_total());
                        ukggirls.setText(model.getUkg_girls());
                        ukgboys.setText(model.getUkg_boys());
                        onetotal.setText(model.getOne_total());
                        onegirls.setText(model.getOne_girls());
                        oneboys.setText(model.getOne_boys());
                        twototal.setText(model.getTwo_total());
                        twogirls.setText(model.getTwo_girls());
                        twoboys.setText(model.getTwo_boys());
                        threetotal.setText(model.getThree_total());
                        threegirls.setText(model.getThree_girls());
                        threeboys.setText(model.getThree_boys());
                        fourtotal.setText(model.getFour_total());
                        fourgirls.setText(model.getFour_girls());
                        fourboys.setText(model.getFour_boys());
                        fivetotal.setText(model.getFive_total());
                        fivegirls.setText(model.getFive_girls());
                        fiveboys.setText(model.getFive_boys());
                        sixtotal.setText(model.getSix_total());
                        sixgirls.setText(model.getSix_girls());
                        sixboys.setText(model.getSix_boys());
                        seventotal.setText(model.getSeven_total());
                        sevengirls.setText(model.getSeven_girls());
                        sevenboys.setText(model.getSeven_boys());
                        eighttotal.setText(model.getEight_total());
                        eightgirls.setText(model.getEight_girls());
                        eightboys.setText(model.getEight_boys());
                        ninetotal.setText(model.getNine_total());
                        ninegirls.setText(model.getNine_girls());
                        nineboys.setText(model.getNine_boys());
                        tentotal.setText(model.getTen_total());
                        tengirls.setText(model.getTeng_irls());
                        tenboys.setText(model.getTen_boys());
                        eleventotal.setText(model.getEleven_total());
                        elevengirls.setText(model.getEleven_girls());
                        elevenboys.setText(model.getEleven_boys());
                        twalvtotal.setText(model.getTwelve_total());
                        twalvgirls.setText(model.getTwelve_girls());
                        twalvboys.setText(model.getTwelve_boys());
                        schoollkgtotal.setText(model.getDropOut_lkg_total());
                        schoollkggirls.setText(model.getDropOut_lkg_girls());
                        schoollkgboys.setText(model.getDropOut_lkg_boys());
                        schoolukgtotal.setText(model.getDropOut_ukg_total());
                        schoolukggirls.setText(model.getDropOut_ukg_girls());
                        schoolukgboys.setText(model.getDropOut_ukg_boys());
                        schoolonetotal.setText(model.getDropOut_one_total());
                        schoolonegirls.setText(model.getDropOut_one_girls());
                        schooloneboys.setText(model.getDropOut_one_boys());
                        schooltwototal.setText(model.getDropOut_two_total());
                        schooltwogirls.setText(model.getDropOut_two_girls());
                        schooltwoboys.setText(model.getDropOut_two_boys());
                        schoolthreetotal.setText(model.getDropOut_three_total());
                        schoolthreegirls.setText(model.getDropOut_three_girls());
                        schoolthreeboys.setText(model.getDropOut_three_boys());
                        schoolfourtotal.setText(model.getDropOut_four_total());
                        schoolfourgirls.setText(model.getDropOut_four_girls());
                        schoolfourboys.setText(model.getDropOut_four_boys());
                        schoolfivetotal.setText(model.getDropOut_five_total());
                        schoolfivegirls.setText(model.getDropOut_five_girls());
                        schoolfiveboys.setText(model.getDropOut_five_boys());
                        schoolsixtotal.setText(model.getDropOut_six_total());
                        schoolsixgirls.setText(model.getDropOut_six_girls());
                        schoolsixboys.setText(model.getDropOut_six_boys());
                        schoolseventotal.setText(model.getDropOut_seven_total());
                        schoolsevengirls.setText(model.getDropOut_seven_girls());
                        schoolsevenboys.setText(model.getDropOut_seven_boys());
                        schooleighttotal.setText(model.getDropOut_eight_total());
                        schooleightgirls.setText(model.getDropOut_eight_girls());
                        schooleightboys.setText(model.getDropOut_eight_boys());
                        schoolninetotal.setText(model.getDropOut_nine_total());
                        schoolninegirls.setText(model.getDropOut_nine_girls());
                        schoolnineboys.setText(model.getDropOut_nine_boys());
                        schooltentotal.setText(model.getDropOut_ten_total());
                        schooltengirls.setText(model.getDropOut_teng_irls());
                        schooltenboys.setText(model.getDropOut_ten_boys());
                        schooleleventotal.setText(model.getDropOut_eleven_total());
                        schoolelevengirls.setText(model.getDropOut_eleven_girls());
                        schoolelevenboys.setText(model.getDropOut_eleven_boys());
                        schooltwalvtotal.setText(model.getDropOut_twelve_total());
                        schooltwalvgirls.setText(model.getDropOut_twelve_girls());
                        schooltwalvboys.setText(model.getDropOut_twelve_boys());


                        Updatedata.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {

                              String Nameofschool=nameofschool.getText().toString().trim();
                              String school_plotarea=plotarea.getText().toString().trim();
                              String Number_of_Building=noofbuilding.getText().toString().trim();
                              String number_of_rooms=noofroom.getText().toString().trim();
                              String Number_of_teachers=noofteacher.getText().toString().trim();
                              String Madhyanbhojan=madhyanbhojan.getText().toString().trim();
                              String Number_of_computer_teachers=noofcomputer.getText().toString().trim();
                              String Number_of_computer_student=noofcomputerstudent.getText().toString().trim();
                              String Lkgtotal=lkgtotal.getText().toString().trim();
                              String Lkggirls=lkggirls.getText().toString().trim();
                              String Lkgboys=lkgboys.getText().toString().trim();
                              String Ukgtotal=ukgtotal.getText().toString().trim();
                              String Ukggirls=ukggirls.getText().toString().trim();
                              String Ukgboys=ukgboys.getText().toString().trim();
                              String Onetotal=onetotal.getText().toString().trim();
                              String Onegirls=onegirls.getText().toString().trim();
                              String Oneboys=oneboys.getText().toString().trim();
                              String Twototal=twototal.getText().toString().trim();
                              String Twogirls=twogirls.getText().toString().trim();
                              String Twoboys=twoboys.getText().toString().trim();
                              String Threetotal=threetotal.getText().toString().trim();
                              String Threegirls=threegirls.getText().toString().trim();
                              String Threeboys=threeboys.getText().toString().trim();
                              String Fourtotal=fourtotal.getText().toString().trim();
                              String Fourgirls=fourgirls.getText().toString().trim();
                              String Fourboys=fourboys.getText().toString().trim();
                              String Fivetotal=fivetotal.getText().toString().trim();
                              String Fivegirls=fivegirls.getText().toString().trim();
                              String Fiveboys=fiveboys.getText().toString().trim();
                              String Sixtotal=sixtotal.getText().toString().trim();
                              String Sixgirls=sixgirls.getText().toString().trim();
                              String Sixboys=sixboys.getText().toString().trim();
                              String Seventotal=seventotal.getText().toString().trim();
                              String Sevengirls=sevengirls.getText().toString().trim();
                              String Sevenboys=sevenboys.getText().toString().trim();
                              String Eighttotal=eighttotal.getText().toString().trim();
                              String Eightgirls=eightgirls.getText().toString().trim();
                              String Eightboys=eightboys.getText().toString().trim();
                              String Ninetotal=ninetotal.getText().toString().trim();
                              String Ninegirls=ninegirls.getText().toString().trim();
                              String Nineboys=nineboys.getText().toString().trim();
                              String Tentotal=tentotal.getText().toString().trim();
                              String Tengirls=tengirls.getText().toString().trim();
                              String Tenboys=tenboys.getText().toString().trim();
                              String Eleventotal=eleventotal.getText().toString().trim();
                              String Elevengirls=elevengirls.getText().toString().trim();
                              String Elevenboys=elevenboys.getText().toString().trim();
                              String Twelvetotal=twalvtotal.getText().toString().trim();
                              String Twelvegirls=twalvgirls.getText().toString().trim();
                              String Twelveboys=twalvboys.getText().toString().trim();
                              String SchoolLkgtotal=schoollkgtotal.getText().toString().trim();
                              String SchoolLkggirls=schoollkggirls.getText().toString().trim();
                              String SchoolLkgboys=schoollkgboys.getText().toString().trim();
                              String SchoolUkgtotal=schoolukgtotal.getText().toString().trim();
                              String SchoolUkggirls=schoolukggirls.getText().toString().trim();
                              String SchoolUkgboys=schoolukgboys.getText().toString().trim();
                              String SchoolOnetotal=schoolonetotal.getText().toString().trim();
                              String SchoolOnegirls=schoolonegirls.getText().toString().trim();
                              String SchoolOneboys=schooloneboys.getText().toString().trim();
                              String SchoolTwototal=schooltwototal.getText().toString().trim();
                              String SchoolTwogirls=schooltwogirls.getText().toString().trim();
                              String SchoolTwoboys=schooltwoboys.getText().toString().trim();
                              String SchoolThreetotal=schoolthreetotal.getText().toString().trim();
                              String SchoolThreegirls=schoolthreegirls.getText().toString().trim();
                              String SchoolThreeboys=schoolthreeboys.getText().toString().trim();
                              String SchoolFourtotal=schoolfourtotal.getText().toString().trim();
                              String SchoolFourgirls=schoolfourgirls.getText().toString().trim();
                              String SchoolFourboys=schoolfourboys.getText().toString().trim();
                              String SchoolFivetotal=schoolfivetotal.getText().toString().trim();
                              String SchoolFivegirls=schoolfivegirls.getText().toString().trim();
                              String SchoolFiveboys=schoolfiveboys.getText().toString().trim();
                              String SchoolSixtotal=schoolsixtotal.getText().toString().trim();
                              String SchoolSixgirls=schoolsixgirls.getText().toString().trim();
                              String SchoolSixboys=schoolsixboys.getText().toString().trim();
                              String SchoolSeventotal=schoolseventotal.getText().toString().trim();
                              String SchoolSevengirls=schoolsevengirls.getText().toString().trim();
                              String SchoolSevenboys=schoolsevenboys.getText().toString().trim();
                              String SchoolEighttotal=schooleighttotal.getText().toString().trim();
                              String SchoolEightgirls=schooleightgirls.getText().toString().trim();
                              String SchoolEightboys=schooleightboys.getText().toString().trim();
                              String SchoolNinetotal=schoolninetotal.getText().toString().trim();
                              String SchoolNinegirls=schoolninegirls.getText().toString().trim();
                              String SchoolNineboys=schoolnineboys.getText().toString().trim();
                              String SchoolTentotal=schooltentotal.getText().toString().trim();
                              String SchoolTengirls=schooltengirls.getText().toString().trim();
                              String SchoolTenboys=schooltenboys.getText().toString().trim();
                              String SchoolEleventotal=schooleleventotal.getText().toString().trim();
                              String SchoolElevengirls=schoolelevengirls.getText().toString().trim();
                              String SchoolElevenboys=schoolelevenboys.getText().toString().trim();
                              String SchoolTwelvetotal=schooltwalvtotal.getText().toString().trim();
                              String SchoolTwelvegirls=schooltwalvgirls.getText().toString().trim();
                              String SchoolTwelveboys=schooltwalvboys.getText().toString().trim();


                              HashMap<String,Object>map=new HashMap<>();
                              map.put("name_Of_school",Nameofschool);
                              map.put("School_plotarea",school_plotarea);
                              map.put("nunber_of_buliding",Number_of_Building);
                              map.put("number_of_rooms",number_of_rooms);
                              map.put("number_of_teachers",Number_of_teachers);
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
                              map.put("no_of_computer_Teachers",Number_of_computer_teachers);
                              map.put("computer_in_student",computerstuden);
                              map.put("no_of_computer_student",Number_of_computer_student);
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
                              map.put("twelve_total",Twelvetotal);
                              map.put("twelve_girls",Twelvegirls);
                              map.put("twelve_boys",Twelveboys);
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
                              map.put("dropOut_twelve_total",SchoolTwelvetotal);
                              map.put("dropOut_twelve_girls",SchoolTwelvegirls);
                              map.put("dropOut_twelve_boys",SchoolTwelveboys);

                              FirebaseDatabase.getInstance().getReference().child("school").child(uid).child(getRef(position).getKey()).updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                  @Override
                                  public void onComplete(@NonNull Task<Void> task) {
                                       if (task.isSuccessful()){
                                           dialog.dismiss();
                                           Toasty.success(getContext(),"Data Updated Successfully",Toasty.LENGTH_LONG,true).show();
                                       }
                                  }
                              }).addOnFailureListener(new OnFailureListener() {
                                  @Override
                                  public void onFailure(@NonNull Exception e) {
                                      Toasty.error(getContext(),"Data is not  Updated",Toasty.LENGTH_LONG,true).show();
                                  }
                              });
                          }
                      });

                        dialog.show();

                    }
                });

                holder.deletedata.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseDatabase.getInstance().getReference().child("school").child(uid).child(getRef(position).getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toasty.success(getContext(),"Data Deleted Successfully",Toasty.LENGTH_LONG,true).show();

                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toasty.error(getContext(),"Data is not deleted",Toasty.LENGTH_LONG,true).show();
                            }
                        });
                    }
                });

            }

            @NonNull
            @Override
            public schoolviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.schoolviewdatarow,parent,false);
            return new schoolviewholder(view1);
            }
        };

        adapter.startListening();
        schoolview.setAdapter(adapter);

         return view;
    }
}
