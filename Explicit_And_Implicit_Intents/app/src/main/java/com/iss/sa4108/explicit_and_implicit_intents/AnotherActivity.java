package com.iss.sa4108.explicit_and_implicit_intents;

import android.app.Activity;
import android.os.Bundle;

public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
    }
}
