package com.gyy14.example.bookshopv2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Book extends HashMap<String,String> {

    final static String host = "http://bookshopapi20180622110219.azurewebsites.net/api/book/";

    public Book(String bookid, String title, String catid, String isbn, String author, String stock, String price) {
        put("BookID", bookid);
        put("Title", title);
        put("CategoryID", catid);
        put("ISBN", isbn);
        put("Author", author);
        put("Stock", stock);
        put("Price", price);
    }

public static List<Book> listBook(){
    List<Book> book = new ArrayList<Book>();
    JSONArray a = JSONParser.getJSONArrayFromUrl(host);
    try {
        for (int i=0; i<a.length();i++) {
            JSONObject b = a.getJSONObject(i);
            book.add(new Book(b.getString("BookID"),b.getString("Title"),b.getString("CategoryID"),
                    b.getString("ISBN"),b.getString("Author"),b.getString("Stock"),b.getString("Price")));
        }
    } catch (Exception e){
        Log.e("JSONArray error", e.toString());
    }
    return book;
}

    public static Book getbook(String bookid){
        JSONObject b = JSONParser.getJSONFromUrl(host + bookid);
        try {
            return new Book(b.getString("BookID"), b.getString("Title"),
                    b.getString("CategoryID"),
                    b.getString("ISBN"), b.getString("Author"), b.getString("Stock"), b.getString("Price"));
        } catch (Exception e){
            Log.e("Book.getbook()", "JSONArray error");
        }
        return(null);
    }

public static List<Book> SearchBooks(String searchquery){
    List<Book> book = new ArrayList<Book>();
    JSONArray a = JSONParser.getJSONArrayFromUrl(host + "/search/" + searchquery );
    try {
        for (int i=0; i<a.length();i++) {
            JSONObject b = a.getJSONObject(i);
            book.add(new Book(b.getString("BookID"),b.getString("Title"),b.getString("CategoryID"),
                    b.getString("ISBN"),b.getString("Author"),b.getString("Stock"),b.getString("Price")));
        }
    } catch (Exception e){
        Log.e("JSONArray error", e.toString());
    }
    return book;
}
    final static String imageURL = "http://bookshopapi20180622110219.azurewebsites.net/api/book/";
    public static Bitmap getPhoto(String isbn){
        try{
            /*URL url = (thumbnail ? new URL(String.format("%s/%s-s.jpg",imageURL, isbn + "/cover")) :
                    new URL(String.format("%s/%s.jpg",imageURL, isbn + "/cover")));*/
            URL url = (new URL(String.format(imageURL + isbn + "/cover")));
            URLConnection conn = url.openConnection();
            InputStream ins = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(ins);
            ins.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Book.getPhoto()", "Bitmap error" + e);
        }
        return(null);

    }
}
