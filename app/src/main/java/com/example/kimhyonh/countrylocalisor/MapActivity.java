package com.example.kimhyonh.countrylocalisor;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MapActivity extends Activity {

    EditText locationEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        String location = getIntent().getExtras().getString("Location");
        locationEt = (EditText) findViewById(R.id.locationEt);
        locationEt.setText(location);
    }

    public void search(View v) {
        String location = locationEt.getText().toString();

        if(location != null && !location.isEmpty()) {
            Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
            showMap(uri);
        } else {
            TextView error = (TextView) findViewById(R.id.error);
            error.setVisibility(View.VISIBLE);
            error.setText(R.string.error);
        }
    }

    public void googleSearch(View v) {
        String location = locationEt.getText().toString();

        if(location != null && !location.isEmpty()) {
            searchWeb(location);
        } else {
            TextView error = (TextView) findViewById(R.id.error);
            error.setVisibility(View.VISIBLE);
            error.setText(R.string.error);
        }
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
//
//    public void showMapByCountry(View v) {
//        String lat = getResources().getText(R.string.lat).toString();
//        String lng = getResources().getText(R.string.lng).toString();
//        String zoom = getResources().getText(R.string.zoom).toString();
//
//        Uri uri = Uri.parse("geo:" + lat + "," + lng + "?z=" + zoom);
//        showMap(uri);
//    }
//
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
