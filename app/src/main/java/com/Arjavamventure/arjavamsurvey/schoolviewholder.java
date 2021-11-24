package com.Arjavamventure.arjavamsurvey;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class schoolviewholder extends RecyclerView.ViewHolder {
    TextView desk,sport,medical,food,toylet2,water,electricity,teachar,sporttype,problem,computer,computerstudent,
            nameofschool,plotarea,noofbuilding,noofroom,noofteacher,madhyanbhojan,noofcomputer,noofcomputerstudent,lkgtotal,lkggirls,lkgboys,ukgtotal,ukggirls,ukgboys,onetotal,onegirls,oneboys,twototal,twogirls,twoboys,threetotal,threegirls,threeboys,fourtotal,fourgirls,fourboys,
            fivetotal,fivegirls,fiveboys,sixtotal,sixgirls,sixboys,seventotal,sevengirls,sevenboys,eighttotal,eightgirls,eightboys,ninetotal,ninegirls,nineboys,tentotal,tengirls,tenboys,
            eleventotal,elevengirls,elevenboys,twalvtotal,twalvgirls,twalvboys,schoollkgtotal,schoollkggirls,schoollkgboys,schoolukgtotal,schoolukggirls,schoolukgboys,schoolonetotal,schoolonegirls,schooloneboys,schooltwototal,schooltwogirls,schooltwoboys,schoolthreetotal,schoolthreegirls,schoolthreeboys,schoolfourtotal,schoolfourgirls,schoolfourboys,
            schoolfivetotal,schoolfivegirls,schoolfiveboys,schoolsixtotal,schoolsixgirls,schoolsixboys,schoolseventotal,schoolsevengirls,schoolsevenboys,schooleighttotal,schooleightgirls,schooleightboys,schoolninetotal,schoolninegirls,schoolnineboys,schooltentotal,schooltengirls,schooltenboys,
            schooleleventotal,schoolelevengirls,schoolelevenboys,schooltwalvtotal,schooltwalvgirls,schooltwalvboys;

    ImageButton editdata,deletedata;
    public schoolviewholder(@NonNull View itemView) {
        super(itemView);


        editdata=itemView.findViewById(R.id.editdata);
        deletedata=itemView.findViewById(R.id.deletedata);
        nameofschool=itemView.findViewById(R.id.nameofschool);
        plotarea=itemView.findViewById(R.id.plotarea);
        noofbuilding=itemView.findViewById(R.id.noofbuilding);
        noofroom=itemView.findViewById(R.id.noofroom);
        noofteacher=itemView.findViewById(R.id.noofteacher);
        desk=itemView.findViewById(R.id.desk);
        sport=itemView.findViewById(R.id.sport);
        medical=itemView.findViewById(R.id.medical);
        madhyanbhojan=itemView.findViewById(R.id.madhyanbhojan);
        food=itemView.findViewById(R.id.food);
        toylet2=itemView.findViewById(R.id.toilet2);
        water=itemView.findViewById(R.id.sourceofwater);
        electricity=itemView.findViewById(R.id.electocity);
        teachar=itemView.findViewById(R.id.teachar);
        sporttype=itemView.findViewById(R.id.sporttype);
        problem=itemView.findViewById(R.id.problem);
        computer=itemView.findViewById(R.id.computer);
        noofcomputer=itemView.findViewById(R.id.noofcomputer);
        computerstudent=itemView.findViewById(R.id.computerstudent);
        noofcomputerstudent=itemView.findViewById(R.id.noofcomputerstudent);
        lkgtotal=itemView.findViewById(R.id.lkgtotal);
        lkggirls=itemView.findViewById(R.id.lkggirls);
        lkgboys=itemView.findViewById(R.id.lkgboys);
        ukgtotal=itemView.findViewById(R.id.ukgtotal);
        ukggirls=itemView.findViewById(R.id.ukggirls);
        ukgboys=itemView.findViewById(R.id.ukgboys);
        onetotal=itemView.findViewById(R.id.onetotal);
        onegirls=itemView.findViewById(R.id.onegirls);
        oneboys=itemView.findViewById(R.id.oneboys);
        twototal=itemView.findViewById(R.id.twototal);
        twogirls=itemView.findViewById(R.id.twogirls);
        twoboys=itemView.findViewById(R.id.twoboys);
        threetotal=itemView.findViewById(R.id.threetotal);
        threegirls=itemView.findViewById(R.id.threegirls);
        threeboys=itemView.findViewById(R.id.threeboys);
        fourtotal=itemView.findViewById(R.id.fourtotal);
        fourgirls=itemView.findViewById(R.id.fourgirls);
        fourboys=itemView.findViewById(R.id.fourboys);
        fivetotal=itemView.findViewById(R.id.fifthtotal);
        fivegirls=itemView.findViewById(R.id.fifthgirls);
        fiveboys=itemView.findViewById(R.id.fifthboys);
        sixtotal=itemView.findViewById(R.id.sixtotal);
        sixgirls=itemView.findViewById(R.id.sixgirls);
        sixboys=itemView.findViewById(R.id.sixboys);
        seventotal=itemView.findViewById(R.id.seventotal);
        sevengirls=itemView.findViewById(R.id.sevengirls);
        sevenboys=itemView.findViewById(R.id.sevenboys);
        eighttotal=itemView.findViewById(R.id.eighttotal);
        eightgirls=itemView.findViewById(R.id.eightgirls);
        eightboys=itemView.findViewById(R.id.eightboys);
        ninetotal=itemView.findViewById(R.id.ninetotal);
        ninegirls=itemView.findViewById(R.id.ninegirls);
        nineboys=itemView.findViewById(R.id.nineboys);
        tentotal=itemView.findViewById(R.id.tentotal);
        tengirls=itemView.findViewById(R.id.tengirls);
        tenboys=itemView.findViewById(R.id.tenboys);
        eleventotal=itemView.findViewById(R.id.eleventotal);
        elevengirls=itemView.findViewById(R.id.elevengirls);
        elevenboys=itemView.findViewById(R.id.elevenboys);
        twalvtotal=itemView.findViewById(R.id.twalbtotal);
        twalvgirls=itemView.findViewById(R.id.twalbgirls);
        twalvboys=itemView.findViewById(R.id.twalbboys);
        schoollkgtotal=itemView.findViewById(R.id.schoollkgtotal);
        schoollkggirls=itemView.findViewById(R.id.schoollkggirls);
        schoollkgboys=itemView.findViewById(R.id.schoollkgboys);
        schoolukgtotal=itemView.findViewById(R.id.schoolukgtotal);
        schoolukggirls=itemView.findViewById(R.id.schoolukggirls);
        schoolukgboys=itemView.findViewById(R.id.schoolukgboys);
        schoolonetotal=itemView.findViewById(R.id.schoolonetotal);
        schoolonegirls=itemView.findViewById(R.id.schoolonegirls);
        schooloneboys=itemView.findViewById(R.id.schooloneboys);
        schooltwototal=itemView.findViewById(R.id.schooltwototal);
        schooltwogirls=itemView.findViewById(R.id.schooltwogirls);
        schooltwoboys=itemView.findViewById(R.id.schooltwoboys);
        schoolthreetotal=itemView.findViewById(R.id.schoolthreetotal);
        schoolthreegirls=itemView.findViewById(R.id.schoolthreegirls);
        schoolthreeboys=itemView.findViewById(R.id.schoolthreeboys);
        schoolfourtotal=itemView.findViewById(R.id.schoolfourtotal);
        schoolfourgirls=itemView.findViewById(R.id.schoolfourgirls);
        schoolfourboys=itemView.findViewById(R.id.schoolfourboys);
        schoolfivetotal=itemView.findViewById(R.id.schoolfifthtotal);
        schoolfivegirls=itemView.findViewById(R.id.schoolfifthgirls);
        schoolfiveboys=itemView.findViewById(R.id.schoolfifthboys);
        schoolsixtotal=itemView.findViewById(R.id.schoolsixtotal);
        schoolsixgirls=itemView.findViewById(R.id.schoolsixgirls);
        schoolsixboys=itemView.findViewById(R.id.schoolsixboys);
        schoolseventotal=itemView.findViewById(R.id.schoolseventotal);
        schoolsevengirls=itemView.findViewById(R.id.schoolsevengirls);
        schoolsevenboys=itemView.findViewById(R.id.schoolsevenboys);
        schooleighttotal=itemView.findViewById(R.id.schooleighttotal);
        schooleightgirls=itemView.findViewById(R.id.schooleightgirls);
        schooleightboys=itemView.findViewById(R.id.schooleightboys);
        schoolninetotal=itemView.findViewById(R.id.schoolninetotal);
        schoolninegirls=itemView.findViewById(R.id.schoolninegirls);
        schoolnineboys=itemView.findViewById(R.id.schoolnineboys);
        schooltentotal=itemView.findViewById(R.id.schooltentotal);
        schooltengirls=itemView.findViewById(R.id.schooltengirls);
        schooltenboys=itemView.findViewById(R.id.schooltenboys);
        schooleleventotal=itemView.findViewById(R.id.schooleleventotal);
        schoolelevengirls=itemView.findViewById(R.id.schoolelevengirls);
        schoolelevenboys=itemView.findViewById(R.id.schoolelevenboys);
        schooltwalvtotal=itemView.findViewById(R.id.schooltwalbtotal);
        schooltwalvgirls=itemView.findViewById(R.id.schooltwalbgirls);
        schooltwalvboys=itemView.findViewById(R.id.schooltwalbboys);
    }
}
