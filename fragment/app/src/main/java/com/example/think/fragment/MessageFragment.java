package com.example.think.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private EditText editText;
    private Button bt_send;
    OnMessageReadListener messageReadListener;
    public MessageFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener{
        public void onMessageRead(String message);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        editText =view.findViewById(R.id.text_message);
        bt_send = view.findViewById(R.id.send_button);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                messageReadListener.onMessageRead(message);
            }
        });
        return view;
    }

    public void onAttach(Context context){
        // fragment生命周期的第一步，关联到activity
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            messageReadListener = (OnMessageReadListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must overrode onMessageRead.....");
        }
    }

}
