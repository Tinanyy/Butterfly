package com.nyy.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;

public class MainTab04 extends Fragment {

    private View tab4View;
    private TextView btnLogout;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tab4View = inflater.inflate(R.layout.activity_forth_layout, container, false);
        btnLogout = tab4View.findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AVUser.getCurrentUser().logOut();
             //   startActivity(new Intent(MainTab04.this, LoginActivity.class));
              //  MainTab04.this.finish();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();


            //    Intent intent=new Intent("activity.loggou.kill.all.activities");
            //   sendBroadcast(intent); //发送广播
            }

        });
        return tab4View;
    }

    }








