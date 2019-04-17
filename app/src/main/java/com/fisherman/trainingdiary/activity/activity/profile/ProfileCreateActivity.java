package com.fisherman.trainingdiary.activity.activity.profile;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.profile.DaggerProfileCreateComponent;
import com.fisherman.trainingdiary.contract.profile.ProfileCreateContract;
import com.fisherman.trainingdiary.databinding.ActivityProfileCreateBinding;
import com.fisherman.trainingdiary.entity.Profile;

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
@EActivity(R.layout.activity_profile_create)
public class ProfileCreateActivity extends AppCompatActivity implements ProfileCreateContract.View {

    @Inject Profile profile;
    @Inject ProfileCreateContract.Presenter presenter;
    @Inject Toast toast;

    @BindingObject
    ActivityProfileCreateBinding binding;

    @AfterInject
    void inject() {
        DaggerProfileCreateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setProfile(profile);
    }

    @Click(R.id.saveButton)
    @Override
    public void onSaveButtonClicked() {
        presenter.saveProfile(profile);
    }

    @Override
    public void showErrorMessage(String message) {
        toast.setText(message);
        toast.show();
    }
}
