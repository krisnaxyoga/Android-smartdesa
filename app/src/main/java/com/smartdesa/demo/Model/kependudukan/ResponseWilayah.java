package com.smartdesa.demo.Model.kependudukan;

import java.util.List;

public class ResponseWilayah {

    private int kode;
    private List<ModelWilayah> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelWilayah> getData() {
        return data;
    }

    public void setData(List<ModelWilayah> data) {
        this.data = data;
    }

}
