package com.tzg.endgraduationwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tzg.endgraduationwork.InterNewWork.NetWork;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String BASEDATA = "http://v.juhe.cn/xhzd/";
    public Retrofit retrofit;
    public NetWork netWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutinto());

        btnSerListener();
        initUIRefor();
        initRetorfit();
        initNetWork();
    }

    public abstract void btnSerListener();

    public abstract void initUIRefor();

    public abstract int getLayoutinto();

    public void initNetWork() {
        netWork = retrofit.create(NetWork.class);
    }

    public void initRetorfit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEDATA)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initOkhttp())
                .build();
    }

    public OkHttpClient initOkhttp() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }
}
