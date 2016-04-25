package yjm.com.templatelib.item;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.Item;
import yjm.com.templatelib.bean.Title;

/**
 * Created by lzy on 2015/12/23.
 */
public class ItemSpecial1ViewHolder extends ItemBaseViewHolder {


    public ItemSpecial1ViewHolder(Context context, View convertView) {
        super(context, convertView);
    }

    @Override
    public void initialUI(Item item) throws Exception{
        SimpleDraweeView img = getView(R.id.img);
        if (item.getImgs().size() > 0) {
            Uri uri = Uri.parse(item.getImgs().get(0).getImgUrl());
            img.setImageURI(uri);
        }
        TextView desc = getView(R.id.desc);
        final ArrayList<Title> titles = item.getTitles();
        if (titles.size() > 0) {
            String valueDesc = titles.get(0).getValueDesc();
            desc.setText(valueDesc);
        }
    }
}
