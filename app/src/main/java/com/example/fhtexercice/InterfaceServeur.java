package com.example.fhtexercice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceServeur {

    @GET("products")
    Call<List<Produit>> getProduits();

}
