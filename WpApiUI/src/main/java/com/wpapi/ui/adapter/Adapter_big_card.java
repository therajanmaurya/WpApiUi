package com.wpapi.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wpapi.ui.R;
import com.wpapi.ui.interfaces.IPostModel;
import com.wpapi.ui.ui.LayoutUI;

import java.util.List;


/**
 * Created by RajanMaurya on 01/02/16.
 */
public class Adapter_big_card<T extends IPostModel> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String LOG_TAG = getClass().getSimpleName();
    private List<T> mPostdata;
    Context context;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    int layoutui;
    LayoutUI UIType;


    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mpost_image;
        TextView mpost_title, mpost_date, mpost_description;

        public ViewHolder(View v) {
            super(v);
            mpost_image = (ImageView) v.findViewById(R.id.post_image);
            mpost_date = (TextView) v.findViewById(R.id.post_date);
            mpost_title = (TextView) v.findViewById(R.id.post_title);
            mpost_description = (TextView) v.findViewById(R.id.post_description);

        }

        public ImageView getCoverpost() {
            return mpost_image;
        }

        public TextView getTitle() {
            return mpost_title;
        }

        public TextView getDate() {
            return mpost_date;
        }

        public TextView getsubDescription() {

            return mpost_description;
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar1);
        }
    }


    public Adapter_big_card(Context activity, @Nullable List<T> postModels , LayoutUI layoutUI) {
        this.context = activity;
        this.mPostdata = postModels;
        UIType = layoutUI;
    }


    @Override
    public int getItemCount() {
        return mPostdata.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mPostdata.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

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


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {

             switch (UIType)
                {
                    case google_card:



                    case cheesesquare:



                    default:

                }

            ((ViewHolder) holder).mpost_title.setText(mPostdata.get(position).getTitle());
            ((ViewHolder) holder).mpost_description.setText(mPostdata.get(position).getDescription());
            ((ViewHolder) holder).mpost_date.setText(mPostdata.get(position).getDate());

        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }


}