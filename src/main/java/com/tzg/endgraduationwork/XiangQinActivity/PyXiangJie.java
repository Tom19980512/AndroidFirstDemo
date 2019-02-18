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
import com.tzg.endgraduationwork.Jianjie.Jianjie_py;
import com.tzg.endgraduationwork.R;
import com.tzg.endgraduationwork.Xiangjie.Xiangjie_py;

import java.util.List;

public class PyXiangJie extends BaseActivity {
    private TextView zi,py,bs,wb,bh,jianjie,xiangjie;
    private PYJiGuoBean.ResultBean.ListBean pyresultBean;
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
                    Intent py = new Intent(PyXiangJie.this,Xiangjie_py.class);
                    py.putExtra("py",pyresultBean);
                    startActivity(py);
                }
            }
        });
        jianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_jj++;
                if(count_jj>=2){
                    Intent py = new Intent(PyXiangJie.this,Jianjie_py.class);
                    py.putExtra("py",pyresultBean);
                    startActivity(py);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void initUIRefor() {
        Intent intent = getIntent();
        pyresultBean = (PYJiGuoBean.ResultBean.ListBean) intent.getSerializableExtra("py");
        zi.setText(pyresultBean.getZi());
        py.setText(pyresultBean.getPinyin());
        bs.setText(pyresultBean.getBushou());
        wb.setText(pyresultBean.getWubi());
        bh.setText(pyresultBean.getBihua());
        jianjie.setText(changString(pyresultBean.getJijie()));
        xiangjie.setText(changString(pyresultBean.getXiangjie()));

    }

    @Override
    public int getLayoutinto() {
        return R.layout.activity_xj_py;
    }
    //拼接字符串
    public String changString(List<String> list){
        StringBuilder csvBuilder = new StringBuilder();
        for(String py : list){
            csvBuilder.append(py);
            csvBuilder.append(",");
        }
        return csvBuilder.toString();
    }
}
