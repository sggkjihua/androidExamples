package com.example.think.explicity;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int message_request = 01;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showlog("onCreate activity.....");
    }



    @Override
    protected void onResume() {
        super.onResume();
        showlog("onResume activity.....");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showlog("onPause activity.....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showlog("onStop activity.....");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showlog("onRestart activity.....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showlog("onDestroy activity.....");
    }

    public void go(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("message","this is a simple message");
        startActivity(intent);
    }

    public void clickfinish(View view) {
        finish();
    }

    public void clickStart(View view) {
        Intent intent = new Intent(MainActivity.this, AnoherActivity.class);
        startActivity(intent);
    }

    public void showlog(String message){
        Log.d("Life cycle test",message);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(message_request == requestCode){
            if(resultCode == RESULT_OK){
                String message = data.getStringExtra("message");
                textView = findViewById(R.id.text_show);
                textView.setText(message);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void getmessage(View view) {
        Intent intent = new Intent(this, AnoherActivity.class);
        startActivityForResult(intent, message_request);
    }
}
