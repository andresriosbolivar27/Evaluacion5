package com.example.evaluacion5.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion5.R;
import com.example.evaluacion5.model.Mascota;

import java.util.ArrayList;

public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> perfilMascota;
    Activity activity;

    public PerfilMascotaAdaptador(ArrayList<Mascota> mascota, Activity activity) {
        this.perfilMascota = mascota;
        this.activity = activity;
    }

    //Inflara el layout y lo pasara al viewholder para que el obtenga los vies
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new MascotaViewHolder(v);
    }
    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = perfilMascota.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvContadorMV.setText(mascota.getContador());


    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de mascotas
        return perfilMascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvContadorMV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.lista_fotos_perfil);
            tvContadorMV = itemView.findViewById(R.id.tvContadorFotoPerfil);
        }
    }
}
