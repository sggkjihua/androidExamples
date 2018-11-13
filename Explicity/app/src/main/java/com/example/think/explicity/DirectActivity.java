package com.example.think.explicity;

import android.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DirectActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);
        textView = findViewById(R.id.text_show);
        //Bundle remoteReply = RemoteInput.getDataResultsFromIntent(getIntent());

    }
}
