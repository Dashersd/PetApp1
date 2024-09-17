package com.example.petapp1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    Spinner petSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        petSpinner = findViewById(R.id.pet_spinner);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button5);

        // Set an OnClickListener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the SecondActivity
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
            }
        });


        String[] petOptions = {"Select an option...", "Dog", "Cat"};

        // Create an ArrayAdapter with the hint as the first item
        ArrayAdapter<String> petAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, petOptions) {
            @Override
            public boolean isEnabled(int position) {
                // Disable the first item (hint)
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set hint item color to gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    // Set regular item color to black
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        petAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        petSpinner.setAdapter(petAdapter);
    }
}