package yjm.com.templatelib.template;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcylib.util.DensityUtil;
import com.lcylib.util.GsonUtil;

import java.util.ArrayList;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.R;
import yjm.com.templatelib.ScrollListener;
import yjm.com.templatelib.bean.Item;
import yjm.com.templatelib.bean.TExtraLabel;
import yjm.com.templatelib.bean.Template;
import yjm.com.templatelib.bean.Title;

/**
 * Created by lzy on 2015/12/3.
 */
public class LabelViewHolder extends TemplateBaseViewHolder {

    public LabelViewHolder(Context context, View convertView, ClickListener clickListener) {
        super(context, convertView, clickListener);
    }

    @Override
    public void initialUI(ScrollListener scrollListener, Template template) throws Exception {
        if (template.getItems().size() <= 0)
            return;
        final Item item = template.getItems().get(0);
        if (template.getType().equals(Template.TYPE_LABEL)) {
            TExtraLabel extraLabel = GsonUtil.fromJson(template.getExtra(), TExtraLabel.class);
            RelativeLayout prl = getView(R.id.item);
            if (extraLabel != null) {
                prl.setPadding(DensityUtil.dip2px(context, extraLabel.getMarginLeft()), DensityUtil.dip2px(context, extraLabel.getMarginTop()), DensityUtil.dip2px(context, extraLabel.getMarginRight()), DensityUtil.dip2px(context, extraLabel.getMarginBottom()));
            } else {
                prl.setPadding(0, 0, 0, 0);
            }
        }
        TextView title = getView(R.id.title);
        TextView assist = getView(R.id.assist);
        ArrayList<Title> titles = item.getTitles();
        switch (titles.size()) {
            case 0:
                assist.setVisibility(View.GONE);
                title.setText("");
                break;
            case 1:
                assist.setVisibility(View.GONE);
                title.setText(titles.get(0).getValueDesc());
                break;
            default:
                assist.setVisibility(View.VISIBLE);
                title.setText(titles.get(0).getValueDesc());
                assist.setText(titles.get(1).getValueDesc());
                assist.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = item.getHref();
                        clickListener.onClick(url);
                    }
                });
                break;
        }
    }
}
