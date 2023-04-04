package com.rallo.pokemon;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rallo.pokemon.databinding.FragmentListPokemonBinding;
import com.rallo.pokemon.placeholder.PlaceholderContent.PlaceholderItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> mValues;

    public MyItemRecyclerViewAdapter(List<Pokemon> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentListPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.pokemon_name.setText(mValues.get(position).getName());
        holder.pokemon_life.setText(mValues.get(position).getLife());
        holder.pokemon_attack.setText(mValues.get(position).getAttack());
        holder.pokemon_defense.setText(mValues.get(position).getDefense());
        holder.pokemon_speed.setText(mValues.get(position).getSpeed());
        Picasso.get().load(mValues.get(position).getPictureURL()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView image;
        public final TextView pokemon_speed;
        public final TextView pokemon_defense;
        public final TextView pokemon_attack;
        public final TextView pokemon_life;
        public final TextView pokemon_name;
        public Pokemon mItem;

        public ViewHolder(FragmentListPokemonBinding binding) {
            super(binding.getRoot());
            pokemon_name = binding.textView;
            pokemon_speed = binding.pokemonSpeed;
            pokemon_defense = binding.pokemonDefense;
            pokemon_attack = binding.pokemonAttack;
            pokemon_life = binding.pokemonLife;
            image = binding.pokemonImage;
        }

    }
}