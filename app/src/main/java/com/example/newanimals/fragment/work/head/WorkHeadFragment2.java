package com.example.newanimals.fragment.work.head;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.newanimals.R;
import com.example.newanimals.db.WorkHeadData;
import com.example.newanimals.dialog.AddressDialog;
import com.example.newanimals.dialog.ExpBottomDialog;
import com.example.newanimals.dialog.OfthenPaysDialog;
import com.example.newanimals.dialog.PeriodOplatyDialog;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.presenter.WorkHeadPresenter;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.WorkHeadView;

import java.util.Calendar;

import butterknife.BindView;

public class WorkHeadFragment2 extends BaseFragment implements WorkHeadView {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final int REQUEST_IMAGE_PIKE = 3;
    public static final int PERMISSON_REQUEST_CODE = 2;
    private WorkHeadPresenter presenter;
    @BindView(R.id.offen)
    EditText chastota;
    @BindView(R.id.exp)
    EditText exp;
    @BindView(R.id.ot_price)
    EditText otPrice;
    @BindView(R.id.do_price)
    EditText doPrice;
    @BindView(R.id.grafic)
    EditText grafic;
    @BindView(R.id.offen_period)
    EditText period;
    @BindView(R.id.udalenka_no)
    Button u_no;
    @BindView(R.id.udalenka_yes)
    Button u_yes;
    @BindView(R.id.podrabotka_yes)
    Button p_yes;
    @BindView(R.id.podrabotka_no)
    Button p_no;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.next_btn)
    Button nextBtn;
    @BindView(R.id.add_photo)
    FrameLayout add_photo;

    String podrabotka, udalenka;
    public static WorkHeadFragment2 newInstance() {
        return  new WorkHeadFragment2();
    }

    @Override
    protected void initViews() {
        super.initViews();

        presenter = new WorkHeadPresenter(this);

        add_photo.setOnClickListener(v->{
            if(checkPermisson())
                showImageSOurceDialog();
            else requestPermission();
        });
        handleCheckClickButton();
        closeBtn.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        nextBtn.setOnClickListener(l->{
           if(checkPredectly()){
               WorkHeadData data = new WorkHeadData(SPHelper.getLogin(), SPHelper.getTypeAds(), SPHelper.getVidAds(), Calendar.getInstance().getTime().toString(),
                       SPHelper.getNameAds(),SPHelper.getSferaZanitosty(), SPHelper.getOpisanieForWorkHead(), SPHelper.getUrlPhotoDownload(),
                       grafic.getText().toString(),podrabotka, udalenka, exp.getText().toString(), address.getText().toString(),
                       "от "+otPrice.getText().toString() +" до "+ doPrice.getText().toString(), period.getText().toString(), chastota.getText().toString());
               presenter.postDataInDBWorkHead(data);
           }
        });
        chastota.setOnFocusChangeListener((v,focus)->{
            if(focus){
                OfthenPaysDialog.newInstance((type) -> chastota.setText(type)).show(getChildFragmentManager(), "lol");
            }
        });
        exp.setOnFocusChangeListener((l, focus)->{
            if(focus){
                ExpBottomDialog.newInstance((type)-> exp.setText(type)).show(getChildFragmentManager(), "kek");
            }
        });
        period.setOnFocusChangeListener((l, focus)->{
            if(focus){
                PeriodOplatyDialog.newInstance((type)->period.setText(type)).show(getChildFragmentManager(), "lol");
            }
        });

        address.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                AddressDialog.newInstance((type, addresss) -> address.setText(addresss), "").show(getChildFragmentManager(), AddressDialog.TAG);
            }
        });
    }

    private void handleCheckClickButton() {
        u_no.setOnClickListener(l->{
            udalenka = "Работа на месте";
        });
        u_yes.setOnClickListener(v->{
            udalenka = "Удаленная работа";
        });
        p_no.setOnClickListener(v->{
            podrabotka = "Не подработка";
        });
        p_yes.setOnClickListener(l->{
            podrabotka = "Подработка";
        });
    }

    private boolean checkPredectly() {
        if(grafic.getText().toString()!=null && !grafic.getText().toString().equals("") &&
                period.getText().toString()!=null && !period.getText().toString().equals("") &&
                address.getText().toString()!=null && !address.getText().toString().equals("") &&
                exp.getText().toString()!=null && !exp.getText().toString().equals("") &&
                chastota.getText().toString()!=null && !chastota.getText().toString().equals("") &&
                otPrice.getText().toString()!=null && !otPrice.getText().toString().equals("") &&
                doPrice.getText().toString()!=null && !doPrice.getText().toString().equals("") &&
                podrabotka!=null && !podrabotka.equals("") &&
                udalenka!=null && !udalenka.equals("")){
            return true;
        } else {
            Toast.makeText(getContext(),"Проверьте правильность введенных данных!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.work_head_fragment2;
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
}
