package com.yjm.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yjm.util.FontManager;

/**
 * Created by lzy on 2015/8/13.
 */
public class FontAwsomeTextView extends TextView {

    private static Typeface font;

    public FontAwsomeTextView(Context context) {
        super(context);
        init();
    }

    public FontAwsomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontAwsomeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (font == null)
            font = FontManager.getTypeface(getContext());
        setTypeface(font);
    }

}
