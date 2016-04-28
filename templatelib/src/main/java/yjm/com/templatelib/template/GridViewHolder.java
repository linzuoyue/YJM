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
import yjm.com.templatelib.bean.TExtraGrid;
import yjm.com.templatelib.bean.Template;
import yjm.com.templatelib.item.ItemAdapter;

/**
 * Created by lzy on 2015/12/3.
 */
public class GridViewHolder extends TemplateBaseViewHolder {


    public GridViewHolder(Context context, View convertView, ClickListener clickListener) {
        super(context, convertView, clickListener);
    }

    @Override
    public void initialUI(ScrollListener scrollListener, Template template) throws Exception {
        ExpandGridView gridView = getView(R.id.grid);
        gridView.setEnabled(false);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) gridView.getLayoutParams();
        TExtraGrid extraGrid = GsonUtil.fromJson(template.getExtra(), TExtraGrid.class);
        if (extraGrid != null) {
            gridView.setNumColumns(extraGrid.getCol());
            final String divider = extraGrid.getDivider();
            if (!TextUtils.isEmpty(divider)) {
                gridView.setBackgroundColor(Color.parseColor(divider));
            }
            gridView.setHorizontalSpacing(DensityUtil.dip2px(context, extraGrid.getDividerHeight()));
            gridView.setVerticalSpacing(DensityUtil.dip2px(context, extraGrid.getDividerHeight()));
            layoutParams.setMargins(DensityUtil.dip2px(context, extraGrid.getMarginLeft()), DensityUtil.dip2px(context, extraGrid.getMarginTop()), DensityUtil.dip2px(context, extraGrid.getMarginRight()), DensityUtil.dip2px(context, extraGrid.getMarginBottom()));
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
