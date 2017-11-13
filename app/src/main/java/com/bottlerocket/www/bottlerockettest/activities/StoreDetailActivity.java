package com.bottlerocket.www.bottlerockettest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.fragments.StoreDetailFragment;
import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.utils.Constants;

public class StoreDetailActivity extends AppCompatActivity {

    private Intent intent;
    private Store store;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        // Put the object in a bundle to pass it to the fragment
        bundle = new Bundle();
        intent = getIntent();
        if (intent.hasExtra(Constants.STORE_EXTRA)) {
            store = intent.getParcelableExtra(Constants.STORE_EXTRA);
            bundle.putParcelable(Constants.OBJECT_FROM_ACTIVITY, store);

        }

        String name = store.getName();

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Add the StoreDetailFragment to the StoreDetailActivity
        StoreDetailFragment storeDetailFragment = new StoreDetailFragment();
        storeDetailFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.store_detail_fragment_container, storeDetailFragment)
                .commit();
    }

    public static void launchStoreDetailActivity(Context context, Store store) {
        Intent intent = new Intent(context, StoreDetailActivity.class);
        intent.putExtra(Constants.STORE_EXTRA, store);
        context.startActivity(intent);
    }
}
