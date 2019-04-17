package com.fisherman.trainingdiary.activity.activity.statistic;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.inject.component.statistic.DaggerStatisticComponent;
import com.fisherman.trainingdiary.contract.statistic.StatisticContract;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.MassType;
import com.rey.material.widget.Spinner;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

@SuppressLint("Registered")
@EActivity(R.layout.activity_statistic)
public class StatisticActivity extends AppCompatActivity implements StatisticContract.View {

    @ViewById LineChartView graph;
    @ViewById Spinner exerciseSpinner;
    @ViewById Spinner weightSpinner;

    @Inject StatisticContract.Presenter presenter;
    @Inject @Named("exerciseAdapter") ArrayAdapter exerciseAdapter;
    @Inject @Named("weightAdapter") ArrayAdapter weightAdapter;
    @Inject Axis axisX;
    @Inject Axis axisY;

    @AfterViews
    void setupPage() {
        exerciseSpinner.setAdapter(exerciseAdapter);
        weightSpinner.setAdapter(weightAdapter);
        Spinner.OnItemSelectedListener selectedListener = new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner parent, View view, int position, long id) {
                refreshGraph((Exercise) exerciseSpinner.getSelectedItem(), (MassType) weightSpinner
                        .getSelectedItem
                                ());
            }
        };
        exerciseSpinner.setOnItemSelectedListener(selectedListener);
        weightSpinner.setOnItemSelectedListener(selectedListener);
        graph.setValueSelectionEnabled(true);
        axisX.setName(getString(R.string.workout));
        axisY.setName(getString(R.string.weight));
    }

    @AfterInject
    void inject() {
        DaggerStatisticComponent.builder().context(this).build().inject(this);
    }

    private void refreshGraph(Exercise exercise, MassType massType) {
        setGraphPoints(presenter.getHistoryList(exercise, massType));
    }

    private void setGraphPoints(List<History> history) {
        List<PointValue> points = new LinkedList<>();
        for (int i = 0; i < history.size(); i++) {
            points.add(new PointValue(i, history.get(i).getWeight()));
        }
        Line line = new Line(points).setColor(Color.WHITE).setCubic(false).setHasLabelsOnlyForSelected(true);

        List<Line> lines = new ArrayList<>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);
        data.setValueLabelTextSize(100);
        data.setValueLabelBackgroundAuto(false);
        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);
        graph.setLineChartData(data);
    }
}
