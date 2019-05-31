package com.example.communicationfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View fragment2 = inflater.inflate(R.layout.fragment_2, container, false);
        TextView textView = fragment2.findViewById(R.id.textView2);
        Bundle bundle = getArguments();

        textView.setText(bundle.getString("dữ liệu"));
        return fragment2;
    }
}
