package com.yude.judicialauctionproject.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.entity.CheckBoxData;

import java.util.List;

/**
 * Created by hexiang on 17/3/21.
 */
public class CheckboxAdapter extends CommAdapter<CheckBoxData> {
    ViewHolder holder;

    public CheckboxAdapter(List<CheckBoxData> t, Context context) {
        super(t, context, R.layout.item_list_backdateils_checkbox);

    }


    @Override
    public void convert(ViewHolder holder, CheckBoxData data, final int position) {
        this.holder = holder;
        holder.setText(R.id.text_tv, data.getTitle());
       // holder.setImg(R.id.picture_iv, data.getPicture());
        holder.setBackgroundImg(R.id.picture_iv,data.getPicture());

    }


    public View retentView() {

        View view = holder.getView(R.id.picture_iv);
        return view;
    }


}



