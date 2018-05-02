package com.example.administrator.mydart;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Administrator on 2018/4/10.
 */

public class VideoViewDemo  extends Activity  {

    private String path;

    private MyVideoView mVideoView;

    private String str;


    @Override
    protected void onCreate(  Bundle icicle ) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.videoview);

        mVideoView=(MyVideoView)findViewById(R.id.surface_view);

        mVideoView.setOnCompletionListener(new MyPlayerOnCompletionListener());

        DisplayMetrics dm=new DisplayMetrics();


        this.getWindowManager().getDefaultDisplay().getMetrics(dm);


        MyVideoView.WIDTH=dm.widthPixels;
        MyVideoView.HEIGHT=dm.heightPixels;

        if(path==""){

            Toast.makeText(this,"视频播放格式错误",Toast.LENGTH_SHORT).show();

        }else  {


            Intent intent=getIntent();
            Bundle b=intent.getExtras();
            setResult(RESULT_OK,intent);

            str=b.getString("str1");




            mVideoView.setVideoURI(Uri.parse("android.resource://com.example.administrator.mydart/"+str));

            mVideoView.start();


        }



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
       // System.exit(0);










    }



    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( VideoViewDemo.this, "本视频由西浦国际提供，请勿抄袭", Toast.LENGTH_SHORT).show();


            finish();

        }
    }



    //    @Override
//    public void onCompletion(MediaPlayer mp) {
//
//        System.out.println("本视频由西浦国际提供，请勿抄袭");
//    }




}
