package com.bottlerocket.www.bottlerockettest.database;

import android.provider.BaseColumns;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class DatabaseContract {
    public static final class StoreEntry implements BaseColumns {
        public static final String TABLE_NAME = "store";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LATITUDE = "latitude";
        public static final String COLUMN_ZIP_CODE = "zipcode";
        public static final String COLUMN_STORE_LOGO_URL = "storeLogoURL";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_LONGITUDE = "longitude";
        public static final String COLUMN_STORE_ID = "storeID";
        public static final String COLUMN_STATE = "state";
    }
}
