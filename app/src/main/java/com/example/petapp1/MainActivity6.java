package com.example.petapp1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6); // Ensure that this matches the actual layout file name

        GridLayout calendarGrid = findViewById(R.id.calendar_grid);
        TextView monthYearText = findViewById(R.id.month_year_text);

        // Example for setting the month and year text
        monthYearText.setText("September");

        // Populate the days of the month (this is just an example for September)
        String[] days = {
                "", "", "", "", "", "1", "2",
                "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30"
        };

        // Add TextViews dynamically for each day of the month
        for (String day : days) {
            TextView dayTextView = new TextView(this);
            dayTextView.setText(day);
            dayTextView.setGravity(Gravity.CENTER);
            dayTextView.setTextColor(Color.BLACK);
            dayTextView.setPadding(16, 16, 16, 16);

            // Style specific days (e.g. highlight the 5th)
            if (day.equals("5")) {
                dayTextView.setBackgroundResource(R.drawable.circle_background);
                dayTextView.setTextColor(Color.BLACK);
            }

            calendarGrid.addView(dayTextView);
        }
    }
}
