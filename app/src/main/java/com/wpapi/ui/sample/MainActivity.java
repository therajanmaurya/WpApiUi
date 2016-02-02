package com.wpapi.ui.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.wpapi.ui.adapter.Adapter_big_card;
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

        for(int i = 0 ; i<10 ; i++)
        {
            PostModel postModel1 = new PostModel();
            postModel1.setImageSource("Image");
            postModel1.setDate("1/2/2016");
            postModel1.setTitle("Title");
            postModel1.setDescription("Description");
            postModel.add(postModel1);
        }

        Adapter_big_card<PostModel> adapter_big_card  = new Adapter_big_card(this , postModel , LayoutUI.google_card);
        recyclerView.setAdapter(adapter_big_card);

        setContentView(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
