package com.example.newanimals.fragment.car;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newanimals.R;
import com.example.newanimals.db.CarData;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.presenter.WriteDataInFirebasePresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.WriteDataInFirebaseView;
import com.github.pinball83.maskededittext.MaskedEditText;

import java.util.Calendar;

import butterknife.BindView;

public class CreateCarFragment2 extends BaseFragment implements WriteDataInFirebaseView {
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.name_ads)
    EditText nameAds;
    @BindView(R.id.mark_auto)
    EditText markAuto;
    @BindView(R.id.code_vin)
    EditText codeVin;
    @BindView(R.id.years)
    MaskedEditText years;
    @BindView(R.id.type_dvigatel)
    EditText typeDvigatel;
    @BindView(R.id.corobka)
    EditText corobka;
    @BindView(R.id.sostoyanie)
    EditText sostoyanie;
    @BindView(R.id.probeg)
    EditText probeg;
    @BindView(R.id.pts)
    EditText pts;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.address)
    EditText address;

    private WriteDataInFirebasePresenter presenter;
    public static CreateCarFragment2 newInstance() {
        return  new CreateCarFragment2();
    }

    @Override
    protected void initViews() {
        super.initViews();
        presenter = new WriteDataInFirebasePresenter(this);
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nextBtn.setOnClickListener(v->{
           if(handleCheckForEmptyLine()){
               CarData data = new CarData(SPHelper.getLogin(), SPHelper.getTypeAds(), SPHelper.getVidAds(),  Calendar.getInstance().getTime().toString(),
                       SPHelper.getUrlPhotoDownload(), nameAds.getText().toString(), address.getText().toString(),markAuto.getText().toString(),
                       codeVin.getText().toString(), years.getText().toString(), typeDvigatel.getText().toString(), corobka.getText().toString(),
                       sostoyanie.getText().toString(), probeg.getText().toString(),pts.getText().toString(), price.getText().toString());
               presenter.postDataInDBCar(data);
           }

        });
    }

    private boolean handleCheckForEmptyLine() {
        if(nameAds.getText().toString()!=null && !nameAds.getText().toString().equals("") &&
                markAuto.getText().toString()!=null && !markAuto.getText().toString().equals("") &&
                codeVin.getText().toString()!=null && !codeVin.getText().toString().equals("") &&
                years.getText().toString()!=null && !years.getText().toString().equals("") &&
                typeDvigatel.getText().toString()!=null && !typeDvigatel.getText().toString().equals("") &&
                corobka.getText().toString()!=null && !corobka.getText().toString().equals("") &&
                sostoyanie.getText().toString()!=null && !sostoyanie.getText().toString().equals("") &&
                probeg.getText().toString()!=null && !probeg.getText().toString().equals("") &&
                pts.getText().toString()!=null && !pts.getText().toString().equals("") &&
                price.getText().toString()!=null && !price.getText().toString().equals("") &&
                address.getText().toString()!=null && !address.getText().toString().equals("")){
            return true;
        } else {
            Toast.makeText(getContext(), "Проверьте правильность введенных данных!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.create_car_fragment_2;
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
