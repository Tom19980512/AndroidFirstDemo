package com.tzg.endgraduationwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tzg.endgraduationwork.Activity.BsActivity;
import com.tzg.endgraduationwork.Activity.PyActivity;
import com.tzg.endgraduationwork.Activity.ZiActivity;

public class MainActivity extends AppCompatActivity {
    private Button zi,py,bs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        findById();
        zi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZiActivity.class);
                startActivity(intent);
            }
        });

        py.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PyActivity.class);
                startActivity(intent);
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BsActivity.class);
                startActivity(intent);
            }
        });

    }
    public void findById(){
        zi = (Button) findViewById(R.id.btn_zi);
        py = (Button) findViewById(R.id.btn_py);
        bs = (Button) findViewById(R.id.btn_bs);
    }
}
