package com.example.demofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_2 extends Fragment {

    TextView txt_2;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View fragment_2 = inflater.inflate(R.layout.fragment_2, container, false);

        txt_2 = getActivity().findViewById(R.id.txt_2);

        Bundle bundle = getArguments();
        txt_2.setText(bundle.getString("key"));
        return fragment_2;
    }
}
