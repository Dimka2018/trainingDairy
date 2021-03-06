package com.fisherman.trainingdiary.activity.inject.module.listener;

import android.app.Activity;
import android.view.View;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.activity.activity.profile.ProfileUpdateActivity_;
import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.profile.ProfileContract;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.resource.ExtraKey;

import java.util.NoSuchElementException;

import dagger.Module;
import dagger.Provides;

import static com.fisherman.trainingdiary.activity.activity.weight.WeightActivity.DIALOG_TAG;

@Module
public class ProfileItemListenerModule {

    private static final int REQUEST_CODE = 1;

    @ActivityScope
    @Provides
    SwipeMenuListView.OnMenuItemClickListener provideItemListener(final AutoRefreshableListAdapter adapter,
                                                                  final ProfileContract.Presenter presenter,
                                                                  final Activity activity, final Dialog
                                                                  dialog) {
        return new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                final Profile profile = (Profile) adapter.get(position);
                switch(index){
                    case 0:
                        presenter.activateProfile(profile);
                        break;
                    case 1:
                        ProfileUpdateActivity_.intent(activity).extra(ExtraKey.PROFILE_EXTRA_KEY, profile)
                                .startForResult
                                        (REQUEST_CODE);
                        break;
                    case 2:
                        dialog.setPositiveClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.deleteProfile(profile);
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
