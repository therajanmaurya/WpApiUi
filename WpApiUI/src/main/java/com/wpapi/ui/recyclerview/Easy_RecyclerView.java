package com.wpapi.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.wpapi.ui.ui.LayoutManagerType;

/**
 * Easy_RecyclerView is the Simplest RecyclerView ,don't need to doing lots of stuff
 * just make object and use it
 *
 * @author  Rajan Maurya
 * @version 1.0
 * @since   03/02/2016
 */
public class Easy_RecyclerView
{

    private Context context;
    private RecyclerView.LayoutManager mLayoutManager;
    private int SPAN_COUNT = 2;
    private int orientation = 1;

    /**
     * Default Constructor for Linearlayout
     *
     * @param context
     */
    public Easy_RecyclerView(Context context)
    {
        this.context = context;
    }


    /**
     * Constructor for Gridlayout
     *
     * @param context
     * @param SPAN_COUNT count in grid line
     */
    public Easy_RecyclerView(Context context, int SPAN_COUNT)
    {
        this.context = context;
        this.SPAN_COUNT = SPAN_COUNT;
    }


    /**
     * Setting All the stuff of RecyclerView like SPAN_COUNT and LayoutManagerType
     * @param layoutManagerType LayoutType (Grid or Linear)
     * @return Easy_RecyclerView
     */
    public RecyclerView SetLayoutManager(RecyclerView recyclerView,LayoutManagerType layoutManagerType)
    {
        return SetParameter(recyclerView , layoutManagerType);
    }


    public RecyclerView SetLayoutManager(RecyclerView recyclerView,LayoutManagerType layoutManagerType , int columns)
    {
        this.SPAN_COUNT = columns;
        return SetParameter(recyclerView , layoutManagerType);
    }


    public RecyclerView SetLayoutManager(RecyclerView recyclerView,LayoutManagerType layoutManagerType , int columns , int orientation)
    {
        this.SPAN_COUNT = columns;
        this.orientation = orientation;
        return SetParameter(recyclerView , layoutManagerType);
    }


    public RecyclerView SetParameter(RecyclerView recyclerView,LayoutManagerType layoutManagerType)
    {
        int scrollPosition = 0;
        SetLayoutType(layoutManagerType, SPAN_COUNT, orientation);
        if (recyclerView.getLayoutManager() != null)
        {
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
    public void SetLayoutType(LayoutManagerType layoutManagerType, int SPAN_COUNT , int orientation)
    {

        switch (layoutManagerType)
        {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(context, SPAN_COUNT);
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(context);
                break;
            case STAGGERED_GRID_LAYOUT_MANAGER:
                mLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT ,LinearLayoutManager.VERTICAL);
            default:
                mLayoutManager = new LinearLayoutManager(context);
        }
    }

}
