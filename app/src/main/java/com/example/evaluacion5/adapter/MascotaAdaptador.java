package com.example.evaluacion5.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion5.R;
import com.example.evaluacion5.activities.DetalleMascota;
import com.example.evaluacion5.model.MascotaConstructor;
import com.example.evaluacion5.model.Mascota;

import java.util.List;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    List<Mascota> mascotas;
    Activity activity;
    private MascotaConstructor mascotaConstructor;

    public MascotaAdaptador(List<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
        this.mascotaConstructor = new MascotaConstructor(activity);
        mascotaConstructor.insertPets();
    }

    //Inflara el layout y lo pasara al viewholder para que el obtenga los vies
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMV.setText(mascota.getNombre());
        mascotaViewHolder.tvContadorMV.setText(mascota.getContador());

        mascotaViewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascotaConstructor.giveLike(mascota);
                mascotaViewHolder.tvContadorMV.setText(String.valueOf(mascotaConstructor.getLikes(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreMV,tvContadorMV;
        private ImageButton imageButton;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFotoMascota);
            tvNombreMV = itemView.findViewById(R.id.tvNombreMascota);
            imageButton = itemView.findViewById(R.id.btnLike);
            tvContadorMV = itemView.findViewById(R.id.tvContador);
        }
    }
}