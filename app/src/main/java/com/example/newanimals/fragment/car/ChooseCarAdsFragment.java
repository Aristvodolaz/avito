package com.example.newanimals.fragment.car;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.CreateAdsFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class ChooseCarAdsFragment extends BaseFragment {

    @BindView(R.id.auto)
    LinearLayout auto;
    @BindView(R.id.moto)
    LinearLayout moto;
    @BindView(R.id.big_car)
    LinearLayout bigCar;
    @BindView(R.id.woter)
    LinearLayout water;
    @BindView(R.id.zapchasti)
    LinearLayout zapchasti;

    @BindView(R.id.close_btn)
    ImageView closeBtn;
    public static ChooseCarAdsFragment newInstance() {
        return new ChooseCarAdsFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        auto.setOnClickListener(view -> {
            SPHelper.setVidAds("auto");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateCarFragment1.newInstance(), true);
        });
        moto.setOnClickListener(v->{
            SPHelper.setVidAds("moto");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateCarFragment1.newInstance(), true);
        });
        bigCar.setOnClickListener(v->{
            SPHelper.setVidAds("bigCar");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateCarFragment1.newInstance(), true);
        });
        water.setOnClickListener(v->{
            SPHelper.setVidAds("water");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateCarFragment1.newInstance(), true);
        });
        zapchasti.setOnClickListener(v->{
            SPHelper.setVidAds("zapchasti");
            ((CreateAdsActivity)getActivity()).replaceFragment(CreateCarFragment1.newInstance(), true);
        });
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.cshoose_car_fragment_layout;
    }
}
