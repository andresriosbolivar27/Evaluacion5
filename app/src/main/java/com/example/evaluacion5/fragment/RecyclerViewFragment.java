package com.example.evaluacion5.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion5.R;
import com.example.evaluacion5.adapter.MascotaAdaptador;
import com.example.evaluacion5.model.Mascota;
import com.example.evaluacion5.presenters.IFragmentPresenter;
import com.example.evaluacion5.presenters.MascotaPresentador;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {
    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascotas;
    private IFragmentPresenter iFragmentPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);
        listaMascotas = v.findViewById(R.id.rvMascotas);
        iFragmentPresenter = new MascotaPresentador(this, getContext());
        return v;
    }
    @Override
    public void GenerarLayout(){
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }
    @Override
    public void InicializarAdaptador(MascotaAdaptador adaptador){
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public MascotaAdaptador CrearAdaptador(List<Mascota> mascotas) {
        return new MascotaAdaptador(mascotas, getActivity());
    }


}