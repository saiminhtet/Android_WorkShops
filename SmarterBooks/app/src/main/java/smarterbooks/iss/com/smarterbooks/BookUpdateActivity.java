package smarterbooks.iss.com.smarterbooks;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import smarterbooks.iss.com.smarterbooks.Classes.Book;

public class BookUpdateActivity extends AppCompatActivity implements View.OnClickListener {
    final static int[] ids = {R.id.BookID, R.id.Title, R.id.CategoryID, R.id.ISBN, R.id.Author, R.id.Stock, R.id.Price};
    final static String[] keys = {"BookID", "Title", "CategoryID", "ISBN", "Author", "Stock", "Price"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_update);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String bookid = i.getStringExtra("bookid");
        Book books = Book.getbook(bookid);
        show(books);
    }

    void show(Book books) {
        for (int i = 0; i < keys.length; i++) {
            EditText e = (EditText) findViewById(ids[i]);
            e.setText(books.get(keys[i]));
        }
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(Book.getPhoto(false, books.get("ISBN")));
    }

    @Override
    public void onClick(View v) {
        EditText BookID, Title, CategoryID, ISBN, Author, Stock, Price;
        BookID = (EditText) findViewById(R.id.BookID);
        Title = (EditText) findViewById(R.id.Title);
        CategoryID = (EditText) findViewById(R.id.CategoryID);
        ISBN = (EditText) findViewById(R.id.ISBN);
        Author = (EditText) findViewById(R.id.Author);
        Stock = (EditText) findViewById(R.id.Stock);
        Price = (EditText) findViewById(R.id.Price);
//        JSONArray updatebooklist = new JSONArray();
//        JSONObject jsonObject = new JSONObject();
//        try{
//            jsonObject.put("Title", Title.toString());
//            jsonObject.put("CategoryID", CategoryID.toString());
//            jsonObject.put("ISBN", ISBN.toString());
//            jsonObject.put("Author", Author.toString());
//            jsonObject.put("Stock", Stock.toString());
//            jsonObject.put("Price", Price.toString());
//        }
//        catch (Exception e) {
//            System.out.println("Error:" + e);
//        }
        Book updatebooklist = new Book(BookID.getText().toString(), Title.getText().toString(), CategoryID.getText().toString(), ISBN.getText().toString(), Author.getText().toString(), Stock.getText().toString(), Price.getText().toString());
       String result = Book.updateBook(updatebooklist);
    }
}