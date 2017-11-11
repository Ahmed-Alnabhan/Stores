package com.bottlerocket.www.bottlerockettest.view.store;

import com.bottlerocket.www.bottlerockettest.model.Store;

/**
 * Created by Ahmed on 11/11/2017.
 */

public interface StoreView {
    void displayStore(Store store);
    void showErrorMessage();
    void hideErrorMessage();
}
