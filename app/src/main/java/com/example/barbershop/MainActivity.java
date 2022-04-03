package com.example.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText user;
    private EditText password;
    private String usr;
    private String psw;
    private static final String usuario = "Admin";
    private static final String senha = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        user = findViewById(R.id.edituser);
        password = findViewById(R.id.editpassword);

        Button btsend = findViewById(R.id.btsend);
        btsend.setOnClickListener(this);
        if(savedInstanceState!=null){
            usr = savedInstanceState.getString("user");
            psw = savedInstanceState.getString("password");
        }
        else{
            usr = "Sem user";
            psw = "Sem password";
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putString("user", usr);
        dados.putString("password", psw);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btsend){
            String usr = user.getText().toString();
            String psw = password.getText().toString();

            if(usr.equals(usuario) && psw.equals(senha)) {
                Toast.makeText(this, "Indo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, homeActivity.class);
                startActivity(intent);
            }
            else if(!psw.equals(senha) || !usr.equals(usuario)){
                Toast.makeText(this, "Usuário ou Senha Incorretos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}