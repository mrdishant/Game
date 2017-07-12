package com.nearur.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    TextView t1,t2;
    ImageView image;
    StringBuffer b=new StringBuffer();
    ArrayList<Integer> d;
    Player[] p;
    Button btn;
    MediaPlayer mp;
    int n,count=0;
    void first(){
        t1=(TextView)findViewById(R.id.textViewDisplay);
        t2=(TextView)findViewById(R.id.textViewRandom);
        btn=(Button)findViewById(R.id.buttonPlay);
        image=(ImageView)findViewById(R.id.image);
        Intent r=getIntent();
        n=r.getIntExtra("number",0);
        p=new Player[n];
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        mp=MediaPlayer.create(this,R.raw.b1);
        first();
        distribute(n);
    }

    public void distribute(int n){
        d=new ArrayList<>();
        for(int i=1;i<=n*3;i++){
            d.add(i);
        }

        Collections.shuffle(d);

        int i=0,x=0;
        while(x<n*3){

            p[i]=new Player();
            p[i].i=d.get(x).toString();
            p[i].j=d.get(x+1).toString();
            p[i].k=d.get(x+2).toString();
            i++;
            x=x+3;
        }
        setView();

        Collections.shuffle(d);
        Collections.shuffle(d);
        Collections.shuffle(d);
    }
    public void setView(){
        b.delete(0,b.length());
        for(int i=0;i<n;i++){
            b.append("Player "+(i+1)+" : "+p[i]+"\n");
        }
        t1.setText(b);
    }

    public void cl2(View v){

            for(int i=0;i<n;i++){
                if(p[i].i==d.get(count).toString()){
                    p[i].i=p[i].j;
                    p[i].j=p[i].k;
                    p[i].k="";
                    t2.setText(d.get(count).toString());
                    break;
                }
                else if(p[i].j==d.get(count).toString()){
                    p[i].j=p[i].k;
                    p[i].k="";
                    t2.setText(d.get(count).toString());
                    break;
                }
                else if(p[i].k==d.get(count).toString()){
                    p[i].k="";
                    t2.setText(d.get(count).toString());
                    break;
                }
            }
            setView();
            count++;
            for(int i=0;i<n;i++){
            if(p[i].i==""&&p[i].j==""&&p[i].k==""){
                String res="Player "+(i+1)+" Wins";
                t2.setText(res);
                btn.setVisibility(Button.INVISIBLE);
                image.setBackgroundResource(R.drawable.tenor);
                mp.start();
            }
        }

    }
}

