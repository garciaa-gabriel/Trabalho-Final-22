package com.example.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class servicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        setActionBar();

        ListView lista = findViewById(R.id.services);
        ArrayList<String> services = preencher();
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.abc_list_menu_item_radio, services);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String pos = services.get(position).toString();


                if(pos.equals(services.get(0).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(1).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(2).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(3).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(4).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(5).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(6).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
                }
                else if(pos.equals(services.get(7).toString())){
                    String pp = String.valueOf(position);
                    changeScreen(services, pp);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Serviços");
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


    private void changeScreen(ArrayList<String> services, String pp){
        Intent servicesIntent = new Intent(this, scheduleActivity.class);
        Bundle params = new Bundle();
        params.putString("pp", pp);
        servicesIntent.putExtras(params);
        startActivity(servicesIntent);
    }

    private ArrayList<String> preencher() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Acabamentos");
        dados.add("Barba na Navalha");
        dados.add("Barba na Máquina");
        dados.add("Corte Máquina Simples");
        dados.add("Corte Máquina + Tesoura");
        dados.add("Corte Máquina Degradê");
        dados.add("Corte + Barba");
        dados.add("Corte + Barba + Acabamentos");
        return dados;
    }
}
