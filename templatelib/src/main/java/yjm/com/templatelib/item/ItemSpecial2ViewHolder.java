package yjm.com.templatelib.item;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lcylib.widget.AutoXSpaceTextView;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.Item;

/**
 * Created by lzy on 2015/12/23.
 */
public class ItemSpecial2ViewHolder extends ItemBaseViewHolder {

    public ItemSpecial2ViewHolder(Context context, View convertView) {
        super(context, convertView);
    }

    @Override
    public void initialUI(Item item) throws Exception {
        SimpleDraweeView img = getView(R.id.img);
        if (item.getImgs().size() > 0) {
            Uri uri = Uri.parse(item.getImgs().get(0).getImgUrl());
            img.setImageURI(uri);
        }
        TextView desc = getView(R.id.desc1);
        if (item.getTitles().size() > 0)
            desc.setText(item.getTitles().get(0).getValueDesc());
        AutoXSpaceTextView autoXSpaceTextView = getView(R.id.desc2);
        if (item.getTitles().size() > 1)
            autoXSpaceTextView.setMyText(item.getTitles().get(1).getValueDesc());
        autoXSpaceTextView = getView(R.id.desc3);
        if (item.getTitles().size() > 2)
            autoXSpaceTextView.setMyText(item.getTitles().get(2).getValueDesc());
    }
}
