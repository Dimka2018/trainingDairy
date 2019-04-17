package com.fisherman.trainingdiary.activity.view.adapter.autorefresh;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.fisherman.trainingdiary.R;

public class RefreshableArrayAdapter extends ArrayAdapter implements Refreshable {

    public static String NEW_ELEMENT;

    private EntitySource entitySource;

    public RefreshableArrayAdapter(Context context, int resource, int dropdownResourceId, int
            textViewResourceId, EntitySource entitySource) {
        super(context, resource, textViewResourceId, entitySource.get());
        this.setDropDownViewResource(dropdownResourceId);
        this.entitySource = entitySource;
        NEW_ELEMENT = context.getString(R.string.create_new);
        add(NEW_ELEMENT);
    }

    public RefreshableArrayAdapter (Context context, int resource, int dropdownResourceId,
                                    EntitySource entitySource) {
        super(context, resource, entitySource.get());
        this.setDropDownViewResource(dropdownResourceId);
        this.entitySource = entitySource;
        NEW_ELEMENT = context.getString(R.string.create_new);
        add(NEW_ELEMENT);
    }


    @Override
    public void refresh() {
        clear();
        addAll(entitySource.get());
        add(NEW_ELEMENT);
        notifyDataSetChanged();
    }
}
