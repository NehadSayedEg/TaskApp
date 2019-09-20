package com.nehad.android.taskapp.Housing;

import com.nehad.android.taskapp.Model.HousingList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface housingAPI {

    @GET("optibov/api/housing/getUserHousingList")
     //@GET("getUserHousingList")

    Call<HousingList> getUserHousing(@Query("lang_id") int lang_id ,
                                     @Query( "apiToken")String apiToken);

}
