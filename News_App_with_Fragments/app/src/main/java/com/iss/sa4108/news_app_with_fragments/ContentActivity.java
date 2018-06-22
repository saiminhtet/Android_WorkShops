package com.iss.sa4108.news_app_with_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.iss.sa4108.news_app_with_fragments.Fragments.ContentFragment;

public class ContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Intent intent = getIntent();
        if (intent.hasExtra("url")) {
            String url = intent.getExtras().getString("url");
            Bundle args = new Bundle();
            args.putSerializable("url", url);
            Fragment f = new ContentFragment();
            f.setArguments(args);
            getFragmentManager().beginTransaction()
                    .add(R.id.content, f)
                    .commit();
        }
    }
}
