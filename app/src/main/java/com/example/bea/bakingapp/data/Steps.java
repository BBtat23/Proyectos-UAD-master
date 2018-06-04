package com.example.bea.bakingapp.data;

public class Steps {

    private int mId;
    private String mShortDescription;
    private String mDescription;
    private String mVideoURL;
    private String mThumbnailURL;

    public Steps(int id, String shortDescription, String description, String videoURL, String thumbnailURL){
        this.mId = id;
        this.mShortDescription = shortDescription;
        this.mDescription = description;
        this.mVideoURL = videoURL;
        this.mThumbnailURL = thumbnailURL;
    }

    public int getId(){return mId;}
    public String getShortDescription(){return mShortDescription;}
    public String getDescription(){return mDescription;}
    public String getVideoURL(){return mVideoURL;}
    public String getThumbnailURL(){return mThumbnailURL;}
}
