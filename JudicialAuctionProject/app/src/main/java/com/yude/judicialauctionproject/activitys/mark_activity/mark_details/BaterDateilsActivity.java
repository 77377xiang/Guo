package com.yude.judicialauctionproject.activitys.mark_activity.mark_details;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.activitys.DetailsFavoriteNewActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.activitys.DetailsMarkBriefActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.activitys.DetailsMustKnowActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.activitys.DetailsNoticeActivity;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.DirectoriesTextAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.ReleaseComplete_PagerAdapter;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.entity.Detail;
import com.yude.judicialauctionproject.entity.Record;
import com.yude.judicialauctionproject.entity.dsf.NoScrollListViewDate;
import com.yude.judicialauctionproject.utils.ImageUtil;
import com.yude.judicialauctionproject.views.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

/**
 *   进行中详情
 */
public   class BaterDateilsActivity extends BaseActivity  implements View.OnClickListener{


    TextView pager_r_text_tv,
            pager_r_time_tv,
            page_b_text_tv,
            pager_b_time_tv,
            position_tv,
            Determine_tv,
            start_money_tv,
            money_number_tv,
            people_money_tv,
            people_money_number_tv,
            in_number_tv,
            see_number_tv,
            importance_number_tv,
            start_money_two_tv,
            add_money_tv,
            guarantee_money_tv,
            type_tv,
            quick_pople_tv,
            implement_number_tv,
            corporate_name_tv,
            Division_TV;



    LinearLayout pager_r_time_ll,
            pager_b_time_ll,
            quick_ll,
            button_ll,
            w_ll,
            memo_ll;

    FrameLayout pople_number_fl;



    Button Release_btn,back_btn;

    ImageView Notice_iv,know_iv,information_iv;
    RecyclerView  auction_record_rv, auction_count_rv;

    NoScrollListView directories_nss_LL;
    List<String> directoriesText = new ArrayList<>();
    DirectoriesTextAdapter adapter;

    private ViewPager mViewPager;
    private List<ImageView> mImageViewList= new ArrayList<>();
    private int currentPosition = 1;
    private int dotPosition = 0;
    private int prePosition = 0;
    private LinearLayout mLinearLayoutDot;
    private List<String> urlList; // viewpager 数据源

    String uil1 ="http://s3.ifengimg.com/2014/09/16/7fa036d73307d21e397ed89b86975138.jpg";
    String uil2 ="http://img4.imgtn.bdimg.com/it/u=3079581662,1609145946&fm=23&gp=0.jpg";
    String uil3="http://www.wygfw.com/kindeditor/attached/image/20150316/20150316131042614261.jpg";
    String uil4 = "http://img1.emfc.net.cn/emfcimg/userfiles/image/20150310/1014564635ae2bd2d18459.jpg";
    String uil5 = "http://pic1.nipic.com/2008-09-02/200892224140147_2.jpg";


    TextView tile_tv;
    ImageView l_title_iv, r_title_iv;
    boolean isGZ;//  关注与没关注的触摸标识
    private List<Record> recordList;//具体数据
    private List<Record> recordCountList;//状态标题

    private List<ImageView> mImageViewDotList = new ArrayList<>();
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mViewPager.setCurrentItem(currentPosition, false);
            }
        }
    };


    private void setOnItemClickListenerNoScrollListView() {
        directories_nss_LL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(BaterDateilsActivity.this, DetailsNoticeActivity.class));

                        Toast.makeText(BaterDateilsActivity.this, "竞买公告", Toast.LENGTH_LONG).show();

                        break;
                    case 1:
                        startActivity(new Intent(BaterDateilsActivity.this, DetailsMustKnowActivity.class));
                        Toast.makeText(BaterDateilsActivity.this, "竞买须知", Toast.LENGTH_LONG).show();

                        break;
                    case 2:
                        startActivity(new Intent(BaterDateilsActivity.this, DetailsMarkBriefActivity.class));

                        Toast.makeText(BaterDateilsActivity.this, "竞买标的物介绍", Toast.LENGTH_LONG).show();

                        break;
                    case 3:
                        Toast.makeText(BaterDateilsActivity.this, "特殊消息", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BaterDateilsActivity.this,DetailsFavoriteNewActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }




    @Override
    public int getContentViewId() {
        return R.layout.activity_dateils;
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






    // 网络加载 图片
    private void init() {
        urlList = new ArrayList<>();
        urlList = new ArrayList<String>();
        //  mImageViewDotList = new ArrayList();
        urlList.add(uil1);
        urlList.add(uil2);
        urlList.add(uil3);
        urlList.add(uil4);
        urlList.add(uil5);
        ImageView imageView;

        for (int i = 0; i < urlList.size() + 2; i++) {
            if (i == 0) {   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                imageView = new ImageView(this);
                //imageView.setBackgroundResource(images[images.length - 1]);

                ImageUtil.setImgwithOptions(urlList.get(urlList.size() - 1), imageView);
                mImageViewList.add(imageView);
            } else if (i == urlList.size() + 1) {   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                imageView = new ImageView(this);

                ImageUtil.setImgwithOptions(urlList.get(0), imageView);
                // imageView.setBackgroundResource(images[0]);

                mImageViewList.add(imageView);
            } else {  //其他情况则为ImageView设置images[i-1]的图片作为背景
                imageView = new ImageView(this);

                // imageView.setBackgroundResource(images[i - 1]);
                ImageUtil.setImgwithOptions(urlList.get(i - 1), imageView);
                mImageViewList.add(imageView);
            }
        }


    }

    //   改写  设置轮播小圆点
    private void setDotD() {
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
        params.rightMargin = 20;
        //  for循环创建images.length个ImageView（小圆点）


        for (int i = 0; i < urlList.size(); i++) {
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


    //   改写 给view pager 设置小原点
    private void setViewPagerD() {
        ReleaseComplete_PagerAdapter adapter = new ReleaseComplete_PagerAdapter(mImageViewList, this,urlList);
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
                    currentPosition = urlList.size();
                    dotPosition = urlList.size() - 1;
                } else if (position == urlList.size() + 1) {    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
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





    private void initViewsAll() {
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        mLinearLayoutDot = (LinearLayout) findViewById(R.id.ll_main_dot);
        pager_r_time_ll = (LinearLayout) findViewById(R.id.pager_r_time_ll);
        pager_b_time_ll = (LinearLayout) findViewById(R.id.pager_b_time_ll);
        quick_ll = (LinearLayout) findViewById(R.id.quick_ll);
        pople_number_fl = (FrameLayout) findViewById(R.id.pople_number_fl);
        memo_ll = (LinearLayout) findViewById(R.id.memo_ll);
        button_ll = (LinearLayout) findViewById(R.id.button_ll);
        w_ll =(LinearLayout) findViewById(R.id.w_ll);


        pager_r_text_tv = (TextView) findViewById(R.id.pager_r_text_tv);
        pager_r_time_tv = (TextView) findViewById(R.id.pager_r_time_tv);
        page_b_text_tv = (TextView) findViewById(R.id.page_b_text_tv);
        pager_b_time_tv = (TextView) findViewById(R.id.pager_b_time_tv);
        position_tv = (TextView) findViewById(R.id.position_tv);
        Determine_tv = (TextView) findViewById(R.id.Determine_tv);
        start_money_tv = (TextView) findViewById(R.id.start_money_tv);
        money_number_tv = (TextView) findViewById(R.id.money_number_tv);
        people_money_tv = (TextView) findViewById(R.id.people_money_tv);
        people_money_number_tv = (TextView) findViewById(R.id.people_money_number_tv);
        in_number_tv = (TextView) findViewById(R.id.in_number_tv);
        see_number_tv = (TextView) findViewById(R.id.see_number_tv);
        importance_number_tv = (TextView) findViewById(R.id.importance_number_tv);
        start_money_two_tv = (TextView) findViewById(R.id.ensure_money_tv);
        add_money_tv = (TextView) findViewById(R.id.add_money_tv);
        guarantee_money_tv = (TextView) findViewById(R.id.guarantee_money_tv);
        type_tv = (TextView) findViewById(R.id.type_tv);
        quick_pople_tv = (TextView) findViewById(R.id.quick_pople_tv);
        implement_number_tv = (TextView) findViewById(R.id.implement_number_tv);
        corporate_name_tv = (TextView) findViewById(R.id.corporate_name_tv);
        pager_r_text_tv = (TextView) findViewById(R.id.pager_r_text_tv);
        Division_TV = (TextView) findViewById(R.id.Division_TV);

        Release_btn = (Button) findViewById(R.id.Release_btn);//
        back_btn = (Button) findViewById(R.id.back_btn);//

        Notice_iv = (ImageView) findViewById(R.id.Notice_iv);//
        know_iv = (ImageView) findViewById(R.id.know_iv);//
        information_iv = (ImageView) findViewById(R.id.information_iv);//

        auction_record_rv= (RecyclerView) findViewById(R.id.auction_record_rv);//状态 竞卖号 价格 时间
        auction_count_rv= (RecyclerView) findViewById(R.id.auction_count_rv);  //具体信息
        directories_nss_LL = (NoScrollListView) findViewById(R.id.directories_nss_LL);

        // pager_r_time_ll .setVisibility(View.GONE);// 隐藏右边时间
        quick_ll.setVisibility(View.VISIBLE);
        back_btn.setVisibility(View.VISIBLE);
        Division_TV.setVisibility(View.VISIBLE);
        pople_number_fl.setVisibility(View.VISIBLE);

        memo_ll.setVisibility(View.VISIBLE);
        auction_record_rv.setVisibility(View.VISIBLE);
        auction_count_rv.setVisibility(View.VISIBLE);
        people_money_tv.setVisibility(View.VISIBLE); //  显示出价人
        people_money_number_tv.setVisibility(View.VISIBLE);// 显示出价钱数
        button_ll.setVisibility(View.GONE);
        Release_btn.setText("暂缓");
        back_btn.setText("终止");

        // 获取最顶端的布局空间焦点
        w_ll.setFocusable(true);
        w_ll.setFocusableInTouchMode(true);
        w_ll.requestFocus();


        // initDirectoriesDate();
        NoScrollListViewDate scrollListViewDate = new NoScrollListViewDate();
        scrollListViewDate.initDirectoriesDate(directoriesText);
        adapter = new DirectoriesTextAdapter(directoriesText,this);
        directories_nss_LL.setAdapter(adapter);
    }

    @Override
    protected void initViews(Bundle bundle) {

        initViewsAll();
        //mViewPager = (ViewPager) findViewById(R.id.vp_main);
        //mLinearLayoutDot = (LinearLayout) findViewById(R.id.ll_main_dot);
        initTitle();
        init();
        autoPlay();
        setDotD();
        setViewPagerD();
        setRecyclerViewAdapter();
        viewClickListener();
        setOnItemClickListenerNoScrollListView();
    }

    //给所有的RecyclerView设置适配器
    private void setRecyclerViewAdapter() {
        inData();
        //
        auction_record_rv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Record>(this, recordList, R.layout.item_auction_1) {
            @Override
            public void convert(RecycleHolder holder, Record data, int position) {
                holder.setText(R.id.auction_status, data.getStatus());
                holder.setText(R.id.auction_code, data.getCode());
                holder.setText(R.id.auction_price, data.getPrice());
                holder.setText(R.id.auction_time, data.getTime());
            }
        });



        auction_count_rv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Record>(this, recordCountList, R.layout.item_auction_1) {
            @Override
            public void convert(RecycleHolder holder, Record data, int position) {
                ((TextView) holder.findView(R.id.auction_status)).setTextColor(Color.BLACK);
                holder.setText(R.id.auction_status, data.getStatus());
                holder.setText(R.id.auction_code, data.getCode());
                holder.setText(R.id.auction_price, data.getPrice());
                holder.setText(R.id.auction_time, data.getTime());
            }
        });


        /*auctionDetailRv.setAdapter(new Pull_Mark_releaseComplteRecyclerAdapter<Detail>(this, detailList, R.layout.item_auction_2) {
            @Override
            public void convert(RecycleHolder holder, Detail data, int position) {
                // holder.setImageNet(R.id.auction_2_iv,data.getImgUrl());
                holder.setText(R.id.auction_2_tv, data.getText());
            }
        });*/
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


    }


    @Override
    protected void initData() {

    }


    private  void viewClickListener(){

        l_title_iv.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        Release_btn.setOnClickListener(this);
        know_iv.setOnClickListener(this);
        Notice_iv.setOnClickListener(this);
        information_iv.setOnClickListener(this);
        r_title_iv.setOnClickListener(this);

    }

    //初始化 目录
    private void initDirectoriesDate() {
        directoriesText = new ArrayList<>();
        //directoriesText.add("竞价成功确认书");
       // directoriesText.add("余款缴付证明");
       // directoriesText.add("缴费清单");
        directoriesText.add("竞买公告");
        directoriesText.add("竞买须知");
        directoriesText.add("标的物介绍");
        directoriesText.add("特殊消息");




    }


    private void initTitle() {
        tile_tv = (TextView) findViewById(R.id.tile_tv);
        l_title_iv = (ImageView) findViewById(R.id.l_title_iv);
        r_title_iv = (ImageView) findViewById(R.id.r_title_iv);
        tile_tv.setText("国颢伺辅");
        l_title_iv.setImageResource(R.mipmap.h_fanhui);
        l_title_iv.setVisibility(View.VISIBLE);
        r_title_iv.setImageResource(R.mipmap.h_guanzhu_t);
        r_title_iv.setVisibility(View.VISIBLE);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.l_title_iv :
               finish();
            break;
            case R.id.r_title_iv :
                if (!isGZ){
                    r_title_iv.setImageResource(R.mipmap.r_gaunzhu_t);
                    isGZ=true;
                }else {
                    r_title_iv.setImageResource(R.mipmap.h_guanzhu_t);
                    isGZ=false;
                }

                break;

            case R.id.Release_btn :
                Toast.makeText(this,"终止",Toast.LENGTH_LONG).show();

                break;
            case R.id.back_btn :
                Toast.makeText(this,"暂缓",Toast.LENGTH_LONG).show();

                break;

            case R.id.Notice_iv :
                Toast.makeText(this,"竞买公告",Toast.LENGTH_LONG).show();

                break;

            case R.id.know_iv :
                Toast.makeText(this,"竞买须知",Toast.LENGTH_LONG).show();

                break;

            case R.id.information_iv :
                Toast.makeText(this,"标物介绍",Toast.LENGTH_LONG).show();

                break;


        }



    }



}
