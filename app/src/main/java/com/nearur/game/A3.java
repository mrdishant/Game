package com.nearur.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class A3 extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
        t=(TextView)findViewById(R.id.textView3);
        String n=getIntent().getStringExtra("Winner").toString().trim();
        t.setText(n);
    }
}
