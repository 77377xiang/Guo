package com.yude.judicialauctionproject.activitys.mark_activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.ReleaseComplete_PagerAdapter;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.entity.Detail;
import com.yude.judicialauctionproject.entity.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * 详情 原始
 */
public class ReleaseCompleteActivity extends BaseActivity {

    private ViewPager mViewPager;
    private List<ImageView> mImageViewList;
    private int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5};
    private int currentPosition = 1;
    private int dotPosition = 0;
    private int prePosition = 0;
    private LinearLayout mLinearLayoutDot;
    private TextView title_tv, right_tv;
    private ImageView left_iv;

    private RecyclerView auctionRecordRv, auctionCountRv, auctionDetailRv;
    private List<Record> recordList;
    private List<Record> recordCountList;
    private List<Detail> detailList;
    private List<String> uil = new ArrayList<>();

    private List<ImageView> mImageViewDotList;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mViewPager.setCurrentItem(currentPosition, false);
            }
        }
    };


    private void initTitle() {
        title_tv.setText("国颢伺辅");
        left_iv.setImageResource(R.mipmap.h_back);
        left_iv.setVisibility(View.VISIBLE);
        left_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    @Override
    public int getContentViewId() {
        return R.layout.activity_mark_release2;
    }

    @Override
    protected void initViews(Bundle bundle) {
        title_tv = (TextView) findViewById(R.id.tile_tv);
        left_iv = (ImageView) findViewById(R.id.l_title_iv);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        mLinearLayoutDot = (LinearLayout) findViewById(R.id.ll_main_dot);

        auctionRecordRv = (RecyclerView) findViewById(R.id.auction_record_rv);
        auctionCountRv = (RecyclerView) findViewById(R.id.auction_count_rv);
        auctionDetailRv = (RecyclerView) findViewById(R.id.auction_detail_rv);

        auctionRecordRv.setLayoutManager(new LinearLayoutManager(this));
        auctionCountRv.setLayoutManager(new LinearLayoutManager(this));
        auctionDetailRv.setLayoutManager(new LinearLayoutManager(this));
        initTitle();
        inData();
        initDataPager();
        setRecyclerViewAdapter();
        setDot();
        setViewPager();
        autoPlay();


    }

    @Override
    protected void initData() {
    }

    private void initDataPager() {
        mImageViewList = new ArrayList<>();
        mImageViewDotList = new ArrayList();
        ImageView imageView;
        for (int i = 0; i < images.length + 2; i++) {
            if (i == 0) {   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                imageView = new ImageView(this);
                imageView.setBackgroundResource(images[images.length - 1]);
                mImageViewList.add(imageView);
            } else if (i == images.length + 1) {   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                imageView = new ImageView(this);
                imageView.setBackgroundResource(images[0]);
                mImageViewList.add(imageView);
            } else {  //其他情况则为ImageView设置images[i-1]的图片作为背景
                imageView = new ImageView(this);
                imageView.setBackgroundResource(images[i - 1]);
                mImageViewList.add(imageView);
            }
        }
    }

    //给所有的RecyclerView设置适配器
    private void setRecyclerViewAdapter() {
        auctionRecordRv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Record>(this, recordList, R.layout.item_auction_1) {
            @Override
            public void convert(RecycleHolder holder, Record data, int position) {
                holder.setText(R.id.auction_status, data.getStatus());
                holder.setText(R.id.auction_code, data.getCode());
                holder.setText(R.id.auction_price, data.getPrice());
                holder.setText(R.id.auction_time, data.getTime());
            }
        });

        auctionCountRv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Record>(this, recordCountList, R.layout.item_auction_1) {
            @Override
            public void convert(RecycleHolder holder, Record data, int position) {
                ((TextView) holder.findView(R.id.auction_status)).setTextColor(Color.BLACK);
                holder.setText(R.id.auction_status, data.getStatus());
                holder.setText(R.id.auction_code, data.getCode());
                holder.setText(R.id.auction_price, data.getPrice());
                holder.setText(R.id.auction_time, data.getTime());
            }
        });


        auctionDetailRv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Detail>(this, detailList, R.layout.item_auction_2) {
            @Override
            public void convert(RecycleHolder holder, Detail data, int position) {
                // holder.setImageNet(R.id.auction_2_iv,data.getImgUrl());
                holder.setText(R.id.auction_2_tv, data.getText());
            }
        });
    }

    //  设置轮播小圆点
    private void setDot() {
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
        params.rightMargin = 20;
        //  for循环创建images.length个ImageView（小圆点）
        for (int i = 0; i < images.length; i++) {
            ImageView imageViewDot = new ImageView(this);
            imageViewDot.setLayoutParams(params);
            //  设置小圆点的背景为暗红图片
            imageViewDot.setBackgroundResource(R.drawable.red_dot_night);
            mLinearLayoutDot.addView(imageViewDot);
            mImageViewDotList.add(imageViewDot);
        }
        //设置第一个小圆点图片背景为红色
        mImageViewDotList.get(dotPosition).setBackgroundResource(R.drawable.red_dot);
    }

    // 设置ViewPager 以及小远点
    private void setViewPager() {
        ReleaseComplete_PagerAdapter adapter = new ReleaseComplete_PagerAdapter(mImageViewList, this ,uil);

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(currentPosition);
        //页面改变监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition = images.length;
                    dotPosition = images.length - 1;
                } else if (position == images.length + 1) {    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition = 1;
                    dotPosition = 0;
                } else {
                    currentPosition = position;
                    dotPosition = position - 1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList.get(prePosition).setBackgroundResource(R.drawable.red_dot_night);
                mImageViewDotList.get(dotPosition).setBackgroundResource(R.drawable.red_dot);
                prePosition = dotPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //当state为SCROLL_STATE_IDLE即没有滑动的状态时切换页面
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mViewPager.setCurrentItem(currentPosition, false);
                }
            }
        });
    }

    //  设置自动播放
    private void autoPlay() {
        new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {
                    SystemClock.sleep(3000);
                    currentPosition++;
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
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

        detailList = new ArrayList<>();
        Detail detail;
        for (int i = 0; i < 3; i++) {
            detail = new Detail();
            detail.setImgUrl("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=c253602d791ed21b66c929e59d6cddae/b151f8198618367a9f738e022a738bd4b21ce573.jpg");
            detail.setText("这是一份2017年1，2月份发布的25个最佳安卓库的列表，你应该会喜欢，虽然是按顺序排列的，但排名不分先后。让我们开始吧！");
            detailList.add(detail);
        }


    }


}
