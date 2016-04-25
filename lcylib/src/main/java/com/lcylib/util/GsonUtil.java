package com.lcylib.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonUtil {
    private static Gson mGson = new Gson();

    public static <T>T fromJson(String json, Type type){
        try {
            return mGson.fromJson(json, type);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object object) {
        return mGson.toJson(object);
    }
}
