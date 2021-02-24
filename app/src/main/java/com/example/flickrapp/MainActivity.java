package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetFlickrJavaObjects.IDisplayPhoto {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GetFlickrJavaObjects getFlickrJavaObjects = new GetFlickrJavaObjects("beach, summer", true, this);
    }

    // Update the view using the photos retrieved from Flickr
    public void displayPhoto(List<Photo> photoList){
        FlickrRecyclerViewAdapter flickrRecyclerViewAdapter = new FlickrRecyclerViewAdapter(this, photoList);
        mRecyclerView.setAdapter(flickrRecyclerViewAdapter);
    }
}