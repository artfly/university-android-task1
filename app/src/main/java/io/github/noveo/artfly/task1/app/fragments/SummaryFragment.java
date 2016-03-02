package io.github.noveo.artfly.task1.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.noveo.artfly.task1.app.R;

public class SummaryFragment extends Fragment {
    private static final String NAME_KEY = "NAME_KEY";
    private static final String SURNAME_KEY = "SURNAME_KEY";
    private static final String AGE_KEY = "AGE_KEY";
    @Bind(R.id.summary_age)
    TextView ageView;
    @Bind(R.id.summary_name)
    TextView nameView;
    @Bind(R.id.summary_surname)
    TextView surnameView;
    private CharSequence name;
    private CharSequence surname;
    private CharSequence age;

    public static SummaryFragment newInstance(CharSequence name, CharSequence surname, CharSequence age) {
        SummaryFragment summaryFragment = new SummaryFragment();
        Bundle params = new Bundle();
        params.putCharSequence(NAME_KEY, name);
        params.putCharSequence(SURNAME_KEY, surname);
        params.putCharSequence(AGE_KEY, age);
        summaryFragment.setArguments(params);
        return summaryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.name = args.getCharSequence(NAME_KEY);
        this.surname = args.getCharSequence(SURNAME_KEY);
        this.age = args.getCharSequence(AGE_KEY);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
