package com.example.think.frag_frag;

import android.content.Intent;
import android.preference.ListPreference;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Message.OnMessageSendListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState!=null){
                return;
            }
            Message messageFragment = new Message();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, messageFragment,null);
            fragmentTransaction.commit();
        }
        }

    @Override
    public void onMessageSend(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);


        Display display= new Display();
        display.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, display,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void to_list(View view) {
        startActivity(new Intent(this, ListPreference.class));
    }
}
