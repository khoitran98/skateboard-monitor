package com.example.skateboardcontroller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.util.Log;

public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        String latitude = getIntent().getStringExtra("LAT");
        String longtitude = getIntent().getStringExtra("LONG");
        mMap = googleMap;
        updateLocationUI();
        double lat = Double.parseDouble(latitude);
        double lng = Double.parseDouble(longtitude);
        LatLng coord = new LatLng(lat, lng);
        // Add marker and move the camera to the located spot
        googleMap.addMarker(new MarkerOptions().position(coord)
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord, 13.0f));
    }

    // Enable the self locate button
    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
//            if (mLocationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
//            } else {
//                mMap.setMyLocationEnabled(false);
//                mMap.getUiSettings().setMyLocationButtonEnabled(false);
//                mLastKnownLocation = null;
//                getLocationPermission();
//           }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }
}
