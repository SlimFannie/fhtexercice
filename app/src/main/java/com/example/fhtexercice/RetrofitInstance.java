package com.example.fhtexercice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
        public static final String BASE_URL = "https://fakestoreapi.com/";
        private static Retrofit retrofit;

        public static Retrofit getInstance(){

            if(retrofit == null)
            {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

            return retrofit;
        }

    }
