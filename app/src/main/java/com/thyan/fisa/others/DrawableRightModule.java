package com.thyan.fisa.others;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class DrawableRightModule {

    @SuppressLint("ClickableViewAccessibility")
    public static void eventDrawableRight(final EditText editText, final Runnable runnable) {
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (editText.getRight() -
                            editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        runnable.run();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
