package com.gyy14.example.bookshopv2;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Button search_btn = (Button) findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtSearch = (EditText) findViewById(R.id.editText2);
                String SearchQuery = txtSearch.getText().toString();
                Intent intent = new Intent(getApplicationContext(),SearchResultsActivity.class);
                intent.putExtra("searchquery", SearchQuery);
                startActivity(intent);

            }
        });
    }


}
