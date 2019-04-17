package com.fisherman.trainingdiary.activity.dialog.training_list;

import android.view.View;
import android.view.ViewGroup;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.dialog.FullScreenDialog;
import com.fisherman.trainingdiary.entity.History;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.training_list_dialog)
public class TrainingListDialog extends FullScreenDialog {

    @ViewById
    ViewGroup listContainer;

    @ViewById
    View correctButton;

    @ViewById
    View positiveButton;

    private View.OnClickListener onSuccessClickListener;
    private View.OnClickListener onCorrectClickListener;
    private List<History> historyList;

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    @AfterViews
    void setupDialog() {
        for (History history : historyList) {
            listContainer.addView(TrainingListItem_.build(getActivity(), history));
        }
    }

    public void setOnSuccessClickListener(View.OnClickListener onSuccessClickListener) {
        this.onSuccessClickListener = onSuccessClickListener;
    }

    public void setOnCorrectClickListener(View.OnClickListener onCorrectClickListener) {
        this.onCorrectClickListener = onCorrectClickListener;
    }

    @Click(R.id.positiveButton)
    void executePositiveClick() {
        dismiss();
        if (onSuccessClickListener != null) {
            onSuccessClickListener.onClick(null);
        }
    }

    @Click(R.id.negativeButton)
    void executeCancelClick() {
        dismiss();
    }

    @Click(R.id.correctButton)
    void executeCorrectClick() {
        dismiss();
        if (onCorrectClickListener != null) {
            onCorrectClickListener.onClick(null);
        }
    }
}
