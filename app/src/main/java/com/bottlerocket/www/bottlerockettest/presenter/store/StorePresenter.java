package com.bottlerocket.www.bottlerockettest.presenter.store;

import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.view.store.StoreView;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface StorePresenter {
    void setStoreView(StoreView view);
    void getStore(Store store);
}
