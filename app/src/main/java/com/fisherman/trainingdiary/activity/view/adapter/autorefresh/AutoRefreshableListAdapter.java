package com.fisherman.trainingdiary.activity.view.adapter.autorefresh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.view.adapter.AdapterApplyable;

import java.util.List;

public class AutoRefreshableListAdapter extends BaseAdapter {

    private List<AdapterApplyable> items;
    private EntitySource entitySource;
    private Context context;

    public AutoRefreshableListAdapter(Context context, EntitySource entitySource) {
        this.context = context;
        this.entitySource = entitySource;
        this.items = entitySource.get();
    }

    public AutoRefreshableListAdapter(Context context) {
        this.context = context;
    }

    public void setEntitySource(EntitySource entitySource) {
        this.entitySource = entitySource;
        this.items = entitySource.get();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            if (!items.get(position).isActive()) {
                convertView = View.inflate(context, R.layout
                                .element_pattern,
                        null);
            } else {
                convertView = View.inflate(context, R.layout
                                .active_element_pattern,
                        null);
            }
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(items.get(position).getValue());
        return convertView;
    }

    public void refresh() {
        this.items = entitySource.get();
        notifyDataSetChanged();
    }

    public AdapterApplyable get(int position) {
        return items.get(position);
    }

    static class ViewHolder {
        TextView textView;
    }
}
