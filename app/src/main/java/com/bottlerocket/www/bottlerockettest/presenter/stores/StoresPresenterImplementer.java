package com.bottlerocket.www.bottlerockettest.presenter.stores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.bottlerocket.www.bottlerockettest.loader.StoresLoader;
import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class StoresPresenterImplementer implements StoresPresenter, LoaderManager.LoaderCallbacks<Stores> {

    private StoresView storesView;
    private Stores stores;
    private Context context;
    private LoaderManager loaderManager;

    public StoresPresenterImplementer(LoaderManager loaderManager, Context context) {
        this.context = context;
        this.loaderManager = loaderManager;
    }

    @Override
    public void setStoresView(StoresView view) {
        storesView = view;
    }

    @Override
    public void getStores() {
        loaderManager.initLoader(1, null, this).forceLoad();
    }

    @Override
    public Loader<Stores> onCreateLoader(int id, Bundle args) {
        stores = new Stores();
        return new StoresLoader(context);
    }

    @Override
    public void onLoadFinished(Loader<Stores> loader, Stores data) {
        stores = data;
        storesView.displayStores(data);
    }

    @Override
    public void onLoaderReset(Loader<Stores> loader) {

    }
}
