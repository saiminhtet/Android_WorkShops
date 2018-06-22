package com.iss.sa4108.listview_listactivity_json;

import android.app.ListActivity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //For the ListActivity not require to setContentView
        //setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        List<String> emps = Employee.list();
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_list_item_1, emps);
        MyAdapter adapter = new MyAdapter(this, R.layout.row, emps);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Intent intent = new Intent(this, EmpDetailsActivity.class);
        intent.putExtra("eid", item);
        startActivity(intent);
    }
}
