package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class scheduleActivity extends AppCompatActivity {
    Spinner select;
    String positionList;
    TimePicker timepicker;
    DatePicker date;
    Button btsend;
    String text;

    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        setActionBar();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            positionList = extras.getString("pp");

        }
         select = (Spinner) findViewById(R.id.spinner);

         ArrayAdapter<String> myAdapter =  new ArrayAdapter<String>(this,
                 androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.spin));
         myAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
         if(extras == null){
             select.setAdapter(myAdapter);
         }
        else {
            int SpinPos = new Integer(positionList.toString());
            select.setAdapter(myAdapter);

            SharedPreferences category_prefs = getSharedPreferences("category_  prefs", Context.MODE_PRIVATE);
            int spinner_index = ((SharedPreferences) category_prefs).getInt("spinner_indx", SpinPos);
            select.setSelection(spinner_index);

        }

        timepicker = findViewById(R.id.timepk);
        date = findViewById(R.id.datepicker);

        btsend = findViewById(R.id.btsend);

        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month = date.getMonth();
                int day = date.getDayOfMonth();
                int year = date.getYear();

                int hour = timepicker.getHour();
                int min = timepicker.getMinute();

                String text = select.getSelectedItem().toString();

                if(view.getId() == R.id.btsend){
                    Intent change = new Intent(getApplicationContext(), successActivity.class);
                    change.putExtra("day", day);
                    change.putExtra("month", month);
                    change.putExtra("year", year);
                    change.putExtra("hour", hour);
                    change.putExtra("minute", min);
                    change.putExtra("text", text);
                    startActivity(change);
                }
            }
        });
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