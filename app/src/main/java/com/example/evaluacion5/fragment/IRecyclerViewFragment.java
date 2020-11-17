package com.example.evaluacion5.fragment;

import com.example.evaluacion5.adapter.MascotaAdaptador;
import com.example.evaluacion5.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public interface IRecyclerViewFragment {

    public void InicializarAdaptador(MascotaAdaptador adaptador);
    public MascotaAdaptador CrearAdaptador(List<Mascota> mascotas);
    public void GenerarLayout();
}
