package com.wpapi.ui.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.wpapi.ui.adapter.Awesome_Adapter;
import com.wpapi.ui.recyclerview.Easy_RecyclerView;
import com.wpapi.ui.sample.models.PostModel;
import com.wpapi.ui.ui.LayoutManagerType;
import com.wpapi.ui.ui.LayoutUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajanMaurya on 03/02/16.
 */
public class sample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<PostModel> postModel  = new ArrayList<>();
        for(int i = 0 ; i<20 ; i++)
        {
            PostModel postModel1 = new PostModel();
            postModel1.setImageSource("http://i.imgur.com/rFLNqWI.jpg");
            postModel1.setDate("1/2/2016");
            postModel1.setTitle("This the Demo of the Cheese And Google card ");
            postModel1.setDescription("Description");
            postModel.add(postModel1);
        }

        RecyclerView easy_recyclerView = (RecyclerView)findViewById(R.id.easy_recyclerview);
        easy_recyclerView = new Easy_RecyclerView(this).SetLayoutManager(easy_recyclerView , LayoutManagerType.STAGGERED_GRID_LAYOUT_MANAGER , 3 , StaggeredGridLayoutManager.VERTICAL);

        Awesome_Adapter<PostModel> awesome_adapter  = new Awesome_Adapter(this , postModel , LayoutUI.simple_cardui );
        easy_recyclerView.setAdapter(awesome_adapter);

    }
}
