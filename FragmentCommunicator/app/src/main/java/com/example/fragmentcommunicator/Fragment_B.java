package com.example.fragmentcommunicator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment_B extends Fragment {

    EditText edt_b;
    Button btn_b;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_B =  inflater.inflate(R.layout.fragment_b, container, false);

        edt_b = fragment_B.findViewById(R.id.edt_b);
        btn_b = fragment_B.findViewById(R.id.btn_b);

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt_a = getActivity().findViewById(R.id.txt_a);
                txt_a.setText(edt_b.getText().toString());
            }
        });

        return fragment_B;
    }
}
