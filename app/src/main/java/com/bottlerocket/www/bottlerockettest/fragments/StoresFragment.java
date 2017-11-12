package com.bottlerocket.www.bottlerockettest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.remote.DataHandler;
import com.bottlerocket.www.bottlerockettest.remote.DataHandlerInterface;
import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresFragment extends Fragment implements StoresView {

    private DataHandlerInterface dataHandler;
    private LoaderManager loaderManager;

    public StoresFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stores, container, false);

        loaderManager = getLoaderManager();
        dataHandler = new DataHandler(loaderManager, getContext());
        dataHandler.setStoresView(this);
        dataHandler.getJSONData();
        return view;
    }

    @Override
    public void displayStores(Stores stores) {
    }

    @Override
    public void showLoadingBar() {

    }

    @Override
    public void hideLoadingBar() {

    }

    @Override
    public void showNoDataMessage() {

    }

    @Override
    public void hideNoDataMessage() {

    }
}
