package com.fisherman.trainingdiary.activity.view.swipe_menu_creator;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.TypedValue;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.fisherman.trainingdiary.R;

public class WorkoutSwipeMenuCreator implements SwipeMenuCreator {

    private static final int CONTROL_ITEM_SIZE = 80;
    private Context context;

    public WorkoutSwipeMenuCreator(Context context){
        this.context = context;
    }

    @Override
    public void create(SwipeMenu menu) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        menu.addMenuItem(createSelectButton());
        menu.addMenuItem(createCorrectButton());
        menu.addMenuItem(createDeleteButton());
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    private SwipeMenuItem createSelectButton(){
        SwipeMenuItem changeItem = new SwipeMenuItem(context);
        changeItem.setWidth(dp2px(CONTROL_ITEM_SIZE));
        changeItem.setBackground(R.drawable.ic_ok);
        return changeItem;
    }

    private SwipeMenuItem createCorrectButton(){
        SwipeMenuItem changeItem = new SwipeMenuItem(context);
        changeItem.setWidth(dp2px(CONTROL_ITEM_SIZE));
        changeItem.setBackground(R.drawable.ic_pen);
        return changeItem;
    }

    private SwipeMenuItem createDeleteButton(){
        SwipeMenuItem changeItem = new SwipeMenuItem(context);
        changeItem.setWidth(dp2px(CONTROL_ITEM_SIZE));
        changeItem.setBackground(R.drawable.ic_delete);
        return changeItem;
    }

}
