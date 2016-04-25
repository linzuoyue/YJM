package yjm.com.templatelib.item;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lcylib.util.GsonUtil;

import yjm.com.templatelib.R;
import yjm.com.templatelib.bean.IExtraCourse;
import yjm.com.templatelib.bean.Item;


/**
 * Created by lzy on 2015/12/22.
 */
public class ItemCourseViewHolder extends ItemBaseViewHolder {

    private int viewType;

    public ItemCourseViewHolder(Context context, View convertView, int viewType) {
        super(context, convertView);
        this.viewType = viewType;
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
        TextView member = getView(R.id.tv_member);
        TextView category = getView(R.id.tv_category);
        IExtraCourse iExtraCourse = GsonUtil.fromJson(item.getExtra(), IExtraCourse.class);
        if (iExtraCourse != null) {
            member.setText("" + iExtraCourse.getStudyCount());
            category.setText(iExtraCourse.getMcp());
        }
    }
}
