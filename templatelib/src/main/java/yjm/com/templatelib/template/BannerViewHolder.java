package yjm.com.templatelib.template;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bigkoo.convenientbanner.view.CBLoopViewPager;
import com.lcylib.Percent.MyPercentLinearLayoutLayoutParams;
import com.lcylib.Percent.MyPercentRelativeLayoutParams;
import com.lcylib.util.DensityUtil;
import com.lcylib.util.GsonUtil;
import com.zhy.android.percent.support.PercentLayoutHelper;

import java.util.ArrayList;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.R;
import yjm.com.templatelib.ScrollListener;
import yjm.com.templatelib.bean.Item;
import yjm.com.templatelib.bean.TExtraBanner;
import yjm.com.templatelib.bean.Template;
import yjm.com.templatelib.item.BannerHolderView;

/**
 * Created by lzy on 2015/12/3.
 */
public class BannerViewHolder extends TemplateBaseViewHolder {

    private ConvenientBanner convenientBanner;
    private float aspectRation = 0.3f;

    public BannerViewHolder(Context context, View convertView, ClickListener clickListener) {
        super(context, convertView, clickListener);
    }

    @Override
    public void initialUI(final ScrollListener scrollListener, Template template) throws Exception {
        convenientBanner = getView(R.id.convenientBanner);
        MyPercentRelativeLayoutParams myPercentRelativeLayoutParams = new MyPercentRelativeLayoutParams(0, 0);
        PercentLayoutHelper.PercentLayoutInfo percentLayoutInfo = myPercentRelativeLayoutParams.getPercentLayoutInfo();
        if (template.getType().equals(Template.TYPE_BANNER)) {
            TExtraBanner extraBanner = GsonUtil.fromJson(template.getExtra(), TExtraBanner.class);
            if (extraBanner != null) {
                myPercentRelativeLayoutParams.setMargins(DensityUtil.dip2px(context, extraBanner.getMarginLeft()), DensityUtil.dip2px(context, extraBanner.getMarginTop()), DensityUtil.dip2px(context, extraBanner.getMarginRight()), DensityUtil.dip2px(context, extraBanner.getMarginBottom()));
                aspectRation = extraBanner.getAspectRation();
                percentLayoutInfo.heightPercent = new PercentLayoutHelper.PercentLayoutInfo.PercentVal(1 / aspectRation, true);
            } else
                percentLayoutInfo.heightPercent = new PercentLayoutHelper.PercentLayoutInfo.PercentVal(aspectRation, true);
        } else {
            percentLayoutInfo.heightPercent = new PercentLayoutHelper.PercentLayoutInfo.PercentVal(aspectRation, true);
        }
        myPercentRelativeLayoutParams.width = MyPercentLinearLayoutLayoutParams.MATCH_PARENT;
        myPercentRelativeLayoutParams.height = 0;
        convenientBanner.setLayoutParams(myPercentRelativeLayoutParams);
        CBLoopViewPager viewPager = convenientBanner.getViewPager();
        viewPager.clearOnPageChangeListeners();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (scrollListener == null)
                    return;
                if (state == ViewPager.SCROLL_STATE_IDLE || state == ViewPager.SCROLL_STATE_SETTLING)
                    scrollListener.onChildScrollEnd();
                else
                    scrollListener.onChildScrolling();
            }
        });
        final ArrayList<Item> items = template.getItems();
        convenientBanner.setPages(new CBViewHolderCreator<BannerHolderView>() {
                @Override
                public BannerHolderView createHolder() {
                    return new BannerHolderView(this, items, aspectRation);
                }
            }, items).setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                final String href = items.get(i).getHref();
                clickListener.onClick(href);
            }
        });
        if (items.size() > 1) {
            convenientBanner.setCanLoop(true);
            convenientBanner.setPageIndicator(new int[]{R.drawable.banner_point_nor, R.drawable.banner_point_hover}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        } else {
            convenientBanner.setCanLoop(false);
            convenientBanner.setPageIndicator(new int[]{R.drawable.transparent, R.drawable.transparent}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        }
    }

    @Override
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        if (convenientBanner != null)
            convenientBanner.stopTurning();
    }

    @Override
    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        if (convenientBanner != null) {
            convenientBanner.stopTurning();
            convenientBanner.startTurning(5000);
        }
    }
}
