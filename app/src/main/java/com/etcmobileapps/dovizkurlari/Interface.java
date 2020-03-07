package com.etcmobileapps.dovizkurlari;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {


        @GET("exchange")
        Call<Repo> dovizListele();


}
