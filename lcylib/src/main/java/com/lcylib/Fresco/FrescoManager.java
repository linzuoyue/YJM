package com.lcylib.Fresco;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lzy on 2016/4/15.
 */
public class FrescoManager {
    
    public static void initialize(Context context) {
        Fresco.initialize(context);
    }

}
