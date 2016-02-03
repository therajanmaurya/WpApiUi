package com.wpapi.ui.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.wpapi.ui.adapter.Awesome_Adapter;
import com.wpapi.ui.sample.models.PostModel;
import com.wpapi.ui.ui.LayoutUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        RecyclerView recyclerView = new RecyclerView(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

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

        Awesome_Adapter<PostModel> adapter_big_card  = new Awesome_Adapter(this , postModel , LayoutUI.google_card );
        recyclerView.setAdapter(adapter_big_card);

        setContentView(recyclerView);
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
