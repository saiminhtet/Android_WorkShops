package com.iss.sa4108.persistingdata;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MyPreferenceAvtivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypreference);
    }
}
