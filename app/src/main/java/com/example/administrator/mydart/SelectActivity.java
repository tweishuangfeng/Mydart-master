package com.example.administrator.mydart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2018/3/30.
 */

public class SelectActivity  extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ImageButton btnback=(ImageButton)findViewById(R.id.back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });




        ImageButton btnsoft=(ImageButton)findViewById(R.id.soft);

        btnsoft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(SelectActivity.this,GameActivity.class);
                startActivity(intent2);
            }
        });


    }








}
