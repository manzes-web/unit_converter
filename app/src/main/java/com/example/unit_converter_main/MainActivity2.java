package com.example.unit_converter_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    private EditText editTextText;
    private  EditText editTextText1;
    private TextView textView;

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        // Enable the Up button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Incorrect: Setting content view to activity_main again
//        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button);
//        TextView textView = findViewById(R.id.textView2);
        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView5);
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_items,
                android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);
        button.setOnClickListener(view -> {
          String s = editTextText.getText().toString();
            String unit1 = spinner.getSelectedItem().toString();
            String unit2 = spinner2.getSelectedItem().toString();
            if(!s.isEmpty()) {
                double value = Double.parseDouble(s);
                double result;
                if (unit1.equals("KG") && unit2.equals("POUND")) {
                    result = 2.205 * value;
                } else if (unit2.equals("KG") && unit1.equals("POUND")) {
                    result = value / 2.205;
                }else {
                    result =value;
                }
                textView.setText(String.format("%.2f", result));
            }else{
                textView.setText("");
                Toast.makeText(this, "please give input", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle toolbar item clicks
            if (item.getItemId() == android.R.id.home) {// Respond to the action bar's Up/Home button
                onBackPressed(); // Or handle navigation as needed
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}