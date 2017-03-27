package com.yude.judicialauctionproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.readystatesoftware.viewbadger.BadgeView;
import com.yude.judicialauctionproject.adapter.AdapterMain;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.fragment.auctiondate_fragment.AuctionDateFragment;
import com.yude.judicialauctionproject.fragment.markfagment.Mark2Fragment;
import com.yude.judicialauctionproject.fragment.myfragment.MyFragment;
import com.yude.judicialauctionproject.fragment.noticefragment.NoticeFragment;
import com.yude.judicialauctionproject.views.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.taskLL)
    LinearLayout taskLL;
    @BindView(R.id.workLL)
    LinearLayout workLL;
    @BindView(R.id.myLL)
    LinearLayout myLL;

    @BindView(R.id.newLL)
    LinearLayout newLL;

    @BindView(R.id.number_tv)
    TextView number_tv;


    NoScrollViewPager therePager;
    BadgeView isShowUnpublished_bv;

    private List<Fragment> fragments = new ArrayList<>();
    AdapterMain adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle bundle) {


        therePager = (NoScrollViewPager) findViewById(R.id.therePager);
        fragments.add(new Mark2Fragment());
        //fragments.add(new MarkFragment());
        fragments.add(new AuctionDateFragment());
        fragments.add(new NoticeFragment());
        fragments.add(new MyFragment());
        adapter = new AdapterMain(getSupportFragmentManager(), fragments);
        therePager.setAdapter(adapter);
        therePager.setOffscreenPageLimit(3);
        defaultChecked();
    }

    @Override
    protected void initData() {

    }

    private void defaultChecked() {
        therePager.setCurrentItem(0);
        iv1.setImageResource(R.mipmap.r_biaodi);
        iv2.setImageResource(R.mipmap.h_paimaishuji);
        iv3.setImageResource(R.mipmap.h_wodi);
        tv1.setTextColor(0xff7f7f7f);
        tv2.setTextColor(0xff7f7f7f);
        tv3.setTextColor(0xff7f7f7f);
        tv4.setTextColor(0xff7f7f7f);
        iv4.setImageResource(R.mipmap.h_tongzhi);

       //  初始化提示标
        showBadgeView_ReleaseComplete(number_tv);


    }


    private void showBadgeView_ReleaseComplete(View view) {
        //http://www.th7.cn/Program/Android/201606/874990.shtml
        isShowUnpublished_bv = new BadgeView(this, view);
        //  BadgeView badgeView = new BadgeView(getContext(), view);  // 将需要设置角标的View 传递进去
        isShowUnpublished_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isShowUnpublished_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isShowUnpublished_bv.setTextSize(9);// 设置文本大小
        isShowUnpublished_bv.setText("50"); // 设置要显示的文本
        isShowUnpublished_bv.show();// 将角标显示出来

        // badgeView.toggle();//打开关闭或者角标
        // badgeView.setTextColor(Color.BLUE);//角标内文字颜色
        // badgeView.setBadgeBackgroundColor(Color.YELLOW);//角标背景颜色
        // badgeView.setTextSize(12);//角标内数字大小
        //badgeView.toggle(true);//默认动画效果

    }



    @OnClick({R.id.taskLL, R.id.workLL, R.id.myLL,R.id.newLL})
    void click(View v) {
        switch (v.getId()) {
            //标的
            case R.id.taskLL:
                therePager.setCurrentItem(0);
                iv1.setImageResource(R.mipmap.r_biaodi);
                iv2.setImageResource(R.mipmap.h_paimaishuji);
                iv3.setImageResource(R.mipmap.h_wodi);
                tv1.setTextColor(0xff7f7f7f);
                tv2.setTextColor(0xff7f7f7f);
               tv3.setTextColor(0xff7f7f7f);

                iv4.setImageResource(R.mipmap.h_tongzhi);
                tv4.setTextColor(0xff7f7f7f);

                break;
            // 拍卖数据
            case R.id.workLL:
                therePager.setCurrentItem(1);
                iv1.setImageResource(R.mipmap.h_biaodi);
                iv2.setImageResource(R.mipmap.r_paimaishuju);
                iv3.setImageResource(R.mipmap.h_wodi);
                tv1.setTextColor(0xff7f7f7f);
                tv2.setTextColor(0xff7f7f7f);
                tv3.setTextColor(0xff7f7f7f);
                iv4.setImageResource(R.mipmap.h_tongzhi);
                tv4.setTextColor(0xff7f7f7f);
                break;

            // 消息
            case  R.id.newLL :

                therePager.setCurrentItem(2);
                iv1.setImageResource(R.mipmap.h_biaodi);
                iv2.setImageResource(R.mipmap.h_paimaishuji);
                iv3.setImageResource(R.mipmap.h_wodi);
                tv1.setTextColor(0xff7f7f7f);
                tv2.setTextColor(0xff7f7f7f);
                tv3.setTextColor(0xff7f7f7f);
                iv4.setImageResource(R.mipmap.r_tongzhi);
                tv4.setTextColor(0xff7f7f7f);
            // 点击后提示消失
                isShowUnpublished_bv.setVisibility(View.GONE);
                break;



            //我的
            case R.id.myLL:
                therePager.setCurrentItem(3);
                iv1.setImageResource(R.mipmap.h_biaodi);
                iv2.setImageResource(R.mipmap.h_paimaishuji);
                iv3.setImageResource(R.mipmap.r_wode);
                tv1.setTextColor(0xff7f7f7f);
                tv2.setTextColor(0xff7f7f7f);
                tv3.setTextColor(0xff7f7f7f);
                iv4.setImageResource(R.mipmap.h_tongzhi);
                tv4.setTextColor(0xff7f7f7f);

                break;
            default:
                break;

        }
    }





}
