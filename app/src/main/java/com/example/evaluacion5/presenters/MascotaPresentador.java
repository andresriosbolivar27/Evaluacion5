package com.example.evaluacion5.presenters;

import android.content.Context;

import com.example.evaluacion5.fragment.IRecyclerViewFragment;
import com.example.evaluacion5.model.MascotaConstructor;
import com.example.evaluacion5.model.Mascota;

import java.util.List;

public class MascotaPresentador implements IFragmentPresenter {
    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private MascotaConstructor mascontaConstructor;
    private List<Mascota> pets;

    public MascotaPresentador(IRecyclerViewFragment iFragmentView, Context context){
        this.iRecyclerViewFragment = iFragmentView;
        this.context = context;
        this.getPets();
    }

    @Override
    public void getPets() {
        mascontaConstructor = new MascotaConstructor(context);
        pets =  mascontaConstructor.getPets();
        this.showPets();
    }

    @Override
    public void showPets() {
        iRecyclerViewFragment.InicializarAdaptador(iRecyclerViewFragment.CrearAdaptador(pets));
        iRecyclerViewFragment.GenerarLayout();
    }
}
