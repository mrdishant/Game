package com.nearur.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    StringBuffer b=new StringBuffer();
    ArrayList<Integer> d;
    Player[] p;
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        t1=(TextView)findViewById(R.id.textView2);
        Intent r=getIntent();
        n=r.getIntExtra("number",0);
        p=new Player[n];
        random(n);
    }

    public void random(int n){
        d=new ArrayList<Integer>();
        for(int i=1;i<=n*3;i++){
            d.add(i);
        }

        Collections.shuffle(d);

        int i=0,x=0;
        while(x<n*3){

            p[i]=new Player();
            p[i].i=d.get(x);
            p[i].j=d.get(x+1);
            p[i].k=d.get(x+2);
            i++;
            x=x+3;
        }
        setView();
    }
    public void setView(){
        b.delete(0,b.length());
        for(int i=0;i<n;i++){
            b.append("Player "+(i+1)+" : "+p[i]+"\n");
        }
        t1.setText(b);
    }

    public void cl2(View v){
        String  res="";
        Collections.shuffle(d);
        int x=0;
        outer:
        while(x<n*3){

            for(int i=0;i<n;i++){
                if(p[i].i==0&&p[i].j==0&&p[i].k==0){
                    res="Player "+(i+1)+" Wins";
                    break outer;
                }
            }

            for(int i=0;i<n;i++){
                if(p[i].i==d.get(x)){
                    p[i].i=0;
                    Toast.makeText(A2.this, "Player "+(i+1)+" : "+d.get(x)+" cancelled", Toast.LENGTH_LONG).show();
                    break;
                }
                else if(p[i].j==d.get(x)){
                    p[i].j=0;
                    Toast.makeText(A2.this, "Player "+(i+1)+" : "+d.get(x)+" cancelled", Toast.LENGTH_LONG).show();
                    break;
                }
                else if(p[i].k==d.get(x)){
                    p[i].k=0;
                    Toast.makeText(A2.this, "Player "+(i+1)+" : "+d.get(x)+" cancelled", Toast.LENGTH_LONG).show();
                    break;
                }
            }

            x++;
        }
        Intent intent=new Intent(A2.this,A3.class);
        intent.putExtra("Winner",res);
        startActivity(intent);
    }
}

