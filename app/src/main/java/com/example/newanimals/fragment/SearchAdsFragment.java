package com.example.newanimals.fragment;

import android.app.ProgressDialog;
import android.widget.LinearLayout;
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

public class SearchAdsFragment extends BaseFragment implements LoadDataView {
    public static SearchAdsFragment newInstance() {
        return new SearchAdsFragment();
    }

    @BindView(R.id.all)
    LinearLayout all;
    @BindView(R.id.rv)
    RecyclerView rv;

    private AdsAdapter adsAdapter;
    private LoadDataPresenter presenter;
    public ProgressDialog dialogFragment;
    @Override
    protected void initViews() {
        super.initViews();
        presenter = new LoadDataPresenter(this);
        all.setOnClickListener(l->{
            presenter.getDataFromDB();
            dialogFragment = ProgressDialog.show(getContext(), "","Пожалуйста подождите...", true);
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.search_ads_fragment_layout;
    }

    @Override
    public void getMessage(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getData(List<AdsData> data) {
        adsAdapter =  new AdsAdapter(data, getContext());
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rv.setAdapter(adsAdapter);
        dialogFragment.dismiss();
    }


}
