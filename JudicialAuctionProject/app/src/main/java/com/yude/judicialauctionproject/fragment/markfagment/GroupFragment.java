package com.yude.judicialauctionproject.fragment.markfagment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

/**
 * 关于标的fragment 封装复用
 */
public abstract class GroupFragment extends BaseFragment {

    // private int type;

    // private  int background_red = 1;//延时
    // private  int background_greed = 2 ;//进行中
    // private  int background_red_j = 3;// 已结束

    int background;

    public abstract int type();

    public abstract List<Attention> initListData();

    public abstract int itemId();

    public abstract List<Attention> onRefreshDate();

    public abstract List<Attention> onLoadMoreDate();


    PullLoadMoreRecyclerView pullLoadMoreRecyclerView;
    private Pull_Mark_releaseComplteRecyclerAdapter<Attention> pull_Mark_releaseComplteRecyclerAdapter;
    // private List<Attention> attentionList;
    private String img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489119016935&di=e562bb3b7bdf57de43494c3ced7c3542&imgtype=0&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2Fda017cffgx6BpgriqtA72%26690";

    @Override
    public int getContentViewId() {
        return R.layout.fragment_mark_group;

    }


    @Override
    protected void initViews(Bundle bundle) {
        pullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) rootView.findViewById(R.id.group_rv);
        pullLoadMoreRecyclerView.setLinearLayout();
//  R.layout.item_pull_mark_rv_relesecompiete
        //  initData_rv();
        initListData();
        pull_Mark_releaseComplteRecyclerAdapter = new Pull_Mark_releaseComplteRecyclerAdapter<Attention>(getContext(), initListData(), itemId()) {
            @Override
            public void convert(RecycleHolder holder, Attention data, int position) {

               // background = data.getBackground_greed();

                //没有时间背景
                if (itemId() == R.layout.item_groupfragment_nobackground) {
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());

                }

                // 有背景的红色
                if (itemId() == R.layout.item_groupfragment_background ) {
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextBackground(R.id.time_tv, 0xffff5267);
                    holder.setText(R.id.time_tv,data.getDelayTime());

                }

                // 有背景的 绿色
                if (itemId() == R.layout.item_groupfragment_background && position==1&&type()==4) {
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextBackground(R.id.time_tv, 0xff3eee9d);
                   // holder.setText(R.id.time_tv,data.getDelayTime());
                    holder.setText(R.id.time_tv,data.getProgressiveTime());


                }


                // 无背景 已完成
                if (itemId() == R.layout.item_groupfragment_background && position ==2 && type() ==4) {
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextBackground(R.id.time_tv, 0xfff0f0f0);
                    holder.setText(R.id.time_tv,"已结束");

                }


                // 无背景  字体红色的
                if (itemId() == R.layout.item_groupfragment_redtext ) {
                    holder.setText(R.id.time_tv, data.getLastTime());
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextColor(R.id.time_tv,0xffc82015);

                   // holder.setTextBackground(R.id.time_tv, 0xffe96f8a);

                }

/*





                //  时间背景未绿    进行中
                if (itemId() == R.layout.item_groupfragment_background && background == 2) {

                    holder.setText(R.id.time_tv, data.getLastTime());
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextBackground(R.id.time_tv, 0xff3eee9d);

                }

                //时间背景为红   时间背景为红 延时
                if (itemId() == R.layout.item_groupfragment_background && background == 1) {

                    holder.setText(R.id.time_tv, data.getLastTime());
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextBackground(R.id.time_tv, 0xfffefefe);


                }

                // 时间背景未红   已结束
                if (itemId() == R.layout.item_groupfragment_background && background == 3) {

                    holder.setText(R.id.time_tv, data.getLastTime());
                    holder.setImg(R.id.attention_iv, data.getImgUrl());
                    holder.setText(R.id.attention_title, data.getTitle());
                    holder.setText(R.id.attention_location, data.getLocaiton());
                    holder.setText(R.id.attention_eara, data.getEara());
                    holder.setText(R.id.attention_time, data.getTime());
                    holder.setTextBackground(R.id.time_tv, 0xfffefefe);
                    holder.setText(R.id.attention_time, "已结束");
                }

*/



               /* holder.setImg(R.id.attention_iv, data.getImgUrl());
                holder.setText(R.id.attention_title, data.getTitle());
                holder.setText(R.id.attention_location, data.getLocaiton());
                holder.setText(R.id.attention_eara, data.getEara());
                holder.setText(R.id.attention_time, data.getTime());
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

                        Log.i("ssss", onRefreshDate().size() + "");
                        pull_Mark_releaseComplteRecyclerAdapter.notifyDataSetChanged();
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                    }

                }, 3000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        onLoadMoreDate();
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


                if (type() == 4 && position==0) {
                    Toast.makeText(getContext(), "上拍详情 延时", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), UnpublishedDateilsActivity.class);
                    startActivity(intent);
                }


                if (type() == 4 &&position==1) {
                    Toast.makeText(getContext(), "上拍详情 进行中", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), BaterDateilsActivity.class);
                    startActivity(intent);

                }


                if (type() == 4 &&position==2) {
                    Toast.makeText(getContext(), "上拍详情 已完成", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), SucceesDateilsActivity.class);
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






   /* private void initData_rv() {
        attentionList =  initListData();

       // attentionList = new ArrayList<>();
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
*/


}
