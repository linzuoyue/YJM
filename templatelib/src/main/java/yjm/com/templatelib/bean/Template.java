package yjm.com.templatelib.bean;

import java.util.ArrayList;

/**
 * Created by lzy on 2015/9/24.
 */
public class Template {

    public static final int TEMPLATE_COUNT = 5;
    //template
    public static final String BANNER = "banner";
    public static final String GRID = "grid";
    public static final String VERTICAL_LIST = "vertical_list";
//    public static final String HORIZONTAL_LIST = "horizontal_list";
    public static final String COMBINED = "combined";
    public static final String LABEL = "label";

    //type
    public static final String TYPE_GRID = "grid";
    public static final String TYPE_BANNER = "banner";
    public static final String TYPE_LIST = "list";
    public static final String TYPE_LABEL = "label";

    private String template = "";
    private String version = "";
    private String type = "";
    private String href = "";
    private String id = "";
    private String name = "";
    private String extra = "";
    private ArrayList<Template> subTemplates = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Template> getSubTemplates() {
        return subTemplates;
    }

    public void setSubTemplates(ArrayList<Template> subTemplates) {
        this.subTemplates = subTemplates;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
