package com.example.evaluacion5.activities;

import com.example.evaluacion5.adapter.FavouritePetAdapter;
import com.example.evaluacion5.model.Mascota;

import java.util.List;

public interface IUltimasMascotasFavoritas {
    public void GenerarLayout();

    public void InicializarAdaptador(FavouritePetAdapter adaptador);
    public FavouritePetAdapter CrearAdaptador(List<Mascota> mascotas);
}
