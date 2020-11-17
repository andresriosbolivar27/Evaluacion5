package com.example.evaluacion5.db;

public class DBConstants {
    public static String DBNombre = "petagram";
    public static int DBVersion = 1;

    public static String TblMascotas = "pets";
    public static String IDMascota = "id";
    public static String ColNombreMascota = "name";
    public static String ColImagenMascota = "picture";

    public static String TblFavoritos = "likes";
    public static String IDFavorito = "id";
    public static String ColFavIDMascota = "id_pet";
    public static String ColFavoritoContador = "likes";
}
