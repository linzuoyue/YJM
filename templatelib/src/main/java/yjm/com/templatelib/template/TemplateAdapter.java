package yjm.com.templatelib.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcylib.adapter.AbstractRecyclerViewAdapter;

import java.util.ArrayList;

import yjm.com.templatelib.ClickListener;
import yjm.com.templatelib.ScrollListener;
import yjm.com.templatelib.bean.Template;

/**
 * Created by lzy on 2015/12/2.
 */
public class TemplateAdapter extends AbstractRecyclerViewAdapter<Template, TemplateBaseViewHolder> {

    private ScrollListener scrollListener;
    private ClickListener clickListener;

    public TemplateAdapter(Context context, ClickListener clickListener, ScrollListener scrollListener) {
        super(context);
        this.clickListener = clickListener;
        this.scrollListener = scrollListener;
    }

    public TemplateAdapter(Context context, ClickListener clickListener) {
        super(context);
        this.clickListener = clickListener;
    }

    @Override
    public void onViewAttachedToWindow(TemplateBaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.onViewAttachedToWindow();
    }


    @Override
    public void onViewDetachedFromWindow(TemplateBaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.onViewDetachedFromWindow();
    }

    @Override
    public void onViewRecycled(TemplateBaseViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(TemplateBaseViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    public void setData(ArrayList<Template> items) {
        ArrayList<Template> templates = new ArrayList<>();
        if (items == null)
            return;
        for (int i = 0; i < items.size(); i++) {
            final Template template = items.get(i);
            if (template.getTemplate().equals(Template.COMBINED)) {
                templates.addAll(template.getSubTemplates());
            } else {
                templates.add(template);
            }
        }
        super.setData(templates);
    }

    public void addData(ArrayList<Template> items) {
        ArrayList<Template> templates = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            final Template template = items.get(i);
            if (template.getTemplate().equals(Template.COMBINED))
                templates.addAll(template.getSubTemplates());
            else templates.add(template);
        }
        super.addData(templates);
    }

    public void insert(int position, Template item) {
        if (item.getTemplate().equals(Template.COMBINED)) {
            super.insert(position, item.getSubTemplates());
        } else super.insert(position, item);
    }

    public void insert(int position, ArrayList<Template> items) {

    }

    @Override
    public int getItemViewType(int position) {
        return TemplateBaseViewHolder.getTemplateItemViewType(getItem(position));
    }

    @Override
    public TemplateBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(TemplateBaseViewHolder.getTemplateResID(viewType), null);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return TemplateBaseViewHolder.create(context, view, viewType, clickListener);
    }

    @Override
    public void onBindViewHolder(TemplateBaseViewHolder holder, int position) {
        try {
            holder.initialUI(scrollListener, getItem(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}