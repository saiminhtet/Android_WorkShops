package com.iss.sa4108.currencyconvertor;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends Activity {
    private void convert(EditText t, double factor, EditText r) {
        double i = Double.parseDouble(t.getText().toString());
        r.setText(String.format("%5f", i*factor));
    }

    private double getConversion() {
        final Spinner s = (Spinner) findViewById(R.id.spinner1);
        int i = s.getSelectedItemPosition();

        Resources res = getResources();
        String[] va = res.getStringArray(R.array.currencyV);
        return(Double.parseDouble(va[i]));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText t1 = (EditText) findViewById(R.id.editText1);
        final EditText t2 = (EditText) findViewById(R.id.editText2);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double f = getConversion();
                convert(t1, 1/f, t2);
            }
        });
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double f = getConversion();
                convert(t2, f, t1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}