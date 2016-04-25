package yjm.com.templatelib.bean;

/**
 * Created by lzy on 2016/3/14.
 */
public class IExtraLiveTelecast {

    private String anchor;
    private String date;
    private int status;
    private String studyCount;
    private String contentId;

    public String getStudyCount() {
        return studyCount;
    }

    public void setStudyCount(String studyCount) {
        this.studyCount = studyCount;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
