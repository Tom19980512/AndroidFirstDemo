package com.tzg.endgraduationwork.Xiangjie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.PYJiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class Xiangjie_py extends AppCompatActivity {
    private TextView mypy,xjstring;
    private PYJiGuoBean.ResultBean.ListBean pyresultBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangjie_py);
        getSupportActionBar().hide();
        mypy=(TextView)findViewById(R.id.mypy);
        xjstring=(TextView)findViewById(R.id.xjstring);
        xjstring.setMovementMethod(ScrollingMovementMethod.getInstance());
        Intent intent = getIntent();
        pyresultBean = (PYJiGuoBean.ResultBean.ListBean) intent.getSerializableExtra("py");
        mypy.setText(pyresultBean.getZi());
        xjstring.setText(changString(pyresultBean.getXiangjie()));
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
