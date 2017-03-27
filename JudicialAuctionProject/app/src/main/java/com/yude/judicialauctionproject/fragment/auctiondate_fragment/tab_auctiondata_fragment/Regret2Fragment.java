package com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.CommAdapter;
import com.yude.judicialauctionproject.entity.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexiang on 17/3/18.
 */
public class Regret2Fragment extends AuctionDateGroupFragment  {


    @Override
    public String getZongNumber() {
        return "4500";
    }

    @Override
    public String getNoeNumber() {
        return "300";
    }

    @Override
    public String getTwoNumber() {
        return "3000";
    }

    @Override
    public String getSellNumber() {
        return "10000";
    }


    @Override
    public List<Test> getChildrenData() {
        return initChildrenData();
    }

    @Override
    public int getContetViewId() {

        return R.layout.fragment_auctiondate_regret;
    }

    @Override
    public void onDataSetChangeed(CommAdapter adapter) {

    }


    private  List<Test> initChildrenData(){

       List<Test> n_date;

        n_date = new ArrayList<>();

        Test tset1 = new Test();
        tset1.setLiv("成交率");
        tset1.setMoney("成交价格");
        tset1.setNumber("上拍件数");
        tset1.setZonge("成交件数");
        n_date.add(tset1);


        Test tset = new Test();
        tset.setLiv("20%");
        tset.setMoney("300万");
        tset.setNumber("100");
        tset.setZonge("所有");
        n_date.add(tset);


        Test tset2 = new Test();
        tset2.setLiv("20%");
        tset2.setMoney("300万");
        tset2.setNumber("100");
        tset2.setZonge("一拍");
        n_date.add(tset2);

        Test tset3 = new Test();
        tset3.setLiv("20%");
        tset3.setMoney("300万");
        tset3.setNumber("100");
        tset3.setZonge("二拍");
        n_date.add(tset3);

        Test tset4 = new Test();
        tset4.setLiv("20%");
        tset4.setMoney("300万");
        tset4.setNumber("100");
        tset4.setZonge("变卖");
        n_date.add(tset4);
        return n_date;

    }







}
