package com.example.petapp1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText passwordEditText;
    private ImageView hidePassImageView;
    private boolean isPasswordVisible = false;  // Add this variable to track visibility state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Apply window insets for padding (e.g., for edge-to-edge layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button4);
        // Set an OnClickListener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the MainActivity5
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }
        });

        // Initialize the EditText and ImageView
        passwordEditText = findViewById(R.id.eTextPassword);
        hidePassImageView = findViewById(R.id.imageView4);

        // Set an OnClickListener for the ImageView to toggle password visibility
        hidePassImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Hide password
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    hidePassImageView.setImageResource(R.drawable.ic_hidepass); // Change icon to "hide" icon
                } else {
                    // Show password
                    passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    hidePassImageView.setImageResource(R.drawable.purple_showpass); // Change icon to "show" icon
                }
                isPasswordVisible = !isPasswordVisible; // Toggle the flag

                // Move cursor to the end of the text
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });
    }
}
