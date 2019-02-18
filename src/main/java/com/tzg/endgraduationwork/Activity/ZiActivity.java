package com.tzg.endgraduationwork.Activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tzg.endgraduationwork.BaseActivity;
import com.tzg.endgraduationwork.DataBean.JiGuoBean;
import com.tzg.endgraduationwork.MyAdapter.MainItemAdapter;
import com.tzg.endgraduationwork.R;
import com.tzg.endgraduationwork.XiangQinActivity.ZiXiangJie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ZiActivity extends BaseActivity {
    private EditText editText;
    private ImageView btn_ser;
    private RecyclerView myrec;
    private MainItemAdapter itemAdapter;
    private List<JiGuoBean.ResultBean> ziDate = new ArrayList<JiGuoBean.ResultBean>();
    private String MyKey = "bf1f9352094074c284aa3a2caad67b73";
    private String Old_word = "";



    @Override
    //草 料
    public void btnSerListener() {

        getSupportActionBar().hide();
        initFindById();
        btn_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断不能输入为空
                if (!editText.getText().toString().trim().equals("")&&rexStr(editText.getText().toString().trim())){
                    //判断是否为第一次搜索
                    if (ziDate.size()==0){//等于0 表示还未有成功搜索过
                        NewWoke();

                    }
                    //判断是否为第二次搜索
                    if(ziDate.size()>0){
                        if(!editText.getText().toString().trim().equals(Old_word)&&!editText.getText().toString().trim().equals("")){//判断与上一次输入不同
                            NewWoke();
                        }else{
                            Toast.makeText(ZiActivity.this,"您输入与上次输入相同",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(ZiActivity.this,"您输入的为空或者输入有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initUIRefor() {
            myrec.setLayoutManager(new LinearLayoutManager(this));
            itemAdapter = new MainItemAdapter();
            itemAdapter.setOnItem(new MainItemAdapter.OnItem() {
                @Override
                public void onItemClick(int position) {
                    Log.e("onclike","点击第"+(position+1)+"条");
                    Intent intent = new Intent(ZiActivity.this,ZiXiangJie.class);
                    intent.putExtra("zi",ziDate.get(position));
                    startActivity(intent);
                }
            });
            myrec.setAdapter(itemAdapter);
    }
    public void initFindById(){
        editText = (EditText) findViewById(R.id.ed_zi);
        btn_ser = (ImageView) findViewById(R.id.ser_zi);
        myrec = (RecyclerView) findViewById(R.id.recy);
    }
    @Override
    public int getLayoutinto() {
        return R.layout.activity_zi;
    }

    public boolean rexStr(String str){
        String regx = "[\u4E00-\u9FA5]";
        if (str.matches(regx)){
            return true;
        }
        return false;
    }
    public void NewWoke(){
        Old_word = editText.getText().toString().trim();
        netWork.getJieGuo(MyKey,editText.getText().toString().trim())
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<JiGuoBean,List<JiGuoBean.ResultBean>>() {
                    @Override
                    //Collections.singletonList
                    public List<JiGuoBean.ResultBean> call(JiGuoBean jiGuoBean) {
                        return Collections.singletonList(jiGuoBean.getResult());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<JiGuoBean.ResultBean>>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(List<JiGuoBean.ResultBean> resultBeans) {
                        Toast.makeText(ZiActivity.this,"正在查询",Toast.LENGTH_SHORT).show();
                        Log.e("zi",""+resultBeans.size());
                        ziDate = resultBeans;
                        itemAdapter.setMadapterlist(resultBeans);
                    }
                });
    }
}
