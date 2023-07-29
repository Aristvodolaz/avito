package com.example.newanimals.fragment.biznes;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.service.ChooseCategoryServiceAdsFragment;
import com.example.newanimals.fragment.service.CreateServiceAdsFragment;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class CreateBiznesAddNameFragment extends BaseFragment {
    @BindView(R.id.name_service)
    EditText nameService;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    public static CreateBiznesAddNameFragment newInstance() {
        return new CreateBiznesAddNameFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nextBtn.setOnClickListener(v->{
            if(nameService.getText().toString()!=null && !nameService.getText().toString().equals("")){
                SPHelper.setNameAds(nameService.getText().toString());
                ((CreateAdsActivity)getActivity()).replaceFragment(ChooseTypeBiznesFragment.newInstance(), true);
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.create_ads_name_fragment_layout;
    }
}
