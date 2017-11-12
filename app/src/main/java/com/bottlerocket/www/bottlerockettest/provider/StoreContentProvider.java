package com.bottlerocket.www.bottlerockettest.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bottlerocket.www.bottlerockettest.database.DBHelper;
import com.bottlerocket.www.bottlerockettest.database.DatabaseContract;
import com.bottlerocket.www.bottlerockettest.utils.Constants;

import java.util.HashMap;

/**
 * Created by Ahmed on 11/11/2017.
 */

public class StoreContentProvider extends ContentProvider {
    // Define fields of store table
    public static final String address = "address";
    public static final String city = "city";
    public static final String storeName = "name";
    public static final String latitude = "latitude";
    public static final String zipcode = "zipcode";
    public static final String storeLogoURL = "storeLogoURL";
    public static final String phone = "phone";
    public static final String longitude = "longitude";
    public static final String storeID = "storeID";
    public static final String state = "state";

    // Define the uriCode
    public static final int uriStore = 1;


    private static HashMap<String, String> values;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Constants.PROVIDER_NAME, "storescp", uriStore);
    }

    private SQLiteDatabase mDb;
    private DBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        mDb = dbHelper.getWritableDatabase();
        return mDb != null;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        int myUri = uriMatcher.match(uri);

        // Use switch extend the code in the future
        switch (myUri){
            case uriStore:
                queryBuilder.setTables(DatabaseContract.StoreEntry.TABLE_NAME);
                queryBuilder.setProjectionMap(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        Cursor cursor = queryBuilder.query(mDb, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getApplicationContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        switch (uriMatcher.match(uri)) {
            case uriStore:
                return "vnd.android.cursor.dir/storescp";
            default:
                throw new IllegalArgumentException("Unsupported URI " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Uri myUri = null;
        switch (uriMatcher.match(uri)) {
            case uriStore:
                long recordID1 = mDb.insert(DatabaseContract.StoreEntry.TABLE_NAME, null, contentValues);
                if (recordID1 > 0) {
                    myUri = ContentUris.withAppendedId(Constants.STORES_CONTENT_URL, recordID1);
                    getContext().getContentResolver().notifyChange(myUri, null);
                }
                break;

            default:throw new SQLException("Failed to insert row into " + uri);
        }
        return myUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int rowsDeleted;
        switch(uriMatcher.match(uri)){
            case uriStore:
                rowsDeleted = mDb.delete(DatabaseContract.StoreEntry.TABLE_NAME, selection, selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        int rowsUpdated;
        switch(uriMatcher.match(uri)){
            case uriStore:
                rowsUpdated = mDb.update(DatabaseContract.StoreEntry.TABLE_NAME, contentValues, selection, selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }
}
