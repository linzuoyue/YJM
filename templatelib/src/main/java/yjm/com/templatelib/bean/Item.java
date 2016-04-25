package yjm.com.templatelib.bean;

import java.util.ArrayList;

/**
 * Created by lzy on 2015/9/22.
 */
public class Item {

    //style
    public static final String IMAGE = "image";
    public static final String TEXT = "text";
    public static final String LABEL = "label";
    public static final String COURSE1 = "course1";
    public static final String COURSE2 = "course2";
    public static final String SPECIAL1 = "special1";
    public static final String SPECIAL2 = "special2";
    public static final String LIVE_TELECAST = "live_telecast";
    public static final String LIVE_TELECAST2 = "live_telecast2";

    //type
    public static final String CLASS = "class";

    private String style = "";
    private String version = "";
    private String type = "";
    private ArrayList<Title> titles = new ArrayList<>();
    private ArrayList<Img> imgs = new ArrayList<>();

    private String href = "";
    private String id = "";
    private String extra = "";
    private String background = "";

    public ArrayList<Img> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<Img> imgs) {
        this.imgs = imgs;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Title> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<Title> titles) {
        this.titles = titles;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
