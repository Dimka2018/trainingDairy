package com.fisherman.trainingdiary.activity.activity.exercise;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.exercise.DaggerExerciseUpdateComponent;
import com.fisherman.trainingdiary.contract.exercise.ExerciseUpdateContract;
import com.fisherman.trainingdiary.databinding.ActivityExerciseUpdateBinding;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.resource.ExtraKey;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * author Dmitry Plotnikov
 */
@SuppressLint("Registered")
@DataBound
@EActivity(R.layout.activity_exercise_update)
public class ExerciseUpdateActivity extends AppCompatActivity implements ExerciseUpdateContract.View {

    @Extra(ExtraKey.EXERCISE_EXTRA_KEY)
    Exercise exercise;

    @Inject ExerciseUpdateContract.Presenter presenter;
    @Inject Lazy<Toast> lazyToast;

    @BindingObject
    ActivityExerciseUpdateBinding binding;

    @AfterInject
    void inject() {
        DaggerExerciseUpdateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setExercise(exercise);
    }

    @Click(R.id.saveButton)
    @Override
    public void onUpdateButtonClicked() {
        presenter.updateExercise(exercise);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
