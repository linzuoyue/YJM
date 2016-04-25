package yjm.com.templatelib.bean;

/**
 * Created by lzy on 2015/9/25.
 */
public class TExtraGrid extends TBaseExtra{

    private int row;
    private int col;
    private String divider = "";
    private float dividerHeight;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public float getDividerHeight() {
        return dividerHeight;
    }

    public void setDividerHeight(float dividerHeight) {
        this.dividerHeight = dividerHeight;
    }
}
