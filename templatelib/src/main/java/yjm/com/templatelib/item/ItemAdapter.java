package yjm.com.templatelib.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.lcylib.adapter.SimpleBaseAdapter;

import java.util.HashMap;
import java.util.List;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.bean.Item;

/**
 * Created by lzy on 2015/9/22.
 */
public class ItemAdapter extends SimpleBaseAdapter<Item, ItemBaseViewHolder> {

    private HashMap<String, View> views = new HashMap<>();
    //防止position=0的view因为计算高度而多次initial
    private boolean first = true;
    private int firstPosition = 0;
    private ClickListener clickListener;

    public ItemAdapter(Context context, List<Item> data, ClickListener clickListener) {
        super(context, data);
        this.clickListener = clickListener;
    }

    @Override
    public int getViewTypeCount() {
        return ItemBaseViewHolder.ITEM_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return ItemBaseViewHolder.getItemViewType(getItem(position));
    }

    @Override
    public int getItemResource(int position) {
        return ItemBaseViewHolder.getItemResID(getItemViewType(position));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ItemBaseViewHolder holder;
        Item item = getItem(position);
        View tempView = views.get(item.getStyle() + position);
        if (first)
            firstPosition = position;
        else if (firstPosition == position && convertView != null)
            return convertView;
        else convertView = tempView;
        if (null == convertView) {
            convertView = View.inflate(context, getItemResource(position), null);
            holder = ItemBaseViewHolder.create(context, convertView, getItemViewType(position));
            convertView.setTag(holder);
            if (position > 0)
            views.put(item.getStyle() + position, convertView);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item item = getItem(position);
                    String url = item.getHref();
                    clickListener.onClick(url);
                }
            });
//            Log.e("lzy", "getView: " + position);
        } else {
            holder = (ItemBaseViewHolder) convertView.getTag();
//            Log.e("lzy", "position=" + position);
        }
        first = false;
        return getItemView(position, convertView, holder);
    }

    @Override
    public View getItemView(int position, View convertView, ItemBaseViewHolder holder) {
        try {
            holder.initialUI(getItem(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }

    public static ItemAdapter createTemplateAdapter(Context context, List<Item> data, ClickListener clickListener) {
        if (data == null || data.size() == 0)
            return null;
        Item item = data.get(0);
        if (item == null)
            return null;
        return new ItemAdapter(context, data, clickListener);
    }

    @Override
    public void notifyDataSetChanged() {
        first = true;
        firstPosition = -1;
        super.notifyDataSetChanged();
    }
}
