package com.example.jbutler.mymou;


import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SeekBarPreference;

public class PreferencesEventCodes extends PreferenceFragmentCompat {

    public PreferencesEventCodes() {
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_eventcodes, rootKey);
    }


}
