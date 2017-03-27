package com.yude.judicialauctionproject.base;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public abstract class CommAdapter<T> extends BaseAdapter {
    List<T> t;
    Context context;
    private int layoutId;

    public CommAdapter(List<T> t, Context context, int layoutId) {
        this.t = t;
        this.layoutId = layoutId;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (t.size() == 0 || t.isEmpty()) {
            return 0;
        } else {
            return t.size();
        }
    }

    @Override
    public T getItem(int position) {
        return t.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(context, convertView, position, layoutId, parent);
        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T data);

}
