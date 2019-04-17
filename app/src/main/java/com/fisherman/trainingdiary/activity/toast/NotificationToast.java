package com.fisherman.trainingdiary.activity.toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fisherman.trainingdiary.R;

public class NotificationToast extends Toast {

    private TextView view;
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public NotificationToast(Context context) {
        super(context);
        view = (TextView) View.inflate(context, R.layout.notification_toast, null);
        setView(view);
        setDuration(LENGTH_SHORT);
        setGravity(Gravity.FILL, 0, 0);
    }

    @Override
    public void setText(CharSequence sequence) {
        view.setText(sequence);
    }
}
