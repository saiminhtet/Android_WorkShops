package com.iss.sa4108.persistingdata;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    int count=0;

    void setTextView(){
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(String.valueOf(count));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoreInstanceState(savedInstanceState);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count+1;
                setTextView();
            }
        });
    }

    void restoreInstanceState(Bundle state) {
        if (state != null) {
            count = state.getInt("Count");
            setTextView();
    }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Count", count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.option1:
               startActivity(new Intent(this, MyPreferencesActivity.class));
                return true;
            case R.id.option2:
                startActivity(new Intent(this, MyPreferenceAvtivity.class));
                return true;
            case R.id.option3:
                startActivity(new Intent(this, ReadWriteFile.class));
                return true;
            case R.id.option5:
                startActivity(new Intent(this, NetworkRead.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
