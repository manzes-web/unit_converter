package com.example.unit_converter_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class Temperature_Page extends AppCompatActivity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_page);
        Toolbar toolbar = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Spinner spinner1 = findViewById(R.id.spinner5);
        Spinner spinner2 = findViewById(R.id.spinner7);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Temperature_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    Button button = findViewById(R.id.button9);
    editText = findViewById(R.id.editTextText3);
    textView = findViewById(R.id.textView7);
    button.setOnClickListener(View ->{
            String s = editText.getText().toString();
            String unit1 = spinner1.getSelectedItem().toString();
            String unit2 = spinner2.getSelectedItem().toString();
            if (!s.isEmpty()){
                double value = Double.parseDouble(s);
                double result = 0;
                switch(unit1){
                    case "CELSIUS(°C)":
                        if (unit2.equals("FAHRENHEIT(°F)")){
                            result = (value * 9/5)+32;
                        }
                        else if (unit2.equals("KELVIN(K)")){
                            result = value + 273.15;
                        }else {
                            result=value;
                        }
                        break;
                    case "FAHRENHEIT(°F)":
                        if (unit2.equals("CELSIUS(°C)")){
                            result = (value - 32) * 5/9;
                        }
                        else if (unit2.equals("KELVIN(K)")){
                            result = (value+459.67) * 5/9;
                        }else {
                            result=value;
                        }
                        break;
                    case "KELVIN(K)":
                        if (unit2.equals("FAHRENHEIT(°F)")){
                            result = (value * 9/5) -459.67;
                        }
                        else if (unit2.equals("CELSIUS(°C)")){
                            result = value - 273.15;
                        }else {
                            result=value;
                        }
                        break;
                }
                textView.setText(String.format("%.2f",result));
            }else {
                textView.setText("");
                Toast.makeText(this, "plz enter input", Toast.LENGTH_SHORT).show();
            }
        });

    }

}