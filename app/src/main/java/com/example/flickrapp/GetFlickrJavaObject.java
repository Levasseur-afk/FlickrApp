package com.example.flickrapp;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class GetFlickrJavaObject implements GetRawData.IProcessRawData{

    private Uri mUri;
    private List<Photo> mPhotos = new ArrayList<>();
    public GetFlickrJavaObject(String tags, boolean tagmode){
        this.mUri = createUri(tags, tagmode);
        GetRawData getRawData = new GetRawData(mUri.toString(), this);
        getRawData.startDownload();
    }

    private Uri createUri(String tags, boolean tagmode){
        final String FLICKR_API_BASE = "https://api.flickr.com/services/feeds/photos_public.gne";
        final String PARAM_TAGS = "tags";
        final String PARAM_TAGMODE = "tagmode";
        final String PARAM_FORMAT = "format";
        final String PARAM_NO_JSON = "nojsoncallback";

        Uri uri  = Uri.parse(FLICKR_API_BASE).buildUpon()
                .appendQueryParameter(PARAM_TAGS, tags)
                .appendQueryParameter(PARAM_TAGMODE, tagmode? "ALL" : "ANY")
                .appendQueryParameter(PARAM_FORMAT, "json")
                .appendQueryParameter(PARAM_NO_JSON, "1")
                .build();
        return uri;
    }

    @Override
    public void processRawData(String json) {
        final String FLICKR_ITEMS = "items";
        final String FLICKR_TITLE = "title";
        final String FLICKR_MEDIA = "media";
        final String FLICKR_PHOTO_URL = "m";
        final String FLICKR_AUTHOR = "author";
        final String FLICKR_AUTHOR_ID = "author_id";
        final String FLICKR_LINK = "link";
        final String FLICKR_TAGS = "tags";

        try {
            JSONObject jsonData = new JSONObject(json);
            JSONArray items = jsonData.getJSONArray(FLICKR_ITEMS);
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonPhoto = items.getJSONObject(i);
                String title = jsonPhoto.getString(FLICKR_TITLE);
                String author = jsonPhoto.getString(FLICKR_AUTHOR);
                String authorId = jsonPhoto.getString(FLICKR_AUTHOR_ID);
                String link = jsonPhoto.getString(FLICKR_LINK);
                String tags = jsonPhoto.getString(FLICKR_TAGS);

                JSONObject jsonMedia = jsonPhoto.getJSONObject(FLICKR_MEDIA);
                String photoUrl = jsonMedia.getString(FLICKR_PHOTO_URL);

                Photo photo = new Photo(title, author, authorId, link, tags, photoUrl);
                mPhotos.add(photo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(Photo singlePhoto : mPhotos){
            Log.d("LINCEO", singlePhoto.toString());
        }
    }
}
