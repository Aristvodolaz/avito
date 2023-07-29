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

public class ExpBottomDialog extends BottomSheetDialogFragment {
    public ExpBottomDialog(ExpBottomDialog.SuggestSelectDialogCallback callback) {
        this.callback = callback;
    }


    public static ExpBottomDialog newInstance(ExpBottomDialog.SuggestSelectDialogCallback callback) {
        ExpBottomDialog d = new ExpBottomDialog(callback);
        return d;
    }
    LinearLayout changeOne, changeTwo, changeThree, changeFour, changeFive;
    TextView remove;
    ImageView close;
    private ExpBottomDialog.SuggestSelectDialogCallback callback;
    public interface SuggestSelectDialogCallback {
        void onSuggestSelected(String data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.choose_exp_dialog, container, false);
        changeOne =v.findViewById(R.id.change_one);
        changeTwo = v.findViewById(R.id.change_two);
        changeThree = v.findViewById(R.id.change_three);
        changeFour = v.findViewById(R.id.change_four);
        changeFive = v.findViewById(R.id.change_five);
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
            callback.onSuggestSelected("Не имеет значения");
            dismiss();
        });
        changeTwo.setOnClickListener(vi->{
            callback.onSuggestSelected("Более 1 года");
            dismiss();
        });
        changeThree.setOnClickListener(vi->{
            callback.onSuggestSelected("Более 3 лет");
            dismiss();
        });
        changeFour.setOnClickListener(vi->{
            callback.onSuggestSelected("Более 5 лет");
            dismiss();
        });
        changeFive.setOnClickListener(vi->{
            callback.onSuggestSelected("Более 10 лет");
            dismiss();
        });

        return v;
    }
}
