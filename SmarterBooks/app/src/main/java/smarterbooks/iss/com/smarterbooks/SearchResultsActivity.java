package smarterbooks.iss.com.smarterbooks;

import android.app.SearchManager;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import smarterbooks.iss.com.smarterbooks.Classes.Book;
import smarterbooks.iss.com.smarterbooks.Classes.BookAdapter;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String searchquery = i.getStringExtra("searchquery");
        List<Book> books = Book.SearchBooks(searchquery);

        final ListView lv1 = (ListView) findViewById(R.id.book_list);

        lv1.setAdapter(new BookAdapter(this, R.layout.listview, books));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object bookobject = lv1.getItemAtPosition(position);
                Book booksitem = (Book) bookobject;
                Intent intent = new Intent(getApplicationContext(), BookDetailsActivity.class);
                intent.putExtra("bookid", booksitem.get("BookID"));
                startActivity(intent);

            }
        });
        }
    }




