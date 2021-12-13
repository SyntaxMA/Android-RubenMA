package com.company.room;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecyclerAlfaFragment extends RecyclerPokemonFragment {
    @Override
    LiveData<List<Pokemon>> obtenerElementos() {
        return pokemonVM.alfabetico();
    }
}
