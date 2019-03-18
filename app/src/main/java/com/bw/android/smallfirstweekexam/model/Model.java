package com.bw.android.smallfirstweekexam.model;

import com.bw.android.smallfirstweekexam.RetrofitService;
import com.bw.android.smallfirstweekexam.entify.FoodBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    Retrofit retrofit = null;
    String baseUrl;
    String dataUrl;
    String stage_id;
    String limit;
    String page;
    Imodel imodel = null;

    public Model(Imodel imodel,String baseUrl,String dataUrl,String stage_id,String limit,String page){
        this.baseUrl = baseUrl;
        this.dataUrl = dataUrl;
        this.imodel = imodel;
        this.limit = limit;
        this.page = page;
        this.stage_id = stage_id;
    }

    public void getData(){
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(RetrofitService.class)
                .getData(stage_id,limit,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
                        imodel.loadDataSuccess(foodBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
