package com.yude.judicialauctionproject.entity.dsf;

import com.yude.judicialauctionproject.adapter.markadapter.DirectoriesTextAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexiang on 17/3/16.
 */
public class NoScrollListViewDate {

    //初始化 目录
    public void initDirectoriesDate(List<String> directoriesText) {
       // directoriesText = new ArrayList<>();
        //directoriesText.add("竞价成功确认书");
        // directoriesText.add("余款缴付证明");
        // directoriesText.add("缴费清单");
        directoriesText.add("竞买公告");
        directoriesText.add("竞买须知");
        directoriesText.add("标的物介绍");
        directoriesText.add("特殊消息");

      //  adapter = new DirectoriesTextAdapter(directoriesText,this);
       // directories_nss_LL.setAdapter(adapter);


    }
}
