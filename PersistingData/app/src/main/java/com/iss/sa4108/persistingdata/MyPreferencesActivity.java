package com.iss.sa4108.persistingdata;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences pref;
    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_preferences);
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        t1 = (EditText) findViewById(R.id.editText1);
        t1.setText(pref.getString("username", "userme"));
        t2 = (EditText) findViewById(R.id.editText2);
        t2.setText(pref.getString("hostname", "localhost"));
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("username", t1.getText().toString());
        editor.putString("hostname", t2.getText().toString());
        editor.commit();
        finish();
    }
}
