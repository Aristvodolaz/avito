package com.example.newanimals.fragment.work.worker;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
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
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.db.WorkData;
import com.example.newanimals.dialog.ChooseWorkBottomSheetDialog;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.car.CreateCarFragment2;
import com.example.newanimals.presenter.LoadPhotoPresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.LoadPhotoView;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

import butterknife.BindView;

public class WorkWorkerFragment2 extends BaseFragment implements LoadPhotoView {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final int REQUEST_IMAGE_PIKE = 3;
    public static final int PERMISSON_REQUEST_CODE = 2;
    private LoadPhotoPresenter presenter;
    @BindView(R.id.grazhdanstvo)
    EditText grazhdanstvo;
    @BindView(R.id.date_birth)
    EditText dateBirth;
    @BindView(R.id.woman)
    Button woman;
    @BindView(R.id.man)
    Button man;
    @BindView(R.id.dop)
    CheckBox dop;
    @BindView(R.id.osnova)
    CheckBox osnova;
    @BindView(R.id.change)
    EditText change;
    @BindView(R.id.yes)
    Button yes;
    @BindView(R.id.no)
    Button no;
    @BindView(R.id.add_photo)
    FrameLayout add_photo;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    String typeWork, howExit, pol;
    public static WorkWorkerFragment2 newInstance() {
        return  new WorkWorkerFragment2();
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
        handleClickCheckBoxAndButton();
        nextBtn.setOnClickListener(v->{

            if(handleCheckPredectly()){
                WorkData data = new WorkData(SPHelper.getLogin(), SPHelper.getTypeAds(), SPHelper.getVidAds(), Calendar.getInstance().getTime().toString(),
                        SPHelper.getNameAds(), SPHelper.getSferaZanitosty(),
                        SPHelper.getUrlPhotoDownload(), pol, dateBirth.getText().toString(),
                        grazhdanstvo.getText().toString(), typeWork, change.getText().toString(), howExit);
                presenter.postDataInDBWork(data);
            }

        });
        change.setOnFocusChangeListener((v, focuse)->{
            if(focuse) {
                ChooseWorkBottomSheetDialog.newInstance((type) -> change.setText(type)).show(getChildFragmentManager(), "lol");
            }
        });
    }

    private void handleClickCheckBoxAndButton() {
        yes.setOnClickListener(v->{
            howExit = "Есть";
        });
        no.setOnClickListener(view -> {
            howExit = "Нет";
        });
        woman.setOnClickListener(l->{
            pol = "Женский";
        });
        man.setOnClickListener(l->{
            pol = "Мужской";
        });
        dop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (dop.isChecked()){
                    osnova.setClickable(false);
                    typeWork = "Дополнительная работа";
                } else {
                    osnova.setClickable(true);
                    nextBtn.setClickable(false);
                }
            }
        });
        osnova.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (osnova.isChecked()){
                    dop.setClickable(false);
                    typeWork = "Основная работа";
                } else {
                    dop.setClickable(true);
                    nextBtn.setClickable(false);
                }
            }
        });

    }

    private boolean handleCheckPredectly() {
        if( grazhdanstvo.getText().toString()!=null && !grazhdanstvo.getText().toString().equals("") &&
                dateBirth.getText().toString()!=null && !dateBirth.getText().toString().equals("") &&
                pol!=null && !pol.equals("") && typeWork!=null && !typeWork.equals("") && howExit!=null && !howExit.equals("") && SPHelper.getUrlPhotoDownload()!=null){
            return true;
        } else {
            Toast.makeText(getContext(), "Проверьте правильность введенных данных!", Toast.LENGTH_SHORT).show();
            return false;
        }
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


    @Override
    protected int layoutId() {
        return R.layout.work_worker_fragment2;
    }
}
