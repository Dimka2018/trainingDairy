package com.fisherman.trainingdiary.activity.inject.module.listener;

import android.app.Activity;
import android.view.View;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.activity.activity.workout.WorkoutUpdateActivity_;
import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.workout.WorkoutContract;
import com.fisherman.trainingdiary.entity.Workout;
import com.fisherman.trainingdiary.resource.ExtraKey;

import java.util.NoSuchElementException;

import dagger.Module;
import dagger.Provides;

import static com.fisherman.trainingdiary.activity.activity.weight.WeightActivity.DIALOG_TAG;

@Module
public class WorkoutItemListenerModule {

    private static final int REQUEST_CODE = 1;

    @ActivityScope
    @Provides
    SwipeMenuListView.OnMenuItemClickListener provideItemListener(final AutoRefreshableListAdapter adapter,
                                                                  final WorkoutContract.Presenter presenter,
                                                                  final Activity activity,
                                                                  final Dialog dialog) {
        return new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                final Workout workout = (Workout) adapter.get(position);
                switch (index){
                    case 0:
                        presenter.activateWorkout(workout);
                        break;
                    case 1:
                        workout.loadFull();
                        WorkoutUpdateActivity_.intent(activity).extra(ExtraKey.WORKOUT_EXTRA_KEY,
                                workout).startForResult(REQUEST_CODE);
                        break;
                    case 2:
                        dialog.setPositiveClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.deleteWorkout(workout);
                            }
                        });
                        dialog.show(activity.getFragmentManager(), DIALOG_TAG);
                        break;
                    default:
                        throw new NoSuchElementException("Unknown button " + index);
                }
                return false;
            }
        };
    }
}
