package com.fisherman.trainingdiary.activity.activity.workout;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.workout.DaggerWorkoutCreateComponent;
import com.fisherman.trainingdiary.activity.view.TrainingDayView;
import com.fisherman.trainingdiary.activity.view.TrainingDayView_;
import com.fisherman.trainingdiary.contract.workout.WorkoutCreateContract;
import com.fisherman.trainingdiary.databinding.ActivityWorkoutCreateBinding;
import com.fisherman.trainingdiary.entity.Day;
import com.fisherman.trainingdiary.entity.Workout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

@SuppressLint("Registered")
@DataBound
@EActivity(R.layout.activity_workout_create)
public class WorkoutCreateActivity extends AppCompatActivity implements WorkoutCreateContract.View {

    @ViewById
    LinearLayout dayContainer;

    @BindingObject
    ActivityWorkoutCreateBinding binding;

    @Inject Workout workout;
    @Inject List<TrainingDayView> dayViews;
    @Inject WorkoutCreateContract.Presenter presenter;
    @Inject Lazy<Toast> lazyToast;
    @Inject Provider<Day> dayProvider;

    @AfterInject
    void inject() {
        DaggerWorkoutCreateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setWorkout(workout);
    }

    @Click(R.id.add_day_button)
    void addWorkoutDay() {
        final Day day = dayProvider.get();
        final TrainingDayView dayView = TrainingDayView_.build(this, day,
                workout.getDayList().size() + 1);
        dayViews.add(dayView);
        workout.getDayList().add(day);
        dayView.setDeleteListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayViews.remove(dayView);
                workout.getDayList().remove(day);
                for (int i = 0; i < dayViews.size(); i++) {
                    dayViews.get(i).setDayNumber(i + 1);
                }
            }
        });
        dayContainer.addView(dayView);
    }

    @Click(R.id.saveButton)
    @Override
    public void onSaveButtonClicked() {
        presenter.saveWorkout(workout);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
