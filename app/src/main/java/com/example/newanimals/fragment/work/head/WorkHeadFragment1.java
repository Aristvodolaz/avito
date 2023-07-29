package com.example.newanimals.fragment.work.head;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.work.ChooseSferaZanitostiFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class WorkHeadFragment1 extends BaseFragment {
    @BindView(R.id.name_service)
    EditText nameService;
    @BindView(R.id.description)
    EditText description;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;

    public static WorkHeadFragment1 newInstance() {
        return new WorkHeadFragment1();
    }

    @Override
    protected void initViews() {
        super.initViews();
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nextBtn.setOnClickListener(v->{
            if(checkPredectly()) {
                ((CreateAdsActivity) getActivity()).replaceFragment(SferaZanitostyForHeadWorkFragment.newInstance(), true);
            }
        });

    }

    private boolean checkPredectly() {
        if(nameService.getText().toString()!=null && !nameService.getText().toString().equals("") &&
                description.getText().toString()!=null && !description.getText().toString().equals("")){
            SPHelper.setNameAds(nameService.getText().toString());
            SPHelper.setOpisanieForWorkHead(description.getText().toString());
            return true;
        } else {
            Toast.makeText(getContext(), "Проверьте правильность заполнения полей!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.work_head_fragment1;
    }
}
