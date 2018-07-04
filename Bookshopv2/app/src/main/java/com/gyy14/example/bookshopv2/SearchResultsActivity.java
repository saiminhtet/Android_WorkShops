package com.gyy14.example.bookshopv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class SearchResultsActivity extends Activity {
    private ProgressDialog simpleWaitDialog;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        new AsyncTask<Void, Void, List<Book>>(){
            @Override
            protected List<Book> doInBackground(Void... params) {
                Intent i = getIntent();
                String searchquery = i.getStringExtra("searchquery");
                return Book.SearchBooks(searchquery);
            }
            @Override
            protected void onPreExecute() {

                simpleWaitDialog =  ProgressDialog.show(SearchResultsActivity.this,
                        "Wait", "Downloading ");

            }
            @Override
            protected void onPostExecute(List<Book> result) {

                final ListView lv1 = (ListView) findViewById(R.id.book_list);
                BookAdapter adapter = new BookAdapter(getApplicationContext(), R.layout.row, result);
                lv1.setAdapter(adapter);
                simpleWaitDialog.dismiss();

                lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        Object bookobject = lv1.getItemAtPosition(position);
                        Book booksitem = (Book) bookobject;
                        Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                        intent.putExtra("bookid", booksitem.get("BookID"));
                        startActivity(intent);
                    }
                });
            }
        }.execute();
    }
}
