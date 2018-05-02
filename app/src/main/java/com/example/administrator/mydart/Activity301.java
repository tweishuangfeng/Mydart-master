package com.example.administrator.mydart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.administrator.mydart.bean.HistoryScore;

import java.net.URL;
import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.administrator.mydart.Utils.videoUrllow;

/**
 * Created by Administrator on 2018/3/31.
 */

public class Activity301  extends Activity {


    private ListView listview = null;


    private TextView mtextview;

    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;


    private TextView huihetitle;
    private TextView baifenbi;
    private int currentscore;
    private int screenscore = 301;

    private MediaPlayer mediaPlayer1;


    private int tag1 = 0;
    private int tag2 = 0;
    private int tag3 = 0;

    public int sum1;
    public int sum2;
    public int sum3;
    public int sumtotal;
    private int i = 0;
    private int count = 0;


    private SoundPool soundPool;
    private VideoView videoView;

    private VideoViewDemo videoViewDemo;


    private MyAdapter myAdapter;


    //List<HistoryScore> scoreList=new ArrayList<>();





    private final int GETCHECK1DATA_CODE = 101;
    private final int GETCHECK2DATA_CODE = 102;
    private final int GETCHECK3DATA_CODE = 103;






    HistoryScore historyScore =new HistoryScore();


    private List<HistoryScore> scoreList ;



    private List<HistoryScore> mData;



    final Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {




                case GETCHECK1DATA_CODE:

                    sumtotal=sum1+sum2+sum3;


                    screenscore = currentscore - sum1;


                    System.out.println(sum1);
                    System.out.println(count);



                    Toast.makeText(getApplicationContext(), "" + sum1, Toast.LENGTH_SHORT).show();

                    i = ++i;









                    huihetitle.setText("回合数");
                    baifenbi.setText(i + "/10");




                    List<HistoryScore> scoreList=new ArrayList<HistoryScore>();

                    historyScore.setScoreTextView("" + sum1 + "\n");

                    historyScore.setTitleTextView("R" + (i) + "\n");




                    scoreList.add(historyScore);


                    myAdapter = new MyAdapter(scoreList, Activity301.this);



                    mtextview.setText("" + screenscore);

                    listview.setAdapter(myAdapter);

                    //  }


                    break;

                case GETCHECK2DATA_CODE:


                    screenscore = currentscore - sum2;




                    System.out.println(sum2);

                    Toast.makeText(getApplicationContext(), "" + sum2, Toast.LENGTH_SHORT).show();




                    scoreList= new ArrayList<HistoryScore>();
                    historyScore.setScoreTextView("" + (sum2 + sum1) + "\n");
                    historyScore.setTitleTextView("R" + (i) + "\n");

                    System.out.println(scoreList.toArray());


                    scoreList.add(historyScore);


                    myAdapter = new MyAdapter(scoreList, Activity301.this);







                    mtextview.setText("" + screenscore);

                    listview.setAdapter(myAdapter);


                    break;


                case GETCHECK3DATA_CODE:


                    screenscore = 301-sum1-sum2 - sum3;



                    System.out.println(sum3);

                    Toast.makeText(getApplicationContext(), "" + sum3, Toast.LENGTH_SHORT).show();



                    huihetitle.setText("回合数");
                    baifenbi.setText(i + "/10");









                    scoreList= new ArrayList<HistoryScore>();
                    historyScore.setScoreTextView("" + (sum3 + sum2 + sum1) + "\n");
                    historyScore.setTitleTextView("R" + (i) + "\n");


                    scoreList.add(historyScore);





                    myAdapter = new MyAdapter(scoreList, Activity301.this);

                    mtextview.setText("" + screenscore);

                    listview.setAdapter(myAdapter);

                    break;

                default:
                    break;


            }



            mtextview.setText("" + screenscore);


            listview.setAdapter(myAdapter);



        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_301);


        mtextview = findViewById(R.id.screenscore);
        checkbox1 = (CheckBox) findViewById(R.id.dart1);
        checkbox2 = (CheckBox) findViewById(R.id.dart2);
        checkbox3 = (CheckBox) findViewById(R.id.dart3);


        huihetitle = (TextView) findViewById(R.id.huihetitle);
        baifenbi = (TextView) findViewById(R.id.baifenbi);

        listview = (ListView) findViewById(R.id.scorelist);


        //监听选中状态的改变

        checkbox1.setOnCheckedChangeListener(listener);
        checkbox2.setOnCheckedChangeListener(listener);
        checkbox3.setOnCheckedChangeListener(listener);


    }









        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               switch (buttonView.getId()){

                   case R.id.dart1:




                        new Thread(new Runnable(){

                           @Override
                           public void run() {

                               currentscore = screenscore;

                               tag1 = 1;
                               sum1 = (int) (Math.random() * 60 + 1);

                               //声音测试
                               if(sum1%2==0){

                                   mediaPlayer1=MediaPlayer.create(Activity301.this,R.raw.double_vi);
                                   mediaPlayer1.start();

                               }





                               Message message = new Message();
                               message.what = GETCHECK1DATA_CODE;;
                               mhandler.sendMessage(message);
                           }
                       }).start();


                        count++;

                       break;



                   case R.id.dart2:



                               currentscore = screenscore;

                               tag2 = 1;
                               sum2 = (int) (Math.random() * 60 + 1);



                               Message message = new Message();
                               message.what = GETCHECK2DATA_CODE;;
                               mhandler.sendMessage(message);

                               count++;

                       break;




                   case R.id.dart3:


                               currentscore = screenscore;

                               tag3 = 1;
                               sum3 = (int) (Math.random() * 60 + 1);


                                message = new Message();
                               message.what = GETCHECK3DATA_CODE;;
                               mhandler.sendMessage(message);


                               count++;

                       break;

                   default:

                       break;


               }

            }


        };


























//    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
//
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//
//        if(checkbox1.isChecked()||checkbox2.isChecked()||checkbox3.isChecked()) {
//
//
//            switch (buttonView.getId()) {
//
//
//                case R.id.dart1:
//
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//
//
//                            currentscore = screenscore;
//
//
//                            tag1 = 1;
//
//                            sum1 = (int) (Math.random() * 60 + 1);
//
//
//                            Message message = mhandler.obtainMessage();
//                            message.what = GETCHECK1DATA_CODE;
//                            mhandler.sendMessage(message);
//
//                        }
//                    }).start();
//
//
//                    break;
//
//                case R.id.dart2:
//
//
//                    tag2 = 1;
//
//                    sum2 = (int) (Math.random() * 60 + 1);
//
//                    currentscore = screenscore;
//
//
//                    Message message = mhandler.obtainMessage();
//                    message.what = GETCHECK2DATA_CODE;
//                    mhandler.sendMessage(message);
//
//
//                    break;
//
//                case R.id.dart3:
//
//
//                    tag3 = 1;
//
//                    sum3 = (int) (Math.random() * 60 + 1);
//
//                    currentscore = screenscore;
//
//
//                    message = mhandler.obtainMessage();
//                    message.what = GETCHECK3DATA_CODE;
//                    mhandler.sendMessage(message);
//
//
//                    break;
//
//
//                default:
//
//                    break;
//
//
//            }
//
//        }
//
//
//        }
//
//
//    };
//
//




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode==1){
            Activity301.this.onStart();
        }
    }



}















//}








