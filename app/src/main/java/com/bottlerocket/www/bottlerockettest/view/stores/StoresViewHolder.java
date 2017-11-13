package com.bottlerocket.www.bottlerockettest.view.stores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.model.Stores;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed on 11/12/2017.
 */

public class StoresViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_store_logo)
    ImageView imgStoreLogo;

    @BindView(R.id.store_name)
    TextView storeName;

    @BindView(R.id.txt_phone)
    TextView phone;

    @BindView(R.id.txt_address)
    TextView address;

    @BindView(R.id.txt_address2)
    TextView address2;

    @BindView(R.id.store_item_group)
    ViewGroup storeItemGroup;

    private Stores stores;

    public StoresViewHolder(View itemView, Stores stores) {
        super(itemView);
        this.stores = stores;
        ButterKnife.bind(this, itemView);
    }

    public ImageView getImgStoreLogo() {
        return imgStoreLogo;
    }

    public TextView getStoreName() {
        return storeName;
    }

    public TextView getPhone() {
        return phone;
    }

    public TextView getAddress() {
        return address;
    }

    public TextView getAddress2() {
        return address2;
    }

    public ViewGroup getStoreItemGroup() {
        return storeItemGroup;
    }
}
