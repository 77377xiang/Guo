package com.yude.judicialauctionproject.fragment.markfagment.moreFragment;

import android.os.Bundle;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseFragment;
import com.yude.judicialauctionproject.entity.Attention;
import com.yude.judicialauctionproject.entity.response.MarkResponse;
import com.yude.judicialauctionproject.fragment.markfagment.MarkGroupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 财产结交
 */
public class AcceptFragment extends MarkGroupFragment {

    @Override
    public int type() {
        return 3;
    }

    @Override
    public List<MarkResponse> initListData() {


        List<MarkResponse>  markResponseList=new ArrayList<>();
        List<Attention> list=  initData_rv();
        for (int i = 0; i < list.size(); i++) {
            markResponseList.add(list.get(i));
        }

        //list.add(markResponseList.get(0));
        markResponseList.add(list.get(0));
        return markResponseList;
    }

    @Override
    public List<MarkResponse> onRefreshDate() {
        return null;
    }

    @Override
    public List<MarkResponse> onLoadMoreDate() {
        return null;
    }

    @Override
    public int rightTextColor() {

        return getContext().getResources().getColor(R.color._c82015);
    }

    @Override
    public int rightTextBackground() {

       // return getContext().getResources().getColor(R.color._ff5267_bg);
        return 0;
    }




    //初始化数据
    private List<Attention> initData_rv() {

        String img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489082859152&di=224fecb18f12855bc2ebcd59a0008c9d&imgtype=0&src=http%3A%2F%2Fpic1.xtuan.com%2Fupload%2Fxiaoguotu%2F20130114%2F20130114154605271293.jpg";
        List<Attention> attentionList = new ArrayList<>();



        Attention attention0;
        attention0 = new Attention();
        attention0.setImgUrl(img);
        attention0.setTitle("城西银泰" + 1 + "号楼");
        attention0.setLocaiton("浙江杭州市");
        attention0.setEara("面积1" + 1 + "0平方");
        attention0.setLastTime("2017年3月 17:45");
        attention0.setTime("2017年6月3日  8:30");
        attention0.setDelayTime("延时 04:30");
        attention0.setSellState("一拍");
        attention0.setBackReason("证件不齐全");
        attention0.setDistanceStart(6);
        attentionList.add(attention0);


        Attention attention;
        attention = new Attention();
        attention.setImgUrl(img);
        attention.setTitle("城西银泰" + 2 + "号楼");
        attention.setLocaiton("浙江杭州市");
        attention.setEara("面积1" + 2 + "0平方");
        attention.setLastTime("2017年3月 17:45");
        attention.setTime("2017年6月3日  8:30");
        attention.setDelayTime("延时 04:30");
        attention.setSellState("二拍");
        attention.setBackReason("房产有纠纷");
        attention.setDistanceStart(4);
        attentionList.add(attention);




        Attention attention1;
        attention1 = new Attention();
        attention1.setImgUrl(img);
        attention1.setTitle("城西银泰" + 4 + "号楼");
        attention1.setLocaiton("浙江杭州市");
        attention1.setEara("面积1" + 4 + "0平方");
        attention1.setLastTime("2017年3月 17:45");
        attention1.setTime("2017年6月3日  8:30");
        attention1.setDelayTime("延时 04:30");
        attention1.setSellState("变拍");
        attention1.setBackReason("厂房不明确");
        attention1.setDistanceStart(5);
        attentionList.add(attention1);



        Attention attention3;
        attention3 = new Attention();
        attention3.setImgUrl(img);
        attention3.setTitle("城西银泰" + 3 + "号楼");
        attention3.setLocaiton("浙江杭州市");
        attention3.setEara("面积1" + 3 + "0平方");
        attention3.setLastTime("2017年3月 17:45");
        attention3.setTime("2017年6月3日  8:30");
        attention3.setDelayTime("延时 04:30");
        attention3.setSellState("一拍");
        attention1.setBackReason("厂房已塌陷");
        attention3.setDistanceStart(3);
        attentionList.add(attention3);

        return attentionList;
    }


}




