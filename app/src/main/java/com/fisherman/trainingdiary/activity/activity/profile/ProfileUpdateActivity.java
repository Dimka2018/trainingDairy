package com.fisherman.trainingdiary.activity.activity.profile;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.profile.DaggerProfileUpdateComponent;
import com.fisherman.trainingdiary.contract.profile.ProfileUpdateContract;
import com.fisherman.trainingdiary.databinding.ActivityProfileUpdateBinding;
import com.fisherman.trainingdiary.entity.Profile;
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
@EActivity(R.layout.activity_profile_update)
public class ProfileUpdateActivity extends AppCompatActivity implements ProfileUpdateContract.View {

    @Extra(ExtraKey.PROFILE_EXTRA_KEY)
    Profile profile;

    @Inject ProfileUpdateContract.Presenter presenter;
    @Inject Lazy<Toast> lazyToast;

    @BindingObject
    ActivityProfileUpdateBinding binding;

    @AfterInject
    void inject() {
        DaggerProfileUpdateComponent.builder().context(this).build().inject(this);
    }

    @AfterViews
    void setupPage() {
        binding.setProfile(profile);
    }

    @Click(R.id.updateButton)
    @Override
    public void onUpdateButtonClicked() {
        presenter.updateProfile(profile);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast toast = lazyToast.get();
        toast.setText(message);
        toast.show();
    }
}
