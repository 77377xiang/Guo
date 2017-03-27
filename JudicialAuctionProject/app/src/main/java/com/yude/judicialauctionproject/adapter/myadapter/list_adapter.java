package com.yude.judicialauctionproject.adapter.myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.entity.Test;

import java.util.List;

/**
 * Created by hexiang on 17/3/4.
 */
public class list_adapter   extends BaseAdapter{

private Context context;
    private List<Test> date;

    public list_adapter(Context context, List<Test> date) {
        this.context = context;
        this.date = date;
    }

    @Override
    public int getCount() {
        return date.size();
    }

    @Override
    public Object getItem(int position) {
        return date.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.test, null);
            holder = new ViewHolder();
            holder.textView=(TextView)convertView.findViewById(R.id.test);

            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        String ss=date.get(position).getName();

        holder.textView.setText(ss);

        return convertView;

    }


    //创建子对象的类
    public class ViewHolder {
        TextView textView;

    }



}
