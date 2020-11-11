package com.rugby.Connections;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    public static String APIKEY = "31d4cdf3e1ae40a5b3ca680e30cc99a1";

    public API retrofitBuilder(){
       retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(API.SportsIO)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create(API.class);

        return api;
    }

    public API retrofitBuilder2(){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(API.Betting)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create(API.class);

        return api;
    }

}
