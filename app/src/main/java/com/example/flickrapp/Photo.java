package com.example.flickrapp;

public class Photo {
    private String mTitle;
    private String mAuthor;
    private String mAuthorId;
    private String mLinks;
    private String mTag;
    private String mImageUrl;

    public Photo(String mTitle, String mAuthor, String mAuthorId, String mLinks, String mTag, String mImageUrl) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mAuthorId = mAuthorId;
        this.mLinks = mLinks;
        this.mTag = mTag;
        this.mImageUrl = mImageUrl;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public void setAuthorId(String mAuthorId) {
        this.mAuthorId = mAuthorId;
    }

    public void setLinks(String mLinks) {
        this.mLinks = mLinks;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mAuthorId='" + mAuthorId + '\'' +
                ", mLinks='" + mLinks + '\'' +
                ", mTag='" + mTag + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                '}';
    }
}
