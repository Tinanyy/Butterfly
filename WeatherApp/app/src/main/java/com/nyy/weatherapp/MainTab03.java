package com.nyy.weatherapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainTab03 extends Fragment {

    private View tab3View;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tab3View=inflater.inflate(R.layout.activity_third_fragment,container,false);
        return tab3View;
    }
}
