package com.bottlerocket.www.bottlerockettest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bottlerocket.www.bottlerockettest.R;
import com.bottlerocket.www.bottlerockettest.model.Store;
import com.bottlerocket.www.bottlerockettest.utils.Constants;
import com.bottlerocket.www.bottlerockettest.view.store.StoreView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreDetailFragment extends Fragment implements OnMapReadyCallback, StoreView {

    @BindView(R.id.store_logo_detail)
    ImageView storeLogo;

    @BindView(R.id.phone_number_detail)
    TextView phoneNumber;

    @BindView(R.id.address_detail)
    TextView storeAddress;

    @BindView(R.id.address2_detail)
    TextView storeAddress2;

    @BindView(R.id.store_id_detail)
    TextView storeID;

    @BindView(R.id.no_store_data_message)
    TextView noStoreDataMessage;

    private Store store;
    private static final String TAG = StoreDetailFragment.class.getSimpleName();

    public StoreDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_detail, container, false);
        ButterKnife.bind(this, view);

        hideErrorMessage();

        store = getStoreFromBundle();
        FragmentManager fragmentManager = getChildFragmentManager();
        final SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        displayStore(store);
        return view;
    }

    private Store getStoreFromBundle() {
        Store store = new Store();
        if(getArguments() != null) {
            store = getArguments().getParcelable(Constants.OBJECT_FROM_ACTIVITY);
        }
        return store;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (store != null) {
            hideErrorMessage();
            String stringLat = store.getLatitude();
            String stringLon = store.getLongitude();
            double lat = 0;
            double lon = 0;
            try {
                lat = Double.parseDouble(stringLat);
                lon = Double.parseDouble(stringLon);
            } catch (NumberFormatException ex){
                Log.e(TAG, ex.getMessage());
            }
            LatLng location = new LatLng(lat, lon);
            googleMap.addMarker(new MarkerOptions().position(location)
                    .title(store.getName()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        } else {
            showErrorMessage();
        }
    }

    @Override
    public void displayStore(Store store) {
        String phone = store.getPhone();
        String address = store.getAddress();
        String address2 = store.getCity() + ", " + store.getState() + " " + store.getZipcode();
        String idOfStore = getResources().getString(R.string.store_id_details) + " " + store.getStoreID();
        String imageURL = store.getStoreLogoURL();

        phoneNumber.setText(phone);
        storeAddress.setText(address);
        storeID.setText(idOfStore);
        // put the urllogo asynchronously into the image view.
        Picasso.with(getContext())
                .load(imageURL)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .tag(getContext())
                .into(storeLogo);
        storeAddress2.setText(address2);
    }

    @Override
    public void showErrorMessage() {
        noStoreDataMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorMessage() {
        noStoreDataMessage.setVisibility(View.GONE);
    }
}
