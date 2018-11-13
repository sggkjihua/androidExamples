package com.example.think.roomex;


import android.os.Bundle;
import android.provider.ContactsContract;
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
public class AddFragment extends Fragment {
    private EditText UserID, UserName, UserEmail;
    private Button bt_save;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        UserID = view.findViewById(R.id.editID);
        UserName = view.findViewById(R.id.editName);
        UserEmail = view.findViewById(R.id.editEmail);

        bt_save = view.findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(UserID.getText().toString());
                String name = UserName.getText().toString();
                String email = UserEmail.getText().toString();
                //创建一个user,然后对其各项属性进行赋值
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                MainActivity.myDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"User has been added.....",Toast.LENGTH_SHORT).show();
                UserID.setText("");
                UserName.setText("");
                UserEmail.setText("");

            }
        });
    return view;
    }

}
