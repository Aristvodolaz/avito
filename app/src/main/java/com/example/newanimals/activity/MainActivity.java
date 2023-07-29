package com.example.newanimals.activity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.newanimals.R;
import com.example.newanimals.fragment.StartAppFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends BaseActivity{
    FirebaseAuth auth;
    FirebaseUser user;
    double lon = 0, lat = 0;
    Handler handler = new Handler();
    Runnable runnable;
    LocationManager locationManager;
    private static final int MY_PERMISSION_REQUEST_LOCATION = 859;
    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        startActivity(new Intent(this,StartAppActivity.class));
    }
    @Override
    protected int layoutResId() {
        return R.layout.main_activity_layout;
    }

    @Override
    protected int titleResId() {
        return 0;
    }
}
