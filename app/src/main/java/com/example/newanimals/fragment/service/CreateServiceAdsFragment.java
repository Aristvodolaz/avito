package com.example.newanimals.fragment.service;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class CreateServiceAdsFragment extends BaseFragment {
    @BindView(R.id.name_service)
    EditText nameService;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    public static CreateServiceAdsFragment newInstance() {
        return new CreateServiceAdsFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        closeBtn.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nextBtn.setOnClickListener(v->{
            if(nameService.getText().toString()!=null && !nameService.getText().toString().equals("")){
                SPHelper.ServiceHelper.setNameService(nameService.getText().toString());
                ((CreateAdsActivity)getActivity()).replaceFragment(ChooseCategoryServiceAdsFragment.newInstance(), true);
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.create_service_ads_fragment_layout;
    }
}
