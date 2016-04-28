package yjm.com.templatelib.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.adapter.CBPageAdapter;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.Img;
import yjm.com.templatelib.bean.Item;

/**
 * Created by lzy on 2015/9/28.
 */
public class BannerHolderView extends CBPageAdapter<Item> implements Holder<Item> {
    private View view;
    private ViewGroup body;
    private float aspectRation;

    public BannerHolderView(CBViewHolderCreator holderCreator, List<Item> datas, float aspectRation) {
        super(holderCreator, datas);
        this.aspectRation = aspectRation;
    }

    @Override
    public View createView(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.template_item_s, null);
        body = (ViewGroup) view.findViewById(R.id.body);
        return view;
    }

    @Override
    public void UpdateUI(final Context context, int i, final Item item) {
        try {
            body.removeAllViews();
            final ArrayList<Img> imgs = item.getImgs();
            if (imgs.size() > 0) {
                Img img = imgs.get(0);
                GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(context.getResources())
                        .build();
                hierarchy.setPlaceholderImage(R.drawable.transparent);
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context, hierarchy);
                ItemBaseViewHolder.addView(body, simpleDraweeView, img, aspectRation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
