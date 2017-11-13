package com.bottlerocket.www.bottlerockettest.utils;

import android.net.Uri;

import com.bottlerocket.www.bottlerockettest.database.DatabaseContract;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class Constants {
    /**
     * Database constants
     */
    public static final String DATABASE_NAME = "stores.db";
    public static final int DATABASE_VERSION = 1;

    /**
     * StoreContentProvider constants
     */
    public static final String PROVIDER_NAME = "com.bottlerocket.www.bottlerockettest.provider.StoreContentProvider";
    public static final String STORES_URL = "content://" + PROVIDER_NAME + "/storescp";
    public static final Uri STORES_CONTENT_URL = Uri.parse(STORES_URL);

    // String query that creates the store table
    public static final String SQL_CREATE_STORE_TABLE = "CREATE TABLE " +
            DatabaseContract.StoreEntry.TABLE_NAME + " (" +
            DatabaseContract.StoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DatabaseContract.StoreEntry.COLUMN_ADDRESS + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_CITY + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_NAME + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_LATITUDE + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_ZIP_CODE + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_STORE_LOGO_URL + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_PHONE + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_LONGITUDE + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_STORE_ID + " TEXT, " +
            DatabaseContract.StoreEntry.COLUMN_STATE + " TEXT " +
            ");";
    // String query that drops the store table
    public static final String SQL_DROP_STORE_TABLE = "DROP TABLE IF EXISTS " + DatabaseContract.StoreEntry.TABLE_NAME;
    public static final String RECYCLER_STATE = "RecyclerState";
}
