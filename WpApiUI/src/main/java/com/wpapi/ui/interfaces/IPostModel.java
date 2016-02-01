package com.wpapi.ui.interfaces;

/**
 * Created by RajanMaurya on 01/02/16.
 */
public interface IPostModel {

    public String getDate();
    public String getTitle();
    public String getImageSource();
    public String getDescription();

    public void setDate(String date);
    public void setTitle(String title);
    public void setImageSource(String imageSource);
    public void setDescription(String description);
}
