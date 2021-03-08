package com.smartdesa.demo.dialog;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.smartdesa.demo.R;
import com.smartdesa.demo.homepage.MekanismeActivity;
import com.smartdesa.demo.homepage.TutorPengaduanActivity;

public class MekanismeDialog extends AppCompatDialogFragment {

    private CardView mekanisme_pengajuan, mekanisme_pengaduan;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_mekanisme_dialog, null);

        mekanisme_pengaduan = view.findViewById(R.id.mekanisme_pengaduan);
        mekanisme_pengajuan = view.findViewById(R.id.mekanisme_pengajuan);

        mekanisme_pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), TutorPengaduanActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        mekanisme_pengajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), MekanismeActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        builder.setView(view);
        return builder.create();
    }
}