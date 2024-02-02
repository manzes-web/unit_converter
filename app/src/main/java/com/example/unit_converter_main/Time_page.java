package com.example.unit_converter_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class Time_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_page);
        Toolbar toolbar7 = findViewById(R.id.toolbar7);
        setSupportActionBar(toolbar7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinner1 = findViewById(R.id.spinner6);
        Spinner spinner2 = findViewById(R.id.spinner8);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Time_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        Button button = findViewById(R.id.button10);
        TextView textView = findViewById(R.id.textView9);
        EditText editText = findViewById(R.id.editTextText4);
        button.setOnClickListener(View->{
            String s = editText.getText().toString();
            String unit1 = spinner1.getSelectedItem().toString();
            String unit2 = spinner2.getSelectedItem().toString();
            if (!s.isEmpty()) {
                double result = 0;
                double value = Double.parseDouble(s);
                switch (unit1) {
                    case "SECONDS":
                        if (unit2.equals("MINUTES")) {
                            result = value / 60;
                        } else if (unit2.equals("HOURS")) {
                            result = value / 3600;
                        } else if (unit2.equals("MILLISECONDS")) {
                            result = value * 100;
                        }else {
                            result = value;
                        }
                        break;
                    case "MINUTES":
                        if (unit2.equals("SECONDS")) {
                            result = value * 60;
                        } else if (unit2.equals("HOURS")) {
                            result = value / 60;
                        } else if (unit2.equals("MILLISECONDS")) {
                            result = value * 100 * 60;
                        }else {
                            result = value;
                        }
                        break;
                    case "HOURS":
                        if (unit2.equals("MINUTES")) {
                            result = value * 60;
                        } else if (unit2.equals("SECONDS")) {
                            result = value * 3600;
                        } else if (unit2.equals("MILLISECONDS")) {
                            result = value * 100 * 3600 ;
                        }else {
                            result = value;
                        }
                        break;
                    case "MILLISECONDS":
                        if (unit2.equals("MINUTES")) {
                            result = value /(100 * 60);
                        } else if (unit2.equals("HOURS")) {
                            result = value / (100 * 3600);
                        } else if (unit2.equals("SECONDS")) {
                            result = value / 100;
                        }else {
                            result = value;
                        }
                        break;
                }
                textView.setText(String.format("%.2f",result));
            }else {
                textView.setText("");
                Toast.makeText(this, "please give input", Toast.LENGTH_SHORT).show();
            }
        });
    }
}