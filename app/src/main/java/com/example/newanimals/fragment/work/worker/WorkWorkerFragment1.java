package com.example.newanimals.fragment.work.worker;

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

public class WorkWorkerFragment1 extends BaseFragment {
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.next_btn)
    Button nextBtn;

    @BindView(R.id.name_service)
    EditText name;
    public static WorkWorkerFragment1 newInstance() {
        return new WorkWorkerFragment1();
    }

    @Override
    protected void initViews() {
        super.initViews();


        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });

        nextBtn.setOnClickListener(v->{
            if(name.getText().toString()!=null && !name.getText().toString().equals("")){
                SPHelper.setNameAds(name.getText().toString());
                ((CreateAdsActivity)getActivity()).replaceFragment(ChooseSferaZanitostiFragment.newInstance(), true);
            }else Toast.makeText(getContext(), "Проверьте правильность введенных данных!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.work_worker_fragment1;
    }
}
