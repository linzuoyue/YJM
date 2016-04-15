package com.lcylib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by lzy on 2015/12/21.
 */
public class AutoXSpaceTextView extends TextView {

    private TextPaint paint;
    private String content;
    private float textHeight;
    private float yPadding;
    private float[][] position;
    private float baseLine;
    private float width;

    public AutoXSpaceTextView(Context context) {
        super(context);
        init();
    }

    public AutoXSpaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoXSpaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.density = getResources().getDisplayMetrics().density;
        paint.setColor(getCurrentTextColor());
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(getTextSize());
//        textHeight = (int) (Math.ceil(fm.descent - fm.top) + 2);// 获得字体高度
        width = getWidth();
    }

    public void setMyText(final String content) {
        if (width == 0) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    setText(content);
                    getViewTreeObserver().removeOnPreDrawListener(this);
                    return false;
                }
            });
        }
    }

    private void setText(String content) {
        if (content != null) {
            float textWidth = paint.measureText(content);
            width = this.getWidth();
            Paint.FontMetrics fm = paint.getFontMetrics();// 得到系统默认字体属性
            baseLine = getHeight() / 2 - (fm.bottom + fm.top) / 2;
        }
        paint.setTextSize(getTextSize());
        getPositions(content);
    }

    public void getPositions(String content) {
        this.content = content;
        char ch;
        //输入点的 x的坐标
        float x = 0;
        float strWidth = 0;
        int count = content.length();
        //初始化字体位置数组
        position = new float[count][2];
        for (int i = 0; i < count; i++) {
            ch = content.charAt(i);
            String str = String.valueOf(ch);

            //根据画笔获得每一个字符的显示的rect 就是包围框（获得字符宽度）
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, 1, rect);
            strWidth += rect.width();

        }
        float totalSpaceWidth = width - strWidth;
        int spaceCount = count - 1;
        spaceCount = spaceCount > 0 ? spaceCount : 1;
        float xPadding = totalSpaceWidth / spaceCount;
        for (int i = 0; i < count; ++i) {
            ch = content.charAt(i);
            String str = String.valueOf(ch);

            //根据画笔获得每一个字符的显示的rect 就是包围框（获得字符宽度）
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, 1, rect);

            //记录每一个字的位置
//            x = x + rect.width() >= width ? width - rect.width() : x;
            position[i][0] = x - rect.left;
            position[i][1] = baseLine;
            x += rect.width() + xPadding;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(content)) {
            for (int i = 0; i < content.length(); i++) {
                canvas.drawText(String.valueOf(content.charAt(i)), position[i][0],
                        position[i][1], paint);
            }
        }
    }
}
