package com.example.newanimals.fragment.service;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.presenter.ServicePresenter;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class ChooseCategoryServiceAdsFragment extends BaseFragment {
    @BindView(R.id.close_btn)
    ImageView closeBtn;
    @BindView(R.id.it)
    LinearLayout it;
    @BindView(R.id.byt_uslugi)
    LinearLayout bytUslugi;
    @BindView(R.id.uslugi)
    LinearLayout uslugi;
    @BindView(R.id.iskusstvo)
    LinearLayout isskustvo;
    @BindView(R.id.krasota)
    LinearLayout krasota;
    @BindView(R.id.delivery)
    LinearLayout delivery;
    @BindView(R.id.master)
    LinearLayout master;
    @BindView(R.id.sidelki)
    LinearLayout sidelki;
    @BindView(R.id.oborydovanie)
    LinearLayout oborudovanie;
    @BindView(R.id.kurs)
    LinearLayout kurs;
    @BindView(R.id.ohrana)
    LinearLayout ohrana;
    @BindView(R.id.pitanie)
    LinearLayout pitanie;
    @BindView(R.id.prazdnik)
    LinearLayout prazdnik;
    @BindView(R.id.reklama)
    LinearLayout reklama;
    @BindView(R.id.remont_obsluzh)
    LinearLayout remont_obsluzh;
    @BindView(R.id.remont_otdelka)
    LinearLayout remont_otdelka;
    @BindView(R.id.building)
    LinearLayout building;
    @BindView(R.id.sad)
    LinearLayout sad;
    @BindView(R.id.transport)
    LinearLayout transport;
    @BindView(R.id.musor)
    LinearLayout musor;
    @BindView(R.id.uborka)
    LinearLayout uborka;
    @BindView(R.id.ustanovka)
    LinearLayout ustanovka;
    @BindView(R.id.photo)
    LinearLayout photo;
    @BindView(R.id.other)
    LinearLayout other;
    @Override
    protected void initViews() {
        super.initViews();
        closeBtn.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
        it.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("IT, интернет, телеком");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        bytUslugi.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Бытовые услуги");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        uslugi.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Деловые услуги");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        isskustvo.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Искусство");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        krasota.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Красота, здоровье");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        delivery.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Курьерские поручения");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        master.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Мастер на час");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        sidelki.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Няни, сиделки");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        oborudovanie.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Оборудование, производство");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        kurs.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Обучение, курсы");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        ohrana.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Охрана, безопасность");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        pitanie.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Питание, кейтеринг");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        prazdnik.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Праздники, мероприятия");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        reklama.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Реклама, полиграфия");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        remont_obsluzh.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Ремонт и обслуживание техники");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        remont_otdelka.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Ремонт и отделка");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        building.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Строительство");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        sad.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Сад, благоустройство");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        transport.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Транспорт, перевозки");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        musor.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Вывоз мусора и вторсырья");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        uborka.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Уборка");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        ustanovka.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Установка техники");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        photo.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Фото и видеосъёмка");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
        other.setOnClickListener(l->{
            SPHelper.ServiceHelper.setCategoryService("Другое");
            ((CreateAdsActivity)getActivity()).replaceFragment(ServiceFragment.newInstance(), true);
        });
    }

    public static ChooseCategoryServiceAdsFragment newInstance() {
        return new ChooseCategoryServiceAdsFragment();
    }
    @Override
    protected int layoutId() {
        return R.layout.choose_category_service_fragment;
    }
}
