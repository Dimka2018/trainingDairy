package com.fisherman.trainingdiary.activity.view.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class AdapterFactory {

    public static <T> ArrayAdapter createArrayAdapter (Context context, int elementId, int dropDownId, List<T>
            source) {
        ArrayAdapter<T> adapter = new ArrayAdapter<>(context, elementId, source);
        adapter.setDropDownViewResource(dropDownId);
        return adapter;
    }

}
