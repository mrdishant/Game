package com.nearur.game;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class A1 extends AppCompatActivity {
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        t = (EditText) findViewById(R.id.editText);
    }
    public void cl(View v) {
        Intent i = new Intent(this, A2.class);
        if (t.getText().length() > 0) {
            int n = Integer.parseInt(t.getText().toString().trim());
            i.putExtra("number", n);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"No Input",Toast.LENGTH_SHORT).show();
        }
    }
}


