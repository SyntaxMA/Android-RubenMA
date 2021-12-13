package com.company.room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.company.room.databinding.FragmentNuevoPokemonBinding;

public class PokemonNuevoFragment extends Fragment {
    private FragmentNuevoPokemonBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentNuevoPokemonBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PokemonVM pokemonVM = new ViewModelProvider(requireActivity()).get(PokemonVM.class);
        NavController navController = Navigation.findNavController(view);

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombre.getText().toString();
                String descripcion = binding.descripcion.getText().toString();

                switch (nombre){
                    //<----------------- 1a Gen ----------------->//
                    case "bulbasaur":
                    case "Bulbasaur":
                        pokemonVM.insertar(new Pokemon(R.drawable.bulbasaur,nombre, descripcion));
                        break;
                    case "charmander":
                    case "Charmander":
                        pokemonVM.insertar(new Pokemon(R.drawable.charmander,nombre, descripcion));
                        break;
                    case "squirtle":
                    case "Squirtle":
                        pokemonVM.insertar(new Pokemon(R.drawable.squirtle,nombre, descripcion));
                        break;
                    //<----------------- 2a Gen ----------------->//
                    case "chikorita":
                    case "Chikorita":
                        pokemonVM.insertar(new Pokemon(R.drawable.chikorita,nombre, descripcion));
                        break;
                    case "cyndaquil":
                    case "Cyndaquil":
                        pokemonVM.insertar(new Pokemon(R.drawable.cyndaquil,nombre, descripcion));
                        break;
                    case "totodile":
                    case "Totodile":
                        pokemonVM.insertar(new Pokemon(R.drawable.totodile,nombre, descripcion));
                        break;
                    //<----------------- 3a Gen ----------------->//
                    case "treecko":
                    case "Treecko":
                        pokemonVM.insertar(new Pokemon(R.drawable.treecko,nombre, descripcion));
                        break;
                    case "torchic":
                    case "Torchic":
                        pokemonVM.insertar(new Pokemon(R.drawable.torchic,nombre, descripcion));
                        break;
                    case "mudkip":
                    case "Mudkip":
                        pokemonVM.insertar(new Pokemon(R.drawable.mudkip,nombre, descripcion));
                        break;
                    //<----------------- 4a Gen ----------------->//
                    case "turtwig":
                    case "Turtwig":
                        pokemonVM.insertar(new Pokemon(R.drawable.turtwig,nombre, descripcion));
                        break;
                    case "chimchar":
                    case "Chimchar":
                        pokemonVM.insertar(new Pokemon(R.drawable.chimchar,nombre, descripcion));
                        break;
                    case "piplup":
                    case "Piplup":
                        pokemonVM.insertar(new Pokemon(R.drawable.piplup,nombre, descripcion));
                        break;
                    //<----------------- 5a Gen ----------------->//
                    case "snivy":
                    case "Snivy":
                        pokemonVM.insertar(new Pokemon(R.drawable.snivy,nombre, descripcion));
                        break;
                    case "tepig":
                    case "Tepig":
                        pokemonVM.insertar(new Pokemon(R.drawable.tepig,nombre, descripcion));
                        break;
                    case "oshawott":
                    case "Oshawott":
                        pokemonVM.insertar(new Pokemon(R.drawable.oshawott,nombre, descripcion));
                        break;
                    //<----------------- 6a Gen ----------------->//
                    case "chespin":
                    case "Chespin":
                        pokemonVM.insertar(new Pokemon(R.drawable.chespin,nombre, descripcion));
                        break;
                    case "fennekin":
                    case "Fennekin":
                        pokemonVM.insertar(new Pokemon(R.drawable.fennekin,nombre, descripcion));
                        break;
                    case "froakie":
                    case "Froakie":
                        pokemonVM.insertar(new Pokemon(R.drawable.froakie,nombre, descripcion));
                        break;
                    //<----------------- 7a Gen ----------------->//
                    case "rowlet":
                    case "Rowlet":
                        pokemonVM.insertar(new Pokemon(R.drawable.rowlet,nombre, descripcion));
                        break;
                    case "litten":
                    case "Litten":
                        pokemonVM.insertar(new Pokemon(R.drawable.litten,nombre, descripcion));
                        break;
                    case "popplio":
                    case "Popplio":
                        pokemonVM.insertar(new Pokemon(R.drawable.popplio,nombre, descripcion));
                        break;
                    //<----------------- 8a Gen ----------------->//
                    case "grookey":
                    case "Grookey":
                        pokemonVM.insertar(new Pokemon(R.drawable.grookey,nombre, descripcion));
                        break;
                    case "scorbunny":
                    case "Scorbunny":
                        pokemonVM.insertar(new Pokemon(R.drawable.scorbunny,nombre, descripcion));
                        break;
                    case "sobble":
                    case "Sobble":
                        pokemonVM.insertar(new Pokemon(R.drawable.sobble,nombre, descripcion));
                        break;
                    //<----------------- Pikachu ----------------->//
                    case "pikachu":
                    case "Pikachu":
                        pokemonVM.insertar(new Pokemon(R.drawable.pikachu,nombre, descripcion));
                        break;
                    //<----------------- Predeterminado ----------------->//
                    default:
                        pokemonVM.insertar(new Pokemon(R.drawable.ghost,nombre, descripcion));
                        break;
                }
                navController.popBackStack();
            }
        });
    }
}