package com.example.think.dialogapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class DialogSingle extends DialogFragment {
    private String selection;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] subjects = getActivity().getResources().getStringArray(R.array.subjects);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose only one of them");
        builder.setSingleChoiceItems(R.array.subjects, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selection = subjects[which];
            }

        });
        builder.setPositiveButton("Damn it!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "You choice "+selection,Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Damn ni", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Fuck you !!!!!!", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }
}
