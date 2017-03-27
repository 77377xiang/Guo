package com.yude.judicialauctionproject.fragment.markfagment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.xiang.wechat.listviewpull.PullToRefreshListView;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.activitys.mark_activity.FallbackActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.ReleaseCompleteActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.UnpublishedActivity;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_ReleasEcompleteAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_unpublishedAdapter;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.entity.Attention;
import com.yude.judicialauctionproject.entity.Test;
import com.yude.judicialauctionproject.entity.response.MarkResponse;
import com.yude.judicialauctionproject.utils.LineDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 通过
 */
public class Unpublished_Fragment extends MarkGroupFragment {


    // @BindView(R.id.attention_rv)
    // XRecyclerView attentionRv;
    private Pull_Mark_releaseComplteRecyclerAdapter<Attention> pull_Mark_releaseComplteRecyclerAdapter;
    private List<Attention> attentionList;
    private String img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489082859155&di=610057dd27265c46b106b96cba2b354f&imgtype=0&src=http%3A%2F%2Fs10.sinaimg.cn%2Fmiddle%2Fa25b5c7ag78fe212f98e9%26690";

    @Override
    public int type() {
        return 2;
    }

    @Override
    public List<MarkResponse> initListData() {

        List<MarkResponse>  markResponseList=new ArrayList<>();
        List<Attention> list=  initData_rv();
        for (int i = 0; i < list.size(); i++) {
            markResponseList.add(list.get(i));
        }
        //list.add(markResponseList.get(0));
        //markResponseList.add(list.get(0));
        return markResponseList;

    }

    @Override
    public List<MarkResponse> onRefreshDate() {
        return null;
    }

    @Override
    public List<MarkResponse> onLoadMoreDate() {
        return null;
    }

    @Override
    public int rightTextColor() {
        return getContext().getResources().getColor(R.color._ffffff);
    }

    @Override
    public int rightTextBackground() {
        return getContext().getResources().getColor(R.color._ff5267_bg);
    }


    //初始化数据
    private List<Attention> initData_rv() {
        List<Attention> attentionList = new ArrayList<>();


        Attention attention0;
        attention0 = new Attention();
        attention0.setImgUrl(img);
        attention0.setTitle("城西银泰" + 1 + "号楼");
        attention0.setLocaiton("浙江杭州市");
        attention0.setEara("面积1" + 1 + "0平方");
        attention0.setLastTime("2017年3月 17:45");
        attention0.setTime("2017年6月3日  8:30");
        attention0.setDelayTime("延时 04:30");
        attention0.setSellState("一拍");
        attention0.setBackReason("证件不齐全");
        attention0.setDistanceStart(Attention.Distance.Start1);
        attentionList.add(attention0);


        Attention attention;
        attention = new Attention();
        attention.setImgUrl(img);
        attention.setTitle("城西银泰" + 2 + "号楼");
        attention.setLocaiton("浙江杭州市");
        attention.setEara("面积1" + 2 + "0平方");
        attention.setLastTime("2017年3月 17:45");
        attention.setTime("2017年6月3日  8:30");
        attention.setDelayTime("延时 04:30");
        attention.setSellState("二拍");
        attention.setBackReason("房产有纠纷");
        attention.setDistanceStart(Attention.Distance.DistanceGg2);
        attentionList.add(attention);




        Attention attention1;
        attention1 = new Attention();
        attention1.setImgUrl(img);
        attention1.setTitle("城西银泰" + 4 + "号楼");
        attention1.setLocaiton("浙江杭州市");
        attention1.setEara("面积1" + 4 + "0平方");
        attention1.setLastTime("2017年3月 17:45");
        attention1.setTime("2017年6月3日  8:30");
        attention1.setDelayTime("延时 04:30");
        attention1.setSellState("变拍");
        attention1.setBackReason("厂房不明确");
        attention.setDistanceStart(Attention.Distance.DistanceGg2);
        attentionList.add(attention1);



        Attention attention3;
        attention3 = new Attention();
        attention3.setImgUrl(img);
        attention3.setTitle("城西银泰" + 3 + "号楼");
        attention3.setLocaiton("浙江杭州市");
        attention3.setEara("面积1" + 3 + "0平方");
        attention3.setLastTime("2017年3月 17:45");
        attention3.setTime("2017年6月3日  8:30");
        attention3.setDelayTime("延时 04:30");
        attention3.setSellState("一拍");
        attention1.setBackReason("厂房已塌陷");
        attention3.setDistanceStart(Attention.Distance.No3);
        attentionList.add(attention3);

        return attentionList;
    }






/*

    @Override
    public int getContentViewId() {
        return R.layout.fragment_mark_unpublished;
    }

    @Override
    protected void initViews(Bundle bundle) {
        initData_rv();

        attentionRv.setLayoutManager(new LinearLayoutManager(getContext()));

        //这句就是添加我们自定义的分隔线
        if (!(attentionList.size() == 0)) {
            attentionRv.addItemDecoration(new LineDecoration(getContext(), LineDecoration.VERTICAL_LIST));
        }

        attentionRv.setAdapter(pull_Mark_releaseComplteRecyclerAdapter = new Pull_Mark_releaseComplteRecyclerAdapter<Attention>(getContext(), attentionList, R.layout.item_pull_mark_rv_unpublisheed) {
            @Override
            public void convert(RecycleHolder holder, Attention data, int position) {
                holder.setText(R.id.time_tv,data.getLastTime());
                holder.setImg(R.id.attention_iv, data.getImgUrl());
                holder.setText(R.id.attention_title, data.getTitle());
                holder.setText(R.id.attention_location, data.getLocaiton());
                holder.setText(R.id.attention_eara, data.getEara());
                holder.setText(R.id.attention_time, data.getTime());

            }
        });


        pull_Mark_releaseComplteRecyclerAdapter.setOnItemClickListener(new Pull_Mark_releaseComplteRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View view, int position) {

                Intent intent = new Intent(getContext(),ReleaseCompleteActivity.class);
                startActivity(intent);

            }
        });



        //上下拉
        attentionRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            //下拉
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        attentionList.clear();
//                        for (int i = 0; i < 15; i++) {
//                            listData.add("item" + i + "after " + refreshTime + " times of refresh");
//                        }
                        Attention attention;
                        for (int i = 0; i < 3; i++) {
                            attention = new Attention();
                            attention.setImgUrl(img);
                            attention.setTitle("西溪北苑" + i + "号楼");
                            attention.setLocaiton("浙江杭州市");
                            attention.setEara("面积1" + i + "0平方");
                            attention.setLastTime("距离开始10天4小时");
                            */
/*if (i % 3 == 0) {
                                attention.setTime("一拍中");
                            } else {
                                attention.setTime("开拍时间:2017年3月7日" + i + ":30");
                            }*//*


                            attention.setTime("开拍时间:2017年3月7日" + i + ":30");
                            attentionList.add(attention);
                        }

                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        attentionRv.refreshComplete();
                    }

                }, 3000);            //refresh data here
            }

            //上拉
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
//                        for (int i = 0; i < 15; i++) {
//                            listData.add("item" + (i + listData.size()));
//                        }
                        Attention attention;
                        for (int i = 0; i < 2; i++) {
                            attention = new Attention();
                            attention.setImgUrl(img);
                            attention.setTitle("西溪北苑" + i + "号楼");
                            attention.setLocaiton("浙江杭州市");
                            attention.setEara("面积1" + i + "0平方");
                            attention.setLastTime("距离开始0天4小时");
                            */
/*if (i % 3 == 0) {
                                attention.setTime("一拍中");
                            } else {
                                attention.setTime("开拍时间:2017年3月7日" + i + ":30");
                            }*//*

                            attention.setTime("一拍中 加载数据");
                            attentionList.add(attention);
                        }
                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        attentionRv.loadMoreComplete();
                    }
                }, 3000);


            }

        });

       */
/* initData();
        pull_Mark_unpublishedAdapter = new Pull_Mark_unpublishedAdapter(date,getContext());
        unpublished_list.setAdapter(pull_Mark_unpublishedAdapter);

        unpublished_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getContext(),UnpublishedActivity.class);
                startActivity(intent);

            }
        });*//*


    }

*/


   /* //初始化数据
    private List<Attention> initData_rv() {
        attentionList = new ArrayList<>();
        Attention attention;
        for (int i = 0; i < 3; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("城西银泰" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setLastTime("距离开始30天7小时");
            attention.setDelayTime("距离开始 4时20分");
            attention.setBackground_greed(0);
           *//* if (i % 3 == 0) {
                attention.setTime("一拍中");
            } else {
                attention.setTime("开拍时间:2017年3月7日" + i + ":30");
            }*//*
            attention.setTime("2017年6月3日  8:30");
            attentionList.add(attention);
        }
        return attentionList;

    }


    @Override
    public int type() {
        return 2;
    }

    @Override
    public List<Attention> initListData() {
        return initData_rv();
    }

    @Override
    public int itemId() {
        return R.layout.item_groupfragment_background;
    }

    @Override
    public List<Attention> onRefreshDate() {
        attentionList.clear();
        Attention attention;
        for (int i = 0; i < 3; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("西溪北苑" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setLastTime("距离开始10天4小时");
            attention.setTime("开拍时间:2017年3月7日" + i + ":30");
            attention.setBackground_greed(0);
            attentionList.add(attention);

        }

        return attentionList;
    }

    @Override
    public List<Attention> onLoadMoreDate() {

        Attention attention;
        for (int i = 0; i < 2; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("西溪北苑" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setLastTime("距离开始0天4小时");
            attention.setTime("一拍中 加载数据");
            attention.setBackground_greed(0);
            attentionList.add(attention);

        }
        return attentionList;

    }*/



}