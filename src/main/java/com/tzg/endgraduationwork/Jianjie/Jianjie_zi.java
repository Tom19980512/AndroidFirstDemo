package com.tzg.endgraduationwork.Jianjie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.JiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class Jianjie_zi extends AppCompatActivity {
    private TextView myzi,jjstring;
    private JiGuoBean.ResultBean resultBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jianjie_zi);
        getSupportActionBar().hide();
        myzi = (TextView)findViewById(R.id.myzi);
        jjstring = (TextView)findViewById(R.id.jjstring);
        jjstring.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        resultBean = (JiGuoBean.ResultBean) intent.getSerializableExtra("zi");
        myzi.setText(resultBean.getZi());
        jjstring.setText(changString(resultBean.getJijie()));
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
