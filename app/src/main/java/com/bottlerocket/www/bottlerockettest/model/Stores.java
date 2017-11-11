package com.bottlerocket.www.bottlerockettest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class Stores implements Parcelable {
    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.stores);
    }

    public Stores() {
    }

    protected Stores(Parcel in) {
        this.stores = in.createTypedArrayList(Store.CREATOR);
    }

    public static final Parcelable.Creator<Stores> CREATOR = new Parcelable.Creator<Stores>() {
        @Override
        public Stores createFromParcel(Parcel source) {
            return new Stores(source);
        }

        @Override
        public Stores[] newArray(int size) {
            return new Stores[size];
        }
    };
}
