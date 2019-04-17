package com.fisherman.trainingdiary.activity.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.fisherman.trainingdiary.R;
import com.xenione.digit.TabDigit;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.clock)
public class TimerView extends LinearLayout implements Runnable{

    private static final char[] SEXAGISIMAL = new char[]{'0', '1', '2', '3', '4', '5'};

    @ViewById
    TabDigit charHighSecond;

    @ViewById
    TabDigit charLowSecond;

    @ViewById
    TabDigit charHighMinute;

    @ViewById
    TabDigit charLowMinute;
    private View mClock = this;

    private boolean mPause = true;

    private int seconds = 0;
    private int minutes = 0;


    public TimerView(Context context) {
        this(context, null);
    }

    public TimerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @AfterViews
    void init() {
        setOrientation(HORIZONTAL);
        charHighSecond.setChars(SEXAGISIMAL);
        charHighMinute.setChars(SEXAGISIMAL);
    }

    public void pause() {
        mPause = true;
    }

    private void sync() {
        charHighSecond.sync();
        charLowSecond.sync();
        charHighMinute.sync();
        charLowMinute.sync();
    }

    public void toggle() {
        if (mPause) {
            resume();
        } else {
            stop();
        }
    }

    public void stop() {
        pause();
    }

    public void reset() {
        minutes = 0;
        seconds = 0;
        charLowSecond.setChar(0);
        charHighSecond.setChar(0);
        charLowMinute.setChar(0);
        charHighMinute.setChar(0);
    }

    public void resume() {
        mPause = false;
        ViewCompat.postOnAnimationDelayed(mClock, this, 1000);
    }

    @Override
    public void run() {
        if(mPause){
            if (seconds != 0 || minutes != 0) {
                sync();
                reset();
                sync();
            }
            return;
        }

        if (seconds == 59) {
            seconds = 0;
            minutes ++;
            if (minutes % 10 == 0) {
                charHighMinute.start();
            }
            charLowMinute.start();
        } else {
            seconds ++;
        }

        if (minutes == 59) {
            minutes = 0;
        }


        if (seconds % 10 == 0) {
            charHighSecond.start();
        }
        charLowSecond.start();

        ViewCompat.postOnAnimationDelayed(mClock, this, 1000);

    }
}
