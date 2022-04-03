package com.example.barbershop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class successActivity extends AppCompatActivity {
    int day, month, year, hour, minute;
    String text;
    TextView agendadt;
    TextView agendatm;
    TextView services;
    String am_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        setActionBar();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void setActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Agendar");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.home){
            Intent intent = new Intent(this, homeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.services){
            Intent intent = new Intent(this, servicesActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.schedule){
            Intent intent = new Intent(this, scheduleActivity.class);
            startActivity(intent);
            return true;
        }

        switch (item.getItemId()){
            case android.R.id.home:this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}