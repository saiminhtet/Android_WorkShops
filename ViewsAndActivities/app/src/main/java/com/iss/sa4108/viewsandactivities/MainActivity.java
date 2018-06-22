package com.iss.sa4108.viewsandactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    CheckBox checkbox1;
    EditText text;

    void append(String m) {
        text.append(m+"\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText1);
        // make anonymous object as listener
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                append("button Clicked");
            }
        });

        // make activity as listener
        checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkbox1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        append("checkbox changed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                append("item1");
                return true;
            case R.id.item2:
                append("item2");
                return true;
            case R.id.item3:
                Toast t = Toast.makeText(this, "My message", Toast.LENGTH_SHORT);
                t.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Context Menus
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context1:
                // do something
                Toast t = Toast.makeText(this, "My message", Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.context2:
                // for ListView, can do following for index to data

                // do something with m
                Toast t2 = Toast.makeText(this, "My message", Toast.LENGTH_SHORT);
                t2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
