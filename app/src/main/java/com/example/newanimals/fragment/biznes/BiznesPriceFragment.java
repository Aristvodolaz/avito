package com.example.newanimals.fragment.biznes;

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

public class BiznesPriceFragment  extends BaseFragment {
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.name_service)
    EditText price;
    @Override
    protected void initViews() {
        super.initViews();

        nextBtn.setOnClickListener(v->{
            if(handleCheckPredectly()){
                ((CreateAdsActivity)getActivity()).replaceFragment(BiznesAddressFragment.newInstance(), true);
            }
        });
        closeBtn.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    private boolean handleCheckPredectly() {
        if(price.getText().toString()!=null && !price.getText().toString().equals("")){
            SPHelper.BizznesHelper.setPriceBiznes(price.getText().toString());
            return true;
        } else {
            Toast.makeText(getContext(), "Проверьте правильность заполнения поля!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static BiznesPriceFragment newInstance() {
        return new BiznesPriceFragment();
    }
    @Override
    protected int layoutId() {
        return 0;
    }
}
