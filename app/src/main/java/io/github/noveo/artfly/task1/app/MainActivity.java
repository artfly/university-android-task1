package io.github.noveo.artfly.task1.app;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.EditText;
import butterknife.*;

public class MainActivity extends AppCompatActivity {
    private static final String PICKER_TAG = "PICKER_TAG";
    private static final String DATE_KEY = "DATE_KEY";
    public static final String EXTRA_AGE = "EXTRA_AGE";
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_SURNAME = "EXTRA_SURNAME";
    private DatePickerFragment dateFragment = new DatePickerFragment();

    @Bind(R.id.text_name) EditText name;
    @Bind(R.id.text_surname) EditText surname;
    @Bind(R.id.main_content) View content;

    @OnClick(R.id.submit)
    public void submit() {
        if (name.getText().toString().equals(""))
            Snackbar.make(content, "Please enter your name", Snackbar.LENGTH_SHORT).show();
        else if (surname.getText().toString().equals(""))
            Snackbar.make(content, "Please enter your surname", Snackbar.LENGTH_SHORT).show();
        else if (dateFragment.getAge() == -1)
            Snackbar.make(content, "Please enter your birthdate", Snackbar.LENGTH_SHORT).show();
        else {
            Intent summaryIntent = new Intent(this, SummaryActivity.class);
            summaryIntent.putExtra(EXTRA_AGE, dateFragment.getAge());
            summaryIntent.putExtra(EXTRA_NAME, name.getText().toString());
            summaryIntent.putExtra(EXTRA_SURNAME, surname.getText().toString());
            startActivity(summaryIntent);
        }
    }

    @OnClick(R.id.button_birth)
    public void showPicker() {
        dateFragment.show(getFragmentManager(), PICKER_TAG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        if (dateFragment.getDate() != null)
            outState.putLong(DATE_KEY, dateFragment.getDate().getTime());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull final Bundle savedInstanceState) {
        dateFragment.setDate(savedInstanceState.getLong(DATE_KEY));
        super.onRestoreInstanceState(savedInstanceState);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
