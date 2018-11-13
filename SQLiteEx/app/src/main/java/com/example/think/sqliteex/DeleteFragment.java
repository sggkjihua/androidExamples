package com.example.think.sqliteex;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {
    private EditText delete_id;
    Button bt_delete;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        delete_id = view.findViewById(R.id.delete_id);
        bt_delete = view.findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }

    private  void deleteContact(){
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getWritableDatabase();
        int id = Integer.parseInt(delete_id.getText().toString());
        contactDbHelper.deleteContact(id,database);
        contactDbHelper.close();
        Toast.makeText(getActivity(), "Contact has been deleted",Toast.LENGTH_SHORT).show();
        delete_id.setText("");
    }

}
