package com.sayeedul.recyclerlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

        Button sign;
        EditText user,pass,gend;

        String username,password,gender,cntry;
        Integer pos;

        String [] country = {"India","China","Pakistan","USA","BHUTAN","UAE"};

        Spinner CountrySpinner;
        ArrayAdapter<String> countryAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            user = (EditText)findViewById(R.id.userET);
            pass = (EditText)findViewById(R.id.passET);
            sign = (Button)findViewById(R.id.signup);
            gend = (EditText)findViewById(R.id.genderET);

            username = user.getText().toString();
            password = pass.getText().toString();
            gender = gend.getText().toString();

            CountrySpinner = (Spinner)findViewById(R.id.spinner);

            countryAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,country);
            CountrySpinner.setAdapter(countryAdapter);

            CountrySpinner.setOnItemSelectedListener(this);


            sign.setOnClickListener(this);

            user.setText(getIntent().getStringExtra("USERNAME1"));
            pass.setText(getIntent().getStringExtra("PASSWORD1"));
            gend.setText(getIntent().getStringExtra("GENDER1"));
            CountrySpinner.setSelection(getIntent().getIntExtra("POSITION1",0));

        }

    @Override
    public void onClick(View v) {

            Intent i = new Intent(MainActivity.this, DisplayRecyclerview.class);
            i.putExtra("USERNAME", user.getText().toString());
            i.putExtra("PASSWORD", pass.getText().toString());
            i.putExtra("GENDER", gend.getText().toString());
            i.putExtra("COUNTRY", cntry);
            i.putExtra("POSITION", pos);
            startActivity(i);

        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        cntry = country[position];
        pos = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(MainActivity.this, "NO Country SELECTED. PLEASE SELECT", Toast.LENGTH_SHORT).show();
    }
}
