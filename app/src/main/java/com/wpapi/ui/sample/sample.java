package com.wpapi.ui.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        Easy_RecyclerView easy_recyclerView = (Easy_RecyclerView)findViewById(R.id.easy_recyclerview);
        easy_recyclerView = easy_recyclerView.getRecyclerView(LayoutManagerType.LINEAR_LAYOUT_MANAGER);

        Awesome_Adapter<PostModel> awesome_adapter  = new Awesome_Adapter(this , postModel , LayoutUI.google_card );
        easy_recyclerView.setAdapter(awesome_adapter);

    }
}
