package com.example.demofragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_1 extends Fragment implements View.OnClickListener {

    EditText edt_1;
    Button btn_1;
    Communicate communicate;



    public interface Communicate{
        void SendData(String data);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicate = (Communicate) activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicate = (Communicate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment_1 = inflater.inflate(R.layout.fragment_1, container, false);

        edt_1 = getActivity().findViewById(R.id.edt_1);
        btn_1 = getActivity().findViewById(R.id.btn_1);

        btn_1.setOnClickListener(this);

        return fragment_1;
    }

    @Override
    public void onClick(View v) {
        communicate.SendData(edt_1.getText().toString());
    }
}
