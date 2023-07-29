package com.example.newanimals.view;

import com.example.newanimals.db.AdsData;
import com.example.newanimals.db.ServiceData;
import com.example.newanimals.db.WorkHeadData;

import java.util.List;

public interface LoadDataView {
    void getMessage(String str);
    void getData(List<AdsData> data);

}
