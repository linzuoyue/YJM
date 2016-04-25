package com.lcylib.Percent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.zhy.android.percent.support.PercentLayoutHelper;
import com.zhy.android.percent.support.PercentRelativeLayout;

/**
 * Created by lzy on 2015/12/25.
 */
public class MyPercentRelativeLayoutParams extends PercentRelativeLayout.LayoutParams{

    private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;

    public MyPercentRelativeLayoutParams(Context c, AttributeSet attrs) {
        super(c, attrs);
        this.mPercentLayoutInfo = PercentLayoutHelper.getPercentLayoutInfo(c, attrs);
    }

    public MyPercentRelativeLayoutParams(int width, int height) {
        super(width, height);
        mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
    }

    public MyPercentRelativeLayoutParams(ViewGroup.LayoutParams source) {
        super(source);
        mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
    }

    public MyPercentRelativeLayoutParams(ViewGroup.MarginLayoutParams source) {
        super(source);
        mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
    }


    public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo() {
        return this.mPercentLayoutInfo;
    }
}
