package com.fisherman.trainingdiary.activity.inject.module.listener;

import android.app.Activity;
import android.view.View;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.activity.activity.weight.WeightUpdateActivity_;
import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.weight.WeightContract;
import com.fisherman.trainingdiary.entity.MassType;

import java.util.NoSuchElementException;

import dagger.Module;
import dagger.Provides;

import static com.fisherman.trainingdiary.activity.activity.weight.WeightActivity.DIALOG_TAG;

@Module
public class WeightItemListenerModule {

    private static final int REQUEST_CODE = 1;

    @ActivityScope
    @Provides
    SwipeMenuListView.OnMenuItemClickListener provideItemListener(final AutoRefreshableListAdapter adapter,
                                                                    final Activity activity,
                                                                    final Dialog dialog,
                                                                    final WeightContract.Presenter presenter) {
        return new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                final MassType massType = (MassType) adapter.get(position);
                switch(index){
                    case 0:
                        WeightUpdateActivity_.intent(activity).extra(WeightContract.EXTRA_KEY, massType)
                                .startForResult
                                        (REQUEST_CODE);
                        break;
                    case 1:
                        dialog.setPositiveClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.deleteMassType(massType);
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
