package com.bottlerocket.www.bottlerockettest.view.stores;

import com.bottlerocket.www.bottlerockettest.model.Stores;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface StoresView {
    void displayStores(Stores stores);
    void showLoadingBar();
    void hideLoadingBar();
    void showNoDataMessage();
    void hideNoDataMessage();
}
