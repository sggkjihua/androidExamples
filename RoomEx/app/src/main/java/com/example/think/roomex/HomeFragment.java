package com.example.think.roomex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Button bt_add = view.findViewById(R.id.bt_add);
        bt_add.setOnClickListener(this);
        Button bt_view = view.findViewById(R.id.bt_view);
        bt_view.setOnClickListener(this);

        Button bt_delete= view.findViewById(R.id.bt_delete2);
        bt_delete.setOnClickListener(this);
        Button bt_update= view.findViewById(R.id.bt_update);
        bt_update.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddFragment()).addToBackStack(null).commit();
                break;
            case R.id.bt_view:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadFragment()).addToBackStack(null).commit();
                break;
            case R.id.bt_delete2:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.bt_update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
