package com.bottlerocket.www.bottlerockettest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.adapter.StoresAdapter;
import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.remote.DataHandler;
import com.bottlerocket.www.bottlerockettest.remote.DataHandlerInterface;
import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresFragment extends Fragment implements StoresView {

    @BindView(R.id.no_data_message)
    TextView noDataMessage;

    @BindView(R.id.stores_loading_pb)
    ProgressBar storesLoadingPB;

    @BindView(R.id.recycler_view)
    RecyclerView storesRecyclerView;

    private DataHandlerInterface dataHandler;
    private LoaderManager loaderManager;
    private Bundle state;
    private StoresAdapter storesAdapter;

    public StoresFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stores, container, false);

        // ButterKnife
        ButterKnife.bind(this, view);

        // Show the progress bar of stores loading
        showLoadingBar();

        state = new Bundle();

        // Set layoutManager of the recyclerview
        storesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loaderManager = getLoaderManager();
        dataHandler = new DataHandler(loaderManager, getContext());
        dataHandler.setStoresView(this);
        dataHandler.getJSONData();
        return view;
    }

    @Override
    public void displayStores(Stores stores) {
        if (stores.getStores().size() > 0) {
            hideLoadingBar();
            hideNoDataMessage();
            storesRecyclerView.setVisibility(View.VISIBLE);
            onSaveInstanceState(state);
            storesAdapter= new StoresAdapter(stores, getContext());
            storesRecyclerView.setAdapter(storesAdapter);
            storesRecyclerView.getAdapter().notifyDataSetChanged();
            onViewStateRestored(state);

        } else {
            showNoDataMessage();
            storesRecyclerView.setVisibility(View.GONE);
        }

        // Hide stores loading progress bar
        hideLoadingBar();
    }

    @Override
    public void showLoadingBar() {
        storesLoadingPB.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingBar() {
        storesLoadingPB.setVisibility(View.GONE);
    }

    @Override
    public void showNoDataMessage() {
        noDataMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoDataMessage() {
        noDataMessage.setVisibility(View.GONE);
    }
}
