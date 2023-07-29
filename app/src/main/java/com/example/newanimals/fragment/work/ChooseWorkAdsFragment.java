package com.example.newanimals.fragment.work;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.work.head.WorkHeadFragment1;
import com.example.newanimals.fragment.work.worker.WorkWorkerFragment1;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class ChooseWorkAdsFragment extends BaseFragment {
    @BindView(R.id.rezume)
    LinearLayout rezume;
    @BindView(R.id.vakansii)
    LinearLayout vakansii;

    @BindView(R.id.close_btn)
    ImageView closeBtn;

    public static ChooseWorkAdsFragment newInstance() {
        return new ChooseWorkAdsFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        rezume.setOnClickListener(v->{
            SPHelper.setVidAds("rezume");
            ((CreateAdsActivity)getActivity()).replaceFragment(WorkWorkerFragment1.newInstance(), true);
        });
        vakansii.setOnClickListener(v->{
            SPHelper.setVidAds("vakansii");
            ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment1.newInstance(), true);
        });
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.choose_work_ads_layout;
    }
}
