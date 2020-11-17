package com.example.evaluacion5.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion5.R;
import com.example.evaluacion5.model.Favorito;
import com.example.evaluacion5.model.Mascota;

import java.util.List;

public class FavouritePetAdapter extends RecyclerView.Adapter<FavouritePetAdapter.PetViewHolder>  {

    private List<Mascota> mascotas;
    private Activity activity;
    private Favorito petConstructor;

    public FavouritePetAdapter(List<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
        this.petConstructor = new Favorito(activity);
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new PetViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolderholder, int position) {
        final Mascota mascota = mascotas.get(position);
        petViewHolderholder.imageCV.setImageResource(mascota.getFoto());
        petViewHolderholder.nameCV.setText(mascota.getNombre());
        petViewHolderholder.textViewLikes.setText(String.valueOf(mascota.getLikes()));
    }
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageCV;
        private TextView nameCV;
        private ImageButton imageButton;
        private TextView textViewLikes;

        public PetViewHolder(View itemView) {
            super(itemView);
            imageCV = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            nameCV = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            imageButton = (ImageButton) itemView.findViewById(R.id.btnLike);
            textViewLikes = (TextView) itemView.findViewById(R.id.tvContador);
        }
    }
}


