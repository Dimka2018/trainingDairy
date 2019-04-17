package com.fisherman.trainingdiary.activity.dialog;

import android.view.View;
import android.widget.EditText;

import com.fisherman.trainingdiary.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.add_dialog)
public class AddDialog extends FullScreenDialog {

    private View.OnClickListener onSuccessClickListener;
    private String inputHint;

    @ViewById
    EditText input;

    @AfterViews
    void setupView() {
        input.setHint(inputHint);
    }

    public void setHint(String hint) {
        this.inputHint = hint;
    }

    public String getInputText() {
        return input.getText().toString();
    }

    public void setOnSuccessClickListener(View.OnClickListener onSuccessClickListener) {
        this.onSuccessClickListener = onSuccessClickListener;
    }

    @Click(R.id.positive_button)
    void handlePositiveClick() {
        if (onSuccessClickListener != null) {
            onSuccessClickListener.onClick(null);
        }
        dismiss();
    }

    @Click(R.id.negative_button)
    void close() {
        dismiss();
    }
}
