package yjm.com.templatelib.template;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

import com.lcylib.adapter.AbstractRecyclerViewAdapter;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.R;
import yjm.com.templatelib.ScrollListener;
import yjm.com.templatelib.bean.Item;
import yjm.com.templatelib.bean.Template;


/**
 * Created by lzy on 2015/12/3.
 */
public abstract class TemplateBaseViewHolder extends AbstractRecyclerViewAdapter.ViewHolder {

    public static final int ITEM_TYPE_EMPTY = 0;
    public static final int ITEM_TYPE_BANNER = 1;
    public static final int ITEM_TYPE_GRID = 2;
    public static final int ITEM_TYPE_LABEL = 3;
    public static final int ITEM_TYPE_LIST = 4;

    private SparseArray<View> views = new SparseArray<View>();

    protected Context context;

    protected ClickListener clickListener = new ClickListener() {
        @Override
        public void onClick(String href) {

        }
    };

    public TemplateBaseViewHolder(Context context, View convertView, ClickListener clickListener) {
        super(convertView);
        this.context = context;
        this.clickListener = clickListener;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int resId) {
        View v = views.get(resId);
        if (null == v) {
            v = itemView.findViewById(resId);
            views.put(resId, v);
        }
        return (T) v;
    }

    public abstract void initialUI(ScrollListener scrollListener, Template template) throws Exception;

    public static TemplateBaseViewHolder create(Context context, View convertView, int viewType, ClickListener clickListener) {
        if (viewType == ITEM_TYPE_BANNER)
            return new BannerViewHolder(context, convertView, clickListener);
        else if (viewType == ITEM_TYPE_GRID)
            return new GridViewHolder(context, convertView, clickListener);
        else if (viewType == ITEM_TYPE_LIST)
            return new ListViewHolder(context, convertView, clickListener);
        else if (viewType == ITEM_TYPE_LABEL)
            return new LabelViewHolder(context, convertView, clickListener);
        return new TemplateBaseViewHolder(context, convertView, clickListener) {
            @Override
            public void initialUI(ScrollListener scrollListener, Template template) throws Exception {

            }
        };
    }

    public static int getTemplateResID(int viewType) {
        if (viewType == ITEM_TYPE_BANNER)
            return R.layout.template_banner;
        else if (viewType == ITEM_TYPE_GRID || viewType == ITEM_TYPE_LIST)
            return R.layout.template_grid;
        else if (viewType == ITEM_TYPE_LABEL)
            return R.layout.template_label;
        return R.layout.template_empty;
    }

    public static int getTemplateItemViewType(Template template) {
        if (template.getTemplate().equals(Template.BANNER))
            return ITEM_TYPE_BANNER;
        else if (template.getTemplate().equals(Template.GRID))
            return ITEM_TYPE_GRID;
        else if (template.getTemplate().equals(Template.VERTICAL_LIST))
            return ITEM_TYPE_LIST;
        else if (template.getTemplate().equals(Item.LABEL))
            return ITEM_TYPE_LABEL;
        return ITEM_TYPE_EMPTY;
    }

    public void onViewDetachedFromWindow() {
    }

    public void onViewAttachedToWindow() {

    }
}
