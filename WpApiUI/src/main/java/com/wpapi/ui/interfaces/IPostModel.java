package com.wpapi.ui.interfaces;

/**
 * Interface for overriding getter and setter
 * for binding the data to model
 *
 * @author  Rajan Maurya
 * @version 1.0
 * @since   01/02/2016
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
