package com.example.think.frag_frag;


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
public class Message extends Fragment {
    private Button bt;
    private EditText editText;
    OnMessageSendListener messageSendListener;
    public interface OnMessageSendListener{
        public void onMessageSend(String message);
    }
    public Message() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);
        bt = view.findViewById(R.id.Send_button);
        editText = view.findViewById(R.id.editMessage);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                messageSendListener.onMessageSend(message);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        //这个顺位在oncreate 之前
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            messageSendListener = (OnMessageSendListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }

    }

    @Override
    public void onResume() {
        //点击返回之后输入框应该重新置为空
        super.onResume();
        editText.setText("");
    }
}
