package com.smartdesa.demo.dialog;

import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.smartdesa.demo.R;
import com.smartdesa.demo.homepage.UpdateActivity;
import com.smartdesa.demo.tutorial.TutorialActivity;

public class MainDialog extends AppCompatDialogFragment {

    Button btn_tutorial, btn_update;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_main_dialog, null);

        btn_tutorial = view.findViewById(R.id.btn_tutorial);
        btn_update = view.findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UpdateActivity.class);
                startActivity(intent);
            }
        });
        btn_tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TutorialActivity.class);
                startActivity(intent);
            }
        });

        builder.setView(view)
                .setTitle("Info Aplikasi");

        return builder.create();
    }
}