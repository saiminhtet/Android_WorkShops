package com.iss.sa4108.listview_listactivity_json;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.ImageView;

public class EmpDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_details);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String eid = i.getStringExtra("eid");
        Employee emp = Employee.getEmp(eid);
        show(emp);
    }

    void show(Employee emp) {
        int []ids = {R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4};
        String []keys = {"Name", "Id", "Salary", "Address"};
        for (int i=0; i<keys.length; i++) {
            EditText e = (EditText) findViewById(ids[i]);
            e.setText(emp.get(keys[i]));
        }
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(Employee.getPhoto(false, emp.get("Id")));
    }
}
