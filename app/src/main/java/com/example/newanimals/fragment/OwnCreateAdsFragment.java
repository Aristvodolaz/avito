package com.example.newanimals.fragment;

import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newanimals.R;
import com.example.newanimals.adapter.AdsAdapter;
import com.example.newanimals.db.AdsData;
import com.example.newanimals.presenter.LoadDataPresenter;
import com.example.newanimals.view.LoadDataView;

import java.util.List;

import butterknife.BindView;

public class OwnCreateAdsFragment extends BaseFragment implements LoadDataView {
    @BindView(R.id.rv)
    RecyclerView rv;
    public AdsAdapter adapter;
    public LoadDataPresenter presenter;
    public ProgressDialog dialogFragment;
    @Override
    protected void initViews() {
        super.initViews();
        presenter = new LoadDataPresenter(this);
        dialogFragment = ProgressDialog.show(getContext(), "","Пожалуйста подождите...", true);
        presenter.getDataFromDBForUser();
    }

    public static OwnCreateAdsFragment newInstance() {
        return new OwnCreateAdsFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.own_create_ads_fragment;
    }

    @Override
    public void getMessage(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getData(List<AdsData> data) {
         adapter = new AdsAdapter(data, getContext());
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rv.setAdapter(adapter);
        dialogFragment.dismiss();
    }


}
