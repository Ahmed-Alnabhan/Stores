package com.bottlerocket.www.bottlerockettest.remote;

import com.bottlerocket.www.bottlerockettest.model.Store;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface DataHandlerInterface {
    void getJSONData();
    void storeJsonInDB(Store store);
}
