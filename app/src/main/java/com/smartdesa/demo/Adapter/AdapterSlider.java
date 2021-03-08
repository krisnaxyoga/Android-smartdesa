package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smartdesa.demo.Model.slider.ModelSlider;
import com.smartdesa.demo.R;

import java.util.ArrayList;

public class AdapterSlider extends BaseAdapter {

    private Context mCtx;
    private ArrayList<ModelSlider> listslider;

    public AdapterSlider(Context mCtx, ArrayList<ModelSlider> listslider){
        this.mCtx = mCtx;
        this.listslider = listslider;
    }
    @Override
    public int getCount() {
        return listslider.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ModelSlider modelSlider = listslider.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.ly_slider, null);
//        TextView textView = (TextView) view.findViewById(R.id.textView);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
//        textView.setText(hero.getName());

        Glide.with(mCtx).load(modelSlider.getGambar()).into(imageView);
        return view;
    }

}
