package com.company.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PokemonAlmacen {

    PokemonDataBase.ElementosDao elementosDao;
    Executor executor = Executors.newSingleThreadExecutor();

    PokemonAlmacen(Application application){
        elementosDao = PokemonDataBase.obtenerInstancia(application).obtenerElementosDao();
    }


    LiveData<List<Pokemon>> obtener(){
        return elementosDao.obtener();
    }

    LiveData<List<Pokemon>> alfabetico() {
        return elementosDao.alfabetico();
    }


    void insertar(Pokemon pokemon){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.insertar(pokemon);
            }
        });
    }

    void eliminar(Pokemon pokemon) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.eliminar(pokemon);
            }
        });
    }
}