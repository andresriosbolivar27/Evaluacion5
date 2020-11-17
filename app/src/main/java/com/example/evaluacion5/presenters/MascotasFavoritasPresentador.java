package com.example.evaluacion5.presenters;

import android.content.Context;

import com.example.evaluacion5.activities.IUltimasMascotasFavoritas;
import com.example.evaluacion5.model.MascotaConstructor;
import com.example.evaluacion5.model.Mascota;

import java.util.List;

public class MascotasFavoritasPresentador implements IFragmentPresenter {
    private IUltimasMascotasFavoritas iUltimasMascotasFavoritas;
    private Context context;
    private MascotaConstructor petConstructor;
    private List<Mascota> mascotas;

    public MascotasFavoritasPresentador(Context context, IUltimasMascotasFavoritas iUltimasMascotasFavoritas){
        this.iUltimasMascotasFavoritas = iUltimasMascotasFavoritas;
        this.context = context;
        this.getPets();
    }

    @Override
    public void getPets() {
        petConstructor = new MascotaConstructor(context);
        mascotas = petConstructor.getPets();
        this.showPets();
    }

    @Override
    public void showPets() {
        iUltimasMascotasFavoritas.InicializarAdaptador(iUltimasMascotasFavoritas.CrearAdaptador(mascotas));
        iUltimasMascotasFavoritas.GenerarLayout();
    }
}
