package com.yude.judicialauctionproject.entity.response;


import com.yude.judicialauctionproject.entity.base.BaseResponse;

import java.util.List;

public class TaskListResponse extends BaseResponse {

    private ResultEntity result;

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public static class ResultEntity {
        private int total;
        private int totalAll;


        /*private List<Task> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotalAll() {
            return totalAll;
        }

        public void setTotalAll(int totalAll) {
            this.totalAll = totalAll;
        }

        public List<Task> getRows() {
            return rows;
        }

        public void setRows(List<Task> rows) {
            this.rows = rows;
        }
*/

    }
}
