package com.bottlerocket.www.bottlerockettest.remote;

import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface DataHandlerInterface {
    void getJSONData();
    void setStoresView(StoresView view);
    void storeJsonInDB(Store store);
}
