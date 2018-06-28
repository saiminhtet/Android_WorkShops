package smarterbooks.iss.com.smarterbooks;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import smarterbooks.iss.com.smarterbooks.Classes.Book;
import smarterbooks.iss.com.smarterbooks.Classes.BookAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncTask<String, Void, BookAdapter>(){
            @Override
            protected BookAdapter  doInBackground(String... params) {
                List<Book> books = Book.listBook();
                BookAdapter adapter = new BookAdapter(getApplicationContext(),R.layout.listview, books);
                return adapter;
            }
            @Override
            protected void onPostExecute(BookAdapter adapter){
                final ListView lv1 = (ListView) findViewById(R.id.book_list);
                lv1.setAdapter(adapter);
            }
        }.execute();
//        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
//        List<Book> books = Book.listBook();
//        final ListView lv1 = (ListView) findViewById(R.id.book_list);
//        lv1.setAdapter(new BookAdapter(this, R.layout.listview, books));
//        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                Object bookobject = lv1.getItemAtPosition(position);
//                Book booksitem = (Book) bookobject;
//                Intent intent = new Intent(getApplicationContext(),BookDetailsActivity.class);
//                intent.putExtra("bookid", booksitem.get("BookID"));
//                startActivity(intent);
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(new ComponentName(this, SearchResultsActivity.class)));
        //searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.print(query);
                Intent intent = new Intent(getApplicationContext(),SearchResultsActivity.class);
                intent.putExtra("searchquery", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


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
