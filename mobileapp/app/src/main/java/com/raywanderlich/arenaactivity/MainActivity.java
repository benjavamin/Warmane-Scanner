
package com.raywanderlich.arenaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner bracketSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bracketSpinner = findViewById(R.id.bracketSpinner);
        bracketSpinner.setOnItemSelectedListener(this);
        String[] bracketArr = new String[] {"2v2", "3v3"};
        ArrayAdapter brackets = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,bracketArr);
        bracketSpinner.setAdapter(brackets);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
