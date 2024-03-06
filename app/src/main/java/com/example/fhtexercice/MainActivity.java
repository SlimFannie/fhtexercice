package com.example.fhtexercice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Produit> produits = new ArrayList<>();
    RecyclerView rv;
    ProduitsDB pdb;
    ProduitDAO pdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvProduits);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        pdb = Room.databaseBuilder(this, ProduitsDB.class, "ProduitsDB")
                .allowMainThreadQueries()
                .build();

        pdao = pdb.pdao();

        if(pdao.getProduits().isEmpty()) {
            InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
            Call<List<Produit>> call = serveur.getProduits();

            call.enqueue(new Callback<List<Produit>>() {
                @Override
                public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                    produits = response.body();
                    rv.setAdapter(new AdapterProduit(produits));
                }

                @Override
                public void onFailure(Call<List<Produit>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            produits = pdao.getProduits();
            rv.setAdapter(new AdapterProduit(produits));
        }
    }
}