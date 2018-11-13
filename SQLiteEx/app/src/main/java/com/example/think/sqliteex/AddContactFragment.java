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
public class AddContactFragment extends Fragment {
    private Button bt_save;
    EditText Id, Name, Email;
    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        bt_save = view.findViewById(R.id.bt_save);
        Id = view.findViewById(R.id.editID);
        Name = view.findViewById(R.id.updateName);
        Email = view.findViewById(R.id.updateEmail);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id), name, email, database);
                contactDbHelper.close();
                Id.setText("");
                Name.setText("");
                Email.setText("");
                Toast.makeText(getActivity(), "Contact has successfully saved", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
