package io.github.noveo.artfly.task1.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by arty on 23.02.16.
 */
public class MainFragment extends Fragment {
    private static final String PICKER_TAG = "PICKER_TAG";
    private static final String DATE_KEY = "DATE_KEY";
    private DatePickerFragment dateFragment = new DatePickerFragment();

    @Bind(R.id.text_name) EditText name;
    @Bind(R.id.text_surname) EditText surname;
    @Bind(R.id.fragment_main) View content;

    @OnClick(R.id.submit)
    public void submit() {
        if (name.getText().toString().equals(""))
            Snackbar.make(content, "Please enter your name", Snackbar.LENGTH_SHORT).show();
        else if (surname.getText().toString().equals(""))
            Snackbar.make(content, "Please enter your surname", Snackbar.LENGTH_SHORT).show();
        else if (dateFragment.getAge() == -1)
            Snackbar.make(content, "Please enter your birthdate", Snackbar.LENGTH_SHORT).show();
        else {
            EventBus.getDefault().post(new SubmitEvent(name.getText().toString(),
                                        surname.getText().toString(), String.valueOf(dateFragment.getAge())));
        }
    }

    @OnClick(R.id.button_birth)
    public void showPicker() {
        dateFragment.show(getFragmentManager(), PICKER_TAG);
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        if  (dateFragment.getDate() != null)
            outState.putLong(DATE_KEY, dateFragment.getDate().getTime());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            dateFragment.setDate(savedInstanceState.getLong(DATE_KEY));
        }
        super.onActivityCreated(savedInstanceState);
    }
}
