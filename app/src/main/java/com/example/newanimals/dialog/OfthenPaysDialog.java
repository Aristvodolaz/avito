package com.example.newanimals.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newanimals.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class OfthenPaysDialog extends BottomSheetDialogFragment {
    public OfthenPaysDialog(OfthenPaysDialog.SuggestSelectDialogCallback callback) {
        this.callback = callback;
    }


    public static OfthenPaysDialog newInstance(OfthenPaysDialog.SuggestSelectDialogCallback callback) {
        OfthenPaysDialog d = new OfthenPaysDialog(callback);
        return d;
    }
    LinearLayout changeOne, changeTwo, changeThree;
    TextView remove;
    ImageView close;
    private OfthenPaysDialog.SuggestSelectDialogCallback callback;
    public interface SuggestSelectDialogCallback {
        void onSuggestSelected(String data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.choose_ofthe_dialog, container, false);
        changeOne =v.findViewById(R.id.change_one);
        changeTwo = v.findViewById(R.id.change_two);
        changeThree = v.findViewById(R.id.change_three);
        close = v.findViewById(R.id.close_btn);
        remove = v.findViewById(R.id.remove);
        close.setOnClickListener(vi->{
            dismiss();
        });
        remove.setOnClickListener(vi->{
            callback.onSuggestSelected("");
            dismiss();
        });
        changeOne.setOnClickListener(vi->{
            callback.onSuggestSelected("Почасовая оплата");
            dismiss();
        });
        changeTwo.setOnClickListener(vi->{
            callback.onSuggestSelected("Каждый день");
            dismiss();
        });
        changeThree.setOnClickListener(vi->{
            callback.onSuggestSelected("Дважды в месяц");
            dismiss();
        });


        return v;
    }
}
