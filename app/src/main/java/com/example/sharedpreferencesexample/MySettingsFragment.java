package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

public class MySettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        final SwitchPreferenceCompat notificationsRef = findPreference("notifications");
        if (notificationsRef != null) {
            notificationsRef.setSummaryProvider(new Preference.SummaryProvider<SwitchPreferenceCompat>() {
                @Override
                public CharSequence provideSummary(SwitchPreferenceCompat preference) {
                    if (notificationsRef.isChecked()) {
                        return "Активирани";
                    } else {
                        return "Деактивирани";
                    }
                }
            });
        }

        Preference feedbackPref = findPreference("feedback");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://doctrinalocus.eu/contacts/"));
        if (feedbackPref != null) {
            feedbackPref.setIntent(intent);
        }


//        EditTextPreference signaturePreference = findPreference("signature");
//        if (signaturePreference != null) {
//            signaturePreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
//                @Override
//                public CharSequence provideSummary(EditTextPreference preference) {
//                    String text = preference.getText();
//                    if (TextUtils.isEmpty(text)){
//                        return "Not set";
//                    }
//                    return "Length of saved value: " + text.length();
//                }
//            });
//        }
//
//        SharedPreferences sharedPreferences =
//                PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
//        String name = sharedPreferences.getString("signature", "");
//        Toast.makeText(getActivity().getApplicationContext(), name, Toast.LENGTH_LONG).show();


    }
}
