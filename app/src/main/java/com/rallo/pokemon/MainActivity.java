package com.rallo.pokemon;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PostExecuteActivity<Pokemon> {
    public static String language = "English";
    private final String TAG = "frallo " + getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go).setOnClickListener(clic -> {
            // String url = "https://raw.githubusercontent.com/fanzeyi/pokemon.json/17d33dc111ffcc12b016d6485152aa3b1939c214/pokedex.json";
            // new HttpAsyncGet<>(url, Pokemon.class, this, new ProgressDialog(clic.getContext()));

            // redirect to second activity
            setContentView(R.layout.result_activity);
        });

        // language spinner listener
        ((Spinner) findViewById(R.id.spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                language = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                language = "English";
            }
        });
    }


    @Override
    public void onPostExecutePokemons(List<Pokemon> itemList) {
        Pokemon pokemonFirst = itemList.get(0);
        Log.d(TAG, "First pokemon = " + pokemonFirst);
    }
}