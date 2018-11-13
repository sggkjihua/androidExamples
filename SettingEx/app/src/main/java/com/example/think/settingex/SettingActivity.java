package com.example.think.settingex;

import android.arch.lifecycle.ViewModelProvider;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v14.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransitionImpl;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.widget.Toolbar;

public class SettingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState!=null){
                return;
            }
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainSettingFragment()).commit();
        }
    }

    public static class MainSettingFragment extends android.preference.PreferenceFragment {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefference);
            Preference preference = findPreference("University");
        }
    }
}
