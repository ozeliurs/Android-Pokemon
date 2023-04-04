package com.rallo.pokemon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PodiumPokemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PodiumPokemonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PodiumPokemonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Podium.
     */
    // TODO: Rename and change types and number of parameters
    public static PodiumPokemonFragment newInstance(String param1, String param2) {
        PodiumPokemonFragment fragment = new PodiumPokemonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    List<Pokemon> getPodium() {
        return Pokemon.completeList.stream()
                .sorted((p1, p2) -> p2.getRank() - p1.getRank())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_podium_pokemon_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateView();

    }

    private void updateView() {
        View view = getView();
        List<Pokemon> podium = getPodium();
        assert view != null;
        ((TextView) view.findViewById(R.id.top1_name)).setText(podium.get(0).getName() + " - " + podium.get(0).getRank() + "pts");
        ((TextView) view.findViewById(R.id.top2_name)).setText(podium.get(1).getName() + " - " + podium.get(1).getRank() + "pts");
        ((TextView) view.findViewById(R.id.top3_name)).setText(podium.get(2).getName() + " - " + podium.get(2).getRank() + "pts");

        Picasso.get().load(podium.get(0).getPictureURL()).into((ImageView) view.findViewById(R.id.top1));
        Picasso.get().load(podium.get(1).getPictureURL()).into((ImageView) view.findViewById(R.id.top2));
        Picasso.get().load(podium.get(2).getPictureURL()).into((ImageView) view.findViewById(R.id.top3));
    }
}