package com.example.kimhyonh.countrylocalisor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showMapByCountry(View v) {
        String lat = getResources().getText(R.string.lat).toString();
        String lng = getResources().getText(R.string.lng).toString();
        String zoom = getResources().getText(R.string.zoom).toString();

        Uri uri = Uri.parse("geo:" + lat + "," + lng + "?z=" + zoom);
        showMap(uri);
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
