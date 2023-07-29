package com.example.newanimals.fragment;

import android.os.Bundle;

import com.example.newanimals.R;

public class PersonFragment extends BaseFragment{
    public static PersonFragment newInstance() {
        return new PersonFragment();
    }

    //todo need to create .xml
    @Override
    protected int layoutId() {
        return R.layout.person_fragment_layout;
    }
}
