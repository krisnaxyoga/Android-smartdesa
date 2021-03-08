package com.smartdesa.demo.dialog;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.smartdesa.demo.R;
import com.smartdesa.demo.updatefoto.FotoProfil;
import com.smartdesa.demo.updatefoto.GaleriProfil;

public class FotoDialog extends AppCompatDialogFragment {

    private CardView kamera, galeri;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_foto_dialog, null);

        kamera = view.findViewById(R.id.kamera);
        galeri = view.findViewById(R.id.galeri);

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), FotoProfil.class);
                view.getContext().startActivity(intent);
            }
        });

        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), GaleriProfil.class);
                view.getContext().startActivity(intent);
            }
        });

        builder.setView(view);
        return builder.create();
    }
}