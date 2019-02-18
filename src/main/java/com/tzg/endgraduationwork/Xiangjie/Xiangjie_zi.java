package com.tzg.endgraduationwork.Xiangjie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.JiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class Xiangjie_zi extends AppCompatActivity {
    private TextView myzi,xjstring;
    private JiGuoBean.ResultBean resultBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangjie_zi);
        getSupportActionBar().hide();
        myzi = (TextView)findViewById(R.id.myzi);
        xjstring = (TextView)findViewById(R.id.xjstring);
        xjstring.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        resultBean = (JiGuoBean.ResultBean) intent.getSerializableExtra("zi");
        myzi.setText(resultBean.getZi());
        xjstring.setText(changString(resultBean.getXiangjie()));
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
