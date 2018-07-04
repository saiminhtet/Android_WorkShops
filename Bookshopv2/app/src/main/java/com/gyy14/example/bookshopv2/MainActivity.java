package com.gyy14.example.bookshopv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {
    private ProgressDialog simpleWaitDialog;
 @SuppressLint("StaticFieldLeak")
 @Override
 protected void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     new AsyncTask<Void, Void, List<Book>>(){
         @Override
         protected List<Book> doInBackground(Void... params) {
             return Book.listBook();
         }
         @Override
         protected void onPreExecute() {

             simpleWaitDialog =  ProgressDialog.show(MainActivity.this,
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i;
        switch (item.getItemId()) {
            case R.id.search:
                i = new Intent(this,SearchActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}