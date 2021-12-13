package com.company.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PokemonVM extends AndroidViewModel {

    PokemonAlmacen pokemonAlmacen;

    MutableLiveData<Pokemon> elementoSeleccionado = new MutableLiveData<>();

    public PokemonVM(@NonNull Application application) {
        super(application);

        pokemonAlmacen = new PokemonAlmacen(application);
    }
    LiveData<List<Pokemon>> obtener(){
        return pokemonAlmacen.obtener();
    }
    LiveData<List<Pokemon>> alfabetico(){
        return pokemonAlmacen.alfabetico();
    }
    MutableLiveData<Pokemon> seleccionado(){
        return elementoSeleccionado;
    }

    void insertar(Pokemon pokemon){
        pokemonAlmacen.insertar(pokemon);
    }
    void eliminar(Pokemon pokemon){
        pokemonAlmacen.eliminar(pokemon);
    }
    void seleccionar(Pokemon pokemon){
        elementoSeleccionado.setValue(pokemon);
    }

}