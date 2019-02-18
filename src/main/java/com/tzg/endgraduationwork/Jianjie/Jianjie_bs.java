package com.tzg.endgraduationwork.Jianjie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.BSJiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class Jianjie_bs extends AppCompatActivity {
    private TextView mybs,jjstring;
    private BSJiGuoBean.ResultBean.ListBean bsresultBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jianjie_bs);
        getSupportActionBar().hide();
        mybs =(TextView)findViewById(R.id.mybs);
        jjstring=(TextView)findViewById(R.id.jjstring);
        jjstring.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        bsresultBean = (BSJiGuoBean.ResultBean.ListBean) intent.getSerializableExtra("bs");
        mybs.setText(bsresultBean.getZi());
        jjstring.setText(changString(bsresultBean.getJijie()));
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
