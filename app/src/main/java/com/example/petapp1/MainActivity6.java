package com.example.petapp1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    private TextView selectedDayTextView; // To store the currently selected day

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
            if (!day.isEmpty()) {
                TextView dayTextView = new TextView(this);
                dayTextView.setText(day);
                dayTextView.setGravity(Gravity.CENTER);
                dayTextView.setTextColor(Color.BLACK);
                dayTextView.setPadding(18, 16, 16, 16);

                // Set an OnClickListener to handle day selection
                dayTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handleDaySelection((TextView) v);
                    }
                });

                calendarGrid.addView(dayTextView);
            }
        }
    }

    // Method to handle the day selection and toggle background
    private void handleDaySelection(TextView dayTextView) {
        if (selectedDayTextView != null) {
            // Remove the circle from the previously selected day
            selectedDayTextView.setBackgroundResource(0); // Clear background
        }

        // Set the circular background to the currently selected day
        dayTextView.setBackgroundResource(R.drawable.circle_background);
        selectedDayTextView = dayTextView; // Update the selected day reference
    }
}
