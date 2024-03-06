package com.example.fhtexercice;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProduitDAO {

    @Query("SELECT * FROM Table_Produit")
    public List<Produit> getProduits();

}

