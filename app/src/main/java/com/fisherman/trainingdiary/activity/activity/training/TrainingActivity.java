package com.fisherman.trainingdiary.activity.activity.training;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.dialog.training_list.TrainingListDialog;
import com.fisherman.trainingdiary.activity.inject.component.training.DaggerTrainingComponent;
import com.fisherman.trainingdiary.activity.view.TimerView;
import com.fisherman.trainingdiary.activity.view.TrainingView;
import com.fisherman.trainingdiary.activity.view.TrainingView_;
import com.fisherman.trainingdiary.contract.training.TrainingContract;
import com.fisherman.trainingdiary.dto.WorkoutDTO;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.entity.TrainingPart;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@SuppressLint("Registered")
@EActivity(R.layout.activity_training)
public class TrainingActivity extends AppCompatActivity implements TrainingContract.View {

    private static final String DIALOG_TAG = "finish";

    private List<TrainingPart> trainingPartList;

    @ViewById ViewGroup exerciseContainer;
    @ViewById FlowingDrawer slider;
    @ViewById TimerView timer;

    @Inject TrainingContract.Presenter presenter;
    @Inject Lazy<TrainingListDialog> lazyDialog;
    @Inject List<TrainingView> views;
    @Inject List<History> historyList;

    @AfterInject
    void inject() {
        DaggerTrainingComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        Profile current = presenter.getCurrentProfile();
        this.trainingPartList = current.getCurrentDay().getTrainingPartList();
        for (TrainingPart part : trainingPartList) {
            WorkoutDTO workoutDTO = presenter.getWorkoutDTO(part);
            History hist = workoutDTO.getHistory();
            historyList.add(hist);
            TrainingView trainingView = TrainingView_.build(this, workoutDTO, hist);
            trainingView.setSetIncreaseCallback(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openSideMenu();
                    startTimer();
                }
            });
            views.add(trainingView);
            exerciseContainer.addView(trainingView);
        }
    }

    @Click(R.id.saveButton)
    void showFinishDialog() {
        TrainingListDialog dialog = lazyDialog.get();
        dialog.setHistoryList(historyList);
        dialog.setOnSuccessClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFinishWorkoutButtonClicked(trainingPartList, historyList);
            }
        });
        dialog.setOnCorrectClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciseContainer.removeAllViews();
                for (View view : views) {
                    exerciseContainer.addView(view);
                }
                slider.closeMenu();
            }
        });
        dialog.show(getFragmentManager(), DIALOG_TAG);
    }

    @Click(R.id.timer)
    void toggleTimer() {
        timer.toggle();
    }

    @Override
    public void openSideMenu() {
        slider.openMenu();
    }

    @Override
    public void startTimer() {
        timer.resume();
    }
}
