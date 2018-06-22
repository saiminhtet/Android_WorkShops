package com.iss.sa4108.persistingdata;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadWriteFile extends Activity {

    EditText txt1, txt2;
    final String filename = "abc.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_file);
        txt1 = (EditText) findViewById(R.id.editText1);
        txt2 = (EditText) findViewById(R.id.editText2);
    }

    public void Write(View v) {
        String contents = txt1.getText().toString();
        try {
            //FileOutputStream f = openFileOutput(filename, Context.MODE_PRIVATE);
            File file = Environment.getExternalStoragePublicDirectory(filename);
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter w = new PrintWriter(f);
            w.println(contents);
            w.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Read(View v) {
        StringBuilder buf = new StringBuilder();
        try {
           // FileInputStream fos = openFileInput(filename);
            File file = Environment.getExternalStoragePublicDirectory(filename);
            FileInputStream fos = new FileInputStream(file);
            BufferedReader r = new BufferedReader(new InputStreamReader(fos));
            String s;
            while ((s = r.readLine()) != null) {
                buf.append(s);
                buf.append("\r\n");
            }
            r.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txt2.setText(buf.toString());
    }
}
