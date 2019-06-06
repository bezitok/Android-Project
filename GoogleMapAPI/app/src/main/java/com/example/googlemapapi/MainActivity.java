package com.example.googlemapapi;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends BaseActivity {

    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        showDialogLoading();
        SupportMapFragment supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id
                        .fragment_map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;
                mGoogleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                    @Override
                    public void onMapLoaded() {
                        dismissDialog();
                        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
                    }
                });
                LatLng framgiaVietnam = new LatLng(21.0166458, 105.7841248);
                mGoogleMap
                        .addMarker(
                                new MarkerOptions().position(framgiaVietnam).title("Framgia Vietnam"));
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(framgiaVietnam, 18));
            }
        });
    }

}
