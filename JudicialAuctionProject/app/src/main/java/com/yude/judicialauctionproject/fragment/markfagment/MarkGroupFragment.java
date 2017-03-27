package com.yude.judicialauctionproject.fragment.markfagment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.BaterDateilsActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.DateilsActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.SucceesDateilsActivity;
import com.yude.judicialauctionproject.activitys.mark_activity.mark_details.UnpublishedDateilsActivity;
import com.yude.judicialauctionproject.adapter.RecycleHolder;
import com.yude.judicialauctionproject.adapter.markadapter.Pull_Mark_releaseComplteRecyclerAdapter;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.entity.Attention;
import com.yude.judicialauctionproject.entity.response.MarkResponse;

import java.util.List;

/**
 * Created by hexiang on 17/3/19.
 */
public abstract class MarkGroupFragment extends BaseFragment {


    // private List<Attention> attentionList;
    PullLoadMoreRecyclerView pullLoadMoreRecyclerView;
    private Pull_Mark_releaseComplteRecyclerAdapter<MarkResponse> pull_Mark_releaseComplteRecyclerAdapter;
    private String img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489119016935&di=e562bb3b7bdf57de43494c3ced7c3542&imgtype=0&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2Fda017cffgx6BpgriqtA72%26690";

    //  返回   标示 待审核1 ， 通过2， 退回3  上拍4
    public abstract int type();

    // 初始化数据
    public abstract List<MarkResponse> initListData();

    //刷新数据
    public abstract List<MarkResponse> onRefreshDate();

    // 加载数据
    public abstract List<MarkResponse> onLoadMoreDate();

    //  右上时间 显示字体颜色
    public abstract int rightTextColor();

    // 右上时间 背景
    public abstract int rightTextBackground();

    //  图片拍卖状态   一拍 二拍 变卖
    // public  abstract  String sellState();


    @Override
    public int getContentViewId() {
        return R.layout.fragment_mark_group;
    }


    @Override
    protected void initViews(Bundle bundle) {
        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) rootView.findViewById(R.id.group_rv);
        pullLoadMoreRecyclerView.setLinearLayout();
        initListData();



        pull_Mark_releaseComplteRecyclerAdapter = new Pull_Mark_releaseComplteRecyclerAdapter<MarkResponse>(getContext(), initListData(), R.layout.item_groupfragment_background) {
            @Override
            public void convert(RecycleHolder holder, MarkResponse data, int position) {

                // 待审核
                if (type() == 1 && data.getDistanceStart() == Attention.Distance.No3) {

                    holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                    holder.setText(R.id.attention_title, data.getTitle());  // 标题
                    holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                    holder.setText(R.id.attention_eara, data.getEara()); //  面积
                    holder.setText(R.id.attention_time, data.getTime());  // 时间
                    holder.findView(R.id.time_tv).setVisibility(View.GONE);
                    holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                    //holder.setText(R.id.time_tv, data.getDelayTime());   //  右边 时间
                    // holder.setTextBackground(R.id.time_tv, rightTextBackground());   //  右边 时间 背景
                    //holder.setTextColor(R.id.time_tv, rightTextColor());   //  右边 时间 字体颜色
                    // holder.setText(R.id.number_p_tv, data.getSellState());   //  左下拍卖状态
                }

                //  通过
                if (type() == 2) {

                    //距离开始
                    if (data.getDistanceStart() == Attention.Distance.Start1) {
                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        holder.setTextBackground(R.id.time_tv, getContext().getResources().getColor(R.color._ff5267_bg));
                        holder.setText(R.id.time_tv,  "距离开始 5天3 小时");


                    }

                    // 距离公告
                    if (data.getDistanceStart() == Attention.Distance.DistanceGg2) {

                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        holder.setText(R.id.time_tv,  "距离公告 1天3 小时");
                        holder.setTextBackground(R.id.time_tv, getContext().getResources().getColor(R.color._ff5267_bg));


                    }

                    // 没有提示
                    if (data.getDistanceStart() == Attention.Distance.No3) {
                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        holder.findView(R.id.time_tv).setVisibility(View.GONE);

                    }

                }
                // 已回退
                if (type() == 3) {
                    holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                    holder.setText(R.id.attention_title, data.getTitle());  // 标题
                    holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                    holder.setText(R.id.attention_eara, data.getEara()); //  面积
                    holder.setText(R.id.attention_time, data.getTime());  // 时间
                    holder.setText(R.id.time_tv, data.getBackReason());   //  右边 时间
                    // holder.setTextBackground(R.id.time_tv, rightTextBackground());   //  右边 时间 背景
                    holder.setTextColor(R.id.time_tv, rightTextColor());   //  右边 时间 字体颜色
                    //holder.setText(R.id.number_p_tv, data.getSellState());   //  左下拍卖状态
                    holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                }


                if (type() == 4) {

                    // 延时
                    if (data.getDistanceStart() == Attention.Distance.ys6) {
                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.setText(R.id.number_p_tv, data.getSellState());
                        holder.setText(R.id.time_tv,  "延时 4时30分");
                        holder.setTextBackground(R.id.time_tv, getContext().getResources().getColor(R.color._ff5267_bg));
                        // holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        // holder.findView(R.id.time_tv).setVisibility(View.GONE);


                    }

                    // 距结束
                    if (data.getDistanceStart() == Attention.Distance.Finish4) {
                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.setText(R.id.number_p_tv, data.getSellState());
                        holder.setText(R.id.time_tv,  "距结束 10时30分");
                        holder.setTextBackground(R.id.time_tv, getContext().getResources().getColor(R.color._019688_bg));
                        // holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        // holder.findView(R.id.time_tv).setVisibility(View.GONE);


                    }

                    // 距开拍
                    if (data.getDistanceStart() == Attention.Distance.kp5) {
                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.setText(R.id.number_p_tv, data.getSellState());
                        holder.setText(R.id.time_tv, "距开拍 10时30分");
                        holder.setTextBackground(R.id.time_tv, getContext().getResources().getColor(R.color._2196f3_bg));
                        // holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        // holder.findView(R.id.time_tv).setVisibility(View.GONE);


                    }


                    // 没有
                    if (data.getDistanceStart() == Attention.Distance.No3) {
                        holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                        holder.setText(R.id.attention_title, data.getTitle());  // 标题
                        holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                        holder.setText(R.id.attention_eara, data.getEara()); //  面积
                        holder.setText(R.id.attention_time, data.getTime());  // 时间
                        holder.setText(R.id.number_p_tv, data.getSellState());
                        // holder.setText(R.id.time_tv,data.getSellState()+"距开拍 10时30分");
                        // holder .setTextBackground(R.id.time_tv,R.color._2196f3_bg);
                        holder.findView(R.id.number_p_tv).setVisibility(View.GONE);
                        holder.findView(R.id.time_tv).setVisibility(View.GONE);

                    }


                }




              /*  holder.setImg(R.id.attention_iv, data.getImgUrl());  // 图片
                holder.setText(R.id.attention_title, data.getTitle());  // 标题
                holder.setText(R.id.attention_location, data.getLocaiton());  //位置
                holder.setText(R.id.attention_eara, data.getEara()); //  面积
                holder.setText(R.id.attention_time, data.getTime());  // 时间
                holder.setText(R.id.time_tv, data.getDelayTime());   //  右边 时间
                holder.setTextBackground(R.id.time_tv, rightTextBackground());   //  右边 时间 背景
                holder.setTextColor(R.id.time_tv, rightTextColor());   //  右边 时间 字体颜色
                holder.setText(R.id.number_p_tv, data.getSellState());   //  左下拍卖状态
*/
            }
        };


        pullLoadMoreRecyclerView.setAdapter(pull_Mark_releaseComplteRecyclerAdapter);
        pullLoadMoreRecyclerView.setFooterViewText("正在加载……");


        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        onRefreshDate();

                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                    }

                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        onLoadMoreDate();
                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();

                    }
                }, 1000);


            }
        });


        //添加点击事件
        pull_Mark_releaseComplteRecyclerAdapter.setOnItemClickListener(new Pull_Mark_releaseComplteRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View view, int position) {

                Attention.Distance  DistanceStart = initListData().get(position).getDistanceStart();



                //   1  待审核详情  2  通过的详情  3  已退回的详情  4  上拍详情

                if (type() == 1) {
                    Toast.makeText(getContext(), "待审核详情", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), DateilsActivity.class);
                    startActivity(intent);
                }

                if (type() == 2) {
                    Toast.makeText(getContext(), "通过的详情", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), UnpublishedDateilsActivity.class);
                    startActivity(intent);
                }


                if (type() == 3) {
                    Toast.makeText(getContext(), "已退回的详情", Toast.LENGTH_LONG).show();
                    // Intent intent = new Intent(getContext(), DateilsActivity.class);
                    // startActivity(intent);
                }


                if (type() == 4 && DistanceStart == Attention.Distance.ys6) {
                    Toast.makeText(getContext(), "上拍详情 延时", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), UnpublishedDateilsActivity.class);
                    startActivity(intent);
                }


                if (type() == 4 && DistanceStart == Attention.Distance.Finish4) {
                    Toast.makeText(getContext(), "上拍详情 进行中", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), BaterDateilsActivity.class);
                    startActivity(intent);

                }


                if (type() == 4 && DistanceStart == Attention.Distance.No3) {
                    Toast.makeText(getContext(), "上拍详情 已完成", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), SucceesDateilsActivity.class);
                    startActivity(intent);
                }

                if (type() == 4 && DistanceStart == Attention.Distance.kp5) {
                    Toast.makeText(getContext(), "上拍详情 延时", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), UnpublishedDateilsActivity.class);
                    startActivity(intent);
                }



               /* if (type() == 4 || background == 3) {
                    Toast.makeText(getContext(), "已结束的", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), SucceesDateilsActivity.class);
                    startActivity(intent);

                }

                if (type() == 4 || background == 1) {
                    Toast.makeText(getContext(), "上拍延时的", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), BaterDateilsActivity.class);
                    startActivity(intent);

                }
               */

                //  Intent intent = new Intent(getContext(), DateilsActivity.class);
                // startActivity(intent);

            }
        });


    }


// 初始化数据

   /* private List<Attention> initData_rv() {
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
        return attentionList;
    }
*/


/*
    //刷新数据

    public List<Attention> onRefreshDate() {

        attentionList.clear();
        Attention attention;
        for (int i = 0; i < 3; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("西溪北苑" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setTime("一拍中 刷新的数据");
            attentionList.add(attention);

        }
        return attentionList;
    }

//  加载数据
    public List<Attention> onLoadMoreDate() {

        Attention attention;
        for (int i = 0; i < 3; i++) {
            attention = new Attention();
            attention.setImgUrl(img);
            attention.setTitle("西溪北苑" + i + "号楼");
            attention.setLocaiton("浙江杭州市");
            attention.setEara("面积1" + i + "0平方");
            attention.setTime("一拍中 加载数据");
            attentionList.add(attention);
        }

        return attentionList;
    }


    */


}
