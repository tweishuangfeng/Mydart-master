package com.example.administrator.mydart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2018/3/30.
 */

public class Fragment1  extends Fragment {

    private  View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.fragment01, null);

        ImageButton btn1 = view.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activityplayersel.class);
                startActivity(intent);
            }
        });

        return  view;

    }



}
