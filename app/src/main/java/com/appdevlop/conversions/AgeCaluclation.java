package com.appdevlop.conversions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;

public class AgeCaluclation extends AppCompatActivity {
    Toolbar toolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_caluclation);
        toolbar=findViewById(R.id.topAc);
        toolbar.setTitle("Age Calculator");
        setSupportActionBar(toolbar);

    }
}