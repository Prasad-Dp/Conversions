package com.appdevlop.conversions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;

public class Simple_Caluclator extends AppCompatActivity {
Toolbar toolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple__caluclator);
        toolbar=findViewById(R.id.actoolbar);
        toolbar.setTitle("Basic Calculator");
        setSupportActionBar(toolbar);
    }
}