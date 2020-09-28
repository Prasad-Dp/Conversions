package com.appdevlop.conversions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Converstions extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converstions);
        toolbar=findViewById(R.id.toolTop);
        toolbar.setTitle("Convector");
        setSupportActionBar(toolbar);

    }
}