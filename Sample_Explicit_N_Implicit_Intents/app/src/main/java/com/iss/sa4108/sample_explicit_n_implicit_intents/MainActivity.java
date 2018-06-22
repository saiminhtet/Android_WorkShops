package com.iss.sa4108.sample_explicit_n_implicit_intents;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Uri uri;
        Intent i;
        switch (item.getItemId()) {
            case R.id.option1:
                uri = Uri.parse("http://www.yahoo.com");
                i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
                return true;
            case R.id.option2:
                uri = Uri.parse("tel:92345678");
                i = new Intent(Intent.ACTION_CALL, uri);
                startActivity(i);
                return true;
            case R.id.option3:
                uri = Uri.parse("tel:92345678");
                i = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(i);
                return true;
            case R.id.option4:
                uri = Uri.parse("geo:1.29191,103.77667");
                i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
                return true;
            case R.id.option5:
                i = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(i);
                return true;
            case R.id.option6:
                uri = Uri.parse("content://contacts/people/");
                i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
                return true;
            case R.id.option7:
                uri = Uri.parse("content://contacts/people/1");
                i = new Intent(Intent.ACTION_EDIT, uri);
                startActivity(i);
                return true;
            case R.id.option8:
                i = new Intent(this, MyBrowser.class);
                i.setData(Uri.parse("http://www.iss.nus.edu.sg/"));
                startActivity(i);
                return true;
            case R.id.option9:
                startActivity(new Intent(this, AnotherActivity.class));
                return true;
            case R.id.option10:
                generateNotification();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void generateNotification(){
        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent n = new Intent(this, AnotherActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this, 0, n, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder =
                new Notification.Builder(this)
                        .setTicker("You have been alerted now -- so be warned and very warned.")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setContentTitle("Happening")
                        .setContentText("You can see what is happening now.")
                        .setContentIntent(pending);
        manager.notify(1, builder.build());
    }
}