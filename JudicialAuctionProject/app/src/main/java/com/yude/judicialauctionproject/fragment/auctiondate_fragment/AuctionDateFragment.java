package com.yude.judicialauctionproject.fragment.auctiondate_fragment;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.entity.dsf.CardBean;
import com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment.Deal_fragment;
import com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment.Flow_fragment;
import com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment.Money_fragment;
import com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment.Regret2Fragment;
import com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment.Regret_fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;


// 拍卖数据
public class AuctionDateFragment extends BaseFragment implements View.OnClickListener {
    private PopupWindow mPopWindow;
    private TimePickerView  pvCustomTime;
   // private ArrayList<CardBean> cardItem = new ArrayList<>();


    @BindView(R.id.type_tv)//待审
            TextView type_tv;
    TextView antique_tv, factory_home_tv, car_tv, home_tv, all_tv;
    LinearLayout linearLayout;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;


    @BindView(R.id.tv1_2)
    TextView tv1_2;
    @BindView(R.id.tv2_2)
    TextView tv2_2;
    @BindView(R.id.tv3_2)
    TextView tv3_2;
    @BindView(R.id.tv4_2)
    TextView tv4_2;

    @BindView(R.id.taskLL)
    LinearLayout taskLL;// 成交总额
    @BindView(R.id.workLL)
    LinearLayout workLL;// 成交件数
    @BindView(R.id.myLL)
    LinearLayout myLL;// 流拍
    @BindView(R.id.moreLL)
    LinearLayout moreLL;//悔拍

    @BindView(R.id.numebr_ll)
    LinearLayout numebr_ll;//悔拍

    @BindView(R.id.show_start_tv)
    TextView show_start_tv;//开始日期
    @BindView(R.id.show_end_tv)
    TextView show_end_tv;//结束日期
    @BindView(R.id.start_ll)
    LinearLayout start_ll;//
    @BindView(R.id.end_ll)
    LinearLayout end_ll;//


    @BindView(R.id.start_iv)
    ImageView start_iv;
    @BindView(R.id.end_iv)
    ImageView end_iv;

    TextView l_title_tv, r_title_tv, title;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_main_auctiondate;
    }

    @Override
    protected void initViews(Bundle bundle) {
        // initTabViws();
        initTitle();
        defaultChecked();

       // Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar date= Calendar.getInstance();
        show_end_tv.setText(date.get(Calendar.YEAR)+"-"+(date.get(Calendar.MONTH)+1)+"-"+date.get(Calendar.DAY_OF_MONTH));
        show_start_tv.setText((date.get(Calendar.YEAR))-1+"-"+(date.get(Calendar.MONTH)+1)+"-"+date.get(Calendar.DAY_OF_MONTH));
    }

    private void initTitle() {
        l_title_tv = (TextView) rootView.findViewById(R.id.l_title_tv);
        r_title_tv = (TextView) rootView.findViewById(R.id.r_title_tv);
        title = (TextView) rootView.findViewById(R.id.tile_tv);
        l_title_tv.setVisibility(View.INVISIBLE);
        title.setText("拍卖数据");
        r_title_tv.setText("类别");
        r_title_tv.setTextSize(18);
        r_title_tv.setVisibility(View.VISIBLE);
        r_title_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "点击了类别", Toast.LENGTH_LONG).show();
                showPopupWindow();
                setScreenBgDarken();
            }
        });

    }


    //默认初始化tab
    private void defaultChecked() {

        tv1.setText("成交额");
        tv1.setTextColor(0xff000000);
        tv2.setText("成交件数");
        tv2.setTextColor(0xff545454);
        tv3.setText("流拍");
        tv3.setTextColor(0xff545454);
        tv4.setText("悔拍");
        tv4.setTextColor(0xff545454);

        initFragment(new Money_fragment(), R.id.numebr_ll);

        //  tv1_2.setBackgroundColor(0xffc80215);
        // tv2_2.setBackgroundColor(0xfff0f0f0);
        //tv3_2.setBackgroundColor(0xfff0f0f0);
        // tv4_2.setBackgroundColor(0xfff0f0f0);

        tv1_2.setBackgroundColor(0xffc80215);
        tv2_2.setVisibility(View.INVISIBLE);
        tv3_2.setVisibility(View.INVISIBLE);
        tv4_2.setVisibility(View.INVISIBLE);


        // initFragment(new ReleaseComplete_Fragment(), R.id.fragment_ll);
    }


    public void initFragment(Fragment fragment, int viewId) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // oneWithDataFragment = new OneWithDataFragment();
        transaction.replace(viewId, fragment);
        //fragment.setArguments(bundle);
        transaction.commit();
    }

    @OnClick({R.id.type_tv, R.id.start_ll, R.id.end_ll, R.id.taskLL, R.id.workLL, R.id.myLL, R.id.moreLL})
    void click(View v) {
        switch (v.getId()) {
            //  点击了类别
            case R.id.type_tv:
                Toast.makeText(getContext(), "点击了类别", Toast.LENGTH_SHORT).show();
                showPopupWindow();
                setScreenBgDarken();
                break;

            case R.id.start_ll:
                Toast.makeText(getContext(), "点击开始日期", Toast.LENGTH_SHORT).show();
                initCustomTimePicker(show_start_tv);
                pvCustomTime.show();
                break;

            case R.id.end_ll:
                initCustomTimePicker(show_end_tv);
                pvCustomTime.show();
                Toast.makeText(getContext(), "点击了结束", Toast.LENGTH_SHORT).show();
                break;

            //  成交额
            case R.id.taskLL:
                // Toast.makeText(getContext(), "点击了类别", Toast.LENGTH_SHORT).show();
                tv1_2.setBackgroundColor(0xffc80215);
                tv1_2.setVisibility(View.VISIBLE);
                tv2_2.setVisibility(View.INVISIBLE);
                tv3_2.setVisibility(View.INVISIBLE);
                tv4_2.setVisibility(View.INVISIBLE);
                tv1.setTextColor(0xff000000);
                tv2.setTextColor(0xff545454);
                tv3.setTextColor(0xff545454);
                tv4.setTextColor(0xff545454);
                initFragment(new Money_fragment(), R.id.numebr_ll);

                break;
            //成交件数
            case R.id.workLL:
                // Toast.makeText(getContext(), "点击了类别", Toast.LENGTH_SHORT).show();
                tv2_2.setVisibility(View.VISIBLE);
                tv1_2.setVisibility(View.INVISIBLE);
                tv2_2.setBackgroundColor(0xffc80215);
                tv3_2.setVisibility(View.INVISIBLE);
                tv4_2.setVisibility(View.INVISIBLE);
                tv1.setTextColor(0xff545454);
                tv2.setTextColor(0xff000000);
                tv3.setTextColor(0xff545454);
                tv4.setTextColor(0xff545454);
                initFragment(new Deal_fragment(), R.id.numebr_ll);
                break;
            //  流拍
            case R.id.myLL:
                //Toast.makeText(getContext(), "点击了类别", Toast.LENGTH_SHORT).show();

                tv3_2.setVisibility(View.VISIBLE);
                tv1_2.setVisibility(View.INVISIBLE);
                tv2_2.setVisibility(View.INVISIBLE);
                tv3_2.setBackgroundColor(0xffc80215);
                tv4_2.setVisibility(View.INVISIBLE);

                tv1.setTextColor(0xff545454);
                tv2.setTextColor(0xff545454);
                tv3.setTextColor(0xff000000);
                tv4.setTextColor(0xff545454);
                initFragment(new Flow_fragment(), R.id.numebr_ll);
                break;
            // 悔拍
            case R.id.moreLL:
                tv4_2.setVisibility(View.VISIBLE);
                //Toast.makeText(getContext(), "点击了类别", Toast.LENGTH_SHORT).show();
                tv1_2.setVisibility(View.INVISIBLE);
                tv2_2.setVisibility(View.INVISIBLE);
                tv3_2.setVisibility(View.INVISIBLE);
                tv4_2.setBackgroundColor(0xffc80215);

                tv1.setTextColor(0xff545454);
                tv2.setTextColor(0xff545454);
                tv3.setTextColor(0xff545454);
                tv4.setTextColor(0xff000000);
               // initFragment(new Regret_fragment(), R.id.numebr_ll);
                initFragment(new Regret2Fragment(), R.id.numebr_ll);
                break;

        }
    }


    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow_type, null);
        mPopWindow = new PopupWindow(contentView, 311, 180);
        //mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        /*final PopupWindow popup = new PopupWindow(contentView, ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT, false);
        WindowManager manager=(WindowManager) getSystemService(getContext().WINDOW_SERVICE);
        int xpos=manager.getDefaultDisplay().getWidth()/2-popup.getWidth()/2;
        popup.setOutsideTouchable(true);
        popup.showAsDropDown(appendIV,xpos, 0);
*/

        //设置各个控件的点击响应
        antique_tv = (TextView) contentView.findViewById(R.id.antique_tv);
        factory_home_tv = (TextView) contentView.findViewById(R.id.factory_home_tv);
        car_tv = (TextView) contentView.findViewById(R.id.car_tv);
        home_tv = (TextView) contentView.findViewById(R.id.home_tv);
        all_tv = (TextView) contentView.findViewById(R.id.all_tv);
        linearLayout = (LinearLayout) contentView.findViewById(R.id.ll);
        View rootview = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main_auctiondate, null);
        // mPopWindow.showAtLocation(rootview, Gravity.RIGHT, 0, 0);
        //点击外部消失
        mPopWindow.setFocusable(true);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //控制透明度
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.7f;
        getActivity().getWindow().setAttributes(lp);
        //显示
        mPopWindow.showAsDropDown(r_title_tv);
        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams p = getActivity().getWindow().getAttributes();
                p.alpha = 1f;
                getActivity().getWindow().setAttributes(p);
            }
        });

        linearLayout.getBackground().setAlpha(0);       //设置透明度

        all_tv.setOnClickListener(this);
        factory_home_tv.setOnClickListener(this);
        car_tv.setOnClickListener(this);
        home_tv.setOnClickListener(this);
        antique_tv.setOnClickListener(this);
    }


    //屏幕变暗
    private void setScreenBgDarken() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        lp.dimAmount = 0.5f;
        getActivity().getWindow().setAttributes(lp);
    }

    // 设置屏幕背景变亮
    private void setScreenBgLight() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 1.0f;
        lp.dimAmount = 1.0f;
        getActivity().getWindow().setAttributes(lp);
    }


    //弹框的监听
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.all_tv:

                Toast.makeText(getContext(), "全部", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_tv:

                Toast.makeText(getContext(), "房产", Toast.LENGTH_SHORT).show();
                break;
            case R.id.car_tv:

                Toast.makeText(getContext(), "汽车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.factory_home_tv:
                Toast.makeText(getContext(), " 工厂", Toast.LENGTH_SHORT).show();
                break;

            case R.id.antique_tv:
                Toast.makeText(getContext(), "古董", Toast.LENGTH_SHORT).show();
                break;

        }

    }


    private void initCustomTimePicker(final TextView view) {
        // 注意：自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针
        // 否则会报空指针
        // 具体可参考demo 里面的两个自定义布局

        Calendar date= Calendar.getInstance();
        date.get(Calendar.YEAR);
        date.get(Calendar.MONTH);
        date.get(Calendar.DAY_OF_MONTH);
    //  date.add(Calendar.YEAR, -1);

        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        //开始时间
        startDate.set((date.get(Calendar.YEAR))-1,date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH));
        //结束时间
        Calendar endDate = Calendar.getInstance();
        endDate.set( date.get(Calendar.YEAR), date.get(Calendar.MONTH),  date.get(Calendar.DAY_OF_MONTH));
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(getContext(), new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                view.setText(getTime(date));
            }
        }).setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData(tvSubmit);
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setDividerColor(Color.BLACK)
                .build();
    }





    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        return format.format(date);
    }



}
