package com.Arjavamventure.arjavamsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {
    RadioGroup radioGroup;
    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
       radioGroup=view.findViewById(R.id.homeradio);
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.households:
                       Intent intent=new Intent(getContext(),households.class);
                       startActivity(intent);
                       break;
                   case R.id.School:
                       Intent schoolintent=new Intent(getContext(),nextpage.class);
                       startActivity(schoolintent);
                       break;
               }

           }
       });

        return view;
    }
}
