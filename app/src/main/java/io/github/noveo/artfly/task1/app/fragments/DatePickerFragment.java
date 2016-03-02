package io.github.noveo.artfly.task1.app.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private Calendar birthdate;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (birthdate != null) {
            return new DatePickerDialog(getActivity(), this, birthdate.get(Calendar.YEAR),
                    birthdate.get(Calendar.MONTH), birthdate.get(Calendar.DAY_OF_MONTH));
        }
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (birthdate == null) {
            birthdate = Calendar.getInstance();
        }
        birthdate.clear();
        birthdate.set(year, month, day);
    }

    public int getAge() {
        if (birthdate == null) {
            return -1;
        }
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < birthdate.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == birthdate.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < birthdate.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age < 0 ? 0 : age;
    }

    public Date getDate() {
        if (birthdate == null) {
            return null;
        }
        return birthdate.getTime();
    }

    public void setDate(long date) {
        birthdate = Calendar.getInstance();
        birthdate.setTime(new Date(date));
    }
}
