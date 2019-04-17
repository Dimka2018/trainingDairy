package com.fisherman.trainingdiary.activity.view.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class PageInjectedAdapter extends PagerAdapter {

    private List<View> viewList;

    @Inject
    public PageInjectedAdapter() {
       viewList = new ArrayList<>();
    }

    @Override
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View page = viewList.get(position);
        container.removeView(page);
        container.addView(page);
        return page;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View page = viewList.get(position);
        container.removeView(page);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    public void setViews(View... views) {
        viewList.addAll(Arrays.asList(views));
    }
}
