package com.yude.judicialauctionproject.fragment.markfagment.moreFragment;

import android.os.Bundle;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.entity.Attention;
import com.yude.judicialauctionproject.fragment.markfagment.GroupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 撤回
 */
public class WithdrawFragment extends GroupFragment {


    List<Attention> attentionList;
    private String img ="http://pic41.nipic.com/20140518/18472880_102522365000_2.jpg";

    @Override
    public int type() {
        return 1;
    }

    @Override
    public List<Attention> initListData() {
        initData_rv();
        return attentionList;
    }

    @Override
    public int itemId() {
        return R.layout.item_groupfragment_nobackground;
    }

    @Override
    public List<Attention> onRefreshDate() {
        // List<Attention> attentionListRefresh = new ArrayList<>();
        attentionList.clear();
        Attention attention;
        for (int i = 0; i < 2; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("城西银泰" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积5" + i + "0平方");
            attention.setTime("开拍时间:2017年5月1日" + i + ":30");
            attentionList.add(attention);
        }


        return attentionList;
    }

    @Override
    public List<Attention> onLoadMoreDate() {

        // List<Attention> attentionListMore = new ArrayList<>();
        Attention attention;
        for (int i = 0; i < 1; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("滨江花园" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setTime("一拍中 加载数据");
            attentionList.add(attention);

        }

        return attentionList;
    }



    //初始化数据
    private void initData_rv() {
        // attentionList =  initListData();

        attentionList = new ArrayList<>();
        Attention attention;
        for (int i = 0; i < 10; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("未来科技成" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setTime("2017年7月3日  12:30");
            attentionList.add(attention);
        }


    }


}
