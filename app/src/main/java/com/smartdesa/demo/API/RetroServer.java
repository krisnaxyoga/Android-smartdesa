package com.smartdesa.demo.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

    private static final String baseURL = "https://dashboard.sipadudemo.my.id/api/";

    private static Retrofit retro;

    public static Retrofit getClient(){
        if(retro == null){

            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }

    //Images
    public static final String URL_IMG_PROFIL = "https://dashboard.sipadudemo.my.id/api/profil/";

    //Berita
    public static final String URL_BERITA = "https://sipadudemo.my.id/berita/";

    //Register
    public static final String URL_REGISTER = "https://regis.sipadudemo.my.id/publics/penduduk/create/";

}
