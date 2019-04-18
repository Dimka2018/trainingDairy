package com.fisherman.trainingdiary.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.animation.AnimationManager;
import com.fisherman.trainingdiary.activity.inject.component.training_part.DaggerTrainingPartComponent;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableSpinner;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.training_part.TrainingPartContract;
import com.fisherman.trainingdiary.databinding.TrainingPartPatternBinding;
import com.fisherman.trainingdiary.entity.TrainingPart;
import com.rey.material.widget.Spinner;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.Lazy;

@SuppressLint("ViewConstructor")
@DataBound
@EViewGroup(R.layout.training_part_pattern)
public class TrainingPartView extends FrameLayout implements TrainingPartContract.View {

    private TrainingPart trainingPart;
    private View.OnClickListener onDeleteListener;
    private boolean isOpened = true;
    private ObservableInt exerciseNumber;

    @ViewById AutoRefreshableSpinner exerciseSpinner;
    @ViewById View spear;
    @ViewById View exerciseContainer;
    @ViewById ViewGroup globalContainer;

    @Inject EntitySource source;
    @Inject Spinner.OnItemSelectedListener newElemListener;
    @Inject Lazy<Toast> lazyToast;

    @BindingObject
    TrainingPartPatternBinding binding;

    public TrainingPartView(@NonNull Context context, TrainingPart trainingPart, int
            exerciseNumber) {
        super(context);
        this.trainingPart = trainingPart;
        this.exerciseNumber = new ObservableInt(exerciseNumber);
    }

    @AfterInject
    void inject() {
        DaggerTrainingPartComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupView() {
        exerciseSpinner.setEntitySource(source);
        exerciseSpinner.setOnNewElementSelectedListener(newElemListener);
        binding.setTrainingPart(trainingPart);
        binding.setExerciseNumber(this.exerciseNumber);
    }

    @Click(R.id.spear)
    void toggle() {
        if (!isOpened) {
            open();
        } else {
            close();
        }
    }

    private void close() {
        spear.startAnimation(AnimationManager.getAnimation(R.anim.rotate_spear_to_close, getContext()));
        globalContainer.removeView(exerciseContainer);
        isOpened = false;
    }

    private void open() {
        spear.startAnimation(AnimationManager.getAnimation(R.anim.rotate_spear_to_open, getContext()));
        globalContainer.addView(exerciseContainer, 0);
        isOpened = true;
    }

    public void setExerciseNumber(int exerciseNumber) {
        this.exerciseNumber.set(exerciseNumber);
    }

    @Click(R.id.delete_day_button)
    void delete() {
            ((ViewGroup) getParent()).removeView(this);
            if (onDeleteListener != null) {
                onDeleteListener.onClick(null);
            }
    }

    public void setOnDeleteClickListener(View.OnClickListener listener) {
        this.onDeleteListener = listener;
    }

    @Override
    public void refresh() {
        exerciseSpinner.refresh();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
