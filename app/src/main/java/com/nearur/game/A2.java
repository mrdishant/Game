package com.nearur.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class A2 extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        t1=(TextView)findViewById(R.id.textView2);
        Intent r=getIntent();
        int n=r.getIntExtra("number",0);
        random(n);
    }

    public void random(int n){
        ArrayList<Integer> d=new ArrayList<Integer>();
        for(int i=1;i<=n*3;i++){
            d.add(i);
        }
        StringBuffer b=new StringBuffer();
        Collections.shuffle(d);
        Iterator<Integer> itr=d.iterator();
        int i=1,j=0;
        while(itr.hasNext()){
            if(j%3==0){
                b.append("\n"+"Player "+i+" : ");
                i++;
            }
            b.append(itr.next()+" ");
            j++;
        }


        Scroller s=new Scroller(this);
        t1.setScroller(s);
        t1.setText(n);
    }
}
