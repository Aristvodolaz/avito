package com.example.newanimals.fragment.biznes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class ChooseTypeBiznesFragment extends BaseFragment {
    @BindView(R.id.it)
    LinearLayout it;
    @BindView(R.id.eda)
    LinearLayout eda;
    @BindView(R.id.proizvodstvo)
    LinearLayout proizvodstvo;
    @BindView(R.id.razvlechenia)
    LinearLayout razvlechenia;
    @BindView(R.id.sh)
    LinearLayout sh;
    @BindView(R.id.building)
    LinearLayout building;
    @BindView(R.id.service)
    LinearLayout service;
    @BindView(R.id.shop)
    LinearLayout shop;
    @BindView(R.id.auto)
    LinearLayout auto;
    @BindView(R.id.krasota)
    LinearLayout krasota;
    @BindView(R.id.teth)
    LinearLayout teth;
    @BindView(R.id.tourizm)
    LinearLayout tourizm;
    @BindView(R.id.other)
    LinearLayout other;
    @BindView(R.id.close_btn)
    ImageView closeBtn;

    @Override
    protected void initViews() {
        super.initViews();
        closeBtn.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        it.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Интернет-магазины и IT");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        eda.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Общественное питание");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        proizvodstvo.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Производство");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        razvlechenia.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Развлечения");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        sh.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Сельское хозяйство");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        service.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Сфера услуг");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        building.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Строительство");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        shop.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Магазины и пункты выдачи заказов");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        auto.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Автобизнес");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        krasota.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Красота и уход");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        teth.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Стоматология и медицина");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        tourizm.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Туризм");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
        other.setOnClickListener(l->{
            SPHelper.BizznesHelper.setTypeBiznes("Другое");
            ((CreateAdsActivity)getActivity()).replaceFragment(OpisanieBiznesFragment.newInstance(), true);
        });
    }

    public static ChooseTypeBiznesFragment newInstance() {
        return new ChooseTypeBiznesFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.choose_type_biznes_fragment;
    }
}
