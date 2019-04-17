package com.fisherman.trainingdiary.activity.dialog;

import android.view.View;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.databinding.DialogBinding;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EFragment;

@DataBound
@EFragment(R.layout.dialog)
public class Dialog extends FullScreenDialog {

    @BindingObject
    DialogBinding binding;

    private View.OnClickListener positiveClickListener;
    private String message;


    @AfterViews
    void setupView() {
        binding.setMessage(message);
    }

    public void setPositiveClickListener(View.OnClickListener positiveClickListener) {
        this.positiveClickListener = positiveClickListener;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Click(R.id.positive_button)
    void handlePositiveClick() {
        dismiss();
        if (positiveClickListener != null) {
            positiveClickListener.onClick(null);
        }
    }

    @Click(R.id.negative_button)
    void close() {
        dismiss();
    }
}
