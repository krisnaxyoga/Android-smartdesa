package com.smartdesa.demo.pengaduan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class FnDisposisi extends Fragment {

    SessionManager sessionManager;
    TextView no_pengaduan,tv_nama_disposisi,tv_created_at,tv_updated_at,tv_content;
    String Sno_pengaduan, Suser_type, Screated_at, Supdated_at, Scontent, Sphoto;
    ImageView images;


    public FnDisposisi() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_fn_disposisi, container, false);

        no_pengaduan = view.findViewById(R.id.no_pengaduan);
        tv_nama_disposisi = view.findViewById(R.id.tv_nama_disposisi);
        tv_created_at = view.findViewById(R.id.tv_created_at);
        tv_updated_at = view.findViewById(R.id.tv_updated_at);
        tv_content = view.findViewById(R.id.tv_content);
        images = view.findViewById(R.id.images);

        sessionManager = new SessionManager(getContext());

        Sno_pengaduan = getActivity().getIntent().getStringExtra("no_pengaduan");
        Suser_type = getActivity().getIntent().getStringExtra("user_type");
        Screated_at = getActivity().getIntent().getStringExtra("created_at");
        Supdated_at = getActivity().getIntent().getStringExtra("updated_at");
        Scontent = getActivity().getIntent().getStringExtra("content");
        Sphoto = getActivity().getIntent().getStringExtra("photo");

        no_pengaduan.setText(Sno_pengaduan);
        tv_nama_disposisi.setText(Suser_type);
        tv_created_at.setText(Screated_at);
        tv_updated_at.setText(Supdated_at);
        tv_content.setText(Scontent);

        if(Sphoto==null){

        }else {
            Picasso.with(getContext()).
                    load(Sphoto).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(images);
        }

        return view;
    }
}