package com.bottlerocket.www.bottlerockettest.presenter.stores;

import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface StoresPresenter {
    void setStoresView(StoresView view);
    void getStores();
}
