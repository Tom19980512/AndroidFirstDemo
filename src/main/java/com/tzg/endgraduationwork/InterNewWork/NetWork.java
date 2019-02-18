package com.tzg.endgraduationwork.InterNewWork;

import com.tzg.endgraduationwork.DataBean.JiGuoBean;
import com.tzg.endgraduationwork.DataBean.BSJiGuoBean;
import com.tzg.endgraduationwork.DataBean.PYJiGuoBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NetWork {
    @GET("query")
    public Observable<JiGuoBean> getJieGuo(@Query("key") String key, @Query("word") String zi);//根据汉字查找
    @GET("querybs")
    public Observable<BSJiGuoBean> getJieGuobs(@Query("key") String key, @Query("word") String zi, @Query("page") int page, @Query("isjijie") int jijie, @Query("isxiangjie") int xiangjie);//根据部首查找
    @GET("querypy")
    public Observable<PYJiGuoBean> getJieGuopy(@Query("key") String key, @Query("word") String zi, @Query("page") int page, @Query("isjijie") int jijie, @Query("isxiangjie") int xiangjie);//根据拼音查找
}
