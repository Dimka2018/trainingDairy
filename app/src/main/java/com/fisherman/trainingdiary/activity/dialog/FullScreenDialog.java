package com.fisherman.trainingdiary.activity.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.ViewGroup;

import com.fisherman.trainingdiary.R;

public abstract class FullScreenDialog extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.full_screen_dialog_style);
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
    }
}
