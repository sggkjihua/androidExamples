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
public class DeleteFragment extends Fragment {

    private Button bt_delete;
    private EditText UserID;
    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete, container, false);
        bt_delete = view.findViewById(R.id.bt_delete2);
        UserID = view.findViewById(R.id.delete_id);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(UserID.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.myDatabase.myDao().deleteUser(user);
                UserID.setText("");
                Toast.makeText(getActivity(),"User has been deleted.....",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
