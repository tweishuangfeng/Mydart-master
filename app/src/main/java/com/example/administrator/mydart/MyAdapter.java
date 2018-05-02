package com.example.administrator.mydart;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mydart.bean.HistoryScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * Created by Administrator on 2018/4/8.
 */

public class MyAdapter  extends BaseAdapter {


    private LayoutInflater mInflater;


    private Context mContext;
    private List<HistoryScore> mdata;




    public MyAdapter(List<HistoryScore> mdata,Context context) {

        this.mdata=mdata;

        this.mInflater = LayoutInflater.from(context);

    }



    @Override
    public int getCount() {
        return  mdata==null?0:mdata.size();
    }

    @Override
    public HistoryScore getItem(int position) {
        return   mdata.get(position);
    }


    @Override
    public long getItemId(int position) {
        return  position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView= mInflater.inflate(R.layout.my_listitem,null);



        HistoryScore historyScore=getItem(position);
        //在view视图中查找控件

        TextView  titletext= (TextView) convertView.findViewById(R.id.itemTitle);
        TextView  scoretext= (TextView) convertView.findViewById(R.id.score);


        titletext.setText(historyScore.getTitleTextView());
        scoretext.setText(historyScore.getScoreTextView());
        return  convertView;




    }





    class ViewHolder {
        private TextView titleTextView;
        private TextView scoreTextView;
    }




}
