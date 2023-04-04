package com.rallo.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostExecuteActivity<Pokemon> {
    public static String language = "english";
    private final String TAG = "frallo " + getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go).setOnClickListener(clic -> {
            String url = "https://raw.githubusercontent.com/fanzeyi/pokemon.json/17d33dc111ffcc12b016d6485152aa3b1939c214/pokedex.json";
            new HttpAsyncGet<>(url, Pokemon.class, this, new ProgressDialog(clic.getContext()));
        });

        // language spinner listener
        ((Spinner) findViewById(R.id.spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                language = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                language = "english";
            }
        });
    }


    @Override
    public void onPostExecutePokemons(List<Pokemon> itemList) {
        Pokemon.completeList = itemList;
        Pokemon pokemonFirst = itemList.get(16);
        Log.d(TAG, "16 pokemon = " + pokemonFirst);
        Pokemon.boost(290);
        Log.d(TAG, "16 pokemon = " + pokemonFirst);
    }
}