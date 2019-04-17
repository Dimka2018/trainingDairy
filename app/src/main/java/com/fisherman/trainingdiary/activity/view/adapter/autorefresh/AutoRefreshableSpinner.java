package com.fisherman.trainingdiary.activity.view.adapter.autorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.fisherman.trainingdiary.R;
import com.rey.material.widget.Spinner;

public class AutoRefreshableSpinner extends Spinner {

    private Context context;
    private RefreshableArrayAdapter adapter;
    private OnItemSelectedListener itemSelectedListener;

    public AutoRefreshableSpinner(Context context) {
        super(context);
        this.context = context;
    }

    public AutoRefreshableSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public AutoRefreshableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setEntitySource(EntitySource entitySource) {
        this.adapter = new RefreshableArrayAdapter(context, R.layout.spinner_element, R.layout
                .spinner_dropdown, entitySource);
        setAdapter(adapter);
    }

    public void setEntitySource(EntitySource entitySource, int resource, int dropdownId) {
        this.adapter = new RefreshableArrayAdapter(context, resource, dropdownId, entitySource);
        setAdapter(adapter);
    }

    public boolean isNewElementSelected() {
        return getSelectedItem().equals(RefreshableArrayAdapter.NEW_ELEMENT);
    }


    public void setOnNewElementSelectedListener(final OnItemSelectedListener listener) {
        this.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner parent, View view, int position, long id) {
                if (isNewElementSelected()) {
                    setSelection(0);
                    listener.onItemSelected(parent, view, position, id);
                } else if (itemSelectedListener != null) {
                    itemSelectedListener.onItemSelected(parent, view, position, id);
                }
            }
        });
    }

    public void setOnElementSelectedListener(OnItemSelectedListener l) {
        this.itemSelectedListener = l;
    }

    public void refresh() {
        adapter.refresh();
    }


}
