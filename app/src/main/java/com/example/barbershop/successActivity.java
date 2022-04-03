package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class successActivity extends AppCompatActivity {
    int day, month, year, hour, minute;
    String text;
    TextView agendadt;
    TextView agendatm;
    TextView services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        agendadt = findViewById(R.id.agendadata);
        agendatm = findViewById(R.id.agendatime);
        services = findViewById(R.id.agendaservico);

       Bundle extras = getIntent().getExtras();
        day = extras.getInt("day", day);
        month = extras.getInt("month", month);
        year = extras.getInt("year", year);
        hour = extras.getInt("hour", hour);
        minute = extras.getInt("minute", minute);
        text = extras.getString("text", text);

        agendadt.setText("" + day + "/" + (month+1) + "/" + year);
        agendatm.setText("" + hour + ":" + minute);
        services.setText(text.toString());

    }
}