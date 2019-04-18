package com.fisherman.trainingdiary.activity.activity.profile;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.profile.DaggerProfileComponent;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.profile.ProfileContract;

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
@EActivity(R.layout.activity_user)
public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    private static final int REQUEST_CODE = 1;

    @ViewById
    SwipeMenuListView swipeProfileMenu;

    @Inject SwipeMenuCreator creator;
    @Inject AutoRefreshableListAdapter adapter;
    @Inject SwipeMenuListView.OnMenuItemClickListener listener;
    @Inject Lazy<Toast> lazyToast;


    @AfterInject
    void inject() {
        DaggerProfileComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        swipeProfileMenu.setAdapter(adapter);
        swipeProfileMenu.setMenuCreator(creator);
        swipeProfileMenu.setOnMenuItemClickListener(listener);
    }

    @Click(R.id.add_profile_button)
    void openAddProfileActivity(){
        ProfileCreateActivity_.intent(this).startForResult(REQUEST_CODE);
    }

    @OnActivityResult(REQUEST_CODE)
    public void refresh() {
        adapter.refresh();
        swipeProfileMenu.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
