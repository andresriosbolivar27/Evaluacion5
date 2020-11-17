package com.example.evaluacion5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.evaluacion5.R;
import com.example.evaluacion5.adapter.FavouritePetAdapter;
import com.example.evaluacion5.adapter.MascotaAdaptador;
import com.example.evaluacion5.model.Mascota;
import com.example.evaluacion5.presenters.IFragmentPresenter;
import com.example.evaluacion5.presenters.MascotasFavoritasPresentador;


import java.util.ArrayList;
import java.util.List;

public class UltimasMascotasFavoritas extends AppCompatActivity implements IUltimasMascotasFavoritas {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IFragmentPresenter presenter;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_mascotas_favoritas);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotas = findViewById(R.id.rvUltimasMascota);
        presenter = new MascotasFavoritasPresentador(this,this);
    }

    @Override
    public void GenerarLayout(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public void InicializarAdaptador(FavouritePetAdapter adaptador){
        listaMascotas.setAdapter(adaptador);
    }
    @Override
    public FavouritePetAdapter CrearAdaptador(List<Mascota> mascotas) {
        return new FavouritePetAdapter(mascotas, this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.options_about:
                intent = new Intent(this, ActivityAcercaDe.class);
                break;
            case R.id.options_contact:
                intent = new Intent(this, ActivityContacto.class);
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}