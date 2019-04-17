package com.fisherman.trainingdiary.activity.inject.module.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.statistic.StatisticContract;
import com.fisherman.trainingdiary.entity.Exercise;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ExerciseListAdapterModule {

    @Provides
    @Named("exerciseAdapter")
    ArrayAdapter provideAdapter(Context context, StatisticContract.Presenter presenter) {
        List<Exercise> exerciseList = presenter.getExerciseList();
        ArrayAdapter exerciseAdapter = new ArrayAdapter<>(context, R.layout.no_frame_spinner_element);
        if (exerciseList.isEmpty()) {
            exerciseAdapter.add(context.getString(R.string.no_exercise));
        } else {
            exerciseAdapter.addAll(exerciseList);
        }
        exerciseAdapter.setDropDownViewResource(R.layout.no_frame_spinner_dropdown);
        return exerciseAdapter;
    }
}
