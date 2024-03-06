package com.example.fhtexercice;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Produit.class}, version = 1)
public abstract class ProduitsDB extends RoomDatabase {

    public abstract ProduitDAO pdao();

}
