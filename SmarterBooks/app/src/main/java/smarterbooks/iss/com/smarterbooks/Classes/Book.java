package smarterbooks.iss.com.smarterbooks.Classes;

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

public class Book extends HashMap<String, String> {
    final static String baseURL = "http://bookshopapi20180622110219.azurewebsites.net/api/";

    public Book(String bookid, String title, String categoryid, String isbn, String author, String stock, String price){
        put("BookID", bookid);
        put("Title", title);
        put("CategoryID", categoryid);
        // put("CategoryName", categoryname);
        put("ISBN", isbn);
        put("Author", author);
        put("Stock", stock);
        put("Price", price);
    }

    public static List<Book> listBook(){
        List<Book> book = new ArrayList<Book>();
        JSONArray a = JSONParser.getJSONArrayFromUrl(baseURL + "book");
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

    public static List<Book> SearchBooks(String searchquery){
        List<Book> book = new ArrayList<Book>();
        JSONArray a = JSONParser.getJSONArrayFromUrl(baseURL + "book/search/" + searchquery );
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
        JSONObject b = JSONParser.getJSONFromUrl(baseURL + "book/" + bookid);
        try {
            return new Book(b.getString("BookID"), b.getString("Title"),
                    b.getString("CategoryID"),
                    b.getString("ISBN"), b.getString("Author"), b.getString("Stock"), b.getString("Price"));
        } catch (Exception e){
            Log.e("Book.getbook()", "JSONArray error");
        }
        return(null);
    }

    final static String imageURL = "http://bookshopapi20180622110219.azurewebsites.net/api/book/";
    public static Bitmap getPhoto(boolean thumbnail, String isbn){
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
            Log.e("Book.getPhoto()", "Bitmap error");
        }
        return(null);

    }

    public static String updateBook(Book b) {
        JSONObject jbook = new JSONObject();
        try {
            jbook.put("BookID", b.get("BookID"));
            jbook.put("Title", b.get("Title"));
            jbook.put("Author", b.get("Author"));
            jbook.put("ISBN", b.get("ISBN"));
            jbook.put("CategoryID",b.get("CategoryID"));
            jbook.put("Stock", b.get("Stock"));
            jbook.put("Price", b.get("Price"));
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        System.out.print(jbook.toString());
        String result = JSONParser.postStream(baseURL + "book/update", jbook.toString());
        return result;
    }
}
