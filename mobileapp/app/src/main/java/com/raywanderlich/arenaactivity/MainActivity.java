
package com.raywanderlich.arenaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner bracketSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bracketSpinner = findViewById(R.id.bracketSpinner);
        String[] bracketArr = new String[] {"2v2", "3v3"};
        ArrayAdapter<String> brackets = new ArrayAdapter<>(this, bracketSpinner, bracketArr);
        bracketSpinner.setAdapter(brackets);
    }

}
