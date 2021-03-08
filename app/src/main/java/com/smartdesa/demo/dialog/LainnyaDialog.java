package com.smartdesa.demo.dialog;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.smartdesa.demo.tempat.HiburanActivity;
import com.smartdesa.demo.R;
import com.smartdesa.demo.tempat.PpobActivity;
import com.smartdesa.demo.tempat.TempatActivity;

public class LainnyaDialog extends AppCompatDialogFragment {

    private CardView tempat, hiburan,ppob;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_lainnya_dialog, null);

        tempat = view.findViewById(R.id.tempat);
        hiburan = view.findViewById(R.id.hiburan);
        ppob = view.findViewById(R.id.ppob);

        tempat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), TempatActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        hiburan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), HiburanActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        ppob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), PpobActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        builder.setView(view);
        return builder.create();
    }
}