package com.example.unit_converter_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class Length_page extends AppCompatActivity {
    private EditText editTextText1;
    private TextView textView;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_page);
        Toolbar toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Length_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
    Button button =findViewById(R.id.button8);
    editTextText1 = findViewById(R.id.editTextText2);
    textView = findViewById(R.id.textView3);
    button.setOnClickListener(View ->{
        String s = editTextText1.getText().toString();
        String unit1 = spinner3.getSelectedItem().toString();
        String unit2 = spinner4.getSelectedItem().toString();
        if(!s.isEmpty()) {
            double value = Double.parseDouble(s);
            double result;
            if (unit1.equals("CENTIMETER") && unit2.equals("INCHES")) {
                result =value / 2.54 ;
            } else if (unit2.equals("CENTIMETER") && unit1.equals("INCHES")) {
                result =2.54 * value ;
            } else {
                result = value;
            }
            textView.setText(String.format("%.2f",result));
        }else {
            textView.setText("");
            Toast.makeText(this, "plz enter input", Toast.LENGTH_SHORT).show();
        }

    });
    }
}