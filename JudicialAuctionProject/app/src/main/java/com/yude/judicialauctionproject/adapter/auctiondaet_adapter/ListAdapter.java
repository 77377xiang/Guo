package com.yude.judicialauctionproject.adapter.auctiondaet_adapter;

import android.content.Context;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.CommAdapter;
import com.yude.judicialauctionproject.adapter.ViewHolder;
import com.yude.judicialauctionproject.entity.Test;

import java.util.List;

/**
 * Created by hexiang on 17/3/15.
 */
public class ListAdapter extends CommAdapter<Test> {


    public ListAdapter(List<Test> t, Context context) {
        super(t, context, R.layout.item_listview_number);
    }


    @Override
    public void convert(ViewHolder holder, Test data ,int position) {

        holder.setText(R.id.t_sun_tv,data.getZonge());
        holder.setText(R.id.t_fix_tv,data.getNumber());
        holder.setText(R.id.t_money_tv,data.getMoney());
        holder.setText(R.id.t_proportion_tv,data.getLiv());



    }



}
