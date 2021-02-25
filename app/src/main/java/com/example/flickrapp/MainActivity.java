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
        // get a reference of the recycler view which will be used later
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GetFlickrJavaObjects getFlickrJavaObjects = new GetFlickrJavaObjects("beach, summer", true, this);
    }


    // Update the view using the photos retrieved from Flickr
    public void displayPhoto(List<Photo> photoList){
        // instanciate the adapter (we are sure the data is ready because
        // the call comes from GetFlickrJavaObjects instance when it's done)
        FlickrRecyclerViewAdapter flickrRecyclerViewAdapter = new FlickrRecyclerViewAdapter(this, photoList);
        // link the adapter with the recyclerView
        mRecyclerView.setAdapter(flickrRecyclerViewAdapter);
    }

}