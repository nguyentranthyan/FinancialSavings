package com.thyan.fisa.Checkinform;

import android.text.TextUtils;
import android.util.Patterns;

public class CheckRegexModule {

    private static final String REGEX_PASSWORD = "[a-zA-Z0-9]{6,50}";

    public static boolean isEmail(String str) {
        return (!TextUtils.isEmpty(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches());
    }

    public static boolean isPassword(String str) {
        return str.matches(REGEX_PASSWORD);
    }

    public static boolean isName(String str) {
        return str.length() > 1;
    }
}
