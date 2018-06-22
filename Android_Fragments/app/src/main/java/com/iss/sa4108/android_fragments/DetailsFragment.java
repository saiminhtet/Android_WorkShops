package com.iss.sa4108.android_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class DetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_details, container, false);
        Bundle arg = getArguments();
        if (arg != null) {
            HashMap<String,String> item = (HashMap<String,String>) arg.getSerializable("item");
            if (item != null) {
                TextView t2 = (TextView) v.findViewById(R.id.textView2);
                t2.setText(item.get("id"));
                TextView t4 = (TextView) v.findViewById(R.id.textView4);
                t4.setText(item.get("description"));
                TextView t6 = (TextView) v.findViewById(R.id.textView6);
                t6.setText(item.get("cost"));
            }
        }
        return(v);
    }
}
