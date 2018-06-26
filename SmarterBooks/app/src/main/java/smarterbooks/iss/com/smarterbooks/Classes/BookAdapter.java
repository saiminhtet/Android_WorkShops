package smarterbooks.iss.com.smarterbooks.Classes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import smarterbooks.iss.com.smarterbooks.R;

public class BookAdapter extends ArrayAdapter<Book> {
    private List<Book> books;
    int resource;

    public BookAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);
        this.resource = resource;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(resource, null);
        Book bookobj = books.get(position);
        if (bookobj != null) {
            TextView txtbookId = (TextView) v.findViewById(R.id.BookID);
            txtbookId.setText(bookobj.get("BookID"));
            TextView txttitle = (TextView) v.findViewById(R.id.Title);
            txttitle.setText(bookobj.get("Title"));
            TextView txtcategoryname = (TextView) v.findViewById(R.id.Author);
            txtcategoryname.setText(bookobj.get("Author"));
            ImageView image = (ImageView) v.findViewById(R.id.imageView2);
            image.setImageBitmap(Book.getPhoto(true, bookobj.get("ISBN")));
        }
        return v;
    }
}
