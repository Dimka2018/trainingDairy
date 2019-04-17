package com.fisherman.trainingdiary.activity.activity.workout;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.workout.DaggerWorkoutUpdateComponent;
import com.fisherman.trainingdiary.activity.view.TrainingDayView;
import com.fisherman.trainingdiary.activity.view.TrainingDayView_;
import com.fisherman.trainingdiary.contract.workout.WorkoutContract;
import com.fisherman.trainingdiary.contract.workout.WorkoutUpdateContract;
import com.fisherman.trainingdiary.databinding.ActivityWorkoutUpdateBinding;
import com.fisherman.trainingdiary.entity.Day;
import com.fisherman.trainingdiary.entity.Workout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

@SuppressLint("Registered")
@DataBound
@EActivity( R.layout.activity_workout_update)
public class WorkoutUpdateActivity extends AppCompatActivity implements WorkoutUpdateContract.View {

    private Workout workout;

    @ViewById
    ViewGroup workoutContent;

    @BindingObject
    ActivityWorkoutUpdateBinding binding;

    @Extra(WorkoutContract.EXTRA_KEY)
    Long workoutId;

    @Inject List<TrainingDayView> trainingDayViews;
    @Inject WorkoutUpdateContract.Presenter presenter;
    @Inject Toast toast;

    @AfterInject
    void inject() {
        DaggerWorkoutUpdateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        workout = presenter.getWorkoutById(workoutId);
        binding.setWorkout(workout);
        setupWorkout();
    }


    private void setupWorkout() {
        List<Day> dayListForWorkout = workout.getDayList();
        for (int i = 0; i < dayListForWorkout.size(); i ++) {
            Day day = dayListForWorkout.get(i);
            createDayView(day, i + 1);
        }
    }

    private void createDayView(final Day day, int dayNumber) {
        final TrainingDayView trainingDayView = TrainingDayView_.build(this, day, dayNumber);
        trainingDayView.setDeleteListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workout.getDayList().remove(day);
                trainingDayViews.remove(trainingDayView);
                for (int i = 0; i < trainingDayViews.size(); i++) {
                    trainingDayViews.get(i).setDayNumber(i + 1);
                }
            }
        });
        workoutContent.addView(trainingDayView);
    }

    @Click(R.id.add_day_button)
    void addWorkoutDay() {
        final Day day = new Day();
        List<Day> dayList = workout.getDayList();
        dayList.add(day);
        final TrainingDayView dayView = TrainingDayView_.build(this, day, dayList
                .size() + 1);
        workoutContent.addView(dayView);
        trainingDayViews.add(dayView);
        dayView.setDeleteListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workout.getDayList().remove(day);
                trainingDayViews.remove(dayView);
                for (int i = 0; i < trainingDayViews.size(); i++) {
                    trainingDayViews.get(i).setDayNumber(i + 1);
                }
            }
        });
    }

    @Click(R.id.updateButton)
    @Override
    public void onUpdateButtonClicked() {
        presenter.update(workout);
    }

    @Override
    public void showErrorMessage(String message) {
        toast.setText(message);
        toast.show();
    }
}
