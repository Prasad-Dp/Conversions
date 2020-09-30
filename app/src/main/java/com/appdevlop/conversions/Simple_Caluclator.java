package com.appdevlop.conversions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Simple_Caluclator extends AppCompatActivity {
Toolbar toolbar;
TextView result,input;
String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple__caluclator);
        toolbar=findViewById(R.id.actoolbar);
        toolbar.setTitle("Basic Calculator");
        setSupportActionBar(toolbar);
        input=findViewById(R.id.input);
        result=findViewById(R.id.result);
    }

    public void equal(View view) {
        value = input.getText().toString();
        if (value.isEmpty()){
            result.setText("");
        }
        else {
        value = value.replaceAll("×","*");
        value = value.replaceAll("%","/100");
        value = value.replaceAll("÷","/");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String finalResult = "";

        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable,value,"javascript",1,null).toString();
        }catch (Exception e){
            finalResult="0";
        }

        result.setText(finalResult);
        }
    }
    public void Division(View view) {
        value=input.getText().toString();
        input.setText(value+"÷");
    }
    public void Add(View view) {
        value=input.getText().toString();
        input.setText(value+"+");
    }
    public void Percent(View view) {
        value=input.getText().toString();
        input.setText(value+"%");
    }
    public void Subtraction(View view) {
        value=input.getText().toString();
        input.setText(value+"-");
    }
    public void Multiply(View view) {
        value=input.getText().toString();
        input.setText(value+"×");
    }

    public void Cleard(View view) {
        input.setText("");
        result.setText("");
    }
    public void BackSpace(View view) {
        String back=input.getText().toString();
        if (back.isEmpty()){
            Toast.makeText(this, "All Cleared", Toast.LENGTH_SHORT).show();}
        else {
                String back1=back.substring(0,back.length()-1);
                input.setText(back1);}

    }


    public void One(View view) {
        value=input.getText().toString();
        input.setText(value+"1");
    }

    public void Two(View view) {
        value=input.getText().toString();
        input.setText(value+"2");
    }
    public void Three(View view) {
        value=input.getText().toString();
        input.setText(value+"3");
    }
    public void Four(View view) {
        value=input.getText().toString();
        input.setText(value+"4");
    }

    public void Five(View view) {
        value=input.getText().toString();
        input.setText(value+"5");
    }
    public void Six(View view) {
        value=input.getText().toString();
        input.setText(value+"6");
    }
    public void Seven(View view) {
        value=input.getText().toString();
        input.setText(value+"7");
    }

    public void Eight(View view) {
        value=input.getText().toString();
        input.setText(value+"8");
    }
    public void Nine(View view) {
        value=input.getText().toString();
        input.setText(value+"9");
    }
    public void DZero(View view) {
        value=input.getText().toString();
        input.setText(value+"00");
    }

    public void Zero(View view) {
        value=input.getText().toString();
        input.setText(value+"0");
    }
    public void Dot(View view) {
        value=input.getText().toString();
        input.setText(value+".");
    }

}
