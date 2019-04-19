package com.fisherman.trainingdiary.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.ObservableInt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.animation.AnimationManager;
import com.fisherman.trainingdiary.activity.inject.component.training_view.DaggerTrainingViewComponent;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableSpinner;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.training_view.TrainingViewContract;
import com.fisherman.trainingdiary.databinding.TrainingPatternBinding;
import com.fisherman.trainingdiary.dto.WorkoutDTO;
import com.fisherman.trainingdiary.entity.History;
import com.rey.material.widget.CompoundButton;
import com.rey.material.widget.Spinner;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

@SuppressLint("ViewConstructor")
@DataBound
@EViewGroup(R.layout.training_pattern)
public class TrainingView extends FrameLayout implements TrainingViewContract.View {

    private static final int STARTING_SET = 1;

    private WorkoutDTO workoutDTO;
    private History history;
    private ObservableInt set;
    private OnClickListener setIncreaseCallback;

    @ViewById AutoRefreshableSpinner weightSpinner;
    @ViewById RelativeLayout bottomLine;
    @ViewById CompoundButton completeButton;
    @ViewById CompoundButton notCompleteButton;
    @ViewById TextView completedStatus;
    @ViewById View setDialogMenu;
    @ViewById View setNumber;
    @ViewById EditText weight;

    @Inject Spinner.OnItemSelectedListener listener;
    @Inject EntitySource weightEntitySource;
    @Inject Toast toast;

    @BindingObject
    TrainingPatternBinding binding;

    public TrainingView(Context context, WorkoutDTO workoutDTO, History history) {
        super(context);
        this.workoutDTO = workoutDTO;
        this.history = history;
        this.set = new ObservableInt(STARTING_SET);
    }

    @AfterInject
    void inject() {
        DaggerTrainingViewComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupView() {
        weightSpinner.setEntitySource(weightEntitySource, R.layout.no_frame_spinner_element,
                R.layout.no_frame_spinner_dropdown);
        weightSpinner.setOnNewElementSelectedListener(listener);
        binding.setWorkoutDto(workoutDTO);
        binding.setHistory(history);
        binding.setCurrentSet(set);
        bottomLine.removeView(setDialogMenu);
    }

    @CheckedChange({R.id.completeButton, R.id.notCompleteButton})
    void changeStatus(CompoundButton button, boolean isChecked) {
        if (isChecked) {
            completeButton.setChecked(completeButton == button);
            notCompleteButton.setChecked(notCompleteButton == button);
            history.setIsCompleted(completeButton.isChecked());
            completedStatus.setText(getContext().getString(completeButton.isChecked() ? R.string
                    .completed
                    : R.string.not_completed));
        }
    }

    @Click(R.id.set_complete_button)
    void increaseSet() {
        if (set.get() == workoutDTO.getNumberSets()) {
            ((ViewGroup) this.getParent()).removeView(this);
        } else {
            closeSetMenu();
            set.set(set.get() + 1);
        }
        if (setIncreaseCallback != null) {
            setIncreaseCallback.onClick(null);
        }
    }

    @Click(R.id.setNumber)
    void openSetMenu() {
        setNumber.setEnabled(false);
        bottomLine.addView(setDialogMenu);
        setDialogMenu.startAnimation(AnimationManager.getAnimation(R.anim
                .open_set_menu_animation, getContext()));
    }

    @Click(R.id.set_cancel_button)
    void closeSetMenu() {
        setDialogMenu.startAnimation(AnimationManager.getAnimation(R.anim
                .close_set_menu_animation, getContext()));
        bottomLine.removeView(setDialogMenu);
        setNumber.setEnabled(true);
    }

    @Override
    public void refresh() {
        weightSpinner.refresh();
    }

    @Override
    public void showErrorMessage(String message) {
        toast.setText(message);
        toast.show();
    }

    public void setSetIncreaseCallback(OnClickListener listener) {
        this.setIncreaseCallback = listener;
    }

}
