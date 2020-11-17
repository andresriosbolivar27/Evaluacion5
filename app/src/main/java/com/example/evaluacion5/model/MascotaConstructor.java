package com.example.evaluacion5.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.evaluacion5.R;
import com.example.evaluacion5.db.DBConstants;
import com.example.evaluacion5.db.DataBase;

import java.util.ArrayList;
import java.util.List;

public class MascotaConstructor {
    private static final int LIKE = 1;
    private Context context;
    public MascotaConstructor(Context context){ this.context = context;}

    public List<Mascota> getPets() {
        DataBase dataBase = new DataBase(context);
        return dataBase.getMascotas();
    }
    public void insertPets(){
        DataBase dataBase = new DataBase(context);
        boolean respuesta = dataBase.isPetsEmpty();
        if(!dataBase.isPetsEmpty()){
            return;
        }
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 1","5",R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2","4",R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 3","3",R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 4","1",R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 5","8",R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 6","10",R.drawable.mascota6));
        mascotas.add(new Mascota("Mascota 7","9",R.drawable.mascota7));
        mascotas.add(new Mascota("Mascota 8","6",R.drawable.mascota8));
        mascotas.add(new Mascota("Mascota 9","7",R.drawable.mascota9));
        for(Mascota mascota : mascotas){
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConstants.ColNombreMascota, mascota.getNombre());
            contentValues.put(DBConstants.ColImagenMascota, mascota.getFoto());
            dataBase.InsertarMascota(contentValues);
        }
    }

    public void giveLike(Mascota mascota) {
        DataBase dataBase = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.ColFavIDMascota, mascota.getId());
        contentValues.put(DBConstants.ColFavoritoContador, LIKE);
        dataBase.InsertarLikes(contentValues);
    }

    public int getLikes(Mascota mascota) {
        DataBase dataBase = new DataBase(context);
        return dataBase.getLikes(mascota);
    }
}
