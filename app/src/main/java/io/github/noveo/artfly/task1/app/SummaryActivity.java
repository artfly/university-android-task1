package io.github.noveo.artfly.task1.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by arty on 23.02.16.
 */
public class SummaryActivity extends AppCompatActivity {
    @Bind(R.id.summary_age) TextView ageView;
    @Bind(R.id.summary_name) TextView nameView;
    @Bind(R.id.summary_surname) TextView surnameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        nameView.setText(intent.getStringExtra(MainActivity.EXTRA_NAME));
        surnameView.setText(intent.getStringExtra(MainActivity.EXTRA_SURNAME));
        ageView.setText(String.valueOf(intent.getIntExtra(MainActivity.EXTRA_AGE, -1)   ));
    }
}
