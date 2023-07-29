package com.example.newanimals.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newanimals.R;
import com.example.newanimals.utils.SPHelper;

import org.w3c.dom.Text;

import butterknife.BindView;

public class ChooseTypeForSaleFragment extends BaseFragment{
    public static final String NAME = "string";
    public static ChooseTypeForSaleFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(NAME, name);
        ChooseTypeForSaleFragment fragment = new ChooseTypeForSaleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @BindView(R.id.name_type)
    TextView nameType;
    @BindView(R.id.buy)
    LinearLayout buy;
    @BindView(R.id.get)
    LinearLayout get;
    @BindView(R.id.post)
    LinearLayout post;
    @BindView(R.id.sale)
    LinearLayout sale;
    @BindView(R.id.close_btn)
    ImageView closeBtn;

    @Override
    protected void initViews() {
        super.initViews();

        nameType.setText(getArguments().getString(NAME, ""));
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });

        sale.setOnClickListener(v->{
            SPHelper.setSaleType("sale");
        });
        post.setOnClickListener(v->{
            SPHelper.setSaleType("post");
        });
        get.setOnClickListener(v->{
            SPHelper.setSaleType("get");
        });
        buy.setOnClickListener(v->{
            SPHelper.setSaleType("buy");
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.choose_type_for_sale_fragment;
    }
}
