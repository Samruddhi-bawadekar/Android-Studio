package com.example.allpickersapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnAnalogTime, btnDigitalTime, btnDatePicker;
    TextView tvAnalogResult, tvDigitalResult, tvDateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnalogTime = findViewById(R.id.btnAnalogTime);
        btnDigitalTime = findViewById(R.id.btnDigitalTime);
        btnDatePicker = findViewById(R.id.btnDatePicker);

        tvAnalogResult = findViewById(R.id.tvAnalogResult);
        tvDigitalResult = findViewById(R.id.tvDigitalResult);
        tvDateResult = findViewById(R.id.tvDateResult);

        // Analog Time Picker (12-hour)
        btnAnalogTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(MainActivity.this,
                    (view, hourOfDay, minute1) -> tvAnalogResult.setText(String.format("%02d:%02d", hourOfDay, minute1)),
                    hour, minute, false);
            dialog.show();
        });

        // Digital Time Picker (24-hour)
        btnDigitalTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(MainActivity.this,
                    (view, hourOfDay, minute12) -> tvDigitalResult.setText(String.format("%02d:%02d", hourOfDay, minute12)),
                    hour, minute, true);
            dialog.show();
        });

        // Date Picker
        btnDatePicker.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                    (view, year1, month1, dayOfMonth) -> tvDateResult.setText(String.format("%02d/%02d/%04d", dayOfMonth, month1 + 1, year1)),
                    year, month, day);
            dialog.show();
        });
    }
}