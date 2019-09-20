package com.nehad.android.taskapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Client {


    public static final String Base_URL ="http://demovisiontsol.com/";
    public static Retrofit retrofit = null ;

    public  static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
