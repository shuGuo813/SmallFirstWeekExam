package com.bw.android.smallfirstweekexam.model;

import com.bw.android.smallfirstweekexam.entify.FoodBean;

import java.util.List;

public interface Imodel {
    void loadDataSuccess(List<FoodBean.DataBean> list);

    void loadDataFail();
}
