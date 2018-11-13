package com.example.think.roomex;


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
public class UpdateFragment extends Fragment {
    private Button bt_update;
    private EditText id_update, name_update, email_update;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update, container, false);
        bt_update = view.findViewById(R.id.bt_update);
        id_update = view.findViewById(R.id.updateID);
        name_update = view.findViewById(R.id.updateName);
        email_update = view.findViewById(R.id.updateEmail);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(id_update.getText().toString());
                String name = name_update.getText().toString();
                String email = email_update.getText().toString();
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                MainActivity.myDatabase.myDao().updateUser(user);

                Toast.makeText(getActivity(),"User has been updated.....",Toast.LENGTH_SHORT).show();
                id_update.setText("");
                name_update.setText("");
                email_update.setText("");

            }
        });
    return view;
    }

}
