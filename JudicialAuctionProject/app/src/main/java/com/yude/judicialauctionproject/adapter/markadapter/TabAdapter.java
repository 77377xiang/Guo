package com.yude.judicialauctionproject.adapter.markadapter;

import android.content.Context;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.ListCommAdapter;
import com.yude.judicialauctionproject.base.ViewHolder;
import com.yude.judicialauctionproject.entity.TabDate;
import com.yude.judicialauctionproject.entity.Test;

import java.util.List;

/**
 * Created by hexiang on 17/3/7.
 */
public class TabAdapter extends ListCommAdapter<TabDate> {//User为数据源对象，
    public TabAdapter(List<TabDate> t, Context context) {
        super(t, context, R.layout.item_tab);//布局为要引入的item 的布局
    }

//    @Override
//    public void convert(ViewHolder holder, User user) {
//        //holder.setText(R.id.text, user.getPhoto());//数据源的get 方法，必须初始化
//        //holder.setImg(R.id.image,user.getUri() );
//
//    }


    @Override
    public void convert(ViewHolder holder, TabDate data) {
        holder.setText(R.id.tv1,data.getText());
        holder.setImage(R.id.iv1,data.getImage());

    }


}

