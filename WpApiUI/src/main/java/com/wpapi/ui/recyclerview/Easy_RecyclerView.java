package com.wpapi.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wpapi.ui.ui.LayoutManagerType;

/**
 * Created by RajanMaurya on 03/02/16.
 */
public class Easy_RecyclerView extends RecyclerView {

    private Context context;
    private Easy_RecyclerView.LayoutManager mLayoutManager;
    private int SPAN_COUNT = 2;

    public Easy_RecyclerView(Context context) {
        super(context);
        this.context = context;
    }

    public Easy_RecyclerView(Context context ,  int SPAN_COUNT)
    {
        super(context);
        this.context  = context;
        this.SPAN_COUNT = SPAN_COUNT;
    }

   public Easy_RecyclerView getRecyclerView(LayoutManagerType layoutManagerType )
    {
        int scrollPosition = 0;
        Easy_RecyclerView recyclerView = new Easy_RecyclerView(context);
        setlayoutmanager(layoutManagerType , SPAN_COUNT);
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);

        return recyclerView;
    }

    public void setlayoutmanager(LayoutManagerType layoutManagerType , int SPAN_COUNT)
    {

            switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(context, SPAN_COUNT);
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(context);
                break;
            default:
                mLayoutManager = new LinearLayoutManager(context);
        }
    }

}
