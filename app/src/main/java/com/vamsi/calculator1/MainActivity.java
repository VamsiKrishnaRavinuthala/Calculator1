package com.vamsi.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.*;
public class MainActivity extends AppCompatActivity {

    TextView ans;
    String s="";
    int d=0;
    String w="";
    ArrayList<String> l=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button a0,a1,a2,a3,a4,a5,a6,a7,a8,a9,plus,minus,div,mul,equal,aback;
        ans=findViewById(R.id.ans);
        a1=findViewById(R.id.btn1);
        a1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="1";
                ans.setText(s);
            }
        });
        a2=findViewById(R.id.btn2);
        a2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="2";
                ans.setText(s);
            }
        });
        a3=findViewById(R.id.btn3);
        a3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="3";
                ans.setText(s);
            }
        });
        a4=findViewById(R.id.btn4);
        a4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="4";
                ans.setText(s);
            }
        });
        a5=findViewById(R.id.btn5);
        a5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="5";
                ans.setText(s);
            }
        });
        a6=findViewById(R.id.btn6);
        a6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="6";
                ans.setText(s);
            }
        });
        a7=findViewById(R.id.btn7);
        a7.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="7";
                ans.setText(s);
            }
        });

        a8=findViewById(R.id.btn8);
        a8.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="8";
                ans.setText(s);
            }
        });

        a9=findViewById(R.id.btn9);
        a9.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="9";
                ans.setText(s);
            }
        });
        a0=findViewById(R.id.btn0);
        a0.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="0";
                ans.setText(s);
            }
        });

        aback=findViewById(R.id.btnback);
        aback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (s.length()>=1) {
                    s = s.replace(s.substring(s.length() - 1), "");
                    ans.setText(s);
                }
            }
        });
        plus=findViewById(R.id.btnplus);
        plus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="+";
                ans.setText(s);
            }
        });

        minus=findViewById(R.id.btnminus);
        minus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="-";
                ans.setText(s);
            }
        });

        mul=findViewById(R.id.btnmul);
        mul.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="*";
                ans.setText(s);
            }
        });

        div=findViewById(R.id.btndiv);
        div.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                s+="/";
                ans.setText(s);
            }
        });

        equal=findViewById(R.id.btnequal);
        equal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                for(int i=0;i<s.length();i++) {
                    //isDigit is a function of Character class it checks a particular char that whether it is a digit or not
                    if (Character.isDigit(s.charAt(i)) == false) {
                        //counter digit will be incremented each time when a character will be a digit
                        l.add(w);
                        l.add(String.valueOf(s.charAt(i)));
                        w = "";
                        d++;
                    } else {
                        w += s.charAt(i);
                    }
                }
                l.add(w);
                //ans.setText(String.valueOf(d));
                //ans.setText(String.valueOf(l.size()));
                for(int i=0;i<d;i++){
                    if (l.contains(String.valueOf('*'))==true){
                        int y=l.indexOf(String.valueOf('*'));
                        int k=Integer.valueOf(l.get(y-1));
                        int q=Integer.valueOf(l.get(y+1));
                        l.remove(y-1);
                        l.remove(y-1);
                        l.remove(y-1);
                        l.add(y-1,String.valueOf(k*q));
                    }
                    else if (l.contains(String.valueOf('/'))==true){
                        int y=l.indexOf(String.valueOf('/'));
                        int k=Integer.valueOf(l.get(y-1));
                        int q=Integer.valueOf(l.get(y+1));
                        l.remove(y-1);
                        l.remove(y-1);
                        l.remove(y-1);
                        l.add(y-1,String.valueOf(k/q));
                    }
                    else if (l.contains(String.valueOf('+'))==true){
                        int y=l.indexOf(String.valueOf('+'));
                        int k=Integer.valueOf(l.get(y-1));
                        int q=Integer.valueOf(l.get(y+1));
                        l.remove(y-1);
                        l.remove(y-1);
                        l.remove(y-1);
                        l.add(y-1,String.valueOf(k+q));
                    }
                    else{
                        int y=l.indexOf(String.valueOf('-'));
                        int k=Integer.valueOf(l.get(y-1));
                        int q=Integer.valueOf(l.get(y+1));
                        l.remove(y-1);
                        l.remove(y-1);
                        l.remove(y-1);
                        l.add(y-1,String.valueOf(k-q));
                    }
                }
                StringBuffer sb = new StringBuffer();
                for (String s : l) {
                    sb.append(s);
                }
                w="";
                int wa=0;
                l.clear();
                String str = sb.toString();
                d=0;
                ans.setText(s+"="+str);
                s=str;
            }
        });
    }
}