package com.fisherman.trainingdiary.activity.activity.main;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseActivity_;
import com.fisherman.trainingdiary.activity.activity.profile.ProfileActivity_;
import com.fisherman.trainingdiary.activity.activity.statistic.StatisticActivity_;
import com.fisherman.trainingdiary.activity.activity.training.TrainingActivity_;
import com.fisherman.trainingdiary.activity.activity.weight.WeightActivity_;
import com.fisherman.trainingdiary.activity.activity.workout.WorkoutActivity_;
import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.inject.component.main.DaggerMainComponent;
import com.fisherman.trainingdiary.activity.view.ControlledPager;
import com.fisherman.trainingdiary.activity.view.adapter.PageInjectedAdapter;
import com.fisherman.trainingdiary.contract.main.MainContract;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * author Dmitry Plotnikov
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String DIALOG_TAG = "dialog";

    @ViewById ControlledPager pager;
    @ViewById View trainingStartView;
    @ViewById View workoutListView;
    @ViewById View exerciseListView;
    @ViewById View massTypeView;
    @ViewById View statisticView;
    @ViewById View profileView;

    @Inject PageInjectedAdapter adapter;
    @Inject MainContract.Presenter presenter;
    @Inject Lazy<Dialog> lazyDialog;

    @AfterInject
    void inject() {
        DaggerMainComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    public void setupMenu() {
        adapter.setViews(trainingStartView, workoutListView, exerciseListView,
                         massTypeView, statisticView, profileView);
        pager.setAdapter(adapter);
    }

    @Click(R.id.trainingStartView)
    void startTraining(){
            if (presenter.hasCurrentUserTraining()) {
                TrainingActivity_.intent(this).start();
            } else {
                Dialog dialog = lazyDialog.get();
                dialog.show(getFragmentManager(), DIALOG_TAG);
            }
    }

    @Click(R.id.workoutListView)
    @Override
    public void openWorkoutList(){
        pager.setSwipeEnabled(true);
        WorkoutActivity_.intent(this).start();
    }

    @Click(R.id.exerciseListView)
    void openExerciseList() {
        ExerciseActivity_.intent(this).start();
    }

    @Click(R.id.massTypeView)
    void openWeightList() {
        WeightActivity_.intent(this).start();
    }

    @Click(R.id.profileView)
    void openProfileList(){
        ProfileActivity_.intent(this).start();
    }

    @Click(R.id.statisticView)
    void openStatistic() {
        StatisticActivity_.intent(this).start();
    }

}
