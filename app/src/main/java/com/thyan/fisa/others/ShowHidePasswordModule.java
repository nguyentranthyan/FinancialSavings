package com.thyan.fisa.others;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

import com.thyan.fisa.R;

public class ShowHidePasswordModule {

    private static final boolean[] isHide = {true};

    public static void eventShowHidePassword(final EditText editTextPassword) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(isHide[0]) {
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    editTextPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.ic_baseline_visibility_off_24, 0);
                    isHide[0] = false;
                }
                else {
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editTextPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.ic_baseline_visibility_24, 0);
                    isHide[0] = true;
                }
            }
        };
        DrawableRightModule.eventDrawableRight(editTextPassword, runnable);
    }
}
