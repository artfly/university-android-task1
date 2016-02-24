package io.github.noveo.artfly.task1.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by arty on 23.02.16.
 */
public class SummaryFragment extends Fragment {
    private static final String NAME_KEY = "NAME_KEY";
    private static final String SURNAME_KEY = "SURNAME_KEY";
    private static final String AGE_KEY = "AGE_KEY";
    private String name;
    private String surname;
    private String age;
    @Bind(R.id.summary_age) TextView ageView;
    @Bind(R.id.summary_name) TextView nameView;
    @Bind(R.id.summary_surname) TextView surnameView;

    public static SummaryFragment newInstance(String name, String surname, String age) {
        SummaryFragment summaryFragment = new SummaryFragment();
        Bundle params = new Bundle();
        params.putString(NAME_KEY, name);
        params.putString(SURNAME_KEY, surname);
        params.putString(AGE_KEY, age);
        summaryFragment.setArguments(params);
        return summaryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.name = args.getString(NAME_KEY);
        this.surname = args.getString(SURNAME_KEY);
        this.age = args.getString(AGE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        nameView.setText(name);
        surnameView.setText(surname);
        ageView.setText(age);
    }
}
