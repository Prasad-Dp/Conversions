package com.appdevlop.conversions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeCaluclation extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    TextView pdtxt,dobtxt;
    ImageButton pdbtn,dobbtn;
    Toolbar toolbar;
    TextView ayear,amonth,aday;
    TextView total_years,total_months,total_weeks,total_days,total_hours,total_minute,total_seconds;
    TextView remain_m,remain_d;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_caluclation);
        toolbar=findViewById(R.id.topAc);
        toolbar.setTitle("Age Calculator");
        setSupportActionBar(toolbar);
        pdtxt=findViewById(R.id.pdtxt);
        dobtxt=findViewById(R.id.dobtxt);
        dobbtn=findViewById(R.id.dobbtn);
        pdbtn=findViewById(R.id.pdbtn);
        ayear=findViewById(R.id.ayear);
        amonth=findViewById(R.id.amonth);
        aday=findViewById(R.id.aday);
        total_years=findViewById(R.id.total_years);
        total_months=findViewById(R.id.total_monts);
        total_weeks=findViewById(R.id.total_weeks);
        total_days=findViewById(R.id.total_days);
        total_hours=findViewById(R.id.total_hours);
        total_minute=findViewById(R.id.total_minutes);
        total_seconds=findViewById(R.id.total_seconds);
        remain_m=findViewById(R.id.remain_m);
        remain_d=findViewById(R.id.remain_d);

        pdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                final int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                datePickerDialog=new DatePickerDialog(AgeCaluclation.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int mon= Integer.parseInt(String.valueOf(month));
                        mon=mon+1;
                        String mont=String.valueOf(mon);
                        pdtxt.setText(dayOfMonth+"-"+mont+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

        dobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                final int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                datePickerDialog=new DatePickerDialog(AgeCaluclation.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int mon= Integer.parseInt(String.valueOf(month));
                        mon=mon+1;
                        String mont=String.valueOf(mon);
                        dobtxt.setText(dayOfMonth+"-"+mont+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

    }

    public void calculating(View view) {
       String present_Date=pdtxt.getText().toString();
       String Dob=dobtxt.getText().toString();
       if (present_Date.isEmpty()||Dob.isEmpty()) {

           Toast.makeText(this, "Please Enter Current Date And Your Date Of Birth", Toast.LENGTH_SHORT).show();
       }
       else {
           String[] present_date_split = present_Date.split("-");
           String[] Dob_split = Dob.split("-");

           int present_year = Integer.parseInt(present_date_split[2]);
           int present_month = Integer.parseInt(present_date_split[1]);
           int present_day = Integer.parseInt(present_date_split[0]);

           int Dob_year = Integer.parseInt(Dob_split[2]);
           int Dob_month = Integer.parseInt(Dob_split[1]);
           int Dob_day = Integer.parseInt(Dob_split[0]);

           int age_year = present_year - Dob_year;
           int age_month = present_month - Dob_month;
           int age_day = present_day - Dob_day;
           if (age_month < 0) {
               age_year = age_year - 1;
               age_month = age_month + 12;
           }
           if (age_day < 0) {
               age_month = age_month - 1;
               age_day = age_day + 30;
           }
           if (age_month>=0){
               age_day=age_day+1;
           }

           String old_year = String.valueOf(age_year);
           String old_month = String.valueOf(age_month);
           String old_day = String.valueOf(age_day);

           ayear.setText(old_year);
           amonth.setText(old_month);
           aday.setText(old_day);


           total_years.setText(old_year);

           long total_m = (12 * age_year + age_month);
           String total_M = String.valueOf(total_m);
           total_months.setText(total_M);

           double total_w = (total_m * 4.348125 + age_day/7.0);
           String total_W = String.valueOf(total_w);
           total_weeks.setText(total_W);

           long total_d=0;
           if (age_month % 2 == 0) {
              total_d= total_d +(age_year * 365) + (age_month * 30) + (age_month / 2) + (age_year / 4) + age_day;

           } else {
              total_d= total_d + (age_year * 365) + (age_month * 30) + (age_month / 2) + (age_year / 4) + age_day + 1;

           }

           String total_D = String.valueOf(total_d);
           total_days.setText(total_D);

           double total_h = (total_d * 24);
           String total_H = String.valueOf(total_h);
           total_hours.setText(total_H);

           long total_mt = (long) (total_h * 60);
           String total_MT = String.valueOf(total_mt);
           total_minute.setText(total_MT);

           long total_s = (total_mt * 60);
           String total_S = String.valueOf(total_s);
           total_seconds.setText(total_S);

           String remain_month=String.valueOf(12-age_month);
           remain_m.setText(remain_month);

           String remain_days=String.valueOf(30-age_day);
           remain_d.setText(remain_days);

       }
    }

    public void Clearing(View view) {
        pdtxt.setText(null);
        dobtxt.setText(null);
    }
}