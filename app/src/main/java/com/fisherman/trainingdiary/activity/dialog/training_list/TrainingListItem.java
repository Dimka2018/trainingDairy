package com.fisherman.trainingdiary.activity.dialog.training_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.databinding.TrainingListPatternBinding;
import com.fisherman.trainingdiary.entity.History;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EViewGroup;

@DataBound
@EViewGroup(R.layout.training_list_pattern)
public class TrainingListItem extends FrameLayout {

    @BindingObject
    TrainingListPatternBinding binding;

    private History history;

    public TrainingListItem(@NonNull Context context, History history) {
        super(context);
        this.history = history;
    }

    @AfterViews
    void setupView() {
        binding.setHistory(history);
    }
}
