package yjm.com.templatelib.item;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lcylib.Percent.MyPercentLinearLayoutLayoutParams;
import com.lcylib.adapter.AdapterViewHolder;
import com.zhy.android.percent.support.PercentLayoutHelper;
import com.zhy.android.percent.support.PercentLinearLayout;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.Img;
import yjm.com.templatelib.bean.Item;
import yjm.com.templatelib.bean.Title;

/**
 * Created by lzy on 2015/12/4.
 */
public abstract class ItemBaseViewHolder extends AdapterViewHolder {

    public static final int ITEM_S = 0;
    public static final int ITEM_COURSE1 = 1;
    public static final int ITEM_COURSE2 = 2;
    public static final int ITEM_SPECIAL1 = 3;
    public static final int ITEM_SPECIAL2 = 4;
    public static final int ITEM_LIVE_TELECAST = 5;
    public static final int ITEM_LIVE_TELECAST2 = 6;

    public static final int ITEM_COUNT = 7;
    protected Context context;

    public ItemBaseViewHolder(Context context, View convertView) {
        super(convertView);
        this.context = context;
    }

    public static int getItemViewType(Item item) {
        if (item.getStyle().equals(Item.COURSE1))
            return ITEM_COURSE1;
        else if (item.getStyle().equals(Item.COURSE2))
            return ITEM_COURSE2;
        else if (item.getStyle().equals(Item.SPECIAL1))
            return ITEM_SPECIAL1;
        else if (item.getStyle().equals(Item.SPECIAL2))
            return ITEM_SPECIAL2;
        else if (item.getStyle().equals(Item.LIVE_TELECAST))
            return ITEM_LIVE_TELECAST;
        else if (item.getStyle().equals(Item.LIVE_TELECAST2))
            return ITEM_LIVE_TELECAST2;
        return ITEM_S;
    }

    public static int getItemResID(int itemViewType) {
        if (itemViewType == ITEM_COURSE1)
            return R.layout.template_item_course1;
        else if (itemViewType == ITEM_COURSE2)
            return R.layout.template_item_course2;
        else if (itemViewType == ITEM_SPECIAL1)
            return R.layout.template_item_special1;
        else if (itemViewType == ITEM_SPECIAL2)
            return R.layout.template_item_special2;
        else if (itemViewType == ITEM_LIVE_TELECAST)
            return R.layout.template_item_livetelecast;
        else if (itemViewType == ITEM_LIVE_TELECAST2)
            return R.layout.template_item_livetelecast2;
        return R.layout.template_item_s;
    }

    public static ItemBaseViewHolder create(Context context, View convertView, int itemViewType) {
        if (itemViewType == ITEM_COURSE1 || itemViewType == ITEM_COURSE2)
            return new ItemCourseViewHolder(context, convertView, itemViewType);
        else if (itemViewType == ITEM_SPECIAL1)
            return new ItemSpecial1ViewHolder(context, convertView);
        else if (itemViewType == ITEM_SPECIAL2)
            return new ItemSpecial2ViewHolder(context, convertView);
        else if (itemViewType == ITEM_LIVE_TELECAST)
            return new ItemLiveTelecastViewHolder(context, convertView);
        else if (itemViewType == ITEM_LIVE_TELECAST2)
            return new ItemLiveTelecast2ViewHolder(context, convertView);
        return new ItemSViewHolder(context, convertView);
    }

    protected void clearAllView() {
        ((ViewGroup) getView(R.id.body)).removeAllViews();
    }

    /**
     * @param context
     * @param body
     * @param imageView
     * @param img
     * @param aspectRatio
     */
    protected static void addView(@NonNull Context context, @NonNull ViewGroup body, SimpleDraweeView imageView, @NonNull Img img, float aspectRatio) {
        imageView.setAspectRatio(aspectRatio);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        body.addView(imageView);
        Uri uri = Uri.parse(img.getImgUrl());
        imageView.setImageURI(uri);
    }

    protected void addView(Title title) {
        addView(context, (ViewGroup) getView(R.id.body), title);
    }

    protected static void addView(Context context, ViewGroup body, Title title) {
        TextView textView = new TextView(context);
        MyPercentLinearLayoutLayoutParams layoutParams = new MyPercentLinearLayoutLayoutParams(0, PercentLinearLayout.LayoutParams.WRAP_CONTENT);
        PercentLayoutHelper.PercentLayoutInfo percentLayoutInfo = layoutParams.getPercentLayoutInfo();
        percentLayoutInfo.widthPercent = new PercentLayoutHelper.PercentLayoutInfo.PercentVal(1, true);
        textView.setText(title.getValueDesc());
        textView.setLines(1);
        textView.setLayoutParams(layoutParams);
        body.addView(textView);
    }

    public abstract void initialUI(Item item) throws Exception;

}
