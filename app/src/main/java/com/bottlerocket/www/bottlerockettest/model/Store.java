package com.bottlerocket.www.bottlerockettest.model;

/**
 * Created by Ahmed on 11/11/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Store implements Parcelable {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("storeLogoURL")
    @Expose
    private String storeLogoURL;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("storeID")
    @Expose
    private String storeID;
    @SerializedName("state")
    @Expose
    private String state;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStoreLogoURL() {
        return storeLogoURL;
    }

    public void setStoreLogoURL(String storeLogoURL) {
        this.storeLogoURL = storeLogoURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.city);
        dest.writeString(this.name);
        dest.writeString(this.latitude);
        dest.writeString(this.zipcode);
        dest.writeString(this.storeLogoURL);
        dest.writeString(this.phone);
        dest.writeString(this.longitude);
        dest.writeString(this.storeID);
        dest.writeString(this.state);
    }

    public Store() {
    }

    protected Store(Parcel in) {
        this.address = in.readString();
        this.city = in.readString();
        this.name = in.readString();
        this.latitude = in.readString();
        this.zipcode = in.readString();
        this.storeLogoURL = in.readString();
        this.phone = in.readString();
        this.longitude = in.readString();
        this.storeID = in.readString();
        this.state = in.readString();
    }

    public static final Parcelable.Creator<Store> CREATOR = new Parcelable.Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel source) {
            return new Store(source);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };
}
