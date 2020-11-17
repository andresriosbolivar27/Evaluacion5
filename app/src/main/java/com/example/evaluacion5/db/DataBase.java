package com.example.evaluacion5.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.evaluacion5.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    private Context context;
    public DataBase(Context context) {
        super(context, DBConstants.DBNombre, null, DBConstants.DBVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTablePets = "CREATE TABLE " + DBConstants.TblMascotas
                + "(" + DBConstants.IDMascota + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DBConstants.ColNombreMascota + " TEXT NOT NULL, "
                + DBConstants.ColImagenMascota + " INTEGER NOT NULL)";

        String queryCreteTableLikes = "CREATE TABLE " + DBConstants.TblFavoritos
                + "(" + DBConstants.IDFavorito + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DBConstants.ColFavIDMascota + " INTEGER NOT NULL, "
                + DBConstants.ColFavoritoContador + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + DBConstants.ColFavIDMascota + ") "
                + "REFERENCES " + DBConstants.TblMascotas + "("+ DBConstants.IDMascota +")"
                + ") ";

        db.execSQL(queryCreateTablePets);
        db.execSQL(queryCreteTableLikes);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBConstants.TblMascotas);
        db.execSQL("DROP TABLE IF EXISTS " + DBConstants.TblFavoritos);
        onCreate(db);
    }

    public List<Mascota> getMascotas() {
        List<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + DBConstants.TblMascotas;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor registers = database.rawQuery(query, null);

        while (registers.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            int mascotaID = registers.getInt(0);
            mascotaActual.setId(mascotaID);
            mascotaActual.setNombre(registers.getString(1));
            mascotaActual.setFoto(registers.getInt(2));

            String queryLikes = "SELECT SUM(" + DBConstants.TblFavoritos + ")"
                    + " FROM " + DBConstants.TblFavoritos
                    + " WHERE " + DBConstants.ColFavIDMascota + " = " + mascotaID;

            Cursor likes = database.rawQuery(queryLikes, null);
            if (likes.moveToNext()) {
                mascotaActual.setLikes(likes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }
            mascotas.add(mascotaActual);
        }
        database.close();
        return mascotas;
    }

    public void InsertarMascota(ContentValues contentValues){
        SQLiteDatabase database = this.getReadableDatabase();
        database.insert(DBConstants.TblMascotas, null, contentValues);
        database.close();
    }

    public boolean isPetsEmpty(){
        int count = 0;
        String query = "SELECT COUNT(*)" +
                " FROM " + DBConstants.TblMascotas;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor register = database.rawQuery(query, null);
        if(register.moveToNext()) {
            count = register.getInt(0);
        }
        return count == 0;
    }

    public void InsertarLikes(ContentValues contentValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(DBConstants.TblFavoritos, null, contentValues);
        database.close();
    }

    public int getLikes(Mascota mascota) {
        int likes = 0;
        String query = "SELECT COUNT(" + DBConstants.ColFavoritoContador + ")" +
                " FROM " + DBConstants.TblFavoritos +
                " WHERE " + DBConstants.ColFavIDMascota + " = " + mascota.getId();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor register = database.rawQuery(query, null);
        if(register.moveToNext()) {
            likes = register.getInt(0);
        }
        database.close();
        return likes;
    }

    public List<Mascota> getMascotasFavoritas(int limit) {
        List<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT p.*, SUM(l." + DBConstants.ColFavoritoContador + ") "
                + " from " + DBConstants.TblMascotas + " p "
                + " join " + DBConstants.TblFavoritos + " l on (p. " + DBConstants.IDMascota + " = l." + DBConstants.ColFavIDMascota + ")"
                + " group by p." + DBConstants.IDMascota
                + " order by l." + DBConstants.IDFavorito + " desc "
                + " limit " + limit;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor registers = database.rawQuery(query, null);

        while (registers.moveToNext()) {
            Mascota currentPet = new Mascota();
            currentPet.setId(registers.getInt(0));
            currentPet.setNombre(registers.getString(1));
            currentPet.setFoto(registers.getInt(2));
            currentPet.setLikes(registers.getInt(3));
            mascotas.add(currentPet);
        }
        database.close();
        return mascotas;
    }
}
