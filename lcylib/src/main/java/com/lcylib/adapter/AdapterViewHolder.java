package com.lcylib.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by lzy on 2015/12/7.
 */
public class AdapterViewHolder {

    private SparseArray<View> views = new SparseArray<View>();
    private View convertView;

    public AdapterViewHolder(View convertView) {
        setConvertView(convertView);
    }

    public void setConvertView(View convertView) {
        this.convertView = convertView;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int resId) {
        View v = views.get(resId);
        if (null == v) {
            v = convertView.findViewById(resId);
            views.put(resId, v);
        }
        return (T) v;
    }


}
