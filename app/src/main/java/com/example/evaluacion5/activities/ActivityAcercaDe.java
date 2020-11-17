package com.example.evaluacion5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

import com.example.evaluacion5.R;

public class ActivityAcercaDe extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /*private  void ContactoEmail(){
        Toast.makeText(this, getString(R.string.nombre), Toast.LENGTH_SHORT).show();
    }
    private void ContactoTelefono(){
        Toast.makeText(this, getString(R.string.carrera), Toast.LENGTH_SHORT).show();
    }*/
}