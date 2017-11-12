package com.bottlerocket.www.bottlerockettest.loader;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;

import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.provider.StoreContentProvider;
import com.bottlerocket.www.bottlerockettest.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 11/12/2017.
 */

public class StoresLoader extends AsyncTaskLoader<Stores> {

    private Stores stores;
    private Store store;
    private List<Store> storesList;

    public StoresLoader(Context context) {
        super(context);
    }

    @Override
    public Stores loadInBackground() {
        storesList = new ArrayList<>();
        stores = new Stores();
        Cursor cursor = getContext().getContentResolver().query(Constants.STORES_CONTENT_URL, null, null, null, null);
        if (cursor.moveToFirst()) {
            try {
                do {
                    store = new Store();
                    store.setAddress(cursor.getString(cursor.getColumnIndex(StoreContentProvider.address)));
                    store.setName(cursor.getString(cursor.getColumnIndex(StoreContentProvider.storeName)));
                    store.setPhone(cursor.getString(cursor.getColumnIndex(StoreContentProvider.phone)));
                    store.setStoreLogoURL(cursor.getString(cursor.getColumnIndex(StoreContentProvider.storeLogoURL)));
                    store.setZipcode(cursor.getString(cursor.getColumnIndex(StoreContentProvider.zipcode)));
                    store.setStoreID(cursor.getString(cursor.getColumnIndex(StoreContentProvider.storeID)));
                    store.setState(cursor.getString(cursor.getColumnIndex(StoreContentProvider.state)));
                    store.setLongitude(cursor.getString(cursor.getColumnIndex(StoreContentProvider.longitude)));
                    store.setLatitude(cursor.getString(cursor.getColumnIndex(StoreContentProvider.latitude)));
                    store.setCity(cursor.getString(cursor.getColumnIndex(StoreContentProvider.city)));
                    storesList.add(store);
                } while (cursor.moveToNext());
            } finally {
                cursor.close();
                stores.setStores(storesList);
            }
        }
        return stores;
    }
}
