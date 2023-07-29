package com.example.newanimals.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.newanimals.R;
import com.example.newanimals.db.AdsData;
import com.example.newanimals.fragment.OwnCreateAdsFragment;
import com.example.newanimals.fragment.PersonFragment;
import com.example.newanimals.fragment.SearchAdsFragment;
import com.example.newanimals.fragment.WarningAddFragment;
import com.example.newanimals.presenter.LoadDataPresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.LoadDataView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import butterknife.BindView;

public class StartAppActivity extends BaseActivity {

    private FirebaseFirestore data_base = FirebaseFirestore.getInstance();
    private CollectionReference item = data_base.collection("AdsData");

    @BindView(R.id.ads_btn)
    LinearLayout adsBtn;
    @BindView(R.id.create_person_btn)
    LinearLayout createPersonBtn;
    @BindView(R.id.add_ads)
    LinearLayout addAdsBtn;
    @BindView(R.id.message_btn)
    LinearLayout messageBtn;
    @BindView(R.id.person_btn)
    LinearLayout personBtn;


    @BindView(R.id.ads)
    ImageView adsImg;
    @BindView(R.id.ads_active)
    ImageView adsActiveImg;

    @BindView(R.id.create)
    ImageView createImg;
    @BindView(R.id.create_active)
    ImageView createActiveImg;

    @BindView(R.id.ads_add)
    ImageView adsAddImg;
    @BindView(R.id.ads_add_active)
    ImageView adsAddActiveImg;

    @BindView(R.id.message_img)
    ImageView messageImg;
    @BindView(R.id.message_active)
    ImageView messageActive;

    @BindView(R.id.user)
    ImageView userImg;
    @BindView(R.id.user_active)
    ImageView userActive;



    private LoadDataPresenter presenter;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        replaceFragment(SearchAdsFragment.newInstance(), true);
        personBtn.setOnClickListener(v->{
            auth = FirebaseAuth.getInstance();
            user = auth.getCurrentUser();
        if (user != null){
            replaceFragment(PersonFragment.newInstance(), true);
            SPHelper.setLogin(user.getEmail());
        } else {replaceFragment(WarningAddFragment.newInstance(), true);}


            userImg.setVisibility(View.GONE);
            userActive.setVisibility(View.VISIBLE);

            adsAddImg.setVisibility(View.VISIBLE);
            adsAddActiveImg.setVisibility(View.GONE);

            messageImg.setVisibility(View.VISIBLE);
            messageActive.setVisibility(View.GONE);

            createActiveImg.setVisibility(View.GONE);
            createImg.setVisibility(View.VISIBLE);

            adsImg.setVisibility(View.VISIBLE);
            adsActiveImg.setVisibility(View.GONE);
        });
        createPersonBtn.setOnClickListener(v->{
            replaceFragment(OwnCreateAdsFragment.newInstance(), true);
            userImg.setVisibility(View.VISIBLE);
            userActive.setVisibility(View.GONE);

            adsAddImg.setVisibility(View.VISIBLE);
            adsAddActiveImg.setVisibility(View.GONE);

            messageImg.setVisibility(View.VISIBLE);
            messageActive.setVisibility(View.GONE);

            createActiveImg.setVisibility(View.VISIBLE);
            createImg.setVisibility(View.GONE);

            adsImg.setVisibility(View.VISIBLE);
            adsActiveImg.setVisibility(View.GONE);
        });
        adsBtn.setOnClickListener(v->{
            replaceFragment(SearchAdsFragment.newInstance(), true);
            userImg.setVisibility(View.VISIBLE);
            userActive.setVisibility(View.GONE);

            adsAddImg.setVisibility(View.VISIBLE);
            adsAddActiveImg.setVisibility(View.GONE);

            messageImg.setVisibility(View.VISIBLE);
            messageActive.setVisibility(View.GONE);

            createActiveImg.setVisibility(View.GONE);
            createImg.setVisibility(View.VISIBLE);

            adsImg.setVisibility(View.GONE);
            adsActiveImg.setVisibility(View.VISIBLE);
        });
        messageBtn.setOnClickListener(v->{
//            replaceFragment(PersonalFragment.newInstance(), false);
            userImg.setVisibility(View.VISIBLE);
            userActive.setVisibility(View.GONE);

            adsAddImg.setVisibility(View.VISIBLE);
            adsAddActiveImg.setVisibility(View.GONE);

            messageImg.setVisibility(View.GONE);
            messageActive.setVisibility(View.VISIBLE);

            createActiveImg.setVisibility(View.GONE);
            createImg.setVisibility(View.VISIBLE);

            adsImg.setVisibility(View.VISIBLE);
            adsActiveImg.setVisibility(View.GONE);
        });
        addAdsBtn.setOnClickListener(l->{
            auth = FirebaseAuth.getInstance();
            user = auth.getCurrentUser(); //получаем пользователя
            if (user != null) {
                startActivity(new Intent(this, CreateAdsActivity.class));
                SPHelper.setLogin(user.getEmail());
            }else {
                replaceFragment(WarningAddFragment.newInstance(), false);
            }
            userImg.setVisibility(View.VISIBLE);
            userActive.setVisibility(View.GONE);

            adsAddImg.setVisibility(View.GONE);
            adsAddActiveImg.setVisibility(View.VISIBLE);

            messageImg.setVisibility(View.VISIBLE);
            messageActive.setVisibility(View.GONE);

            createActiveImg.setVisibility(View.GONE);
            createImg.setVisibility(View.VISIBLE);

            adsImg.setVisibility(View.VISIBLE);
            adsActiveImg.setVisibility(View.GONE);
        });

    }

    @Override
    protected int layoutResId() {
        return R.layout.start_app_activity_layout;
    }

    @Override
    protected int titleResId() {
        return 0;
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

}
