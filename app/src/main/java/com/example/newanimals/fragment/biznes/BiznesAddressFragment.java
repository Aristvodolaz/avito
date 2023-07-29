package com.example.newanimals.fragment.biznes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newanimals.R;
import com.example.newanimals.db.BiznesData;
import com.example.newanimals.dialog.AddressDialog;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.presenter.WriteDataInFirebasePresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.WriteDataInFirebaseView;

import java.util.Calendar;

import butterknife.BindView;

public class BiznesAddressFragment extends BaseFragment implements WriteDataInFirebaseView {

    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.name_service)
    EditText address;

    private WriteDataInFirebasePresenter presenter;

    @Override
    protected void initViews() {
        super.initViews();
        presenter = new WriteDataInFirebasePresenter(this);
        closeBtn.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        address.setOnFocusChangeListener((v, focus)->{
            if(focus){
                AddressDialog.newInstance((type, addresss) -> address.setText(addresss), "").show(getChildFragmentManager(), AddressDialog.TAG);
            }
        });
        nextBtn.setOnClickListener(v->{
            if(checkPredectly()){
                BiznesData data = new BiznesData(SPHelper.getLogin(), SPHelper.getTypeAds(), SPHelper.getVidAds(), Calendar.getInstance().getTime().toString(),
                        SPHelper.getNameAds(), SPHelper.getUrlPhotoDownload(), SPHelper.BizznesHelper.getTypeBiznes(), SPHelper.BizznesHelper.getDescriptionBiznes(),
                        SPHelper.BizznesHelper.getChooseTransaction(), SPHelper.BizznesHelper.getPriceBiznes(), address.getText().toString());
                presenter.postDataInDBBiznes(data);
            }
        });
    }

    private boolean checkPredectly() {
        if(address.getText().toString()!=null && !address.getText().toString().equals("")){
            return true;
        } else {
            Toast.makeText(getContext(), "Введите адрес!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static BiznesAddressFragment newInstance() {
        return new BiznesAddressFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.biznes_address_fragment;
    }

    @Override
    public void sendMessage(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successAdd(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }
}
