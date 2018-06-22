package com.iss.sa4108.persistingdata;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkRead extends Activity {

    EditText txt1, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_read);
        txt1 = (EditText) findViewById(R.id.editText1);
        txt2 = (EditText) findViewById(R.id.editText2);
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txt1.getText().toString();
                txt2.setText(netread(s));
            }
        });
    }

    String netread(String url) {
        StringBuilder buf = new StringBuilder();
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream ins = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(ins));
            String line;
            while ((line = rd.readLine()) != null) {
                buf.append(line);
                buf.append("\r\n");
            }
            rd.close(); ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return(buf.toString());
    }
}
