package com.example.barbershop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId() ;

        if(id == R.id.home){
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
        return true;
    }

    private void setActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_img);
    }

    public void services(View view) {
        Intent intent = new Intent(this, servicesActivity.class);
        startActivity(intent);
    }

    public void schedule(View view) {
        Intent intent = new Intent(this, scheduleActivity.class);
        startActivity(intent);
    }
}