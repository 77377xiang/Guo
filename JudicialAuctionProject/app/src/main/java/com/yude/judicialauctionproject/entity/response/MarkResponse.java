package com.yude.judicialauctionproject.entity.response;

/**
 * Created by hexiang on 17/3/19.
 */
public  class MarkResponse {

    private String imgUrl;  // 图
    private String title; //标题
    private String progressiveTime; //进行中
    private String locaiton; // 位置
    private String eara; // 面积
    private String time;  //  时间
    private String sellState;   //    拍卖状态  一拍 二拍  变卖
    private String lastTime;  // 右边 时间
    private String delayTime;//延时
    private int background_greed;// 状态标识
    private int txetColor; //
    private int distanceStart;  // 距离开始1   距离公告2     没有3    距结束4    距开拍5  延时6
    private String  backReason;  //回退原因


    public  static enum Distance {
        /**
         *  距离开始1
         */
        Start1(1),
        /**
         * 距离公告2
         */
        DistanceGg2(2),
        /**
         *   没有3
         */
        No3(3),
        /**
         * 距结束4
         */
        Finish4(4),
        /**
         * 距开拍5
         */
        kp5(5),
        /**
         * 延时6
         */
        ys6(6)
        ;


        private int index ;

        private Distance(int index ){
            this.index = index ;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }

        public  static Distance   valueOf(int  index){

            switch (index){

                case  0:
                case 1:
                    return  Start1;
                case 2:
                    return DistanceGg2;

                case 3:
                    return No3;


                case 4:
                    return Finish4;

                case 5:
                    return kp5;

                case 6:
                    return ys6;


                default:{

                    return  Start1;
                }

            }
        }

    }




    public Distance getDistanceStart() {
        return Distance.valueOf(distanceStart);
    }

    public void setDistanceStart(Distance distanceStart) {
        this.distanceStart = distanceStart.index;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgressiveTime() {
        return progressiveTime;
    }

    public void setProgressiveTime(String progressiveTime) {
        this.progressiveTime = progressiveTime;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public void setLocaiton(String locaiton) {
        this.locaiton = locaiton;
    }

    public String getEara() {
        return eara;
    }

    public void setEara(String eara) {
        this.eara = eara;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSellState() {
        return sellState;
    }

    public void setSellState(String sellState) {
        this.sellState = sellState;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public int getBackground_greed() {
        return background_greed;
    }

    public void setBackground_greed(int background_greed) {
        this.background_greed = background_greed;
    }

    public int getTxetColor() {
        return txetColor;
    }

    public void setTxetColor(int txetColor) {
        this.txetColor = txetColor;
    }

    public void setDistanceStart(int distanceStart) {
        this.distanceStart = distanceStart;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }




}
