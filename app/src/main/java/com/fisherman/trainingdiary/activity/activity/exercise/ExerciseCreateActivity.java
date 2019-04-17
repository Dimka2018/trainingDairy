package com.fisherman.trainingdiary.activity.activity.exercise;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.exercise.DaggerExerciseCreateComponent;
import com.fisherman.trainingdiary.contract.exercise.ExerciseCreateContract;
import com.fisherman.trainingdiary.databinding.ActivityExerciseCreateBinding;
import com.fisherman.trainingdiary.entity.Exercise;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

/**
 * author Dmitry Plotnikov
 */
@SuppressLint("Registered")
@DataBound
@EActivity(R.layout.activity_exercise_create)
public class ExerciseCreateActivity extends AppCompatActivity implements ExerciseCreateContract.View {

    @Inject Exercise exercise;
    @Inject ExerciseCreateContract.Presenter presenter;
    @Inject Toast toast;

    @BindingObject
    ActivityExerciseCreateBinding binding;

    @AfterInject
    void inject() {
        DaggerExerciseCreateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setExercise(exercise);
    }

    @Click(R.id.add_exercise_button)
    @Override
    public void onSaveButtonClicked() {
        presenter.saveExercise(exercise);
    }

    @Override
    public void showErrorMessage(String message) {
        toast.setText(message);
        toast.show();
    }
}
