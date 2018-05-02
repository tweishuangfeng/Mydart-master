package com.example.administrator.mydart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnsaoma=(ImageButton)findViewById(R.id.btn_saoma);



         btnsaoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"敬请期待",Toast.LENGTH_SHORT);
            }
        });


        Button login=(Button)findViewById(R.id.btn_login_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"敬请期待",Toast.LENGTH_SHORT);
            }
        });



        Button regist=(Button)findViewById(R.id.btn_login_regist);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"敬请期待",Toast.LENGTH_SHORT);

            }
        });



        ImageButton btnyouxi=(ImageButton)findViewById(R.id.youxi);
        btnyouxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,SelectActivity.class);
                startActivity(intent);
            }
        });



    }






}
