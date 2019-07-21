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
import android.widget.Toast;

public class FragmentA extends Fragment {

    TextView txt_a;
    EditText edt_a;
    Button btn_a;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_A = inflater.inflate(R.layout.fragment_a, container, false);

        txt_a = fragment_A.findViewById(R.id.txt_a);
        edt_a = fragment_A.findViewById(R.id.edt_a);
        btn_a = fragment_A.findViewById(R.id.btn_a);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nhập nội dung vào editText và set lên activityMain

                TextView textView = getActivity().findViewById(R.id.txt_main);
                textView.setText(edt_a.getText().toString());
            }
        });

        return fragment_A;
    }

    public void ganNoiDung(String noidung){
        txt_a.setText(noidung);
    }
}
