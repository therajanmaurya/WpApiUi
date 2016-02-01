package com.wpapi.ui.sample.models;

import com.wpapi.ui.interfaces.IPostModel;

/**
 * Created by RajanMaurya on 01/02/16.
 */
public class PostModel implements IPostModel{

    private String mImageSource;
    private String mPostdate;
    private String mPosttitle;
    private String mPostDescription;

    @Override
    public String getDate() {
        return mPostdate;
    }

    @Override
    public String getTitle() {
        return mPosttitle;
    }

    @Override
    public String getImageSource() {
        return mImageSource;
    }

    @Override
    public String getDescription() {
        return mPostDescription;
    }

    @Override
    public void setDate(String date) {
        this.mPostdate = date;
    }

    @Override
    public void setTitle(String title) {
        this.mPosttitle = title;
    }

    @Override
    public void setImageSource(String imageSource) {
        this.mImageSource = imageSource;
    }

    @Override
    public void setDescription(String description) {
        this.mPostDescription = description;
    }
}
