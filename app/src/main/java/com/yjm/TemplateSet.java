package com.yjm;

import java.util.ArrayList;

import yjm.com.templatelib.bean.Template;

/**
 * Created by lzy on 2015/9/24.
 */
public class TemplateSet {

    private String lastVersion = "";
    private ArrayList<Template> data = new ArrayList<>();

    public String getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(String lastVersion) {
        this.lastVersion = lastVersion;
    }

    public ArrayList<Template> getData() {
        return data;
    }

    public void setData(ArrayList<Template> data) {
        this.data = data;
    }
}
