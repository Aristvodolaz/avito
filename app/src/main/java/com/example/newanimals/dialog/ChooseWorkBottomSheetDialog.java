package com.example.newanimals.dialog;

import android.app.Dialog;
import android.content.Context;
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
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ChooseWorkBottomSheetDialog extends BottomSheetDialogFragment {
    public ChooseWorkBottomSheetDialog(SuggestSelectDialogCallback callback) {
        this.callback = callback;
    }


    public static ChooseWorkBottomSheetDialog newInstance(SuggestSelectDialogCallback callback) {
        ChooseWorkBottomSheetDialog d = new ChooseWorkBottomSheetDialog(callback);
        return d;
    }
    LinearLayout changeOne, changeTwo;
    TextView remove;
    ImageView close;
    private SuggestSelectDialogCallback callback;
    public interface SuggestSelectDialogCallback {
        void onSuggestSelected(String data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.choose_work_dialog, container, false);
        changeOne =v.findViewById(R.id.change_one);
        changeTwo = v.findViewById(R.id.change_two);
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
            callback.onSuggestSelected("Активно ищу работу");
            dismiss();
        });
        changeTwo.setOnClickListener(vi->{
            callback.onSuggestSelected("Рассматриваю предложения");
            dismiss();
        });

        return v;
    }
}
