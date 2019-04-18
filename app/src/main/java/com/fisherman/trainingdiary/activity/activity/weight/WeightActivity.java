package com.fisherman.trainingdiary.activity.activity.weight;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.weight.DaggerWeightComponent;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.contract.weight.WeightContract;

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
@EActivity(R.layout.activity_weight)
public class WeightActivity extends AppCompatActivity implements WeightContract.View {

    private static final int REQUEST_CODE = 1;
    public static final String DIALOG_TAG = "dialog";

    @ViewById
    SwipeMenuListView swipeWeightMenu;

    @Inject SwipeMenuCreator creator;
    @Inject AutoRefreshableListAdapter adapter;
    @Inject SwipeMenuListView.OnMenuItemClickListener listener;
    @Inject Lazy<Toast> lazyToast;

    @AfterInject
    void inject() {
        DaggerWeightComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        swipeWeightMenu.setAdapter(adapter);
        swipeWeightMenu.setMenuCreator(creator);
        swipeWeightMenu.setOnMenuItemClickListener(listener);
    }

    @Click(R.id.add_weight_button)
    void startWeightCreateActivity() {
        WeightCreateActivity_.intent(this).startForResult(REQUEST_CODE);
    }

    @OnActivityResult(REQUEST_CODE)
    public void refresh() {
        adapter.refresh();
    }

    @Override
    public void showErrorMesage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
