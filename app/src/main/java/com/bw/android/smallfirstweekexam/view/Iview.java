package com.bw.android.smallfirstweekexam.view;

import com.bw.android.smallfirstweekexam.entify.FoodBean;

import java.util.List;

public interface Iview {
    void loadDataSuccess(List<FoodBean.DataBean> list);

    void loadDataFail();
}
