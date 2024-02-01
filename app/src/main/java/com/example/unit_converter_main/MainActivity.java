package com.example.unit_converter_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openWeightActivity(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openLengthActivity(View v){
        Intent intent = new Intent(this, Length_page.class);
        startActivity(intent);
    }
    public void openTemperatureActivity(View v){
        Intent intent = new Intent(this, Temperature_Page.class);
        startActivity(intent);
    }
    public void openTimeActivity(View v){
        Intent intent = new Intent(this, Time_page.class);
        startActivity(intent);
    }
    public void openCurrencyActivity(View v){
        Intent intent = new Intent(this, Currency_Page.class);
        startActivity(intent);
    }
    public void openCalculatorActivity(View v){
        Intent intent = new Intent(this, Calculator_Page.class);
        startActivity(intent);
    }
}