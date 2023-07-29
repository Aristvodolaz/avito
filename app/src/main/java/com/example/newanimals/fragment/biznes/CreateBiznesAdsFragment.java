package com.example.newanimals.fragment.biznes;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.presenter.LoadPhotoPresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.LoadPhotoView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class CreateBiznesAdsFragment extends BaseFragment implements LoadPhotoView {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final int REQUEST_IMAGE_PIKE = 3;
    public static final int PERMISSON_REQUEST_CODE = 2;
    private LoadPhotoPresenter presenter;
    @BindView(R.id.add_photo)
    FrameLayout add_photo;
    @BindView(R.id.next_btn)
    Button nexBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.image)
    ImageView image;
    public static CreateBiznesAdsFragment newInstance() {
        return new CreateBiznesAdsFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
        presenter = new LoadPhotoPresenter(this);
        add_photo.setOnClickListener(v->{
            if(checkPermisson())
            showImageSOurceDialog();
        else requestPermission();
        });
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nexBtn.setOnClickListener(v->{
            if(SPHelper.getUrlPhotoDownload()!=null && !SPHelper.getUrlPhotoDownload().equals("")) {
                ((CreateAdsActivity) getActivity()).replaceFragment(CreateBiznesAddNameFragment.newInstance(), true);
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
    protected int layoutId() {
        return R.layout.create_biznes_ads_fragment_layout;
    }

    @Override
    public void onMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpploadSuccess(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        add_photo.setVisibility(View.GONE);
        Picasso.get().load(SPHelper.getUrlPhotoDownload()).into(image);
        image.setVisibility(View.VISIBLE);
    }

    @Override
    public void successAddAds(String msg) {

    }
}
