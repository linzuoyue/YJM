package com.lcylib.Percent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.zhy.android.percent.support.PercentLayoutHelper;
import com.zhy.android.percent.support.PercentLinearLayout;

/**
 * Created by lzy on 2015/12/7.
 */
public class MyPercentLinearLayoutLayoutParams extends PercentLinearLayout.LayoutParams {

    private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;

    public MyPercentLinearLayoutLayoutParams(Context c, AttributeSet attrs) {
        super(c, attrs);
        this.mPercentLayoutInfo = PercentLayoutHelper.getPercentLayoutInfo(c, attrs);
    }

    public MyPercentLinearLayoutLayoutParams(int width, int height) {
        super(width, height);
        mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
    }

    public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo() {
        return this.mPercentLayoutInfo;
    }

    public MyPercentLinearLayoutLayoutParams(ViewGroup.LayoutParams source) {
        super(source);
        mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
    }

    public MyPercentLinearLayoutLayoutParams(ViewGroup.MarginLayoutParams source) {
        super(source);
        mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
    }
}
