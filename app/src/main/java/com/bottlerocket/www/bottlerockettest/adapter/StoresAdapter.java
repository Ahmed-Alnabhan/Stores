package com.bottlerocket.www.bottlerockettest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.activities.StoreDetailActivity;
import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.view.stores.StoresViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by Ahmed on 11/12/2017.
 */

public class StoresAdapter extends RecyclerView.Adapter<StoresViewHolder> {

    private Stores stores;
    private Context context;
    private Store store;

    public StoresAdapter(Stores stores, Context context) {
        this.stores = stores;
        this.context = context;
    }

    @Override
    public StoresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new StoresViewHolder(inflater.inflate(R.layout.store_list_item, parent, false), stores);
    }

    @Override
    public void onBindViewHolder(StoresViewHolder holder, final int position) {
        store = stores.getStores().get(position);
        String storeName = store.getName();
        String storeLogoURL = store.getStoreLogoURL();
        String phoneNumber = store.getPhone();
        String address = store.getAddress();
        String city = store.getCity();
        String state = store.getState();
        String zipCode = store.getZipcode();
        String address2 = city + ", " + state + " " + zipCode;

        // put the urllogo asynchronously into the image view.
        Picasso.with(context)
                .load(storeLogoURL)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .tag(context)
                .into(holder.getImgStoreLogo());
        // Set the text into the textviews
        holder.getStoreName().setText(storeName);
        holder.getAddress().setText(address);
        holder.getPhone().setText(phoneNumber);
        holder.getAddress2().setText(address2);

        // Set onClickListener for the item
        holder.getStoreItemGroup().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStoreDetailActivity(stores.getStores().get(position));
            }
        });
    }

    private void startStoreDetailActivity(Store store) {
        StoreDetailActivity.launchStoreDetailActivity(context, store);
    }

    @Override
    public int getItemCount() {
        return stores.getStores().size();
    }
}
