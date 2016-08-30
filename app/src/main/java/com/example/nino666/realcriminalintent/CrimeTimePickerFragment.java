package com.example.nino666.realcriminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by nino666 on 18.8.2016.
 */
public class CrimeTimePickerFragment extends DialogFragment {

    private static final String CRIME_TIME = "time_of_crime";
    public static final String EXTRA_TIME = "com.example.nino666.realcriminalintent.time";

    private TimePicker mCrimeTimePicker;


    public static CrimeTimePickerFragment newInstance(Date date){

        Bundle bundle = new Bundle();
        bundle.putSerializable(CRIME_TIME, date);

        CrimeTimePickerFragment fragment = new CrimeTimePickerFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

      Date date = (Date) getArguments().getSerializable(CRIME_TIME);
      View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        final int hour = calendar.get(Calendar.HOUR);
        final int minute = calendar.get(Calendar.MINUTE);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        mCrimeTimePicker = (TimePicker) view.findViewById(R.id.crime_time_picker_dialog);
        mCrimeTimePicker.setCurrentHour(hour);
        mCrimeTimePicker.setCurrentMinute(minute);


        return new AlertDialog.Builder(getActivity())
                .setTitle("Time of Crime:")
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int hour = mCrimeTimePicker.getCurrentHour();
                        int minute = mCrimeTimePicker.getCurrentMinute();

                        Date date = new GregorianCalendar(year,month,day,hour,minute).getTime();
                        Log.d("TimePicker","time: "+ new SimpleDateFormat("HH:mm").format(date));
                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .create();

    }

    private void sendResult(int resultCode,Date date){

        if(getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, date);
        getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode, intent);
    }
}
