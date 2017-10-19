package com.example.nxwhy.a2048;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout li =new LinearLayout(getApplicationContext());
        ViewGroup.LayoutParams params =new LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT);
        li.setOrientation(LinearLayout.VERTICAL);
        addContentView(li,params);
        for(int i=0;i<4;i++)
        {
            LinearLayout row =new LinearLayout(getApplicationContext());
            
            row.setOrientation(LinearLayout.HORIZONTAL);

            for(int j=0;j<4;j++) {
                FrameLayout fl = new FrameLayout(getApplicationContext());
                FrameLayout.LayoutParams lp =new FrameLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT);
                lp.setMargins(10,10,10,10);

                TextView tv = new TextView(getApplicationContext());
                tv.setText(Integer.toString(i*4+j));
                tv.setTextSize(28);
                tv.setGravity(Gravity.CENTER);
                fl.addView(tv);
                row.addView(fl,lp);
            }
            li.addView(row);
        }

        Card obj = new Card(getApplicationContext());


    }
}
