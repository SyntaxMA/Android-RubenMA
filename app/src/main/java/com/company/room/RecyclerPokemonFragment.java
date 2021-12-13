package com.company.room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.company.room.databinding.FragmentRecyclerPokemonsBinding;
import com.company.room.databinding.ViewholderPokemonBinding;

import java.util.List;


public class RecyclerPokemonFragment extends Fragment {

    private FragmentRecyclerPokemonsBinding binding;
    PokemonVM pokemonVM;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecyclerPokemonsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pokemonVM = new ViewModelProvider(requireActivity()).get(PokemonVM.class);
        navController = Navigation.findNavController(view);

        binding.irANuevoPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nuevoPokemonFragment);
            }
        });

        ElementosAdapter elementosAdapter;
        elementosAdapter = new ElementosAdapter();

        binding.recyclerView.setAdapter(elementosAdapter);

        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Pokemon pokemon = elementosAdapter.obtenerElemento(posicion);
                pokemonVM.eliminar(pokemon);

            }
        }).attachToRecyclerView(binding.recyclerView);

        obtenerElementos().observe(getViewLifecycleOwner(), new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(List<Pokemon> pokemons) {
                elementosAdapter.establecerLista(pokemons);
            }
        });
    }

    LiveData<List<Pokemon>> obtenerElementos(){
        return pokemonVM.obtener();
    }

    class ElementosAdapter extends RecyclerView.Adapter<ChampionViewHolder> {

        List<Pokemon> pokemons;

        @NonNull
        @Override
        public ChampionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ChampionViewHolder(ViewholderPokemonBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ChampionViewHolder holder, int position) {

            Pokemon pokemon = pokemons.get(position);

            holder.binding.nombre.setText(pokemon.nombre);

            Glide.with(RecyclerPokemonFragment.this).load(pokemon.imagen).into(holder.binding.imagen);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pokemonVM.seleccionar(pokemon);
                    navController.navigate(R.id.action_mostrarPokemonFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return pokemons != null ? pokemons.size() : 0;
        }

        public void establecerLista(List<Pokemon> pokemons){
            this.pokemons = pokemons;
            notifyDataSetChanged();
        }

        public Pokemon obtenerElemento(int posicion){
            return pokemons.get(posicion);
        }
    }

    static class ChampionViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderPokemonBinding binding;

        public ChampionViewHolder(ViewholderPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}