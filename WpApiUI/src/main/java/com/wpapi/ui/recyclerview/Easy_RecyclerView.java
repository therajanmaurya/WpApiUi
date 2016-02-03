package com.wpapi.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.wpapi.ui.ui.LayoutManagerType;

/**
 * Easy_RecyclerView is the Simplest RecyclerView ,don't need to doing lots of stuff
 * just make object and use it
 *
 * @author  Rajan Maurya
 * @version 1.0
 * @since   03/02/2016
 */
public class Easy_RecyclerView extends RecyclerView {

    private Context context;
    private Easy_RecyclerView.LayoutManager mLayoutManager;
    private int SPAN_COUNT = 2;

    /**
     * Default Constructor for Linearlayout
     *
     * @param context
     */
    public Easy_RecyclerView(Context context) {
        super(context);
        this.context = context;
    }


    /**
     * Constructor for Gridlayout
     *
     * @param context
     * @param SPAN_COUNT count in grid line
     */
    public Easy_RecyclerView(Context context, int SPAN_COUNT) {
        super(context);
        this.context = context;
        this.SPAN_COUNT = SPAN_COUNT;
    }


    /**
     * Setting All the stuff of RecyclerView like SPAN_COUNT and LayoutManagerType
     * @param layoutManagerType LayoutType (Grid or Linear)
     * @return Easy_RecyclerView
     */
    public Easy_RecyclerView getRecyclerView(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;
        Easy_RecyclerView recyclerView = new Easy_RecyclerView(context);
        setlayoutmanager(layoutManagerType, SPAN_COUNT);
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.scrollToPosition(scrollPosition);

        return recyclerView;
    }

    /**
     * Setting LayoutManager
     * @param layoutManagerType LayoutType
     * @param SPAN_COUNT No. of column in grid
     */
    public void setlayoutmanager(LayoutManagerType layoutManagerType, int SPAN_COUNT) {

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
