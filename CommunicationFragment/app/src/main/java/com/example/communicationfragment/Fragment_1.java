package com.example.communicationfragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment_1 extends Fragment implements View.OnClickListener {

    EditText editText;

    CommunicateFragment communicateFragment;

    public interface CommunicateFragment{
        public void SendData(String data);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        communicateFragment = (CommunicateFragment) context;
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicateFragment = (CommunicateFragment) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment1 = inflater.inflate(R.layout.fragment_1, container, false);
//        TextView textView = getActivity().findViewById(R.id.textView1);
         editText = fragment1.findViewById(R.id.editText);
//        textView.setText(editText.getText());

        // lấy dữ liệu từ activity
//        Bundle bundle = getArguments();
//        editText.setText(bundle.getString("xin chào"));

        Button button = fragment1.findViewById(R.id.buttonFragment1);
        button.setOnClickListener(this);
        return fragment1;
    }

    @Override
    public void onClick(View v) {
        communicateFragment.SendData(editText.getText().toString());
    }
}
