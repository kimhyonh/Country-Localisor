package com.example.kimhyonh.countrylocalisor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openMapActivity(View v) {
        Intent i = new Intent(this, MapActivity.class);

        String country = getResources().getText(R.string.country).toString();
        i.putExtra("Location", country);

        startActivity(i);
    }
}
