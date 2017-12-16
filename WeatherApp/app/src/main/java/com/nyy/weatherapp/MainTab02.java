package com.nyy.weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
public class MainTab02 extends Fragment{

  private View tab2View;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tab2View=inflater.inflate(R.layout.activity_second_fragment,container,false);
        return tab2View;
    }
}
