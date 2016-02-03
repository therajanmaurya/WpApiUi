package com.wpapi.ui.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wpapi.ui.adapter.Awesome_Adapter;
import com.wpapi.ui.listener.RecyclerItemClickListner;
import com.wpapi.ui.recyclerview.Easy_RecyclerView;
import com.wpapi.ui.sample.models.PostModel;
import com.wpapi.ui.ui.LayoutManagerType;
import com.wpapi.ui.ui.LayoutUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListner.OnItemClickListener{



    private String LOG_TAG = getClass().getSimpleName();


    @Override
    public void onItemClick(View childView, int position) {

        Log.d(LOG_TAG , "OnItemClick" + position);
    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        List<PostModel> postModel  = new ArrayList<>();
        for(int i = 0 ; i<20 ; i++)
        {
            PostModel postModel1 = new PostModel();
            postModel1.setImageSource("http://i.imgur.com/rFLNqWI.jpg");
            postModel1.setDate("1/2/2016");
            postModel1.setTitle("This the Demo of the Cheese And Google card ");
            postModel1.setDescription("Description");
            postModel.add(postModel1);
        }

        Easy_RecyclerView easy_recyclerView = new Easy_RecyclerView(this);
        easy_recyclerView = easy_recyclerView.getRecyclerView(LayoutManagerType.GRID_LAYOUT_MANAGER);
        easy_recyclerView.addOnItemTouchListener(new RecyclerItemClickListner(this, this));

        Awesome_Adapter<PostModel> adapter_big_card  = new Awesome_Adapter(this , postModel , LayoutUI.google_card );
        easy_recyclerView.setAdapter(adapter_big_card);

        setContentView(easy_recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
