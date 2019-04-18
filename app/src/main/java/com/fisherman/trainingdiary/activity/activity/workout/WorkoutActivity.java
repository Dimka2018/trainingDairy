package com.fisherman.trainingdiary.activity.activity.workout;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.workout.DaggerWorkoutComponent;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.workout.WorkoutContract;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * author Dmitry Plotnikov
 */
@SuppressLint("Registered")
@EActivity(R.layout.activity_workout)
public class WorkoutActivity extends AppCompatActivity implements WorkoutContract.View {

    private static final int REQUEST_CODE = 1;

    @ViewById
    SwipeMenuListView swipeMenu;

    @Inject AutoRefreshableListAdapter adapter;
    @Inject SwipeMenuCreator creator;
    @Inject SwipeMenuListView.OnMenuItemClickListener listener;
    @Inject Lazy<Toast> lazyToast;

    @AfterInject
    void inject() {
        DaggerWorkoutComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        swipeMenu.setAdapter(adapter);
        swipeMenu.setMenuCreator(creator);
        swipeMenu.setOnMenuItemClickListener(listener);
    }

    @Click(R.id.add_exercise_button)
    void openCreateView(){
        WorkoutCreateActivity_.intent(this).startForResult(REQUEST_CODE);
    }

    @OnActivityResult(REQUEST_CODE)
    public void refresh() {
        adapter.refresh();
        swipeMenu.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
