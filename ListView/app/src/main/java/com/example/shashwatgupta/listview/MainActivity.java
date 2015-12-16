package com.example.shashwatgupta.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] weather = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        ListAdapter myAdapter=new CustomAdapter(this, weather);
        ListView myListView = (ListView)findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String day=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, day, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
