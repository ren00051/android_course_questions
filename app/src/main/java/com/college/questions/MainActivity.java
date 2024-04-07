package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/*

 Complete the TODOs below

 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<String> myItems = new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> myAdapter;
        ListView myListView;

        //Retrieve the ListView
        myListView = findViewById(R.id.theListView);
        //Set up the Adapter
        myAdapter = new ArrayAdapter<>( this,
                android.R.layout.simple_expandable_list_item_1,
                myItems);
        myListView.setAdapter( myAdapter );

        //TODO 1: Add item at the top of the list
        // You can use createEntry() to generate a String
        FloatingActionButton fabAddTop = findViewById(R.id.fabAddTopId);
        fabAddTop.setOnClickListener(c->{
            myItems.add(0,createEntry());
            myAdapter.notifyDataSetChanged();
            Log.d(TAG,"added timestamp to the top of the listView.");
        });


        //TODO 2: Add item at the end of the list.
        // You can use createEntry() to generate a String
        FloatingActionButton fabAddLast = findViewById(R.id.fabAddLastId);
        fabAddLast.setOnClickListener(c->{
            myItems.add(createEntry());
            myAdapter.notifyDataSetChanged();
        });


        //TODO 3: Delete item at the top of the list);
        FloatingActionButton fabDeleteTop = findViewById(R.id.fabDeleteTopId);
        fabDeleteTop.setOnClickListener((c->{
            myItems.remove(0);
            myAdapter.notifyDataSetChanged();
        }));


        //TODO 4: Delete item at the bottom of the list.
        FloatingActionButton fabDeleteLast = findViewById(R.id.fabDeleteLastId);
        fabDeleteLast.setOnClickListener((c->{
            myItems.remove(myItems.size()-1);
            myAdapter.notifyDataSetChanged();
        }));


        //TODO 5: Delete element when an item is clicked with a short click
        // Use the ListView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                myItems.remove(position);
                myAdapter.notifyDataSetChanged();
            }
        });


        //TODO 6: Add element after an item is clicked with a long click
        // Use the ListView

        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                myItems.add(position+1, createEntry());
                myAdapter.notifyDataSetChanged();
                return true;
            }
        });

        //TODO 7: Clear all the items in the list
        FloatingActionButton fabClear = findViewById(R.id.fabClearAllId);
        fabClear.setOnClickListener(c->{
            myItems.clear();
            myAdapter.notifyDataSetChanged();
        });

    }

    //Create a String to add in the row
    private String createEntry() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat(" HH:mm:ss", Locale.CANADA);
        return dateformat.format(new Date());
    }
}
