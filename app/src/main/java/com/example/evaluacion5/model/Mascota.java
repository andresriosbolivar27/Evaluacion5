package com.example.evaluacion5.model;

public class Mascota {
    private String nombre;
    private String contador;
    private int foto;
    private int id;
    private int likes = 0;

    public Mascota (){

    }
    public Mascota(String nombre, String contador, int foto) {
        this.nombre = nombre;
        this.contador = contador;
        this.foto = foto;
    }

    public Mascota(String contador, int foto) {
        this.contador = contador;
        this.foto = foto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}

