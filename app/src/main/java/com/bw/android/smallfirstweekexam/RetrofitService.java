package com.bw.android.smallfirstweekexam;

import com.bw.android.smallfirstweekexam.entify.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    //http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
    @GET("dish_list.php?")
    Observable<FoodBean> getData(@Query("stage_id") String stage_id,
                                @Query("limit") String limit,
                                 @Query("page") String page);

}
