package com.example.evaluacion5.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.evaluacion5.adapter.PageAdapter;
import com.example.evaluacion5.fragment.PerfilMascotaFragment;
import com.example.evaluacion5.fragment.RecyclerViewFragment;
import com.example.evaluacion5.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewPager();
        setSupportActionBar(toolbar);

    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(0).setText("Mascotas");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);
        tabLayout.getTabAt(1).setText("Perfil Mascota");
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment>fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.options_about:
                intent = new Intent(this, ActivityAcercaDe.class);
                break;
            case R.id.options_contact:
                intent = new Intent(this, ActivityContacto.class);
                break;
            case R.id.option_fav:
                intent = new Intent(this, UltimasMascotasFavoritas.class);
                break;
        }
        if(intent != null){
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}