package com.smartdesa.demo.dialog;

import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;
import com.smartdesa.demo.R;
import com.squareup.picasso.Picasso;

public class ZoomImgDialog extends AppCompatDialogFragment {

    private PhotoView photoView;
    String Surl;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_zoom_img_dialog, null);

        photoView = view.findViewById(R.id.photo_view);

        Surl = getActivity().getIntent().getStringExtra("photo");

        Picasso.with(getContext()).
                load(Surl).
                placeholder(R.drawable.progress_animation).
                error(R.drawable.icon).
                fit().
                into(photoView);

        builder.setView(view);
        return builder.create();
    }
}