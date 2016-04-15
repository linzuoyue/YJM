package com.lcylib.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by lzy on 2016/3/22.
 */
public class FontManager {

    public static final String FONTAWESOME = "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), FONTAWESOME);
    }

}
