package com.example.nxwhy.a2048;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by nxwhy on 2017/10/19.
 */

public class Card extends FrameLayout {

    public Card(@NonNull Context context) {
        super(context);
        TextView tv = new TextView(context);
    }
}
