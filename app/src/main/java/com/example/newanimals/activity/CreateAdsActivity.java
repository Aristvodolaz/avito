package com.example.newanimals.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.newanimals.R;
import com.example.newanimals.dialog.ChooseBottomDialog;
import com.example.newanimals.fragment.CreateAdsFragment;
import com.example.newanimals.fragment.StartAppFragment;
import com.example.newanimals.fragment.WarningAddFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.units.qual.C;

public class CreateAdsActivity extends BaseActivity{
    //todo need create .xml
    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        replaceFragment(CreateAdsFragment.newInstance(), true);
    }

    @Override
    protected int layoutResId() {
        return R.layout.create_ads_activity_layout;
    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
    @Override
    protected int titleResId() {
        return 0;
    }
}
