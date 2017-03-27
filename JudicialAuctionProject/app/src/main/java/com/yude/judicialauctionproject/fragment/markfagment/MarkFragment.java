package com.yude.judicialauctionproject.fragment.markfagment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.viewbadger.BadgeView;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.markadapter.Pager_MarkAdapter;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.views.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
/*
* 标的
*
*     tab  待审核有问题
*     点击更多应该隐藏 第一排tab ,显示第二排
*
*
* */


public class MarkFragment extends BaseFragment {

    @BindView(R.id.commissionLL)//待审核
            LinearLayout commissionLL;
    @BindView(R.id.alreadyLL)//已审核
            LinearLayout alreadyLL;
    @BindView(R.id.allLL)//已回退
            LinearLayout allLL;
    @BindView(R.id.morell)//更多
            LinearLayout morell;

    //需要隐藏的


    @BindView(R.id.withdrawLL)//撤回
            LinearLayout withdrawLL;
    @BindView(R.id.putoffLL)//展缓
            LinearLayout putoffLL;
    @BindView(R.id.stopLL)//终止
            LinearLayout stopLL;
    @BindView(R.id.driftll)// 聊流
            LinearLayout driftll;

    @BindView(R.id.dealwithLL)//成交
            LinearLayout dealwithLL;
    @BindView(R.id.repentLL)// 悔拍
            LinearLayout repentLL;
    @BindView(R.id.propertyLL)//财产接交
            LinearLayout propertyLL;

    @BindView(R.id.frist_ll) // 需要先初始化多布局
            LinearLayout frist_ll;

    @BindView(R.id.gone_ll)  //  初始化需要隐藏多布局
            LinearLayout gone_ll;


    // tab  字体
    @BindView(R.id.commissionTV)// 已发布
            TextView commissionTV;
    @BindView(R.id.alreadyTV)// 未发布
            TextView alreadyTV;
    @BindView(R.id.allTV)// 返回
            TextView allTV;
    @BindView(R.id.moreTV)//更多
            TextView moreTV;

    @BindView(R.id.withdrawTV)//
            TextView withdrawTV;
    @BindView(R.id.putoffTV)//
            TextView putoffTV;
    @BindView(R.id.stopTV)//
            TextView stopTV;
    @BindView(R.id.driftTV)//
            TextView driftTV;

    @BindView(R.id.dealwithTV)//
            TextView dealwithTV;
    @BindView(R.id.repentTV)//
            TextView repentTV;
    @BindView(R.id.propertyTV)//
            TextView propertyTV;
    @BindView(R.id.more_TV)//
            TextView more_TV;
    //tab 图片
    @BindView(R.id.commissionIV)
    ImageView commissionIV;
    @BindView(R.id.alreadyIV)
    ImageView alreadyIV;
    @BindView(R.id.allIV)
    ImageView allIV;
    @BindView(R.id.moreIV)
    ImageView moreIV;

    @BindView(R.id.withdrawIV)
    ImageView withdrawIV;
    @BindView(R.id.putoffIV)
    ImageView putoffIV;
    @BindView(R.id.stopIV)
    ImageView stopIV;
    @BindView(R.id.driftIV)
    ImageView driftIV;

    @BindView(R.id.dealwithIV)
    ImageView dealwithIV;
    @BindView(R.id.repentIV)
    ImageView repentIV;
    @BindView(R.id.propertyIV)
    ImageView propertyIV;
    @BindView(R.id.more_IV)
    ImageView more_IV;

//  tab 线

    @BindView(R.id.commissionTwoTV)
    TextView commissionTwoTV;
    @BindView(R.id.alreadyTwoTV)
    TextView alreadyTwoTV;
    @BindView(R.id.allTwoTV)
    TextView allTwoTV;
    @BindView(R.id.moreTwoTV)
    TextView moreTwoTV;


    @BindView(R.id.withdrawTwoTV)
    TextView withdrawTwoTV;
    @BindView(R.id.putoffTwoTV)
    TextView putoffTwoTV;
    @BindView(R.id.stopTwoTV)
    TextView stopTwoTV;
    @BindView(R.id.driftTwoTV)
    TextView driftTwoTV;

    @BindView(R.id.dealwithTwoTV)
    TextView dealwithTwoTV;
    @BindView(R.id.repentTwoTV)
    TextView repentTwoTV;
    @BindView(R.id.propertyTwoTV)
    TextView propertyTwoTV;
    @BindView(R.id.more_TwoTV)
    TextView more_TwoTV;


    @BindView(R.id.seekIV)
    ImageView seekIV;
    @BindView(R.id.taskbarIV)
    ImageView taskbarIV;

    @BindView(R.id.utils_tv)//工具
    TextView utils_tv;
    @BindView(R.id.twoPager)
    NoScrollViewPager twoPager;
    private List<Fragment> twoFragments = new ArrayList<>();
    Pager_MarkAdapter twoAdapter;

    BadgeView isShowUnpublished_bv, isFallBack_bv, isMore_bv, isReleaseComplete_bv;

    boolean isShowUnpublished;
    boolean isFallBack;
    boolean isMore;
    boolean isReleaseComplete;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_main_mark;
    }


    @Override
    protected void initViews(Bundle bundle) {
        TwoPager();
        // showBadgeView_ReleaseComplete(commissionTV);
        // showBadgeView_FallBack(allTV);
        // showBadgeView_More(moreTV);
        //showBadgeView_Unpublished(alreadyTV);
    }


    //设置提示小小标 ReleaseComplete

    private void showBadgeView_ReleaseComplete(View view) {
        //http://www.th7.cn/Program/Android/201606/874990.shtml
        isShowUnpublished_bv = new BadgeView(getContext(), view);
        //  BadgeView badgeView = new BadgeView(getContext(), view);  // 将需要设置角标的View 传递进去
        isShowUnpublished_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isShowUnpublished_bv.setTextSize(9);// 设置文本大小
        isShowUnpublished_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isShowUnpublished_bv.setText("5"); // 设置要显示的文本
        isShowUnpublished_bv.show();// 将角标显示出来

        // badgeView.toggle();//打开关闭或者角标
        // badgeView.setTextColor(Color.BLUE);//角标内文字颜色
        // badgeView.setBadgeBackgroundColor(Color.YELLOW);//角标背景颜色
        // badgeView.setTextSize(12);//角标内数字大小
        //badgeView.toggle(true);//默认动画效果

    }

    //设置提示小小标 返回

    private void showBadgeView_FallBack(View view) {
        //http://www.th7.cn/Program/Android/201606/874990.shtml
        isFallBack_bv = new BadgeView(getContext(), view);
        //  BadgeView badgeView = new BadgeView(getContext(), view);  // 将需要设置角标的View 传递进去
        isFallBack_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isFallBack_bv.setTextSize(9);// 设置文本大小
        isFallBack_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isFallBack_bv.setText("4"); // 设置要显示的文本
        isFallBack_bv.show();// 将角标显示出来

        // badgeView.toggle();//打开关闭或者角标
        // badgeView.setTextColor(Color.BLUE);//角标内文字颜色
        // badgeView.setBadgeBackgroundColor(Color.YELLOW);//角标背景颜色
        // badgeView.setTextSize(12);//角标内数字大小
        //badgeView.toggle(true);//默认动画效果

    }

    //设置提示小标 更多

    private void showBadgeView_More(View view) {
        //http://www.th7.cn/Program/Android/201606/874990.shtml
        isMore_bv = new BadgeView(getContext(), view);
        //  BadgeView badgeView = new BadgeView(getContext(), view);  // 将需要设置角标的View 传递进去
        isMore_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isMore_bv.setTextSize(9);// 设置文本大小
        isMore_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isMore_bv.setText("10"); // 设置要显示的文本
        isMore_bv.show();// 将角标显示出来

        // badgeView.toggle();//打开关闭或者角标
        // badgeView.setTextColor(Color.BLUE);//角标内文字颜色
        // badgeView.setBadgeBackgroundColor(Color.YELLOW);//角标背景颜色
        // badgeView.setTextSize(12);//角标内数字大小
        //badgeView.toggle(true);//默认动画效果

    }

    //设置提示小标 未发布
    private void showBadgeView_Unpublished(View view) {
        //http://www.th7.cn/Program/Android/201606/874990.shtml
        isReleaseComplete_bv = new BadgeView(getContext(), view);
        //  BadgeView badgeView = new BadgeView(getContext(), view);  // 将需要设置角标的View 传递进去
        isReleaseComplete_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isReleaseComplete_bv.setTextSize(9);// 设置文本大小
        isReleaseComplete_bv.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 设置在右上角
        isReleaseComplete_bv.setText("2"); // 设置要显示的文本
        isReleaseComplete_bv.show();// 将角标显示出来

        // badgeView.toggle();//打开关闭或者角标
        // badgeView.setTextColor(Color.BLUE);//角标内文字颜色
        // badgeView.setBadgeBackgroundColor(Color.YELLOW);//角标背景颜色
        // badgeView.setTextSize(12);//角标内数字大小
        //badgeView.toggle(true);//默认动画效果

    }

    private void TwoPager() {
        twoFragments.add(new ReleaseComplete_Fragment());
        twoFragments.add(new Unpublished_Fragment());
        twoFragments.add(new Fallback_Fragment());
        twoFragments.add(new Bater_Fragment());
        twoAdapter = new Pager_MarkAdapter(getChildFragmentManager(), twoFragments);
        twoPager.setOffscreenPageLimit(3);
        twoPager.setAdapter(twoAdapter);
    }


    @OnClick({R.id.commissionLL, R.id.alreadyLL, R.id.allLL, R.id.seekIV,
            R.id.taskbarIV, R.id.morell,R.id.utils_tv,
            R.id.withdrawLL, R.id.putoffLL, R.id.stopLL, R.id.driftll,
            R.id.dealwithLL, R.id.repentLL, R.id.propertyLL, R.id.gone_ll})
    void click(View v) {
        switch (v.getId()) {

            //已发布
            case R.id.commissionLL:
                Toast.makeText(getActivity(), "点击了已发布" + "", Toast.LENGTH_SHORT).show();

                // twoPager.setCurrentItem(0);
                //
                commissionTwoTV.setBackgroundColor(0xffff8400);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xffff8400);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                //more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.ic_launcher);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                //未发布
            case R.id.alreadyLL:
                // twoPager.setCurrentItem(1);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffff8400);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xffff8400);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                //more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.ic_launcher);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;


            //退回
            case R.id.allLL:
                // twoPager.setCurrentItem(2);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffff8400);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xffff8400);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);


                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.ic_launcher);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            //更多
            case R.id.morell:
                // twoPager.setCurrentItem(3);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffff8400);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);

                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xffff8400);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.ic_launcher);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);

                // frist_ll.setVisibility(View.GONE);

                break;
            case R.id.withdrawLL:
                // twoPager.setCurrentItem(4);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffff8400);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xffff8400);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.ic_launcher);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);

                break;

            case R.id.putoffLL:
                // twoPager.setCurrentItem(5);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffff8400);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xffff8400);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.ic_launcher);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            case R.id.stopLL:
                // twoPager.setCurrentItem(6);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffff8400);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xffff8400);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.ic_launcher);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            case R.id.driftll:
                // twoPager.setCurrentItem(7);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffff8400);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xffff8400);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.ic_launcher);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            case R.id.dealwithLL:
                // twoPager.setCurrentItem(8);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffff8400);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xffff8400);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.ic_launcher);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            case R.id.repentLL:
                // twoPager.setCurrentItem(9);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffff8400);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffffffff);

                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xffff8400);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.ic_launcher);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            case R.id.propertyLL:
                // twoPager.setCurrentItem(10);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffff8400);
                // more_TwoTV.setBackgroundColor(0xffffffff);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xffff8400);
                // more_TV.setTextColor(0xff000000);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.tubiao);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.ic_launcher);
                // more_IV.setImageResource(R.drawable.tubiao);


                break;
            case R.id.gone_ll:
                // twoPager.setCurrentItem(11);
                commissionTwoTV.setBackgroundColor(0xffffffff);
                alreadyTwoTV.setBackgroundColor(0xffffffff);
                allTwoTV.setBackgroundColor(0xffffffff);
                moreTwoTV.setBackgroundColor(0xffffffff);

                withdrawTwoTV.setBackgroundColor(0xffffffff);
                stopTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);
                driftTwoTV.setBackgroundColor(0xffffffff);

                dealwithTwoTV.setBackgroundColor(0xffffffff);
                repentTwoTV.setBackgroundColor(0xffffffff);
                propertyTwoTV.setBackgroundColor(0xffffffff);
                // more_TwoTV.setBackgroundColor(0xffff8400);


                commissionTV.setTextColor(0xff000000);
                alreadyTV.setTextColor(0xff000000);
                allTV.setTextColor(0xff000000);
                moreTV.setTextColor(0xff000000);

                withdrawTV.setTextColor(0xff000000);
                putoffTV.setTextColor(0xff000000);
                stopTV.setTextColor(0xff000000);
                driftTV.setTextColor(0xff000000);

                dealwithTV.setTextColor(0xff000000);
                repentTV.setTextColor(0xff000000);
                propertyTV.setTextColor(0xff000000);
                // more_TV.setTextColor(0xffff8400);

                commissionIV.setImageResource(R.drawable.tubiao);
                alreadyIV.setImageResource(R.drawable.tubiao);
                allIV.setImageResource(R.drawable.tubiao);
                moreIV.setImageResource(R.drawable.tubiao);

                withdrawIV.setImageResource(R.drawable.ic_launcher);
                putoffIV.setImageResource(R.drawable.tubiao);
                stopIV.setImageResource(R.drawable.tubiao);
                driftIV.setImageResource(R.drawable.tubiao);

                dealwithIV.setImageResource(R.drawable.tubiao);
                repentIV.setImageResource(R.drawable.tubiao);
                propertyIV.setImageResource(R.drawable.tubiao);
                // more_IV.setImageResource(R.drawable.ic_launcher);


                break;


            case R.id.seekIV:
                // Intent intentSeek =new Intent(getContext(), SeekActivity.class);
                // startActivity(intentSeek);
                //收索
                break;
            case R.id.taskbarIV:
                //  Intent intentResumeSelection =new Intent(getContext(), ResumeSelectionActivity.class);
                // startActivity(intentResumeSelection);
                //任务详情况
                break;
            case R.id.utils_tv:

                Toast.makeText(getActivity(), "点击工具" + "", Toast.LENGTH_SHORT).show();


                //  Intent intentResumeSelection =new Intent(getContext(), ResumeSelectionActivity.class);
                // startActivity(intentResumeSelection);
                //任务详情况
                break;

            default:

                break;


        }
    }


}
