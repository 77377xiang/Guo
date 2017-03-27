package com.yude.judicialauctionproject.activitys.mark_activity.mark_details;

import android.view.View;

import com.yude.judicialauctionproject.entity.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexiang on 17/3/23.
 */
public class TestDateilsActivity extends DateilsGroupActivity {
    @Override
    public void ShowViews() {

        pager_r_time_ll.setVisibility(View.GONE);// 隐藏右边时间
        quick_ll.setVisibility(View.GONE);
        back_btn.setVisibility(View.VISIBLE);//
        Division_TV.setVisibility(View.VISIBLE);//
        pople_number_fl.setVisibility(View.VISIBLE);//

        memo_ll.setVisibility(View.VISIBLE);//
        auction_record_rv.setVisibility(View.VISIBLE);//
        auction_count_rv.setVisibility(View.VISIBLE);//
        sell_ll.setVisibility(View.VISIBLE);//
        ok_play_money_ll.setVisibility(View.VISIBLE);//
        no_play_money_ll.setVisibility(View.VISIBLE);//
        book_ll.setVisibility(View.GONE);// 拍卖确认书
        button_ll.setVisibility(View.GONE);//
        people_money_tv.setVisibility(View.VISIBLE);//
        people_money_number_tv.setVisibility(View.VISIBLE);//
        pager_r_time_ll.setVisibility(View.GONE);// pager 右上 时间
        pager_r_succer_ll.setVisibility(View.VISIBLE); // pager 右上 已结束
        pager_b_number.setVisibility(View.VISIBLE);// pager 右下角 延时
        Release_btn.setText("展缓"); //按键
        back_btn.setText("终止");// 按键

    }

    @Override
    public List<String> getDirectoriesDate() {

        List<String> directoriesText = new ArrayList<>();
        directoriesText = new ArrayList<>();
        directoriesText.add("竞价成功确认书");
        directoriesText.add("余款缴付证明");
        directoriesText.add("缴付清单");
        directoriesText.add("竞买公告");
        directoriesText.add("竞买须知");
        directoriesText.add("标的物介绍");
        directoriesText.add("特殊消息");
        return directoriesText;
    }



    @Override
    public List<String> getPagerDate() {



        List<String> urlList; // viewpager 数据源
        urlList = new ArrayList<String>();
        //  mImageViewDotList = new ArrayList();
        urlList.add(uil1);
        urlList.add(uil2);
        urlList.add(uil3);
        urlList.add(uil4);
        urlList.add(uil5);

        return urlList;
    }

    @Override
    public List<Record> getRecordList() {
        List<Record> recordList;//具体数据
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

        return recordList;
    }

    @Override
    public List<Record> getState() {
        List<Record> recordCountList;//状态标题
        recordCountList = new ArrayList<>();
        Record record2;
        for (int i = 0; i < 2; i++) {
            record2 = new Record();
            record2.setStatus("一拍");
            record2.setCode("流拍");
            record2.setPrice(i + ",200,3000");
            record2.setTime("2017/3/8/ 10:38");
            recordCountList.add(record2);
        }

        return recordCountList;
    }


}
