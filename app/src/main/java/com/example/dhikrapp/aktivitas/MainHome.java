package com.example.dhikrapp.aktivitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dhikrapp.R;

public class MainHome extends AppCompatActivity implements View.OnClickListener {

    private Button btnToLogin, btnToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        btnToLogin = findViewById(R.id.btnLoginMainHome);
        btnToRegister = findViewById(R.id.btnRegisterMainHome);

        btnToRegister.setOnClickListener(this);
        btnToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegisterMainHome:
                Intent a = new Intent(MainHome.this, MainActivity.class);
                startActivity(a);
                break;
            case R.id.btnLoginMainHome:
                Intent i = new Intent(MainHome.this, Login.class);
                startActivity(i);
                break;
        }
    }
}