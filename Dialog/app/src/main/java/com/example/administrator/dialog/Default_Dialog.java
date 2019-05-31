package com.example.administrator.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Default_Dialog extends Dialog implements View.OnClickListener {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.default_dialog);
        setTitle("Demo Default Dialog");

        button = findViewById(R.id.defaultDialogButton);
        button.setOnClickListener(this);
        super.onCreate(savedInstanceState);
    }

    public Default_Dialog(Context context) {
        super(context);
    }

    public Default_Dialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    public void onClick(View v) {
        int idView = v.getId();
        switch (idView){
            case R.id.defaultDialogButton:
                dismiss();
                break;
            default:
                break;
        }
    }
}
