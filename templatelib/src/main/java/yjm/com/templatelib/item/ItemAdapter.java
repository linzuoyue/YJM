package yjm.com.templatelib.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.lcylib.adapter.SimpleBaseAdapter;

import java.util.HashMap;
import java.util.List;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.bean.Item;

/**
 * Created by lzy on 2015/9/22.
 */
public class ItemAdapter extends SimpleBaseAdapter<Item, ItemBaseViewHolder> implements AdapterView.OnItemClickListener {

    protected int itemResource;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBaseViewHolder holder;
        Item item = getItem(position);
        convertView = views.get(item.getStyle() + position);
        if (first) {
            firstPosition = position;
        } else {
            if (firstPosition == position && convertView != null)
                return convertView;
        }
//        Log.e("lzy", "position=" + position);
        if (null == convertView) {
            convertView = View.inflate(context, getItemResource(position), null);
            holder = ItemBaseViewHolder.create(context, convertView, getItemViewType(position));
            convertView.setTag(holder);
            views.put(item.getStyle() + position, convertView);
//            Log.e("lzy", "getView: " + position);
        } else {
            holder = (ItemBaseViewHolder) convertView.getTag();
        }
        if (first)
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = getItem(position);
        String url = item.getHref();
        clickListener.onClick(url);
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
        super.notifyDataSetChanged();
    }
}
