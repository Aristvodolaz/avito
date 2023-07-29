package com.example.newanimals.fragment.biznes;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class ChooseTransactionFragment extends BaseFragment {
    @BindView(R.id.pay)
    LinearLayout pay;
    @BindView(R.id.sdacha)
    LinearLayout sdacha;
    @BindView(R.id.invest)
    LinearLayout invest;
    @BindView(R.id.franshiza)
    LinearLayout franshiza;
    @BindView(R.id.partner)
    LinearLayout partner;
    @BindView(R.id.zaem)
    LinearLayout zaem;
    @Override
    protected void initViews() {
        super.initViews();
        pay.setOnClickListener(l->{
            SPHelper.BizznesHelper.setChooseTransaction("Продать бизнес");
            ((CreateAdsActivity)getActivity()).replaceFragment(BiznesPriceFragment.newInstance(), true);
        });
        sdacha.setOnClickListener(l->{
            SPHelper.BizznesHelper.setChooseTransaction("Сдать бизнес в аренду");
            ((CreateAdsActivity)getActivity()).replaceFragment(BiznesPriceFragment.newInstance(), true);
        });
        invest.setOnClickListener(l->{
            SPHelper.BizznesHelper.setChooseTransaction("Привлечь инвестиции");
            ((CreateAdsActivity)getActivity()).replaceFragment(BiznesPriceFragment.newInstance(), true);
        });
        franshiza.setOnClickListener(l->{
            SPHelper.BizznesHelper.setChooseTransaction("Продать франшизу");
            ((CreateAdsActivity)getActivity()).replaceFragment(BiznesPriceFragment.newInstance(), true);
        });
        partner.setOnClickListener(l->{
            SPHelper.BizznesHelper.setChooseTransaction("Найти партнёра");
            ((CreateAdsActivity)getActivity()).replaceFragment(BiznesPriceFragment.newInstance(), true);
        });
        zaem.setOnClickListener(l->{
            SPHelper.BizznesHelper.setChooseTransaction("Получить заём");
            ((CreateAdsActivity)getActivity()).replaceFragment(BiznesPriceFragment.newInstance(), true);
        });

    }

    public static ChooseTransactionFragment newInstance() {
        return new ChooseTransactionFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.choose_transaction_fragment;
    }
}
