package com.example.newanimals.fragment.service;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.newanimals.R;
import com.example.newanimals.db.ServiceData;
import com.example.newanimals.dialog.AddressDialog;
import com.example.newanimals.dialog.OfthenPaysDialog;
import com.example.newanimals.dialog.TypePriceBottomDialog;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.presenter.ServicePresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.ServiceView;

import java.util.Calendar;

import butterknife.BindView;

public class ServiceFragment extends BaseFragment implements ServiceView {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final int REQUEST_IMAGE_PIKE = 3;
    public static final int PERMISSON_REQUEST_CODE = 2;

    private ServicePresenter presenter;

    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.add_photo)
    FrameLayout add_photo;
    @BindView(R.id.description)
    EditText description;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.nach_price)
    CheckBox nachPrice;
    @BindView(R.id.type_price)
    EditText typePrice;
    String setNachPrice;

    @Override
    protected void initViews() {
        super.initViews();
        presenter = new ServicePresenter(this);
        add_photo.setOnClickListener(v->{
            if(checkPermisson())
                showImageSOurceDialog();
            else requestPermission();
        });
        handleCheckPredectly();
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nextBtn.setOnClickListener(l->{
            if(checkFullHaveInfoPredectly()){
                ServiceData data = new ServiceData(SPHelper.getLogin(), SPHelper.getTypeAds(), Calendar.getInstance().getTime().toString(),
                        SPHelper.ServiceHelper.getNameService(), SPHelper.ServiceHelper.getCategoryService(),SPHelper.getUrlPhotoDownload(), description.getText().toString(),
                        price.getText().toString(), typePrice.getText().toString(),address.getText().toString(), setNachPrice);
                presenter.postDataInDBService(data);
            }
        });
        typePrice.setOnFocusChangeListener((l, focus)->{
            if(focus){
                TypePriceBottomDialog.newInstance((type) -> typePrice.setText(type)).show(getChildFragmentManager(), "lol");
            }
        });
        address.setOnFocusChangeListener((l, focus)->{
            if(focus){
                AddressDialog.newInstance((type, addresss) -> address.setText(addresss), "").show(getChildFragmentManager(), AddressDialog.TAG);
            }
        });
    }

    private boolean checkFullHaveInfoPredectly() {
        if(price.getText().toString()!=null && !price.getText().toString().equals("") &&
                description.getText().toString()!=null && !description.getText().toString().equals("") &&
                typePrice.getText().toString()!=null && !typePrice.getText().toString().equals("") &&
                address.getText().toString()!=null && !address.getText().toString().equals("") &&
                setNachPrice!=null && !setNachPrice.equals("") && !SPHelper.getUrlPhotoDownload().equals("") && SPHelper.getUrlPhotoDownload()!=null &&
                !SPHelper.ServiceHelper.getNameService().equals("") && SPHelper.ServiceHelper.getNameService()!=null &&
                !SPHelper.ServiceHelper.getCategoryService().equals("") && SPHelper.ServiceHelper.getCategoryService()!=null){
            return true;
        } else {
            Toast.makeText(getContext(), "Проверьте правильность заполненных полей!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void handleCheckPredectly() {
        nachPrice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (nachPrice.isChecked()){
                    setNachPrice = "это начальная цена'";
                } else {
                    nextBtn.setClickable(false);
                }
            }
        });
    }

    private void showImageSOurceDialog() {
        String[] options = {"Камера", "Галерея"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Выберите путь фотографии");
        builder.setItems(options, (dialog,witch) ->{
            if(witch == 0){
                dispatchTakePictureIntent();
            } else if (witch ==1) {
                openGallery();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, REQUEST_IMAGE_CAPTURE);
    }

    private void dispatchTakePictureIntent() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getContext().getPackageManager())!=null){
            startActivityForResult(takePicture, REQUEST_IMAGE_PIKE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE){
            Bundle bundle = data.getExtras();
            if(bundle !=null){
                Uri imageUri = data.getData();
                if(imageUri !=null)
                    presenter.uploadPhoto(imageUri, java.util.UUID.randomUUID().toString());
                else Toast.makeText(getContext(),"Ошибка загрузки фотографии!", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_IMAGE_PIKE) {
            Uri img = data.getData();
            if(img!=null)
                presenter.uploadPhoto(img, java.util.UUID.randomUUID().toString());
            else Toast.makeText(getContext(),"Ошибка загрузки фотографии!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSON_REQUEST_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                dispatchTakePictureIntent();
            else
                Toast.makeText(getContext(), "Разрешение использования камеры не получено!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkPermisson(){
        return ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA},
                PERMISSON_REQUEST_CODE);
    }

    @Override
    public void onMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpploadSuccess(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        add_photo.setVisibility(View.GONE);
    }

    @Override
    public void successAddAds(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    public static ServiceFragment newInstance() {
        return new ServiceFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.service_fragment;
    }
}
