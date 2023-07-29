package com.example.newanimals.fragment.house;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.ChooseTypeForSaleFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class ChooseHouseAdsFragment extends BaseFragment {
    @BindView(R.id.flate)
    LinearLayout flats;
    @BindView(R.id.house)
    LinearLayout house;
    @BindView(R.id.rooms)
    LinearLayout rooms;
    @BindView(R.id.garaji)
    LinearLayout garaji;
    @BindView(R.id.commercia)
    LinearLayout commercia;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    public static ChooseHouseAdsFragment newInstance() {
        return new ChooseHouseAdsFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        commercia.setOnClickListener(v->{
            SPHelper.setVidAds("commercia");
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTypeForSaleFragment.newInstance("Коммерческая недвижимость"), true);
        });
        house.setOnClickListener(v->{
            SPHelper.setVidAds("house");
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTypeForSaleFragment.newInstance("Дома, дачи, земельные участки"), true);
        });
        flats.setOnClickListener(v->{
            SPHelper.setVidAds("flats");
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTypeForSaleFragment.newInstance("Квартиры"), true);
        });
        garaji.setOnClickListener(v->{
            SPHelper.setVidAds("garaji");
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTypeForSaleFragment.newInstance("Гаражи и машиноместа"), true);
        });
        rooms.setOnClickListener(v->{
            SPHelper.setVidAds("rooms");
            ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTypeForSaleFragment.newInstance("Комнаты"), true);
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.choose_house_ads_fragment_layout;
    }
}
