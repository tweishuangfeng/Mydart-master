package com.example.administrator.mydart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/30.
 */

public class Activityplayersel extends Activity {


    private Button startbtn;
    private CheckBox mycheckbox;

    private  Toast toast;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playersel);


        ImageButton backbtn=(ImageButton)findViewById(R.id.back);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Activityplayersel.this,Fragment1.class);
                startActivity(intent2);
            }
        });





//        final CheckBox imagebtn1=(CheckBox)findViewById(R.id.imagebtn1);
//
//        imagebtn1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if(event.getAction() == MotionEvent.ACTION_DOWN){
//
//                    imagebtn1.setImageResource(R.drawable.player1selct);
//                    imagebtn1.
//
//                }else if(event.getAction() == MotionEvent.ACTION_UP){
//                    imagebtn1.setImageResource(R.drawable.player1);
//
//                }
//
//                    return false;
//            }
//        });





        startbtn=(Button)findViewById(R.id.start);
        mycheckbox=(CheckBox)findViewById(R.id.imagebtn1);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mycheckbox.isChecked()){

                    Intent intent1=new Intent(Activityplayersel.this,Activity301.class);
                    startActivity(intent1);
                }else{

                    toast=Toast.makeText(getApplicationContext(),"请至少选择一位玩家",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();


                }

            }
        });

    }








}
