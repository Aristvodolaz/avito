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

public class TypePriceBottomDialog extends BottomSheetDialogFragment {
    public TypePriceBottomDialog(TypePriceBottomDialog.SuggestSelectDialogCallback callback) {
        this.callback = callback;
    }


    public static TypePriceBottomDialog newInstance(TypePriceBottomDialog.SuggestSelectDialogCallback callback) {
        TypePriceBottomDialog d = new TypePriceBottomDialog(callback);
        return d;
    }
    LinearLayout changeOne, changeTwo, changeThree, changeFour;
    TextView remove;
    ImageView close;
    private TypePriceBottomDialog.SuggestSelectDialogCallback callback;
    public interface SuggestSelectDialogCallback {
        void onSuggestSelected(String data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.type_price_dialog, container, false);
        changeOne =v.findViewById(R.id.change_one);
        changeTwo = v.findViewById(R.id.change_two);
        changeThree = v.findViewById(R.id.change_three);
        changeFour = v.findViewById(R.id.change_four);
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
            callback.onSuggestSelected("за услугу");
            dismiss();
        });
        changeTwo.setOnClickListener(vi->{
            callback.onSuggestSelected("за час");
            dismiss();
        });
        changeThree.setOnClickListener(vi->{
            callback.onSuggestSelected("за день");
            dismiss();
        });
        changeFour.setOnClickListener(vi->{
            callback.onSuggestSelected("в месяц");
            dismiss();
        });
        return v;
    }
}
