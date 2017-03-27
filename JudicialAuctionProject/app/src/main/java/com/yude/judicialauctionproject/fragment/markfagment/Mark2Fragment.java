package com.yude.judicialauctionproject.fragment.markfagment;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.markadapter.Pager_MarkAdapter;
import com.yude.judicialauctionproject.adapter.markadapter.TabAdapter;
import com.yude.judicialauctionproject.entity.Attention;
import com.yude.judicialauctionproject.entity.TabDate;
import com.yude.judicialauctionproject.entity.Test;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.AcceptFragment;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.DealFragment;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.FlowFragment;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.RegretFragment;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.StopsFragment;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.SuspendedFrgment;
import com.yude.judicialauctionproject.fragment.markfagment.moreFragment.WithdrawFragment;
import com.yude.judicialauctionproject.views.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexiang on 17/3/7.
 */
public class Mark2Fragment extends Fragment implements View.OnClickListener {
    View rootView;

    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;


    LinearLayout fragment_ll;
    LinearLayout taskLL;
    LinearLayout workLL;
    LinearLayout myLL;
    LinearLayout moerLL;
    LinearLayout baterLL;
    LinearLayout height_ll;

    TextView l_title_tv,r_title_tv, title,line_tv;



    TabAdapter adapter;
    GridView listView;
    int isMoreClick = 1;
    NoScrollViewPager twoPager;
    private List<Fragment> twoFragments = new ArrayList<>();
    Pager_MarkAdapter twoAdapter;
    int heightGridView;
    boolean isGetHeight = false;

    List<TabDate> tabDates = new ArrayList<>();

    private  void  initTitle(){
        l_title_tv = (TextView) rootView.findViewById(R.id.l_title_tv);
        r_title_tv = (TextView) rootView.findViewById(R.id.r_title_tv);
        title = (TextView) rootView.findViewById(R.id.tile_tv);
        l_title_tv.setVisibility(View.INVISIBLE);
        title.setText("国颢司辅");
        r_title_tv.setText("工具");
        r_title_tv.setTextSize(18);
        r_title_tv.setVisibility(View.VISIBLE);
        r_title_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"点击了工具",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_mark2, container, false);
        initVies();
        initTitle();
        initTabDate();
        adapter = new TabAdapter(tabDates, getContext());
        listView.setAdapter(adapter);
        TwoPager();
        //  ObjectAnimator.ofFloat(listView,"translationY",0,-500f).setDuration(1).start();//y轴平移


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {
//                listView.setVisibility(View.GONE);
                toggleGrideView(false);
                //  ObjectAnimator.ofFloat(listView,"translationY",0,-500f).setDuration(1000).start();//y轴平移

                // initVies();

                goneTabListener(postion);


            }
        });



        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listView.setVisibility(View.GONE);
                isMoreClick = 1;

                //  ObjectAnimator.ofFloat(listView,"translationY",0,-500f).setDuration(1000).start();//y轴平移

                Toast.makeText(getContext(), "" + i, Toast.LENGTH_SHORT).show();
                // initVies();

            }
        });*/

        return rootView;
    }


    public void initFragment(Fragment fragment, int viewId) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // oneWithDataFragment = new OneWithDataFragment();
        transaction.replace(viewId, fragment);
        //fragment.setArguments(bundle);
        transaction.commit();
    }

    private void goneTabListener(int postion) {

        switch (postion) {

            case 0:
                WithdrawFragment withdrawFragment = new WithdrawFragment();
               // initFragment(new GroupFragment(), R.id.fragment_ll);
                initFragment(withdrawFragment, R.id.fragment_ll);
                Toast.makeText(getContext(), "我被点击了" + postion, Toast.LENGTH_SHORT).show();

                break;

            case 1:
                SuspendedFrgment suspendedFrgment = new SuspendedFrgment();
                initFragment(suspendedFrgment, R.id.fragment_ll);

                break;
            case 2:
                StopsFragment stopsFragment = new StopsFragment();
                initFragment(stopsFragment, R.id.fragment_ll);


                break;
            case 3:
                FlowFragment flowFragment = new FlowFragment();
                initFragment(flowFragment, R.id.fragment_ll);

                break;
            case 4:
                DealFragment dealFragment = new DealFragment();
                initFragment(dealFragment, R.id.fragment_ll);

                break;
            case 5:
                RegretFragment regretFragment = new RegretFragment();
                initFragment(regretFragment, R.id.fragment_ll);
                break;
            case 6:
                AcceptFragment acceptFragment = new AcceptFragment();
                initFragment(acceptFragment, R.id.fragment_ll);

                break;
            default:

                break;

        }

    }


    private void TwoPager() {
        // ReleaseComplete_Fragment  releaseComplete_fragment = new ReleaseComplete_Fragment();

        initFragment(new ReleaseComplete_Fragment(), R.id.fragment_ll);
//        initFragment(new Unpublished_Fragment(),R.id.fragment_ll);
//        initFragment(new Fallback_Fragment(),R.id.fragment_ll);

        // twoFragments.add(new ReleaseComplete_Fragment());
        //  twoFragments.add(new Unpublished_Fragment());
        // twoFragments.add(new Fallback_Fragment());

        // twoAdapter = new Pager_MarkAdapter(getChildFragmentManager(), twoFragments);
        //twoPager.setOffscreenPageLimit(3);
        // twoPager.setAdapter(twoAdapter);
    }


    private void initVies() {

        iv1 = (ImageView) rootView.findViewById(R.id.iv1);
        iv2 = (ImageView) rootView.findViewById(R.id.iv2);
        iv3 = (ImageView) rootView.findViewById(R.id.iv3);
        iv4 = (ImageView) rootView.findViewById(R.id.iv4);
        iv5 = (ImageView) rootView.findViewById(R.id.iv5);

        tv1 = (TextView) rootView.findViewById(R.id.tv1);
        tv2 = (TextView) rootView.findViewById(R.id.tv2);
        tv3 = (TextView) rootView.findViewById(R.id.tv3);
        tv4 = (TextView) rootView.findViewById(R.id.tv4);
        tv5 = (TextView) rootView.findViewById(R.id.tv5);
        line_tv= (TextView) rootView.findViewById(R.id.line_tv);

        taskLL = (LinearLayout) rootView.findViewById(R.id.taskLL);
        workLL = (LinearLayout) rootView.findViewById(R.id.workLL);
        myLL = (LinearLayout) rootView.findViewById(R.id.myLL);
        moerLL = (LinearLayout) rootView.findViewById(R.id.moreLL);
        baterLL = (LinearLayout) rootView.findViewById(R.id.baterLL);
        height_ll = (LinearLayout) rootView.findViewById(R.id.height_ll);

        listView = (GridView) rootView.findViewById(R.id.list);
        // twoPager = (NoScrollViewPager) rootView.findViewById(R.id.twoPager);
        fragment_ll = (LinearLayout) rootView.findViewById(R.id.fragment_ll);

        goneTbaListListener();

//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            // listView.setVisibility(View.GONE);
//                toggleGrideView(false);
//                //  ObjectAnimator.ofFloat(listView,"translationY",0,-500f).setDuration(1000).start();//y轴平移
//
//                Toast.makeText(getContext(), "" + i, Toast.LENGTH_SHORT).show();
//                // initVies();
//
//            }
//        });


        //注意！！！
       // listView.setVisibility(View.VISIBLE);

        listView.setVisibility(View.VISIBLE);
        height_ll.setVisibility(View.VISIBLE);
        line_tv.setVisibility(View.VISIBLE);

        height_ll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!isGetHeight) {
                    heightGridView = height_ll.getHeight();
                    height_ll.setVisibility(View.GONE);
                    line_tv.setVisibility(View.GONE);
                    height_ll.setVisibility(View.GONE);
                    isGetHeight = true;
                }
            }
        });
        defaultChecked();
        taskLL.setOnClickListener(this);
        workLL.setOnClickListener(this);
        myLL.setOnClickListener(this);
        moerLL.setOnClickListener(this);
        baterLL.setOnClickListener(this);
    }

    private void goneTbaListListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // listView.setVisibility(View.GONE);
                toggleGrideView(false);
                //  ObjectAnimator.ofFloat(listView,"translationY",0,-500f).setDuration(1000).start();//y轴平移
                Toast.makeText(getContext(), "" + i, Toast.LENGTH_SHORT).show();
                // initVies();

            }
        });

    }


    //控制更多
    public void toggleGrideView(boolean show) {
        if (heightGridView == 0) {
            heightGridView = height_ll.getHeight();
        }
        height_ll.setVisibility(View.VISIBLE);
        line_tv .setVisibility(View.VISIBLE);
        ValueAnimator scaleY = ValueAnimator.ofInt(show ? 0 : heightGridView, show ? heightGridView : 0); ////第二个高度 需要注意一下, 因为view默认是GONE  无法直接获取高度
        scaleY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatorValue = Integer.valueOf(animation.getAnimatedValue() + "");
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) height_ll.getLayoutParams();
                params.height = animatorValue;
                height_ll.setLayoutParams(params);
            }
        });
        scaleY.setTarget(height_ll);
        scaleY.setDuration(500);
//        scaleY.setInterpolator();
        scaleY.start();

    }


    //默认初始化tab
    private void defaultChecked() {
        iv1.setImageResource(R.mipmap.r_daishenghe);
        iv2.setImageResource(R.mipmap.h_tongguo);
        iv3.setImageResource(R.mipmap.h_yituihui);
        iv4.setImageResource(R.mipmap.h_gengduo4);
        iv5.setImageResource(R.mipmap.h_shagpai03);

        // tv1.setTextColor(0xff11cd6e);
        //tv2.setTextColor(0xffffffff);
        // tv3.setTextColor(0xffffffff);
        //tv4.setTextColor(0xffffffff);
        // tv5.setTextColor(0xffffffff);

        //  待审核
       initFragment(new ReleaseComplete_Fragment(), R.id.fragment_ll);



    }


    //tab 监听
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.taskLL:
                //待审核
                if (height_ll.getVisibility() == View.GONE || height_ll.getHeight() == 0) {
                    // toggleGrideView(true);
                } else {
                    toggleGrideView(false);
                }
                initFragment(new ReleaseComplete_Fragment(), R.id.fragment_ll);
                // twoPager.setCurrentItem(0);
                iv1.setImageResource(R.mipmap.r_daishenghe);
                iv2.setImageResource(R.mipmap.h_tongguo);
                iv3.setImageResource(R.mipmap.h_yituihui);
                iv4.setImageResource(R.mipmap.h_gengduo4);
                iv5.setImageResource(R.mipmap.h_shagpai03);

                //  tv1.setTextColor(0xff11cd6e);
                // tv2.setTextColor(0xffffffff);
                // tv3.setTextColor(0xffffffff);
                // tv4.setTextColor(0xffffffff);
                // tv5.setTextColor(0xffffffff);

                break;
            case R.id.workLL:
              //  通过
                if (height_ll.getVisibility() == View.GONE || height_ll.getHeight() == 0) {
                    //  toggleGrideView(true);
                } else {
                    toggleGrideView(false);
                }
                initFragment(new Unpublished_Fragment(), R.id.fragment_ll);
                // twoPager.setCurrentItem(1);
//                iv1.setImageResource(R.drawable.tubiao);
//                iv2.setImageResource(R.drawable.ic_launcher);
//                iv3.setImageResource(R.drawable.tubiao);
//                iv4.setImageResource(R.drawable.tubiao);
//                iv5.setImageResource(R.drawable.tubiao);

                iv1.setImageResource(R.mipmap.h_daishenghe);
                iv2.setImageResource(R.mipmap.r_tongguo2);
                iv3.setImageResource(R.mipmap.h_yituihui);
                iv4.setImageResource(R.mipmap.h_gengduo4);
                iv5.setImageResource(R.mipmap.h_shagpai03);
                //tv1.setTextColor(0xffffffff);
                //tv2.setTextColor(0xff11cd6e);
                //tv3.setTextColor(0xffffffff);
                //tv4.setTextColor(0xffffffff);
                //tv5.setTextColor(0xffffffff);

                break;
            case R.id.myLL:
                //已退回
                if (height_ll.getVisibility() == View.GONE || height_ll.getHeight() == 0) {
                    // toggleGrideView(true);
                } else {
                    toggleGrideView(false);
                }
               initFragment(new Fallback_Fragment(), R.id.fragment_ll);

                // twoPager.setCurrentItem(2);
//                iv1.setImageResource(R.drawable.tubiao);
//                iv2.setImageResource(R.drawable.tubiao);
//                iv3.setImageResource(R.drawable.ic_launcher);
//                iv4.setImageResource(R.drawable.tubiao);
//                iv5.setImageResource(R.drawable.tubiao);


                iv1.setImageResource(R.mipmap.h_daishenghe);
                iv2.setImageResource(R.mipmap.h_tongguo);
                iv3.setImageResource(R.mipmap.r_tuihui2);
                iv4.setImageResource(R.mipmap.h_gengduo4);
                iv5.setImageResource(R.mipmap.h_shagpai03);


                // tv1.setTextColor(0xffffffff);
                //tv2.setTextColor(0xffffffff);
                // tv3.setTextColor(0xff11cd6e);
                // tv4.setTextColor(0xffffffff);
                // tv5.setTextColor(0xffffffff);
                break;
            case R.id.moreLL:
                //更多
                //twoPager.setCurrentItem(3);
                //listView.setVisibility(View.VISIBLE);
                // ObjectAnimator.ofFloat(listView,"translationY",0,500f).setDuration(1000).start();//y轴平移
//                iv1.setImageResource(R.drawable.tubiao);
//                iv2.setImageResource(R.drawable.tubiao);
//                iv3.setImageResource(R.drawable.tubiao);
//                iv4.setImageResource(R.drawable.ic_launcher);
//                iv5.setImageResource(R.drawable.tubiao);

                iv1.setImageResource(R.mipmap.h_daishenghe);
                iv2.setImageResource(R.mipmap.h_tongguo);
                iv3.setImageResource(R.mipmap.h_yituihui);
                iv4.setImageResource(R.mipmap.r_gengduo4);
                iv5.setImageResource(R.mipmap.h_shagpai03);

                // tv1.setTextColor(0xffffffff);
                // tv2.setTextColor(0xffffffff);
                // tv3.setTextColor(0xffffffff);
                // tv4.setTextColor(0xff11cd6e);
                //tv5.setTextColor(0xffffffff);

                if (height_ll.getVisibility() == View.GONE || height_ll.getHeight() == 0) {
                    toggleGrideView(true);
                } else {
                    toggleGrideView(false);
                }

               /* if(isMoreClick==1){
                    listView.setVisibility(View.VISIBLE);
                    isMoreClick = 2;

                    Log.i("sss",""+isMoreClick);

                }else {
                    listView.setVisibility(View.GONE);
                    isMoreClick = 1;
                }*/


                break;
            case R.id.baterLL:
                //上拍
                initFragment(new Bater_Fragment(), R.id.fragment_ll);
//                iv1.setImageResource(R.drawable.tubiao);
//                iv2.setImageResource(R.drawable.tubiao);
//                iv3.setImageResource(R.drawable.tubiao);
//                iv4.setImageResource(R.drawable.tubiao);
//                iv5.setImageResource(R.drawable.ic_launcher);

                iv1.setImageResource(R.mipmap.h_daishenghe);
                iv2.setImageResource(R.mipmap.h_tongguo);
                iv3.setImageResource(R.mipmap.h_yituihui);
                iv4.setImageResource(R.mipmap.h_gengduo4);
                iv5.setImageResource(R.mipmap.r_shangpai03);

                // tv1.setTextColor(0xffffffff);
                // tv2.setTextColor(0xffffffff);
                //tv3.setTextColor(0xffffffff);
                // tv4.setTextColor(0xffffffff);
                // tv5.setTextColor(0xff11cd6e);

                break;

            default:
                break;

        }

    }

    //需要隐藏的tab 数据
    private void initTabDate() {

        TabDate tabDate = new TabDate();
        tabDate.setImage(R.mipmap.h_cehui);
        tabDate.setText("撤回");
        tabDates.add(tabDate);

        TabDate tabDate1 = new TabDate();
        tabDate1.setImage(R.mipmap.h_zhanhuan);
        tabDate1.setText("暂缓");
        tabDates.add(tabDate1);

        TabDate tabDate2 = new TabDate();
        tabDate2.setImage(R.mipmap.h_zhongzhi);
        tabDate2.setText("终止");
        tabDates.add(tabDate2);

        TabDate tabDate3 = new TabDate();
        tabDate3.setImage(R.mipmap.h_liupai);
        tabDate3.setText("流拍");
        tabDates.add(tabDate3);

        TabDate tabDate4 = new TabDate();
        tabDate4.setImage(R.mipmap.h_chengjiao);
        tabDate4.setText("成交");
        tabDates.add(tabDate4);

        TabDate tabDate5 = new TabDate();
        tabDate5.setImage(R.mipmap.h_huipai);
        tabDate5.setText("悔拍");
        tabDates.add(tabDate5);

        TabDate tabDate6 = new TabDate();
        tabDate6.setImage(R.mipmap.h_caichanjiejiao);
        tabDate6.setText("财产接交");
        tabDates.add(tabDate6);

    }

}
