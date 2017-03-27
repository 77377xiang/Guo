package com.yude.judicialauctionproject.activitys.my_activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.activitys.mark_activity.ReleaseCompleteActivity;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.entity.Attention;

import java.util.ArrayList;
import java.util.List;


/**
 * 特别关注
 */
public class ConcernActivity extends BaseActivity {

    ImageView l_title_iv, r_title_iv;
    TextView tile_tv;
    boolean isLoading;
    PullLoadMoreRecyclerView pullLoadMoreRecyclerView;

    private Pull_Mark_releaseComplteRecyclerAdapter<Attention> pull_Mark_releaseComplteRecyclerAdapter;
    private List<Attention> attentionList;
    private Handler handler = new Handler();

    private String img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489119016935&di=e562bb3b7bdf57de43494c3ced7c3542&imgtype=0&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2Fda017cffgx6BpgriqtA72%26690";

    @Override
    public int getContentViewId() {
        return R.layout.activity_my_concern;
    }


    private void initTitle() {
        tile_tv = (TextView) findViewById(R.id.tile_tv);
        l_title_iv = (ImageView) findViewById(R.id.l_title_iv);
        r_title_iv = (ImageView) findViewById(R.id.r_title_iv);
        tile_tv.setText("特别关注");
        l_title_iv.setImageResource(R.mipmap.h_fanhui);
        l_title_iv.setVisibility(View.VISIBLE);
        r_title_iv.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {

    }


    private void initData_rv() {
        attentionList = new ArrayList<>();
        Attention attention;
        for (int i = 0; i < 10; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("西溪北苑" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setTime("2017年5月3日  17:30");
            attentionList.add(attention);

        }


    }


    @Override
    protected void initViews(Bundle bundle) {
        // mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recycler_rv);
        pullLoadMoreRecyclerView.setLinearLayout();
        initTitle();
        initData_rv();

        pull_Mark_releaseComplteRecyclerAdapter = new Pull_Mark_releaseComplteRecyclerAdapter<Attention>(this, attentionList, R.layout.item_pull_mark_rv_relesecompiete) {
            @Override
            public void convert(RecycleHolder holder, Attention data, int position) {

                holder.setImg(R.id.attention_iv, data.getImgUrl());
                holder.setText(R.id.attention_title, data.getTitle());
                holder.setText(R.id.attention_location, data.getLocaiton());
                holder.setText(R.id.attention_eara, data.getEara());
                holder.setText(R.id.attention_time, data.getTime());

            }
        };


        pullLoadMoreRecyclerView.setAdapter(pull_Mark_releaseComplteRecyclerAdapter);
        pullLoadMoreRecyclerView.setFooterViewText("正在加载……");

        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        attentionList.clear();
                        Attention attention;
                        for (int i = 0; i < 3; i++) {
                            attention = new Attention();
                            attention.setImgUrl(img);
                            attention.setTitle("城西银泰" + i + "号楼");
                            attention.setLocaiton("浙江杭州市");
                            attention.setEara("面积5" + i + "0平方");
                            attention.setTime("开拍时间:2017年5月1日" + i + ":30");
                            attentionList.add(attention);
                        }

                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                    }

                }, 3000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Attention attention;
                        for (int i = 0; i < 2; i++) {
                            attention = new Attention();
                            attention.setImgUrl(img);
                            attention.setTitle("滨江花园" + i + "号楼");
                            attention.setLocaiton("浙江杭州市");
                            attention.setEara("面积1" + i + "0平方");
                            attention.setTime("一拍中 加载数据");
                            attentionList.add(attention);
                        }
                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();

                    }
                }, 3000);


            }
        });


        //添加点击事件
        pull_Mark_releaseComplteRecyclerAdapter.setOnItemClickListener(new Pull_Mark_releaseComplteRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View view, int position) {

                Intent intent = new Intent(ConcernActivity.this, ReleaseCompleteActivity.class);
                startActivity(intent);
            }
        });

    }


}

