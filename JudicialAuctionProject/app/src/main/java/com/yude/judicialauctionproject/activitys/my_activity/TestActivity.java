package com.yude.judicialauctionproject.activitys.my_activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.entity.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexiang on 17/3/14.
 */
public class TestActivity extends BaseActivity{

    private List<Record> recordList;//具体数据
    private List<Record> recordCountList;//状态标题
    RecyclerView  auction_record_rv, auction_count_rv;
    LinearLayout memo_ll;
    @Override
    public int getContentViewId() {
        return R.layout.include_memo;
    }

    @Override
    protected void initViews(Bundle bundle) {
        auction_record_rv= (RecyclerView) findViewById(R.id.auction_record_rv);//状态 竞卖号 价格 时间
        auction_count_rv= (RecyclerView) findViewById(R.id.auction_count_rv);  //具体信息
        memo_ll = (LinearLayout) findViewById(R.id.memo_ll);
        memo_ll.setVisibility(View.VISIBLE);
        inData();
        setRecyclerViewAdapter();

    }

    @Override
    protected void initData() {

    }

    private void inData() {
        recordList = new ArrayList<>();
        Record record1;
        for (int i = 0; i < 2; i++) {
            record1 = new Record();
            record1.setStatus("领先");
            record1.setCode("A1534");
            record1.setPrice(i + ",200,3000");
            record1.setTime("2017/3/8/ 10:38");
            recordList.add(record1);
        }

        /*recordCountList = new ArrayList<>();
        Record record2;
        for (int i = 0; i < 2; i++) {
            record2 = new Record();
            record2.setStatus("一拍");
            record2.setCode("流拍");
            record2.setPrice(i + ",200,3000");
            record2.setTime("2017/3/8/ 10:38");
            recordCountList.add(record2);
        }*/

    }

    //给所有的RecyclerView设置适配器
    private void setRecyclerViewAdapter() {

        auction_record_rv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Record>(this, recordList, R.layout.item_auction_1) {
            @Override
            public void convert(RecycleHolder holder, Record data, int position) {
                holder.setText(R.id.auction_status, data.getStatus());
                holder.setText(R.id.auction_code, data.getCode());
                holder.setText(R.id.auction_price, data.getPrice());
                holder.setText(R.id.auction_time, data.getTime());
            }
        });


       /* auction_count_rv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Record>(this, recordCountList, R.layout.item_auction_1) {
            @Override
            public void convert(RecycleHolder holder, Record data, int position) {
                ((TextView) holder.findView(R.id.auction_status)).setTextColor(Color.BLACK);
                holder.setText(R.id.auction_status, data.getStatus());
                holder.setText(R.id.auction_code, data.getCode());
                holder.setText(R.id.auction_price, data.getPrice());
                holder.setText(R.id.auction_time, data.getTime());
            }
        });*/

    }


}
