package com.bw.android.smallfirstweekexam.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.android.smallfirstweekexam.R;
import com.bw.android.smallfirstweekexam.entify.FoodBean;
import com.bw.android.smallfirstweekexam.presenter.Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *  Created by lsg on 2019/3/18
 *  M层与V层不互通 数据通过P层来获取
 */
public class MainActivity extends AppCompatActivity implements Iview{
    Unbinder unbinder;
    @BindView(R.id.rev_showdata)
    RecyclerView revShowdata;
    Presenter presenter = new Presenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initview();
    }
    //初始化控件
    private void initview() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        revShowdata.setLayoutManager(manager);
        revShowdata.setItemAnimator(new DefaultItemAnimator());
        revShowdata.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        presenter.handlerData();
    }
    //获取接口回调的数据 并且传到适配器
    @Override
    public void loadDataSuccess(List<FoodBean.DataBean> list) {
        FoodDataAdapter adapter = new FoodDataAdapter();
        adapter.refresh(list);
        revShowdata.setAdapter(adapter);
    }

    @Override
    public void loadDataFail() {
        Toast.makeText(this, "获取数据失败！", Toast.LENGTH_SHORT).show();
    }
}
