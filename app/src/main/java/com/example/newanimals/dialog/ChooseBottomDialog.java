package com.example.newanimals.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.newanimals.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.BindView;

public class ChooseBottomDialog extends BottomSheetDialogFragment {
    Button registrBtn, vhodBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.choose_bottom_dialog, container, false);
        registrBtn =v.findViewById(R.id.registr);
        vhodBtn = v.findViewById(R.id.vhod);

        registrBtn.setOnClickListener(vi->{
            WritePhoneNumDialog dialogFragment = new WritePhoneNumDialog();
            dialogFragment.show(getFragmentManager(), "Bottomsheet Fragment");
        });
        vhodBtn.setOnClickListener(vio->{
            EntryDialog dialog = new EntryDialog();
            dialog.show(getFragmentManager(), "hellu");
        });
        return v;
    }
}
