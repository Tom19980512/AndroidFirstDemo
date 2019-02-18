package com.tzg.endgraduationwork.Activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tzg.endgraduationwork.BaseActivity;
import com.tzg.endgraduationwork.DataBean.BSJiGuoBean;
import com.tzg.endgraduationwork.MyAdapter.BSAdapter;
import com.tzg.endgraduationwork.R;
import com.tzg.endgraduationwork.XiangQinActivity.BsXiangJie;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

public class BsActivity extends BaseActivity {
    private EditText editText;
    private ImageView btn_ser;
    private RecyclerView myrec;
    //艹 口
    private List<BSJiGuoBean.ResultBean.ListBean> bsDate = new ArrayList<BSJiGuoBean.ResultBean.ListBean>();
    private BSAdapter bsAdapter;

    private String MyKey = "bf1f9352094074c284aa3a2caad67b73";
    private String Old_word = "";
    private int page =1;

    @Override
    public void btnSerListener() {
        getSupportActionBar().hide();
        initFindById();
        btn_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().trim().equals("")&&rexStr(editText.getText().toString().trim())){
                    if(bsDate.size()==0){
                        NewWoke();
                    }
                    if(bsDate.size()>0){
                        if(!editText.getText().toString().trim().equals(Old_word)&&!editText.getText().toString().trim().equals("")){
                            bsDate.clear();
                            bsAdapter.setMadapterlist(bsDate);
                            NewWoke();
                        }else {
                            Toast.makeText(BsActivity.this,"您输入与上次输入相同",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(BsActivity.this,"您输入的为空或者输入有误",Toast.LENGTH_SHORT).show();
                }
            }
        });

        myrec.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case SCROLL_STATE_IDLE:
                        Log.e("onscroll","当前并不处于滑动状态");
                        break;
                    case SCROLL_STATE_DRAGGING:
                        page = page+1;
                        Log.e("page_bs","页数"+page);
                        addListBean(page);
                        Log.e("onscroll","当前RecyclerView处于滑动状态(手指在屏幕上)");
                        break;
                    case SCROLL_STATE_SETTLING:
                        bsAdapter.setMadapterlist(bsDate);
                        Log.e("onscroll","当前RecyclerView处于滑动状态(手已经离开屏幕)");
                        break;
                }
            }
        });
    }

    public void initUIRefor() {
        myrec.setLayoutManager(new LinearLayoutManager(this));
        bsAdapter = new BSAdapter();
        bsAdapter.setOnItem(new BSAdapter.OnItem() {
            @Override
            public void onItemClick(int position) {
                Log.e("onclike","点击第"+(position+1)+"条");
                Intent intent = new Intent(BsActivity.this,BsXiangJie.class);
                intent.putExtra("bs",bsDate.get(position));
                startActivity(intent);
            }
        });
        myrec.setAdapter(bsAdapter);
    }

    @Override
    public int getLayoutinto() {
        return R.layout.activity_bs;
    }

    public boolean rexStr(String str){
        String regx = "[\u4E00-\u9FA5]";
        if (str.matches(regx)){
            return true;
        }
        return false;
    }

    public void initFindById(){
        editText = (EditText) findViewById(R.id.ed_bs);
        btn_ser = (ImageView) findViewById(R.id.ser_bs);
        myrec = (RecyclerView) findViewById(R.id.recy);
    }
    public void NewWoke(){
        Old_word = editText.getText().toString().trim();
        netWork.getJieGuobs(MyKey,Old_word,page,1,1)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<BSJiGuoBean, List<BSJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public List<BSJiGuoBean.ResultBean.ListBean> call(BSJiGuoBean bsJiGuoBean) {
                        return bsJiGuoBean.getResult().getList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BSJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<BSJiGuoBean.ResultBean.ListBean> listBeans) {
                        Toast.makeText(BsActivity.this,"正在查询",Toast.LENGTH_SHORT).show();
                        bsDate.addAll(listBeans);
                        bsAdapter.setMadapterlist(bsDate);
                        Log.e("listsize","数据条目"+listBeans.size());
                    }
                });
    }
    public void addListBean(int page){
        netWork.getJieGuobs(MyKey,Old_word,page,1,1)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<BSJiGuoBean, List<BSJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public List<BSJiGuoBean.ResultBean.ListBean> call(BSJiGuoBean bsJiGuoBean) {
                        return bsJiGuoBean.getResult().getList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BSJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<BSJiGuoBean.ResultBean.ListBean> listBeans) {
                        Log.e("addListBean","正在调用addListBean进行查询");
                        bsDate.addAll(listBeans);
                        Log.e("addListBean","数据条目"+listBeans.size());
                    }
                });
    }
}
