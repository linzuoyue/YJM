package yjm.com.templatelib.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lcylib.util.DensityUtil;

import java.util.ArrayList;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.Img;
import yjm.com.templatelib.bean.Item;


/**
 * Created by lzy on 2015/12/4.
 */
public class ItemSViewHolder extends ItemBaseViewHolder {

    public ItemSViewHolder(Context context, View convertView) {
        super(context, convertView);
    }

    @Override
    public void initialUI(Item item) throws Exception {
        clearAllView();
        ArrayList<Img> imgs = item.getImgs();
        if (imgs.size() > 0) {
            Img img = imgs.get(0);
            addView(img);
        }
    }

    protected void addView(Img img) {
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(context.getResources())
                .build();
        RoundingParams roundingParams = new RoundingParams();
        int cornersRadius = DensityUtil.dip2px(context, 5);
        roundingParams.setCornersRadius(cornersRadius);
        hierarchy.setRoundingParams(roundingParams);
        hierarchy.setPlaceholderImage(R.drawable.ic_image_default);
        hierarchy.setFailureImage(context.getResources().getDrawable(R.drawable.ic_image_default), ScalingUtils.ScaleType.CENTER_CROP);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context, hierarchy);
        simpleDraweeView.setScaleType(SimpleDraweeView.ScaleType.CENTER_CROP);
        float aspectRationF = img.getAspectRation();
        if (aspectRationF == 0f)
            aspectRationF = 1.82105279f;
        else if (aspectRationF < 0f)
            aspectRationF = 1f;
        addView((ViewGroup) getView(R.id.body), simpleDraweeView, img, aspectRationF);
    }
}
