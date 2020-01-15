package mymou.preferences;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;
import mymou.R;

public class PrefsFragTimePicker extends DialogFragment {

    private TimePicker timePicker;
    private String key;

    public PrefsFragTimePicker() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_timepicker, container, false);

    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        key = getArguments().getString("pref_tag");

        // Load settings depending on whether this is auto start or autostop
         int default_hour;
         String hour_key, minute_key;
        if (key == getResources().getString(R.string.preftag_autostarttimepicker)) {
            default_hour = getResources().getInteger(R.integer.default_autostart_hour);
            hour_key = getResources().getString(R.string.preftag_autostart_hour);
            minute_key = getResources().getString(R.string.preftag_autostart_min);
        } else {
            default_hour = getResources().getInteger(R.integer.default_autostop_hour);
            hour_key = getResources().getString(R.string.preftag_autostop_hour);
            minute_key = getResources().getString(R.string.preftag_autostop_min);
        }

        // Get currently selected time
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        int hour = settings.getInt(hour_key, default_hour);
        int min = settings.getInt(minute_key, 0);

        timePicker = view.findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setHour(hour);
        timePicker.setMinute(min);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(hour_key, hourOfDay);
                editor.putInt(minute_key, minute);
                editor.commit();
            }
        });

    }


}
