package com.example.think.frag_frag;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ListPreferenceActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener{
    private ListPreference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.list_preference);
        init();
    }
    private void init(){
        preference= (ListPreference) findPreference("key_listpreference");
        ///preference.setOnPreferenceClickListener(this); ****点击事件已经被覆盖掉了****
        preference.setOnPreferenceChangeListener(this);
        // 设置summary为所选中的值列表值
        if(preference.getEntry()!=null) {
            preference.setSummary(preference.getEntry());//初始化时设置summary
        }
    }
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        if(preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;//把preference这个Preference强制转化为ListPreference类型
            CharSequence[] entries = listPreference.getEntries();//获取ListPreference中的实体内容
            int index = listPreference.findIndexOfValue((String) newValue);//获取ListPreference中的实体内容的下标值
            listPreference.setSummary(entries[index]);//listPreference中的sumamry显示为当前ListPreference的实体内容中选择的
            Log.d("TAG2", "onPreferenceChange run"+newValue);
            Toast.makeText(ListPreferenceActivity.this,entries[index].toString(),Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
