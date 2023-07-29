package com.example.newanimals.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.newanimals.R;

public class EntryDialog extends DialogFragment {

    EditText login, password;
    TextView losePass;
    Button nextBtn;
    ImageView closeBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.entry_dialog_layout, null);
        login = view.findViewById(R.id.login);
        password = view.findViewById(R.id.password);
        losePass = view.findViewById(R.id.password_lose);
        nextBtn = view.findViewById(R.id.btn_next);
        closeBtn  = view.findViewById(R.id.close_btn);
        closeBtn.setOnClickListener(vis->{
            getDialog().dismiss();
        });
        nextBtn.setOnClickListener(view1 ->{
            handleChekProdectly();});
        getDialog().setTitle("Title");
        return view;
    }
    private void handleChekProdectly() {
        if(password!= null && !password.getText().toString().equals("") && login!= null && !login.getText().toString().equals("")){
//            FragmentManager fm = getFragmentManager();
//            WriteCodeForRegDialog dialogFragment = new WriteCodeForRegDialog();
//            dialogFragment.show(fm, "Bottomsheet Fragment");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (metrics.heightPixels * 0.99));
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
