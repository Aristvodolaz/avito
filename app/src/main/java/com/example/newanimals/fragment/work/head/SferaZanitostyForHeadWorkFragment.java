package com.example.newanimals.fragment.work.head;

import android.widget.LinearLayout;
import android.widget.Space;

import com.example.newanimals.R;
import com.example.newanimals.activity.CreateAdsActivity;
import com.example.newanimals.fragment.BaseFragment;
import com.example.newanimals.fragment.work.ChooseSferaZanitostiFragment;
import com.example.newanimals.fragment.work.worker.WorkWorkerFragment2;
import com.example.newanimals.utils.SPHelper;

import butterknife.BindView;

public class SferaZanitostyForHeadWorkFragment extends BaseFragment{
        @BindView(R.id.it)
        LinearLayout it;
        @BindView(R.id.auto)
        LinearLayout auto;
        @BindView(R.id.admin)
        LinearLayout admin;
        @BindView(R.id.banki)
        LinearLayout banki;
        @BindView(R.id.student)
        LinearLayout student;
        @BindView(R.id.buh)
        LinearLayout buh;
        @BindView(R.id.menage)
        LinearLayout menage;
        @BindView(R.id.gos)
        LinearLayout gos;
        @BindView(R.id.home)
        LinearLayout home;
        @BindView(R.id.zhkh)
        LinearLayout zkh;
        @BindView(R.id.iskusstvo)
        LinearLayout iskusstvo;
        @BindView(R.id.konsul)
        LinearLayout konsul;
        @BindView(R.id.delivery)
        LinearLayout delivery;
        @BindView(R.id.marketing)
        LinearLayout marketing;
        @BindView(R.id.med)
        LinearLayout med;
        @BindView(R.id.since)
        LinearLayout since;
        @BindView(R.id.save)
        LinearLayout save;
        @BindView(R.id.pays)
        LinearLayout pays;
        @BindView(R.id.proizvodstvo)
        LinearLayout proizvodstvo;
        @BindView(R.id.strahovanie)
        LinearLayout strahovanie;
        @BindView(R.id.building)
        LinearLayout building;
        @BindView(R.id.taxi)
        LinearLayout taxi;
        @BindView(R.id.transport)
        LinearLayout transport;
        @BindView(R.id.tourizm)
        LinearLayout tourizm;
        @BindView(R.id.personal)
        LinearLayout persnal;
        @BindView(R.id.fitnes)
        LinearLayout fitnes;
        @BindView(R.id.urist)
        LinearLayout urist;

        public static SferaZanitostyForHeadWorkFragment newInstance() {
            return new SferaZanitostyForHeadWorkFragment();
        }

        @Override
        protected void initViews() {
            super.initViews();
            it.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("IT, интернет, телеком");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            auto.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Автомобильный бизнес");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            admin.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Административная работа");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            banki.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Банки, инвестиции");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            student.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Без опыта, студенты");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            buh.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Бухгалтерия, финансы");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            menage.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Высший менеджмент");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            gos.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Госслужба, НКО");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            home.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Домашний персонал");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            zkh.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("ЖКХ, эксплуатация");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            iskusstvo.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Искусство, развлечения");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            konsul.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Консультирование");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            delivery.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Курьерская доставка");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            marketing.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Маркетинг, реклама, PR");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            med.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Медицина, фармацевтика");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            since.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Образование, наука");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            save.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Охрана, безопасность");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            pays.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Продажи");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            proizvodstvo.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Производство, сырьё, с/х");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            strahovanie.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Страхование");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            building.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Строительство");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            taxi.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Такси");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            transport.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Транспорт");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            tourizm.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Туризм, рестораны");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            persnal.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Управление персоналом");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            fitnes.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Фитнес, салоны красоты");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
            urist.setOnClickListener(v->{
                SPHelper.setSferaZanitosty("Юристпруденция");
                ((CreateAdsActivity)getActivity()).replaceFragment(WorkHeadFragment2.newInstance(), true);
            });
        }

        @Override
        protected int layoutId() {
            return R.layout.choose_sfera_zanitosti_fragment;
        }
}
