package com.bottlerocket.www.bottlerockettest.remote;

import com.bottlerocket.www.bottlerockettest.model.Stores;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface StoresService {
    @GET("BR_Android_CodingExam_2015_Server/stores.json")
    Call<Stores> getStores();
}
