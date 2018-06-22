package com.iss.sa4108.android_fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import java.util.HashMap;

public class DetailsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsfragment);
        Intent intent = getIntent();
        if (intent.hasExtra("details")) {
            HashMap<String, String> m = (HashMap<String,String>)intent.getSerializableExtra("details");
            Bundle args = new Bundle();
            args.putSerializable("item", m);
            Fragment f = new DetailsFragment();
            f.setArguments(args);
            getFragmentManager().beginTransaction()
                    .add(R.id.detailsframe2, f)
                    .commit();
        }
    }

}