package com.example.flickrapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrRecyclerViewAdapter.FlickImageViewHolder>{
    private Context mContext;
    private List<Photo> mPhotoList;

    public FlickrRecyclerViewAdapter(Context context, List<Photo> photoList){
        this.mContext = context;
        mPhotoList = photoList;
    }

    @Override
    public int getItemCount() {
        return this.mPhotoList.size();
    }

    @NonNull
    @Override
    public FlickImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_element, null);
        FlickImageViewHolder flickImageViewHolder = new FlickImageViewHolder(v);
        return flickImageViewHolder;
    }

    // this method is called each time an element is created or updated
    @Override
    public void onBindViewHolder(@NonNull FlickImageViewHolder holder, int position) {
        // retrieve the photo object and its properties
        Photo photo = mPhotoList.get(position);

        // just set a title
        holder.title.setText(photo.getTitle());

        // use Picasso to download images and put them in an imageView (holder.thumbnail)
        Picasso.with(mContext).load(photo.getImageUrl())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);
    }

    class FlickImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumbnail;
        private TextView title;
        public FlickImageViewHolder(View itemView){
            super(itemView);
            this.thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.title = (TextView) itemView.findViewById(R.id.title);
        }
    }

}
