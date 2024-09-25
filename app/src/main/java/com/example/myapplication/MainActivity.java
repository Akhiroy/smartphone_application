package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by ID
        EditText nameInput = findViewById(R.id.nameInput);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        CheckBox courseWeb = findViewById(R.id.courseWeb);
        CheckBox courseFlutter = findViewById(R.id.courseFlutter);
        CheckBox coursePython = findViewById(R.id.coursePython);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView ageText = findViewById(R.id.ageText);
        SeekBar seekBarAge = findViewById(R.id.seekBarAge);
        Switch switchNotifications = findViewById(R.id.switchNotifications);
        Button submitButton = findViewById(R.id.submitButton);

        // SeekBar change listener to update age text
        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageText.setText("Select Age: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Submit button onClick listener
        submitButton.setOnClickListener(view -> {
            // Get user inputs
            String name = nameInput.getText().toString();

            // Gender Selection
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            RadioButton selectedGenderButton = findViewById(selectedGenderId);
            String selectedGender = selectedGenderButton == null ? "" : selectedGenderButton.getText().toString();

            // Course selections
            StringBuilder courses = new StringBuilder();
            if (courseWeb.isChecked()) courses.append("Web Development course ");
            if (courseFlutter.isChecked()) courses.append("Flutter for beginners ");
            if (coursePython.isChecked()) courses.append("Python for beginners ");

            // Get rating
            float rating = ratingBar.getRating();

            // Get age from SeekBar
            int age = seekBarAge.getProgress();

            // Get notification switch status
            boolean notificationsEnabled = switchNotifications.isChecked();

            // Display results in a Toast (or store data as required)
            Toast.makeText(
                    MainActivity.this,
                    "Name: " + name +
                            "\nGender: " + selectedGender +
                            "\nCourses: " + courses.toString() +
                            "\nRating: " + rating +
                            "\nAge: " + age +
                            "\nNotifications: " + "Submitted",
                    Toast.LENGTH_LONG
            ).show();
        });
    }
}
