package com.fisherman.trainingdiary.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.animation.AnimationManager;
import com.fisherman.trainingdiary.databinding.TrainingDayPatternBinding;
import com.fisherman.trainingdiary.entity.Day;
import com.fisherman.trainingdiary.entity.TrainingPart;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ViewConstructor")
@DataBound
@EViewGroup(R.layout.training_day_pattern)
public class TrainingDayView extends FrameLayout {

    private boolean isOpened = true;
    private View.OnClickListener onDeleteListener;
    private Day day;
    private ObservableInt dayNumber;

    @ViewById View upperSpear;
    @ViewById View lowerSpear;
    @ViewById ViewGroup dayContent;
    @ViewById View deleteButton;

    @BindingObject
    TrainingDayPatternBinding binding;

    List<TrainingPartView> trainingPartViews;

    private Context context;

    public TrainingDayView(@NonNull Context context, Day day, int dayNumber) {
        super(context);
        this.context = context;
        this.day = day;
        this.dayNumber = new ObservableInt(dayNumber);
        trainingPartViews = new ArrayList<>();
    }

    @AfterViews
    void setupView() {
        binding.setDay(day);
        binding.setDayNumber(this.dayNumber);
        buildViews(day);
    }

    private void buildViews(Day day) {
        for (TrainingPart trainingPart : day.getTrainingPartList()) {
            addTrainingPartView(trainingPart);
        }
    }

    public void addTrainingPartView(final TrainingPart trainingPart) {
        final TrainingPartView trainingPartView = TrainingPartView_.build(context,
                trainingPart, trainingPartViews.size() + 1);
        trainingPartViews.add(trainingPartView);
        trainingPartView.setOnDeleteClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                List<TrainingPart> trainingPartList = day.getTrainingPartList();
                trainingPartList.remove(trainingPart);
                trainingPartViews.remove(trainingPartView);
                for (int i = 0; i < trainingPartList.size(); i++) {
                    trainingPartViews.get(i).setExerciseNumber(i + 1);
                }
            }
        });
        dayContent.addView(trainingPartView);
    }

    @Click(R.id.addButton)
    void addTrainingPart() {
        final TrainingPart trainingPart = new TrainingPart();
        day.getTrainingPartList().add(trainingPart);
        addTrainingPartView(trainingPart);
    }

    @Click({R.id.lowerSpear, R.id.upperSpear})
    void toggle() {
        if (!isOpened) {
            open();
        } else {
            close();
        }
    }

    private void close() {
        upperSpear.startAnimation(AnimationManager.getAnimation(R.anim.rotate_spear_to_close,
                getContext()));
        lowerSpear.startAnimation(AnimationManager.getAnimation(R.anim.rotate_spear_to_close,
                getContext()));
        dayContent.removeAllViews();
        isOpened = false;
    }

    private void open() {
        upperSpear.startAnimation(AnimationManager.getAnimation(R.anim.rotate_spear_to_open,
                getContext()));
        lowerSpear.startAnimation(AnimationManager.getAnimation(R.anim.rotate_spear_to_open,
                getContext()));
        for(TrainingPartView view : trainingPartViews) {
            dayContent.addView(view);
        }
        isOpened = true;
    }

    @Click(R.id.deleteButton)
    void delete() {
        ((ViewGroup) getParent()).removeView(this);
        if (onDeleteListener != null) {
            onDeleteListener.onClick(deleteButton);
        }
    }

    public void setDeleteListener(View.OnClickListener deleteListener) {
        this.onDeleteListener = deleteListener;
    }

    public void setDayNumber(int number) {
        this.dayNumber.set(number);
    }

}
