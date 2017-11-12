package com.bottlerocket.www.bottlerockettest.utils;

import com.bottlerocket.www.bottlerockettest.remote.RetrofitClient;
import com.bottlerocket.www.bottlerockettest.remote.StoresService;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://sandbox.bottlerocketapps.com/";

    private ApiUtils () {
        throw new AssertionError();
    }

    public static StoresService getStoresService() {
        return RetrofitClient.getClient(BASE_URL).create(StoresService.class);
    }
}
