package com.example.user.helloworld4;


import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {

    public ArrayList<EventModel> eventModels = new ArrayList<>();
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.btn_backarticle_normal);
        }
        final SwipeRefreshLayout swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        if (swipeContainer!=null) {
            swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // Your code to refresh the list here.
                    // Make sure you call swipeContainer.setRefreshing(false)
                    // once the network request has completed successfully.
                    swipeContainer.setRefreshing(false);

                }
            });
        }

        final EventModel model= new EventModel("abc",R.drawable.ic_launcher,"11 Januari 2016");
        eventModels.add(model);
        final EventModel model1= new EventModel("def",R.drawable.ic_launcher,"11 Maret 2016");
        eventModels.add(model1);
        final EventModel model2= new EventModel("xyz",R.drawable.ic_launcher,"11 Juli 2016");
        eventModels.add(model2);
        final EventModel model3= new EventModel("atoz",R.drawable.ic_launcher,"11 September 2016");
        eventModels.add(model3);
        CustomListAdapter adapter=new CustomListAdapter(this, eventModels);
        list=(ListView)findViewById(R.id.list);
        if (list!=null && adapter!= null) {


            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    EventModel Slecteditem = eventModels.get(position);
                    Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
                    intent.putExtra("NAMA_EVENT", Slecteditem.getNama());
                    setResult(0, intent);
                    finish();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
