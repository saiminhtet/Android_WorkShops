package com.gyy14.example.bookshopv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailsActivity extends Activity {
//    final static int []view = {R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4, R.id.editText5, R.id.editText6, R.id.editText7};
//    final static String []key = {"BookID", "Title", "CategoryID", "ISBN", "Author", "Stock", "Price"};

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String item = getIntent().getExtras().getString("BookID");
//        new AsyncTask<String, Void, Book>() {
//            @Override
//            protected Book doInBackground(String... params) {
//                return Book.getBook(params[0]);
//            }
//            @Override
//            protected void onPostExecute(Book result) {
//                for (int i=0; i<view.length; i++) {
//                    EditText t = (EditText) findViewById(view[i]);
//                    t.setText(result.get(key[i]));
//                }
//            }
//        }.execute(item);

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String bookid = i.getStringExtra("bookid");
        Book book=Book.getbook(bookid);
        show(book);
    }

    void show(Book book) {
        int []ids = {R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4, R.id.editText5, R.id.editText6, R.id.editText7};
        String []keys = {"BookID", "Title", "CategoryID", "ISBN","Author","Stock","Price"};
        for (int i=0; i<keys.length; i++) {
            EditText e = (EditText) findViewById(ids[i]);
            e.setText(book.get(keys[i]));
        }
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.setImageBitmap(Book.getPhoto(book.get("ISBN")));
    }
}
