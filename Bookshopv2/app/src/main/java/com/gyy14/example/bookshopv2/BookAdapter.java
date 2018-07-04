package com.gyy14.example.bookshopv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private List<Book> books;
    private ProgressDialog simpleWaitDialog;
    int resource;

    public BookAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);
        this.resource = resource;
        this.books = books;
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

       final View v = inflater.inflate(resource, null);
        Book bookobj = books.get(position);
        if (bookobj != null) {
            TextView txtbookId = (TextView) v.findViewById(R.id.BookID);
            txtbookId.setText(bookobj.get("BookID"));
            TextView txttitle = (TextView) v.findViewById(R.id.Title);
            txttitle.setText(bookobj.get("Title"));
            TextView txtcategoryname = (TextView) v.findViewById(R.id.Author);
            txtcategoryname.setText(bookobj.get("Author"));

            new AsyncTask<Void,Void,Bitmap>(){
                @Override
                protected Bitmap doInBackground(Void... params) {
                    return Book.getPhoto(books.get(position).get("ISBN"));
                }

                @Override
                protected void onPostExecute(Bitmap result){
                    ImageView image = (ImageView) v.findViewById(R.id.imageView2);
                    image.setImageBitmap(result);

                }

            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        return v;
    }
}
