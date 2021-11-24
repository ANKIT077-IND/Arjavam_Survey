package com.Arjavamventure.arjavamsurvey;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class fatchdataviewholder extends RecyclerView.ViewHolder {
    TextView houseno,numberhousehold,nameofowner,cast,gender,age,educationlevel,noofmalemumbers,nooffemalemumbers,
            noofmalechildren,nooffemalechildren,occupation,childno,disablechild,watersoure,agriculter,income,cattle,
            toilet,yestoilet,noofroom,kitchan,plot,noofbulid,noofsotry,plotinsqr,issue;

   ImageButton edit,delete;

    public fatchdataviewholder(@NonNull View itemView) {
        super(itemView);

        edit=itemView.findViewById(R.id.edit);
        delete=itemView.findViewById(R.id.Delete);
        houseno=itemView.findViewById(R.id.houseno);
        numberhousehold=itemView.findViewById(R.id.numberhousehold);
        nameofowner=itemView.findViewById(R.id.nameofowner);
        cast=itemView.findViewById(R.id.cast);
        gender=itemView.findViewById(R.id.gender);
        age=itemView.findViewById(R.id.age);
        educationlevel=itemView.findViewById(R.id.educationlevel);
        noofmalemumbers=itemView.findViewById(R.id.noofmalemumbers);
        nooffemalemumbers=itemView.findViewById(R.id.nooffemalemumbers);
        noofmalechildren=itemView.findViewById(R.id.noofmalechildren);
        nooffemalechildren=itemView.findViewById(R.id.nooffemalechildren);
        occupation=itemView.findViewById(R.id.occupation);
        childno=itemView.findViewById(R.id.childno);
        disablechild=itemView.findViewById(R.id.disablechild);
        watersoure=itemView.findViewById(R.id.watersoure);
        agriculter=itemView.findViewById(R.id.agriculter);
        income=itemView.findViewById(R.id.incom);
        cattle=itemView.findViewById(R.id.cattle);
        toilet=itemView.findViewById(R.id.toilet);
        yestoilet=itemView.findViewById(R.id.yestoilet);
        noofroom=itemView.findViewById(R.id.noofroomh);
        kitchan=itemView.findViewById(R.id.kitchan);
        plot=itemView.findViewById(R.id.plot);
        noofbulid=itemView.findViewById(R.id.noofbulid);
        noofsotry=itemView.findViewById(R.id.noofsotry);
        plotinsqr=itemView.findViewById(R.id.plotinsqr);
        issue=itemView.findViewById(R.id.issue);
    }
}
