package com.fisherman.trainingdiary.activity.inject.module.listener;

import android.app.Activity;
import android.view.View;

import com.fisherman.trainingdiary.activity.dialog.AddDialog;
import com.fisherman.trainingdiary.contract.training_view.TrainingViewContract;
import com.fisherman.trainingdiary.entity.MassType;
import com.rey.material.widget.Spinner;

import dagger.Module;
import dagger.Provides;

import static com.fisherman.trainingdiary.activity.activity.weight.WeightActivity.DIALOG_TAG;

@Module
public class TrainingViewNewMassTypeListenerModule {

    @Provides
    Spinner.OnItemSelectedListener provideListener(final AddDialog dialog, final Activity activity,
                                                   final TrainingViewContract.Presenter presenter) {
        return new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner parent, View view, int position, long id) {
                dialog.setOnSuccessClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MassType massType = new MassType();
                        massType.setName(dialog.getInputText());
                        presenter.saveWeight(massType);
                    }
                });
                dialog.show(activity.getFragmentManager(), DIALOG_TAG);
            }
        };
    }
}
