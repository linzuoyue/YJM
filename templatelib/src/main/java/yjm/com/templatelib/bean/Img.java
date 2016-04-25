package yjm.com.templatelib.bean;

/**
 * Created by lzy on 2015/9/23.
 */
public class Img {

    private String imgUrl = "";
//    private String marginTop;
//    private String marginBottom;
//    private String marginLeft;
//    private String marginRight;
//    private String borderColor;
//    private String widthPercent;
    private String href = "";
    private float aspectRation;

    public float getAspectRation() {
        return aspectRation;
    }

    public void setAspectRation(float aspectRation) {
        this.aspectRation = aspectRation;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
