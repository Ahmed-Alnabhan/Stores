package com.bottlerocket.www.bottlerockettest.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.fragments.StoresFragment;

public class StoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        if (savedInstanceState == null) {
            StoresFragment aPsListFragment = new StoresFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.stores_fragment_container, aPsListFragment)
                    .commit();
        } else {
            //selectedItem = savedInstanceState.getInt(Constants.SELECTED_ITEM);
        }
    }
}
