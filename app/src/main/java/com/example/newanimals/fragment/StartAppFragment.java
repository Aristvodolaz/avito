package com.example.newanimals.fragment;

import android.os.Bundle;

import com.example.newanimals.R;

public class StartAppFragment extends BaseFragment{

    //todo need to create .xml

    public static StartAppFragment newInstance() {
        return new StartAppFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.start_app_fragment;
    }

    @Override
    protected void initViews() {
        super.initViews();

    }
}
