package com.fisherman.trainingdiary.activity.animation;

import android.content.Context;
import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class AnimationManager {

    private static SparseArray< Animation> animationMap = new SparseArray<>();

    public static Animation getAnimation(int resourceId, Context appContext){
        if (animationMap.get(resourceId) == null){
            animationMap.put(resourceId, AnimationUtils.loadAnimation(appContext, resourceId));
        }
        return animationMap.get(resourceId);
    }
}
