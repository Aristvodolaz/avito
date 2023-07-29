package com.example.newanimals.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.biznes.CreateBiznesAdsFragment;
import com.example.newanimals.fragment.car.ChooseCarAdsFragment;
import com.example.newanimals.fragment.house.ChooseHouseAdsFragment;
import com.example.newanimals.fragment.service.CreateServiceAdsFragment;
import com.example.newanimals.fragment.work.ChooseWorkAdsFragment;
import com.example.newanimals.utils.SPHelper;


import butterknife.BindView;

public class CreateAdsFragment extends  BaseFragment{

    @BindView(R.id.transport)
    LinearLayout transport;
    @BindView(R.id.work)
     LinearLayout work;
    @BindView(R.id.biznes)
    LinearLayout biznes;
    @BindView(R.id.other)
    LinearLayout other;
    @BindView(R.id.service)
    LinearLayout service;
    @BindView(R.id.house)
    LinearLayout house;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    public static CreateAdsFragment newInstance() {
        return  new CreateAdsFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        transport.setOnClickListener(v->{
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseCarAdsFragment.newInstance(), true);
            SPHelper.setTypeAds("car");
        });
        house.setOnClickListener(v->{
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseHouseAdsFragment.newInstance(), true);
            SPHelper.setTypeAds("house");
        });
        work.setOnClickListener(v->{
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseWorkAdsFragment.newInstance(), true);
            SPHelper.setTypeAds("work");
        });
        service.setOnClickListener(v->{
            SPHelper.setTypeAds("service");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateServiceAdsFragment.newInstance(), true);

        });
        other.setOnClickListener(v->{
            SPHelper.setTypeAds("other");
        });
        biznes.setOnClickListener(v->{
            SPHelper.setTypeAds("biznes");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateBiznesAdsFragment.newInstance(), true);
        });

        closeBtn.setOnClickListener(vii->{
            getActivity().finish();
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.create_ads_fragment_layout;
    }
}
