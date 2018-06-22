package com.iss.sa4108.news_app_with_fragments.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iss.sa4108.news_app_with_fragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        Bundle arg = getArguments();
        if (arg != null) {
            String url = arg.getString("url");
            if (url != null) {
                WebView webView = (WebView) view.findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView v, String u) {
                        v.loadUrl(u);
                        return false;
                    }
                });
                webView.loadUrl(url);
            }
        }
        return(view);
    }

}
