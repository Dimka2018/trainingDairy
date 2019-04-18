package com.fisherman.trainingdiary.activity.activity.exercise;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.exercise.DaggerExerciseComponent;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.exercise.ExerciseContract;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * @author Dmitry Plotnikov
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_exercise)
public class ExerciseActivity extends AppCompatActivity implements ExerciseContract.View {

    private static final int REQUEST_CODE = 1;

    @ViewById
    SwipeMenuListView swipeExerciseMenu;

    @Inject SwipeMenuCreator creator;
    @Inject AutoRefreshableListAdapter adapter;
    @Inject SwipeMenuListView.OnMenuItemClickListener listener;
    @Inject Lazy<Toast> lazyToast;

    @AfterInject
    void inject() {
        DaggerExerciseComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        swipeExerciseMenu.setAdapter(adapter);
        swipeExerciseMenu.setMenuCreator(creator);
        swipeExerciseMenu.setOnMenuItemClickListener(listener);
    }

    @Click(R.id.add_exercise_button)
     void startExerciseCreatingActivity() {
        ExerciseCreateActivity_.intent(this).startForResult(REQUEST_CODE);
    }

    @OnActivityResult(REQUEST_CODE)
    public void refresh() {
        adapter.refresh();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
