package com.tzg.endgraduationwork.Xiangjie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.BSJiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class Xiangjie_bs extends AppCompatActivity {
    private TextView mybs,xjstring;
    private BSJiGuoBean.ResultBean.ListBean bsresultBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangjie_bs);
        getSupportActionBar().hide();
        mybs =(TextView)findViewById(R.id.mybs);
        xjstring=(TextView)findViewById(R.id.xjstring);
        xjstring.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        bsresultBean = (BSJiGuoBean.ResultBean.ListBean) intent.getSerializableExtra("bs");
        mybs.setText(bsresultBean.getZi());
        xjstring.setText(changString(bsresultBean.getXiangjie()));
    }
    public String changString(List<String> list){
        StringBuilder csvBuilder = new StringBuilder();
        for(String zi : list){
            csvBuilder.append(zi);
            csvBuilder.append(",");
        }
        return csvBuilder.toString();
    }
}
