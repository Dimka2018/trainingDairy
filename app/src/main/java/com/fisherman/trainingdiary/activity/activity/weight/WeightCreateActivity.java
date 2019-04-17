package com.fisherman.trainingdiary.activity.activity.weight;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.weight.DaggerWeightCreateComponent;
import com.fisherman.trainingdiary.contract.weight.WeightCreateContract;
import com.fisherman.trainingdiary.databinding.ActivityWeightCreateBinding;
import com.fisherman.trainingdiary.entity.MassType;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

/**
 * author Dmitry Plotnikov
 */
@SuppressLint("Registered")
@DataBound
@EActivity( R.layout.activity_weight_create)
public class WeightCreateActivity extends AppCompatActivity implements WeightCreateContract.View {

    @Inject MassType massType;
    @Inject WeightCreateContract.Presenter presenter;
    @Inject Toast toast;

    @BindingObject
    ActivityWeightCreateBinding binding;

    @AfterInject
    void inject() {
        DaggerWeightCreateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setMassType(massType);
    }

    @Click(R.id.saveButton)
    @Override
    public void onSaveButtonClick() {
        presenter.saveWeight(massType);
    }

    @Override
    public void showErrorMessage(String message) {
        toast.setText(message);
        toast.show();
    }
}
