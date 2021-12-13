package com.company.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon {
    @PrimaryKey(autoGenerate = true)

    int id;
    int imagen;

    String nombre;
    String descripcion;


    public Pokemon(int imagen, String nombre, String descripcion) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;

    }
}
