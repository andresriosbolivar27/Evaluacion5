package com.example.evaluacion5.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion5.R;
import com.example.evaluacion5.adapter.MascotaAdaptador;
import com.example.evaluacion5.adapter.PerfilMascotaAdaptador;
import com.example.evaluacion5.model.Mascota;

import java.util.ArrayList;
import java.util.List;


public class PerfilMascotaFragment extends Fragment implements IRecyclerViewFragment{

    private RecyclerView listaImagenesPerfil;
    private List<Mascota> mascota;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota,container,false);
        listaImagenesPerfil = v.findViewById(R.id.rvPerfil);
        InicializarListaMascotas();
        InicializarAdaptador(CrearAdaptador(mascota));
        GenerarLayout();
        return v;
    }

    public void InicializarListaMascotas(){
        mascota = new ArrayList<Mascota>();

        mascota.add(new Mascota("5",R.drawable.mascota1));
        mascota.add(new Mascota("4",R.drawable.mascota1));
        mascota.add(new Mascota("2",R.drawable.mascota1));
        mascota.add(new Mascota("0",R.drawable.mascota1));
        mascota.add(new Mascota("6",R.drawable.mascota1));
        mascota.add(new Mascota("8",R.drawable.mascota1));
        mascota.add(new Mascota("9",R.drawable.mascota1));
        mascota.add(new Mascota("7",R.drawable.mascota1));
    }
    public void InicializarAdaptador(MascotaAdaptador adaptador){
        listaImagenesPerfil.setAdapter(adaptador);
    }

    public void GenerarLayout(){
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        listaImagenesPerfil.setLayoutManager(glm);
    }
    @Override
    public MascotaAdaptador CrearAdaptador(List<Mascota> mascotas)
    {
        return new MascotaAdaptador(mascotas, getActivity());
    }
}