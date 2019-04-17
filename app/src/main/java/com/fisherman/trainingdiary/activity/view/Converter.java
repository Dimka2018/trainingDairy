package com.fisherman.trainingdiary.activity.view;

import android.databinding.BindingAdapter;
import android.databinding.InverseMethod;
import android.view.View;
import android.widget.Adapter;

import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableSpinner;
import com.fisherman.trainingdiary.dto.WorkoutDTO;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.MassType;
import com.fisherman.trainingdiary.entity.TrainingPart;
import com.rey.material.widget.Spinner;

public class Converter {

    private Converter() {

    }

    public static String convertLongToString(Long number) {
        return String.valueOf(number);
    }

    @InverseMethod("convertLongToString")
    public static Long convertStringToLong(String string) {
        if (string != null && !"".equals(string)){
            return Long.valueOf(string);
        }
        return 0L;
    }

    public static String convertIntegerToString(Integer integer) {
        return String.valueOf(integer);
    }

    @InverseMethod("convertIntegerToString")
    public static Integer convertStringToInteger(String string) {
        if (string != null && !"".equals(string)){
            return Integer.valueOf(string);
        }
        return 0;
    }

    @BindingAdapter("app:trainingPart")
    public static void convertExercise(AutoRefreshableSpinner spinner, final TrainingPart
            trainingPart) {
        try {
            selectSpinnerItem(spinner, trainingPart.getExercise());
        } catch (Exception e) {
            Exercise exercise = (Exercise) spinner.getSelectedItem();
            trainingPart.setExerciseId(exercise.getId());
        }

        spinner.setOnElementSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner parent, View view, int position, long id) {
                trainingPart.setExerciseId(((Exercise)parent.getSelectedItem()).getId());
            }
        });
    }

    @BindingAdapter("app:selection")
    public static void convertWorkoutDTO(AutoRefreshableSpinner spinner, WorkoutDTO dto) {
        try {
            selectSpinnerItem(spinner, dto.getLastMeasure());
        } catch (Exception e) {
            spinner.setSelection(0);
        }

    }

    @BindingAdapter("app:history")
    public static void setHistoryMassType(AutoRefreshableSpinner spinner, final History history) {
        MassType mass = (MassType) spinner.getSelectedItem();
        history.setMassType(mass);
        history.setMassTypeId(mass.getId());
        spinner.setOnElementSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner parent, View view, int position, long id) {
                MassType massType = ((MassType)parent.getSelectedItem());
                history.setMassType(massType);
                history.setMassTypeId(massType.getId());
            }
        });
    }

    private static <T> void selectSpinnerItem(Spinner spinner, T item) throws Exception {
        Adapter adapter = spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).equals(item)){
                spinner.setSelection(i);
                return;
            }
        }
        throw new Exception("can't find item " + item);
    }


}
