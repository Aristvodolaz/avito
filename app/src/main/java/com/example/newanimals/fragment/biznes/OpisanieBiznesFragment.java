package com.example.newanimals.fragment.biznes;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class OpisanieBiznesFragment extends BaseFragment {
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.name_service)
    EditText description;
    @Override
    protected void initViews() {
        super.initViews();
        SPHelper.setVidAds("biznes");

        nextBtn.setOnClickListener(v->{
            if(handleCheckPredectly()){
                ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTransactionFragment.newInstance(), true);
            }
        });
        closeBtn.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    private boolean handleCheckPredectly() {
        if(description.getText().toString()!=null && !description.getText().toString().equals("")){
            SPHelper.BizznesHelper.setDescriptionBiznes(description.getText().toString());
            return true;
        } else {
            Toast.makeText(getContext(), "Проверьте правильность заполнения поля!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static OpisanieBiznesFragment newInstance() {
        return  new OpisanieBiznesFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.opisanie_biznes_fragment;
    }
}
