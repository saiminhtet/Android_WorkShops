package com.gyy14.example.bookshopv2;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class SearchResultsActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_results);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String searchquery = i.getStringExtra("searchquery");
        List<Book> books = Book.SearchBooks(searchquery);

        final ListView lv1 = (ListView) findViewById(R.id.book_list);

        lv1.setAdapter(new BookAdapter(this, R.layout.row, books));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object bookobject = lv1.getItemAtPosition(position);
                Book booksitem = (Book) bookobject;
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("bookid", booksitem.get("BookID"));
                startActivity(intent);

            }
        });
    }
}
