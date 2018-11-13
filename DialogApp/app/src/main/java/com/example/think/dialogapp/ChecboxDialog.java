package com.example.think.dialogapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.think.dialogapp.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class ChecboxDialog extends DialogFragment {
    private List<String> mSelected;

    public interface OnsubjectSelectedListener {
        public void onSubjectsSelected(List<String> subjects);
    }
    OnsubjectSelectedListener onsubjectSelectedListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mSelected = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a subject");
        builder.setMultiChoiceItems(R.array.subjects, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String[] items = getActivity().getResources().getStringArray(R.array.subjects);
                if (isChecked) {
                    mSelected.add(items[which]);

                }
                else if(mSelected.contains(items[which])){
                    mSelected.remove(items[which]);
                }
            }
        });

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String final_selections = "";
                for (String item:mSelected){
                    final_selections = final_selections + "\n" + item;
                }
                Toast.makeText(getActivity(),"Final Selection: "+final_selections,Toast.LENGTH_SHORT).show();
                onsubjectSelectedListener.onSubjectsSelected(mSelected);
            }
        });

        builder.setNegativeButton("Noway", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Nothing happened", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;
        try {
            onsubjectSelectedListener = (OnsubjectSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must implement~~~~");
        }
    }
}
