package com.example.think.implictapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt_show;
    private Button bt_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_show = findViewById(R.id.bt_show);
        bt_send = findViewById(R.id.bt_send);
        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explicitOpen(v);
            }
        });
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(v);
            }
        });
    }

    public void explicitOpen(View view) {
        startActivity(new Intent(MainActivity.this,SharePost.class));
    }

    public void sendMail(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("message","this is a simple message");
        startActivity(intent);
    }
}
