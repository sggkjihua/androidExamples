package com.example.think.dialogapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ChecboxDialog.OnsubjectSelectedListener {
    private Button button;
    private DialogFragment dialogfragment;
    private ListDialog listDialog;
    private ChecboxDialog checboxDialog;
    private DialogSingle dialogSingle;
    private CustomDialog customDialog;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.bt_show);
        button.setOnClickListener(this);
        textView = findViewById(R.id.text_subjects);
    }

    @Override
    public void onClick(View v) {
        dialogfragment = new DialogFragment();
        dialogfragment.show(getSupportFragmentManager(),"Really damn?????");
    }

    public void showList(View view) {
        listDialog = new ListDialog();
        listDialog.show(getSupportFragmentManager(),"damn?????");
    }

    public void checkbox(View view) {
        checboxDialog = new ChecboxDialog();
        checboxDialog.show(getSupportFragmentManager(),"damn??dsadsa???");
    }

    public void single(View view) {
        dialogSingle = new DialogSingle();
        dialogSingle.show(getSupportFragmentManager(),"Are you okay??");
    }

    public void showCustom(View view) {
        customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager(),"Damananananaa");
    }

    @Override
    public void onSubjectsSelected(List<String> subjects) {
        String result = "";
        for(String item:subjects){
            result = result +"\n" + item;
        }
        textView.setText(result);
    }
}
