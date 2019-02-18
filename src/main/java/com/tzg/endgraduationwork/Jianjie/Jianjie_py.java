package com.tzg.endgraduationwork.Jianjie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.PYJiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class Jianjie_py extends AppCompatActivity {
    private TextView mypy,jjstring;
    private PYJiGuoBean.ResultBean.ListBean pyresultBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jianjie_py);
        getSupportActionBar().hide();
        mypy=(TextView)findViewById(R.id.mypy);
        jjstring=(TextView)findViewById(R.id.jjstring);
        jjstring.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        pyresultBean = (PYJiGuoBean.ResultBean.ListBean) intent.getSerializableExtra("py");
        mypy.setText(pyresultBean.getZi());
        jjstring.setText(changString(pyresultBean.getJijie()));
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
