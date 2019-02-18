package com.tzg.endgraduationwork.XiangQinActivity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.tzg.endgraduationwork.BaseActivity;
import com.tzg.endgraduationwork.DataBean.BSJiGuoBean;
import com.tzg.endgraduationwork.DataBean.JiGuoBean;
import com.tzg.endgraduationwork.DataBean.PYJiGuoBean;
import com.tzg.endgraduationwork.Jianjie.Jianjie_bs;
import com.tzg.endgraduationwork.R;
import com.tzg.endgraduationwork.Xiangjie.Xiangjie_bs;

import java.util.List;

public class BsXiangJie extends BaseActivity {
    private TextView zi,py,bs,wb,bh,jianjie,xiangjie;
    private BSJiGuoBean.ResultBean.ListBean bsresultBean;
    private int count_xj = 0,count_jj = 0;
    @Override
    public void btnSerListener() {
        getSupportActionBar().hide();
        zi = (TextView)findViewById(R.id.xj_zi);
        py = (TextView)findViewById(R.id.xj_pinyin);
        bs = (TextView)findViewById(R.id.xj_bushou);
        wb = (TextView)findViewById(R.id.xj_wubi);
        bh = (TextView)findViewById(R.id.xj_bihua);
        jianjie = (TextView)findViewById(R.id.xj_jianjie);
        xiangjie = (TextView)findViewById(R.id.xj_xiangjie);
        jianjie.setMovementMethod(ScrollingMovementMethod.getInstance());
        xiangjie.setMovementMethod(ScrollingMovementMethod.getInstance());
        xiangjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_xj++;
                if(count_xj>=2){
                    Intent bs = new Intent(BsXiangJie.this,Xiangjie_bs.class);
                    bs.putExtra("bs",bsresultBean);
                    startActivity(bs);
                }
            }
        });
        jianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_jj++;
                if(count_jj>=2){
                    Intent bs = new Intent(BsXiangJie.this,Jianjie_bs.class);
                    bs.putExtra("bs",bsresultBean);
                    startActivity(bs);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void initUIRefor() {

        Intent intent = getIntent();
        bsresultBean = (BSJiGuoBean.ResultBean.ListBean) intent.getSerializableExtra("bs");
        zi.setText(bsresultBean.getZi());
        py.setText(bsresultBean.getPinyin());
        bs.setText(bsresultBean.getBushou());
        wb.setText(bsresultBean.getWubi());
        bh.setText(bsresultBean.getBihua());
        jianjie.setText(changString(bsresultBean.getJijie()));
        xiangjie.setText(changString(bsresultBean.getXiangjie()));

    }

    @Override
    public int getLayoutinto() {
        return R.layout.activity_xj_bs;
    }
    //拼接字符串
    public String changString(List<String> list){
        StringBuilder csvBuilder = new StringBuilder();
        for(String bs : list){
            csvBuilder.append(bs);
            csvBuilder.append(",");
        }
        return csvBuilder.toString();
    }
}
