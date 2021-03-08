package com.smartdesa.demo.Model.slider;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseModelSlider {

    @SerializedName("data")
    private ArrayList<ModelSlider> data;

    public ResponseModelSlider(){

    }

    public ArrayList<ModelSlider> getData() {
        return data;
    }

    public void setData(ArrayList<ModelSlider> data) {
        this.data = data;
    }
}
