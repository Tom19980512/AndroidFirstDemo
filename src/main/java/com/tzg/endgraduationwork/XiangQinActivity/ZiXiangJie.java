package com.tzg.endgraduationwork.XiangQinActivity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.tzg.endgraduationwork.BaseActivity;
import com.tzg.endgraduationwork.DataBean.JiGuoBean;
import com.tzg.endgraduationwork.Jianjie.Jianjie_zi;
import com.tzg.endgraduationwork.R;
import com.tzg.endgraduationwork.Xiangjie.Xiangjie_zi;

import java.util.List;

public class ZiXiangJie extends BaseActivity {
    private TextView zi,py,bs,wb,bh,jianjie,xiangjie;
    private JiGuoBean.ResultBean resultBean;
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
                    Intent zi = new Intent(ZiXiangJie.this,Xiangjie_zi.class);
                    zi.putExtra("zi",resultBean);
                    startActivity(zi);
                }
            }
        });
        jianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_jj++;
                if(count_jj>=2){
                    Intent zi = new Intent(ZiXiangJie.this,Jianjie_zi.class);
                    zi.putExtra("zi",resultBean);
                    startActivity(zi);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void initUIRefor() {
        Intent intent = getIntent();
        resultBean = (JiGuoBean.ResultBean) intent.getSerializableExtra("zi");
        zi.setText(resultBean.getZi());
        py.setText(resultBean.getPinyin());
        bs.setText(resultBean.getBushou());
        wb.setText(resultBean.getWubi());
        bh.setText(resultBean.getBihua());
        jianjie.setText(changString(resultBean.getJijie()));
        xiangjie.setText(changString(resultBean.getXiangjie()));

    }

    @Override
    public int getLayoutinto() {
        return R.layout.activity_xj_zi;
    }

    //拼接字符串
    public String changString(List<String> list){
        StringBuilder csvBuilder = new StringBuilder();
        for(String zi : list){
            csvBuilder.append(zi);
            csvBuilder.append(",");
        }
        return csvBuilder.toString();
    }
}
