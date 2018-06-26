package smarterbooks.iss.com.smarterbooks;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import smarterbooks.iss.com.smarterbooks.Classes.Book;
import smarterbooks.iss.com.smarterbooks.Classes.BookGridViewAdapter;

public class BooksGridViewActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_grid_view);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        List<Book> books = Book.listBook();
        gridView = (GridView) findViewById(R.id.gridView);
//        BookAdapter adapter = new BookAdapter(this, R.layout.listview, books);
//        //setListAdapter(adapter);
        gridView.setAdapter(new BookGridViewAdapter(this, R.layout.gridviewitem, books));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object bookobject = gridView.getItemAtPosition(position);
                Book booksitem = (Book) bookobject;
                Intent intent = new Intent(getApplicationContext(),BookDetailsActivity.class);
                intent.putExtra("bookid", booksitem.get("BookID"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
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
            case R.id.action_booklist:
                Intent intent = new Intent(this, BooksGridViewActivity.class);
                startActivity(intent);
            default:
                break;
        }

        return true;
    }
}
