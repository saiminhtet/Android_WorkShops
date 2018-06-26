package smarterbooks.iss.com.smarterbooks;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import smarterbooks.iss.com.smarterbooks.Classes.Book;

public class BookDetailsActivity extends AppCompatActivity {

    final static int[] ids = {R.id.BookID, R.id.Title, R.id.CategoryID, R.id.ISBN, R.id.Author, R.id.Stock, R.id.Price};
    final static String[] keys = {"BookID", "Title", "CategoryID", "ISBN", "Author", "Stock", "Price"};
    static String bookid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        bookid = i.getStringExtra("bookid");
        Book books = Book.getbook(bookid);
        show(books);
    }


    void show(Book books) {
        for (int i = 0; i < keys.length; i++) {
            TextView e = (TextView) findViewById(ids[i]);
            e.setText(books.get(keys[i]));
        }
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(Book.getPhoto(false, books.get("ISBN")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.editmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
//            case R.id.action_refresh:
//                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
//                        .show();
//                break;
            // action with ID action_settings was selected
            case R.id.action_edit:
//                EditText txtBookID;
//                String BookID = txtBookID.getText().toString();
                Intent intent = new Intent(this, BookUpdateActivity.class);
                intent.putExtra("bookid", bookid);
                startActivity(intent);
            default:
                break;
        }

        return true;
    }
}
