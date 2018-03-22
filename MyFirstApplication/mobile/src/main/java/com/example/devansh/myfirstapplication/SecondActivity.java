package com.example.devansh.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        //getting connection to the TextView widget in the layout_second.xml
        TextView textView = (TextView) findViewById(R.id.display);
        Intent prevIntent = getIntent();
        String msg = prevIntent.getStringExtra("message").toString();
        textView.setText(msg);

    }
}
