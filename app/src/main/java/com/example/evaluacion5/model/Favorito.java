package com.example.evaluacion5.model;

import android.content.Context;

import com.example.evaluacion5.db.DataBase;

import java.util.List;

public class Favorito {
    private static final int LIMIT = 5;
    private Context context;
    public Favorito(Context context){ this.context = context;}
    public List<Mascota> getFavouritePets() {
        DataBase dataBase = new DataBase(context);
        return dataBase.getMascotasFavoritas(LIMIT);
    }
}
