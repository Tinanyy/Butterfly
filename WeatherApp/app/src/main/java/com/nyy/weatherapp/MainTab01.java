package com.nyy.weatherapp;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainTab01 extends Fragment{
  private View tab1View;
@Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tab1View= inflater.inflate(com.nyy.weatherapp.R.layout.activity_first_fragment,container,false);
        return tab1View;
    }
}
