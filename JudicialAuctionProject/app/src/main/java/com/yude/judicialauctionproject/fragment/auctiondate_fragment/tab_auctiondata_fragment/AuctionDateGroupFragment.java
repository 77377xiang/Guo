package com.yude.judicialauctionproject.fragment.auctiondate_fragment.tab_auctiondata_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.adapter.auctiondaet_adapter.ListAdapter;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.entity.Test;
import com.yude.judicialauctionproject.utils.GetTime;
import com.yude.judicialauctionproject.views.view.NoScrollListView;
import com.yude.judicialauctionproject.adapter.CommAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hexiang on 17/3/18.
 */
public abstract class AuctionDateGroupFragment extends BaseFragment implements View.OnClickListener {


    // 总额 一拍 二拍 变卖
    private NoScrollListView list_view, list_one, list_two, list_sell;
    //  对应 相应图标
    private ImageView zong_groupIcon, one_groupIcon, two_groupIcon, sell_groupIcon;
    private List<Test> n_date;
    // 控制相应图标 标示
    private boolean Show_list_view, show_list_one, show_list_two, show_list_sell;
    // 获取右边对应 数量
    private TextView zong_unmber_tv, one_unmber_tv, two_unmber_tv, sell_unmber_tv;
    private TimePickerView pvCustomTime;

    TextView show_start_tv;//开始日期
    TextView show_end_tv;//结束日期
    LinearLayout start_ll;//  开始时间 布局
    LinearLayout end_ll;// 结束时间的
    LinearLayout sell_ll, two_ll, one_ll, zong_ll;

    public abstract String getZongNumber();

    public abstract String getNoeNumber();

    public abstract String getTwoNumber();

    public abstract String getSellNumber();

    public abstract List<Test> getChildrenData();

    public abstract int getContetViewId();

    public abstract void onDataSetChangeed(CommAdapter adapter);


    @Override
    public int getContentViewId() {
        return getContetViewId();
    }

    @Override
    protected void initViews(Bundle bundle) {
        initView();
        initData();
        ControllerListener();
        setListviewAdapter();
    }


    private void initView() {
        list_view = (NoScrollListView) rootView.findViewById(R.id.list_view);
        list_one = (NoScrollListView) rootView.findViewById(R.id.list_one);
        list_two = (NoScrollListView) rootView.findViewById(R.id.list_two);
        list_sell = (NoScrollListView) rootView.findViewById(R.id.list_sell);

        zong_groupIcon = (ImageView) rootView.findViewById(R.id.zong_groupIcon);
        one_groupIcon = (ImageView) rootView.findViewById(R.id.one_groupIcon);
        two_groupIcon = (ImageView) rootView.findViewById(R.id.two_groupIcon);
        sell_groupIcon = (ImageView) rootView.findViewById(R.id.sell_groupIcon);

        zong_unmber_tv = (TextView) rootView.findViewById(R.id.zong_unmber_tv);
        one_unmber_tv = (TextView) rootView.findViewById(R.id.one_unmber_tv);
        two_unmber_tv = (TextView) rootView.findViewById(R.id.two_unmber_tv);
        sell_unmber_tv = (TextView) rootView.findViewById(R.id.sell_unmber_tv);

        show_start_tv = (TextView) rootView.findViewById(R.id.show_start_tv);
        show_end_tv = (TextView) rootView.findViewById(R.id.show_end_tv);
        start_ll = (LinearLayout) rootView.findViewById(R.id.start_ll);
        end_ll = (LinearLayout) rootView.findViewById(R.id.end_ll);

        sell_ll = (LinearLayout) rootView.findViewById(R.id.sell_ll);
        two_ll = (LinearLayout) rootView.findViewById(R.id.two_ll);
        one_ll = (LinearLayout) rootView.findViewById(R.id.one_ll);
        zong_ll = (LinearLayout) rootView.findViewById(R.id.zong_ll);

    }

    ListAdapter listSellAdapter = null;

    //给list 所有list view 设置适配器
    private void setListviewAdapter() {

        list_view.setAdapter(new ListAdapter(getChildrenData(), getContext()));
        list_one.setAdapter(new ListAdapter(getChildrenData(), getContext()));
        list_two.setAdapter(new ListAdapter(getChildrenData(), getContext()));
        listSellAdapter = new ListAdapter(getChildrenData(), getContext());
        list_sell.setAdapter(listSellAdapter);


    }


    //  控制  右边尖头方向  开始和结束日期的点击
    private void ControllerListener() {

//        zong_groupIcon.setOnClickListener(this);
//        one_groupIcon.setOnClickListener(this);
//        two_groupIcon.setOnClickListener(this);
//        sell_groupIcon.setOnClickListener(this);

        sell_ll.setOnClickListener(this);
        two_ll.setOnClickListener(this);
        one_ll.setOnClickListener(this);
        zong_ll.setOnClickListener(this);


        start_ll.setOnClickListener(this);
        end_ll.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zong_ll:
                // Controller(Show_list_view, list_view, zong_groupIcon);

                if (!Show_list_view) {
                    list_view.setVisibility(View.VISIBLE);
                    zong_groupIcon.setImageResource(R.mipmap.h_z_browser);
                    Show_list_view = true;

                } else {
                    Show_list_view = false;
                    list_view.setVisibility(View.GONE);
                    zong_groupIcon.setImageResource(R.mipmap.h_h_browser);

                }
                break;
            case R.id.one_ll:
                // Controller(show_list_one, list_one, one_groupIcon);

                if (!show_list_one) {
                    list_one.setVisibility(View.VISIBLE);
                    one_groupIcon.setImageResource(R.mipmap.h_z_browser);
                    show_list_one = true;

                } else {
                    show_list_one = false;
                    list_one.setVisibility(View.GONE);
                    one_groupIcon.setImageResource(R.mipmap.h_h_browser);

                }
                break;
            case R.id.two_ll:
                // Controller(show_list_two, list_two, two_groupIcon);

                if (!show_list_two) {
                    list_two.setVisibility(View.VISIBLE);
                    two_groupIcon.setImageResource(R.mipmap.h_z_browser);
                    show_list_two = true;

                } else {
                    show_list_two = false;
                    list_two.setVisibility(View.GONE);
                    two_groupIcon.setImageResource(R.mipmap.h_h_browser);

                }

                break;
            case R.id.sell_ll:
                //Controller(show_list_sell, list_sell, sell_groupIcon);
                if (!show_list_sell) {
                    list_sell.setVisibility(View.VISIBLE);
                    sell_groupIcon.setImageResource(R.mipmap.h_z_browser);
                    show_list_sell = true;

                } else {
                    show_list_sell = false;
                    list_sell.setVisibility(View.GONE);
                    sell_groupIcon.setImageResource(R.mipmap.h_h_browser);

                }

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
                onDataSetChangeed(listSellAdapter);
                break;
        }
    }


    //  获取右边对应的数量 时间 以及 内层数据
    private void initData() {
        Calendar date = Calendar.getInstance();
        zong_unmber_tv.setText(getZongNumber());
        one_unmber_tv.setText(getNoeNumber());
        two_unmber_tv.setText(getTwoNumber());
        sell_unmber_tv.setText(getSellNumber());
        show_end_tv.setText(date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DAY_OF_MONTH));
        show_start_tv.setText((date.get(Calendar.YEAR)) - 1 + "-" + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.DAY_OF_MONTH));


       /* n_date = new ArrayList<>();

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
*/
    }


    private void initCustomTimePicker(final TextView view) {
        // 注意：自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针
        // 否则会报空指针
        // 具体可参考demo 里面的两个自定义布局

        Calendar date = Calendar.getInstance();
        date.get(Calendar.YEAR);
        date.get(Calendar.MONTH);
        date.get(Calendar.DAY_OF_MONTH);
        //  date.add(Calendar.YEAR, -1);

        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        //开始时间
        startDate.set((date.get(Calendar.YEAR)) - 1, date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        //结束时间
        Calendar endDate = Calendar.getInstance();
        endDate.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(getContext(), new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                view.setText(GetTime.getTime(date));
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


   /* private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        return format.format(date);
    }
*/

}
