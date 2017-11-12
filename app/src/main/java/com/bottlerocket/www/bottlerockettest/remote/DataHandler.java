package com.bottlerocket.www.bottlerockettest.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.bottlerocket.www.bottlerockettest.database.DBHelper;
import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.model.Stores;
import com.bottlerocket.www.bottlerockettest.presenter.stores.StoresPresenter;
import com.bottlerocket.www.bottlerockettest.presenter.stores.StoresPresenterImplementer;
import com.bottlerocket.www.bottlerockettest.provider.StoreContentProvider;
import com.bottlerocket.www.bottlerockettest.utils.ApiUtils;
import com.bottlerocket.www.bottlerockettest.utils.Constants;
import com.bottlerocket.www.bottlerockettest.view.stores.StoresView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class DataHandler implements DataHandlerInterface {

    private static final String TAG = DataHandler.class.getName();
    private StoresService storesService;
    private Stores stores;
    private SQLiteDatabase mDb;
    private DBHelper dbHelper;
    private Context context;
    private Store myStore;
    private StoresPresenter storesPresenter;
    private android.support.v4.app.LoaderManager loaderManager;
    private StoresView view;

    public DataHandler(android.support.v4.app.LoaderManager loaderManager, Context context) {
        this.context = context;
        this.loaderManager = loaderManager;
        storesPresenter = new StoresPresenterImplementer(loaderManager, context);
    }

    @Override
    public void getJSONData() {
        storesService = ApiUtils.getStoresService();
        Call<Stores> call = storesService.getStores();
        call.enqueue(new Callback<Stores>() {

            @Override
            public void onResponse(Call<Stores> call, Response<Stores> response) {
                if (response.isSuccessful()){
                    stores = response.body();
                    if (stores != null) {
                        recreateStoreTable();
                        for (Store store : stores.getStores()){
                            myStore = new Store();
                            myStore.setAddress(store.getAddress());
                            myStore.setCity(store.getCity());
                            myStore.setLatitude(store.getLatitude());
                            myStore.setLongitude(store.getLongitude());
                            myStore.setName(store.getName());
                            myStore.setPhone(store.getPhone());
                            myStore.setState(store.getState());
                            myStore.setStoreID(store.getStoreID());
                            myStore.setZipcode(store.getZipcode());
                            myStore.setStoreLogoURL(store.getStoreLogoURL());
                            storeJsonInDB(myStore);
                        }
                    }
                    storesPresenter.setStoresView(view);
                    // Retrieve data from database right after saving it successfully
                    storesPresenter.getStores();
                } else {
                    int statusCode = response.code();
                    // Because this is not a release version, we can log the messages
                    Log.d(TAG, String.valueOf(statusCode));
                    storesPresenter.setStoresView(view);
                    // Retrieve data from database even though reading new json data has failed
                    storesPresenter.getStores();
                }
            }

            @Override
            public void onFailure(Call<Stores> call, Throwable t) {
                // Because this is not a release version, we can log the messages
                // We can use interception feature for more flexibility in error handling
                Log.e(TAG + " - FAILURE:", t.getMessage());
                storesPresenter.setStoresView(view);
                // Retrieve data from database even though reading new json data has failed
                storesPresenter.getStores();
            }
        });

    }

    @Override
    public void setStoresView(StoresView view) {
        this.view = view;
    }

    @Override
    public void storeJsonInDB(Store store) {
        // Create a new map of values
        ContentValues storeValues = new ContentValues();
        storeValues.put(StoreContentProvider.address, store.getAddress());
        storeValues.put(StoreContentProvider.city, store.getCity());
        storeValues.put(StoreContentProvider.latitude, store.getLatitude());
        storeValues.put(StoreContentProvider.longitude, store.getLongitude());
        storeValues.put(StoreContentProvider.storeName, store.getName() );
        storeValues.put(StoreContentProvider.phone, store.getPhone());
        storeValues.put(StoreContentProvider.state, store.getState());
        storeValues.put(StoreContentProvider.storeID, store.getStoreID());
        storeValues.put(StoreContentProvider.zipcode, store.getZipcode());
        storeValues.put(StoreContentProvider.storeLogoURL, store.getStoreLogoURL());
        Uri uri = context.getContentResolver().insert(Constants.STORES_CONTENT_URL, storeValues);
    }

    private void recreateStoreTable(){
        dbHelper = new DBHelper(context);
        mDb = dbHelper.getWritableDatabase();
        mDb.execSQL(Constants.SQL_DROP_STORE_TABLE);
        mDb.execSQL(Constants.SQL_CREATE_STORE_TABLE);
    }
}
