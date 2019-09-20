package com.nehad.android.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.nehad.android.taskapp.API.Client;
import com.nehad.android.taskapp.Housing.housingAPI;
import com.nehad.android.taskapp.Model.House;
import com.nehad.android.taskapp.Model.HousingList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
   // public housingList =  new ArrayList<>();
    private List<House> houses ;
    private RecyclerView recyclerView;
   private HousingList housingList;
   Toolbar toolbar;
    private RecyclerView.Adapter HousingAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Housing();

        recyclerView.setHasFixedSize(true);

//        // specify an adapter (see also next example)
//        HousingAdapter = new HousingAdapter(this, housingList);
//        recyclerView.setAdapter(HousingAdapter);




        // toolbar= findViewById(R.id.toolbar);
       // setActionBar(toolbar);
 // getSupportActionBar().setTitle("HOUSING LIST");
//  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  //getSupportActionBar().setDisplayShowHomeEnabled(true);






    }

    private void Housing() {

        Client Client = new Client();
        housingAPI apiService = Client.getClient().create(housingAPI.class);
        Call<HousingList> call = apiService.getUserHousing(1,
                "24mKQy1AiNFQLcVo5fgaGxCCRzAiN0cNdOSYgxmAMEb906Fw7NI34qKsXV87qmOgkvVSqrmSZZfhkTCA");
         call.enqueue(new Callback<HousingList>() {
             @Override
             public void onResponse(Call<HousingList> call, Response<HousingList> response) {


                  HousingList housingList = response.body();

                 Log.v("Responsebody$$$$$$$$", response.body().toString());
                 House house = response.body().getData().get(0);
                 Log.e("HOUSING*********", "GET Housing Name" +house.getName() );

                 HousingAdapter  = new HousingAdapter(MainActivity.this ,housingList);
                 recyclerView.setAdapter(HousingAdapter);

             }

             @Override
             public void onFailure(Call<HousingList> call, Throwable t) {
                 Log.v("Error@@@@@@@@", t.getMessage());


             }
         });
    }
}
