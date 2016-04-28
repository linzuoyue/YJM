package yjm.com.templatelib.template;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.lcylib.util.DensityUtil;
import com.lcylib.util.GsonUtil;
import com.lcylib.widget.ExpandGridView;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.R;
import yjm.com.templatelib.ScrollListener;
import yjm.com.templatelib.bean.TExtraList;
import yjm.com.templatelib.bean.Template;
import yjm.com.templatelib.item.ItemAdapter;


/**
 * Created by Administrator on 2016/4/12.
 */
public class ListViewHolder extends TemplateBaseViewHolder {

    public ListViewHolder(Context context, View convertView, ClickListener clickListener) {
        super(context, convertView, clickListener);
    }

    @Override
    public void initialUI(ScrollListener scrollListener, Template template) throws Exception {
        ExpandGridView gridView = getView(R.id.grid);
        gridView.setEnabled(false);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) gridView.getLayoutParams();
        TExtraList extraList = GsonUtil.fromJson(template.getExtra(), TExtraList.class);
        if (extraList != null) {
            final String divider = extraList.getDivider();
            if (!TextUtils.isEmpty(divider)) {
                gridView.setBackgroundColor(Color.parseColor(divider));
            }
            gridView.setNumColumns(1);
            gridView.setHorizontalSpacing(0);
            gridView.setVerticalSpacing(DensityUtil.dip2px(context, extraList.getDividerHeight()));
            layoutParams.setMargins(DensityUtil.dip2px(context, extraList.getMarginLeft()), DensityUtil.dip2px(context, extraList.getMarginTop()), DensityUtil.dip2px(context, extraList.getMarginRight()), DensityUtil.dip2px(context, extraList.getMarginBottom()));
        } else {
            gridView.setBackgroundColor(context.getResources().getColor(R.color.transparent));
            gridView.setNumColumns(1);
            gridView.setHorizontalSpacing(0);
            gridView.setVerticalSpacing(0);
        }
        ItemAdapter templateAdapter = (ItemAdapter) gridView.getAdapter();
        if (templateAdapter == null)
            templateAdapter = ItemAdapter.createTemplateAdapter(context, template.getItems(), clickListener);
        else
            templateAdapter.replaceAll(template.getItems());
        gridView.setAdapter(templateAdapter);
    }
}
