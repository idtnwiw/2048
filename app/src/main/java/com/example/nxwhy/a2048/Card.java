package com.example.nxwhy.a2048;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

/**
 * Created by nxwhy on 2017/10/19.
 */

public class Card extends FrameLayout {

    TextView tv;
    View view;

    public Card(@NonNull Context context,int w) {
        super(context);
        FrameLayout.LayoutParams lp =new FrameLayout.LayoutParams(w-10,w-10);
        lp.setMargins(4,4,4,4);

        view = new View(context);
        //view.setBackgroundColor(0x33ff00ff);
        addView(view,lp);

        tv = new TextView(context);
        //tv.setText(Integer.toString(0));
        tv.setTextSize(48);
        tv.setGravity(Gravity.CENTER);
        addView(tv);
    }

    int value;

    public void setNum(int num)
    {
        value = num;
        if(num>0)
        {
            tv.setText(Integer.toString(num));
            switch(num)
            {
                case 2:
                    view.setBackgroundColor(0xffeee4da);
                    tv.setTextColor(0xff000000);
                    break;
                case 4:
                    view.setBackgroundColor(0xffede0c8);
                    tv.setTextColor(0xff000000);
                    break;
                case 8:
                    view.setBackgroundColor(0xfff2b179);
                    tv.setTextColor(0xffffffff);
                    break;
                case 16:
                    view.setBackgroundColor(0xfff59563);
                    tv.setTextColor(0xffffffff);
                    break;
                case 32:
                    view.setBackgroundColor(0xfff67c5f);
                    tv.setTextColor(0xffffffff);
                    break;
                case 64:
                    view.setBackgroundColor(0xfff65e3b);
                    tv.setTextColor(0xffffffff);
                    break;
                case 128:
                    view.setBackgroundColor(0xffedcf72);
                    tv.setTextColor(0xffffffff);
                    break;
                case 256:
                    view.setBackgroundColor(0xffedcc61);
                    tv.setTextColor(0xffffffff);
                    break;
                case 512:
                    view.setBackgroundColor(0xffedc850);
                    tv.setTextColor(0xffffffff);
                    break;
                case 1024:
                    view.setBackgroundColor(0xffedc53f);
                    tv.setTextColor(0xffffffff);
                    break;
            }
        }

        else
        {
            tv.setText("");
            view.setBackgroundColor(0xffcdc1b4);
        }
    }

    public int getNum()
    {
        return value;
    }
}
