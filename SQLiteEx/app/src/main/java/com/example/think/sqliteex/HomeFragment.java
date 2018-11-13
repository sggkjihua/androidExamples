package com.example.think.sqliteex;


import android.app.Activity;
import android.content.Context;
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
    private Button bt_save, bt_update, bt_delete, bt_view;
    OnDbOpListener dbOpListener;
    public HomeFragment() {
        // Required empty public constructor
    }
    public interface OnDbOpListener{

        //定义这个接口，在主函数中要覆盖
        public void dBOpPerformaed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bt_save = view.findViewById(R.id.ADD);
        bt_save.setOnClickListener(this);

        //找到并监听相应的按键，hf的是onclistener,因此可以多种监听
        bt_view = view.findViewById(R.id.VIEW);
        bt_view.setOnClickListener(this);
        bt_update = view.findViewById(R.id.UPDATE);
        bt_update.setOnClickListener(this);

        bt_delete = view.findViewById(R.id.DELETE);
        bt_delete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ADD:
                dbOpListener.dBOpPerformaed(0);
                break;
            case R.id.VIEW:
                dbOpListener.dBOpPerformaed(1);
                //转到主函数中进行
                break;
            case R.id.UPDATE:
                dbOpListener.dBOpPerformaed(2);
                //转到主函数中进行
                break;
            case R.id.DELETE:
                dbOpListener.dBOpPerformaed(3);
                //转到主函数中进行
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            dbOpListener = (OnDbOpListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must implement the interface method....");
        }

    }
}
