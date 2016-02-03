package com.wpapi.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wpapi.ui.R;
import com.wpapi.ui.interfaces.IPostModel;
import com.wpapi.ui.ui.LayoutUI;

import java.util.List;

/**
 * The Awesome Adapter is the Adapter That makes you easier to make Awesome UI with
 * No headache only need is just make object pass data and setAdapter
 *
 * @author  Rajan Maurya
 * @version 1.0
 * @since   1/2/2016
 */
public class Awesome_Adapter<T extends IPostModel> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String LOG_TAG = getClass().getSimpleName();
    private List<T> mPostdata;
    private Context context;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    static LayoutUI UIType;


    /**
     * Custom ViewHolder that describes an item view and metadata about its place within the RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mpost_image;
        TextView mpost_title, mpost_date, mpost_description;

        public ViewHolder(View v) {
            super(v);

            switch (UIType)
            {
                //google card UI
                case google_card:

                    mpost_image = (ImageView) v.findViewById(R.id.post_image);
                    mpost_date = (TextView) v.findViewById(R.id.post_date);
                    mpost_description = (TextView) v.findViewById(R.id.post_description);

                    break;

                //cheesesquare card ui
                case cheesesquare:

                    mpost_image = (ImageView) v.findViewById(R.id.post_image);
                    break;

                // Simple card ui
                case simple_cardui:
                    mpost_description = (TextView) v.findViewById(R.id.post_description);
                    break;

                default:
            }

            mpost_title = (TextView) v.findViewById(R.id.post_title);


        }
    }


    /**
     * Progressbar item ViewHolder in RecyclerView (It shows when load more open triggered in RecyclerView)
     */
    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar1);
        }
    }


    /**
     * Constructor To initialize RecyclerView and RecyclerView Item UI Type
     * @param context Context of Fragment/Activity
     * @param postModels Model of data to inflate in RecyclerView
     * @param layoutUI  Ui type like google_card , cheeseSquare , Simple UI
     */
    public Awesome_Adapter(Context context, @Nullable List<T> postModels, LayoutUI layoutUI) {
        this.context = context;
        this.mPostdata = postModels;
        UIType = layoutUI;
    }


    /**
     * It is for setting RecyclerView Size
     * @return size of RecyclerView
     */
    @Override
    public int getItemCount() {
        return mPostdata.size();
    }

    /**
     *
     * @param position In which putting progressbar
     * @return RecyclerView Item View
     */
    @Override
    public int getItemViewType(int position) {
        return mPostdata.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }


    /**
     *
     * This is for Setting the UI of RecyclerView Item
     *
     * @param parent
     * @param viewType Progressbar or Beautiful UI
     * @return Item Ui
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    LayoutUI.UI_Type(UIType), parent, false);

            vh = new ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_loadmore, parent, false);

            vh = new ProgressViewHolder(v);
        }
        return vh;
    }


    /**
     * Binding the data to RecyclerView Item
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {

            Picasso picasso = Picasso.with(context);
            picasso.setIndicatorsEnabled(true);
            picasso.setLoggingEnabled(true);

             switch (UIType)
                {
                    case google_card:

                        ((ViewHolder) holder).mpost_description.setText(mPostdata.get(position).getDescription());
                        ((ViewHolder) holder).mpost_date.setText(mPostdata.get(position).getDate());
                        loadimage(picasso , position,((ViewHolder) holder).mpost_image);
                        break;
                    case cheesesquare:

                        loadimage(picasso , position,((ViewHolder) holder).mpost_image);
                        break;

                    case simple_cardui:

                        ((ViewHolder) holder).mpost_description.setText(mPostdata.get(position).getDescription());

                        break;

                    default:

                }

            ((ViewHolder) holder).mpost_title.setText(mPostdata.get(position).getTitle());


        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }


    /**
     * Loading Image In RecyclerView Item ImageView
     *
     * @param picasso
     * @param position of the RecyclerView
     * @param imageView ImageView Of item to load image from network
     */
    public void loadimage(Picasso picasso , int position , ImageView imageView)
    {
        try
        {
            picasso.load(mPostdata.get(position).getImageSource())
                    .fit()
                    .placeholder(R.drawable.demo)
                    .error(R.drawable.demo)
                    .into(imageView);

        }catch (IllegalArgumentException e)
        {
            Log.d(LOG_TAG , "Null image url");

        }

    }


}