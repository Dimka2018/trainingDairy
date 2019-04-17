package com.fisherman.trainingdiary.activity.inject.module.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.statistic.StatisticContract;
import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class WeightListAdapterModule {

    @Provides
    @Named("weightAdapter")
    ArrayAdapter provideAdapter(Context context, StatisticContract.Presenter presenter) {
        List<MassType> massTypeList = presenter.getMassTypeList();
        ArrayAdapter weightAdapter = new ArrayAdapter<>(context, R.layout.no_frame_spinner_element);
        weightAdapter.setDropDownViewResource(R.layout.no_frame_spinner_dropdown);
        if (massTypeList.isEmpty()) {
            weightAdapter.add(context.getString(R.string.no_weight));
        } else {
            weightAdapter.addAll(massTypeList);
        }
        return weightAdapter;
    }
}
