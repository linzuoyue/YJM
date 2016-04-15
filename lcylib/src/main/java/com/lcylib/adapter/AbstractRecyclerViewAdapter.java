package com.lcylib.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lzy on 2015/8/3.
 */
public abstract class AbstractRecyclerViewAdapter<T extends Object, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private ArrayList<T> items = new ArrayList<T>();
    protected Context context;

    protected AbstractRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public T getItem(int position) {
        return items.get(position);
    }

    public void setData(ArrayList<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addData(ArrayList<T> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void insert(int position, T item) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void insert(int position, ArrayList<T> items) {
        this.items.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    public void remove(int position) {
        T remove = items.remove(position);
        if (remove != null) {
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount() - position + 1);
        }
    }

    public void remove(T item) {
        for (int i = 0; i < items.size(); i++) {
            T temp = items.get(i);
            if (temp.equals(item)) {
                remove(i);
                i--;
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> views = new SparseArray<View>();

        public ViewHolder(View convertView) {
            super(convertView);
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
    }

}