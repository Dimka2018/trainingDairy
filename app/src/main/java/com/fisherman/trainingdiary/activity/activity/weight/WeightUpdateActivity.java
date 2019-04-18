package com.fisherman.trainingdiary.activity.activity.weight;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.weight.DaggerWeightUpdateComponent;
import com.fisherman.trainingdiary.contract.weight.WeightUpdateContract;
import com.fisherman.trainingdiary.databinding.ActivityWeightUpdateBinding;
import com.fisherman.trainingdiary.entity.MassType;
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
@EActivity(R.layout.activity_weight_update)
public class WeightUpdateActivity extends AppCompatActivity implements WeightUpdateContract.View {

    @Inject WeightUpdateContract.Presenter presenter;
    @Inject Lazy<Toast> lazyToast;

    @Extra(ExtraKey.WEIGHT_EXTRA_KEY)
    MassType massType;

    @BindingObject
    ActivityWeightUpdateBinding binding;

    @AfterInject
    void inject() {
        DaggerWeightUpdateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setMassType(massType);
    }

    @Click(R.id.saveButton)
    @Override
    public void onUpdateButtonClick() {
        presenter.updateWeight(massType);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
