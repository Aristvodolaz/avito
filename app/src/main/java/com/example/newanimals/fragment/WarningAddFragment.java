package com.example.newanimals.fragment;

import android.os.Bundle;
import android.widget.Button;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.dialog.ChooseBottomDialog;

import butterknife.BindView;

public class WarningAddFragment extends BaseFragment{
    @BindView(R.id.btn_next)
    Button btnNext;
    public static WarningAddFragment newInstance() {
        return new WarningAddFragment();
    }

    @Override
    protected void initViews() {
        btnNext.setOnClickListener(v->{
            ChooseBottomDialog dialog = new ChooseBottomDialog();
            dialog.setCancelable(true);
            dialog.show(getFragmentManager(), "ops");
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.warning_ads_fragment_layout;
    }
}
