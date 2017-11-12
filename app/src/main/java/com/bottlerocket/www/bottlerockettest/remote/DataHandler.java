package com.bottlerocket.www.bottlerockettest.remote;

import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.utils.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class DataHandler implements DataHandlerInterface {


    private StoresService storesService;
    private Stores stores;

    @Override
    public void getJSONData() {
        storesService = ApiUtils.getStoresService();
        Call<Stores> call = storesService.getStores();
        call.enqueue(new Callback<Stores>() {

            @Override
            public void onResponse(Call<Stores> call, Response<Stores> response) {
                if (response.isSuccessful()){
                    stores = response.body();
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<Stores> call, Throwable t) {

            }
        });

    }

    @Override
    public void storeJsonInDB(Stores stores) {

    }
}
