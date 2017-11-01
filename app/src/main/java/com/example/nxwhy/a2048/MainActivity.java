package com.example.nxwhy.a2048;

import android.graphics.Point;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler h = new Handler();
        h.postDelayed(r,500);
    }
        Runnable r = new Runnable() {
            @Override
            public void run() {
            myfun();
            }
        };

        float sx,sy;
        void myfun()
    {
        ConstraintLayout myview = (ConstraintLayout) findViewById(R.id.myview);

        LinearLayout li =new LinearLayout(getApplicationContext());
        ViewGroup.LayoutParams params =new LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT);
        li.setOrientation(LinearLayout.VERTICAL);
        //addContentView(li,params);
        myview.addView(li,params);

        myview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float ex,ey;
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        sx=event.getX();
                        sy=event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        ex=event.getX()-sx;
                        ey=event.getY()-sy;
                        if(Math.abs(ex)>Math.abs(ey))
                        {
                            if(ex>0)
                                mright();
                            else
                                mleft();

                        }
                        else
                        {
                            if(ey<0)
                                mup();
                            else
                                mdown();

                        }
                        break;
                }
                return true;
            }
        });

        int w = myview.getWidth();
        int n=4;
        int nwidth = w/n;
        for(int j=0;j<n;j++)
        {
            LinearLayout row =new LinearLayout(getApplicationContext());

            row.setOrientation(LinearLayout.HORIZONTAL);

            for(int i=0;i<n;i++) {
                Card fl = new Card(getApplicationContext(),nwidth);
                Cards[j][i]=fl;
                fl.setNum(0);
                //fl.setNum(j*n+i);
                row.addView(fl);
            }
            li.addView(row);
        }

        //Card obj = new Card(getApplicationContext());
        initGame();
        addNum();
        addNum();

        addNum();
        addNum();

    }

    void mright(){
        boolean merge = false;
        for(int j=0;j<nrows;j++) {
            for (int i = nrows - 1; i >= 0; i--) {
                OUT:
                for (int ni = i - 1; ni >= 0; ni--) {
                    int curri = Cards[j][i].getNum();
                    int checki = Cards[j][ni].getNum();
                    if (checki > 0) {
                        if (curri == 0) {
                            Cards[j][i].setNum(checki);
                            Cards[j][ni].setNum(0);
                            merge = true;
                            i++;
                            break;
                        } else if (checki == curri) {
                            Cards[j][i].setNum(checki * 2);
                            Cards[j][ni].setNum(0);
                            merge = true;
                        }
                    }
                }
            }
        }
        //if(merge)
            addNum();
        Toast.makeText(this, "right", Toast.LENGTH_SHORT).show();
    }
    void mleft(){
        boolean merge = false;
        for(int j=0;j<nrows;j++) {
            for (int i = 0; i < nrows; i++) {
                OUT:
                for (int ni = i + 1; ni < nrows; ni++) {
                    int curri = Cards[j][i].getNum();
                    int checki = Cards[j][ni].getNum();
                    if (checki > 0) {
                        if (curri == 0) {
                            Cards[j][i].setNum(checki);
                            Cards[j][ni].setNum(0);
                            merge = true;
                            i--;
                            break;
                        } else if (checki == curri) {
                            Cards[j][i].setNum(checki * 2);
                            Cards[j][ni].setNum(0);
                            merge = true;
                        }
                    }
                }
            }
        }
        //if(merge)
            addNum();
        Toast.makeText(this, "left", Toast.LENGTH_SHORT).show();

    }
    void mup(){

        boolean merge = false;
        for(int i=nrows-1;i>=0;i--) {
            for (int j = 0; j < nrows; j++) {
                OUT:
                for (int nj = j + 1; nj < nrows; nj++) {
                    int curri = Cards[j][i].getNum();
                    int checki = Cards[nj][i].getNum();
                    if (checki > 0) {
                        if (curri == 0) {
                            Cards[j][i].setNum(checki);
                            Cards[nj][i].setNum(0);
                            merge = true;
                            j--;
                            break;
                        } else if (checki == curri) {
                            Cards[j][i].setNum(checki * 2);
                            Cards[nj][i].setNum(0);
                            merge = true;
                        }
                    }
                }
            }
        }
        //if(merge)
            addNum();
        Toast.makeText(this, "up", Toast.LENGTH_SHORT).show();

    }
    void mdown(){

        boolean merge = false;
        for(int i=nrows-1;i>=0;i--) {
            for (int j = nrows - 1; j >= 0; j--) {
                OUT:
                for (int nj = j - 1; nj >= 0; nj--) {
                    int curri = Cards[j][i].getNum();
                    int checki = Cards[nj][i].getNum();
                    if (checki > 0) {
                        if (curri == 0) {
                            Cards[j][i].setNum(checki);
                            Cards[nj][i].setNum(0);
                            merge = true;
                            j++;
                            break;
                        } else if (checki == curri) {
                            Cards[j][i].setNum(checki * 2);
                            Cards[nj][i].setNum(0);
                            merge = true;
                        }
                    }
                }
            }
        }
        //if(merge)
            addNum();
        Toast.makeText(this, "down", Toast.LENGTH_SHORT).show();

    }



    int nrows=4;
    Card[][] Cards =new Card[nrows][nrows];

    ArrayList<Point> emptyList = new ArrayList<Point>();

    void initGame()
    {
        for(int j=0;j<nrows;j++)
            for (int i=0;i<nrows;i++)
            {
                emptyList.add(new Point(i,j));
            }

    }

    void addNum()
    {
        if(emptyList.size()>0)
        {
            boolean right=true;
            while(right){
                int r=(int)(Math.random()*emptyList.size());
                Point p =emptyList.remove(r);
                if(Cards[p.x][p.y].getNum()>0)
                {
                    right=true;
                }
                else
                {
                    Cards[p.x][p.y].setNum(2);
                    right=false;
                }
            }

        }

    }

}
