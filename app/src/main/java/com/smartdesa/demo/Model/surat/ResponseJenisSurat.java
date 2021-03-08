package com.smartdesa.demo.Model.surat;

import java.util.List;

public class ResponseJenisSurat {

//    @SerializedName("data")
//    List<ModelJenisSurat> jsurat;
//    public List<ModelJenisSurat> getJsurat() {
//        return jsurat;
//    }

    private int kode;
    private List<ModelJenisSurat> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelJenisSurat> getData() {
        return data;
    }

    public void setData(List<ModelJenisSurat> data) {
        this.data = data;
    }
}
