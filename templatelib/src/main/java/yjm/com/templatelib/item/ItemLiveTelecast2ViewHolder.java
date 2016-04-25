package yjm.com.templatelib.item;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lcylib.util.GsonUtil;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.IExtraLiveTelecast;
import yjm.com.templatelib.bean.Item;


/**
 * Created by lzy on 2016/3/14.
 */
public class ItemLiveTelecast2ViewHolder extends ItemBaseViewHolder {

    public ItemLiveTelecast2ViewHolder(Context context, View convertView) {
        super(context, convertView);
    }

    @Override
    public void initialUI(Item item) throws Exception {
        SimpleDraweeView img = getView(R.id.img);
        if (item.getImgs().size() > 0) {
            Uri uri = Uri.parse(item.getImgs().get(0).getImgUrl());
            img.setImageURI(uri);
        }
        TextView desc = getView(R.id.tv_desc);
        if (item.getTitles().size() > 0)
            desc.setText(item.getTitles().get(0).getValueDesc());
        IExtraLiveTelecast iExtraLiveTelecast = GsonUtil.fromJson(item.getExtra(), IExtraLiveTelecast.class);
        if (iExtraLiveTelecast != null) {
            desc = getView(R.id.tv_desc1);
            desc.setText(iExtraLiveTelecast.getStudyCount());
            desc = getView(R.id.tv_desc2);
            desc.setText(iExtraLiveTelecast.getAnchor());
            desc = getView(R.id.tv_desc3);
            desc.setText(iExtraLiveTelecast.getDate());
        }
    }
}
