package com.bw.android.smallfirstweekexam.presenter;

import com.bw.android.smallfirstweekexam.entify.FoodBean;
import com.bw.android.smallfirstweekexam.model.Imodel;
import com.bw.android.smallfirstweekexam.model.Model;
import com.bw.android.smallfirstweekexam.view.Iview;

import java.util.List;

public class Presenter implements Imodel {
    //p层是一个中介人的作用 接收m层发来的数据 并且传到v层
    Iview iview = null;
    Model model = new Model(this,"http://www.qubaobei.com/ios/cf/",
                            "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1",
                            "1","20","1");
    public Presenter(Iview iview){
        this.iview = iview;
    }

    public void handlerData(){
        model.getData();
    }

    @Override
    public void loadDataSuccess(List<FoodBean.DataBean> list) {
        iview.loadDataSuccess(list);
    }

    @Override
    public void loadDataFail() {

    }
}
