package com.bottlerocket.www.bottlerockettest.presenter.stores;

import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class StoresPresenterImplementer implements StoresPresenter {

    private StoresView storesView;

    @Override
    public void setStoresView(StoresView view) {
        storesView = view;
    }

    @Override
    public void getStores() {

    }
}
