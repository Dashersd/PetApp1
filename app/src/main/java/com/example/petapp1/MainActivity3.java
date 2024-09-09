package com.example.petapp1;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    // Declare EditText and ImageView
    private EditText passwordEditText;
    private ImageView togglePasswordView;
    private boolean isPasswordVisible = false; // Flag to check if the password is visible

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        // Handle system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize button and set OnClickListener to navigate to another activity
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(v -> {
            // Create an Intent to navigate to MainActivity4
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            startActivity(intent);
        });

        // Initialize EditText and ImageView for password field and toggle icon
        passwordEditText = findViewById(R.id.TextPassword);
        togglePasswordView = findViewById(R.id.imageView12);

        // Set OnClickListener to toggle password visibility
        togglePasswordView.setOnClickListener(v -> {
            if (isPasswordVisible) {
                // Hide password
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                togglePasswordView.setImageResource(R.drawable.orange_hidepass); // Update icon to "hide"
            } else {
                // Show password
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                togglePasswordView.setImageResource(R.drawable.orange_showpass); // Update icon to "show"
            }

            // Ensure the cursor remains at the end of the text
            passwordEditText.setSelection(passwordEditText.length());

            // Toggle the boolean flag
            isPasswordVisible = !isPasswordVisible;
        });
    }
}
