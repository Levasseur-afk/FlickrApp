package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1";
        GetRawData getRawData = new GetRawData(url);
        getRawData.startDownload();
    }
}