package com.example.devansh.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connection between activity and layout
        setContentView(R.layout.layout_main);
    }

    public void buttonClicked(View view){
        EditText editText = (EditText) findViewById(R.id.nameTextView);
        String msg = editText.getText().toString();  //Calling methods on objects : object.method();

        //Intent : To go from one screen to another

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message",msg);
        startActivity(intent);
    }

}
