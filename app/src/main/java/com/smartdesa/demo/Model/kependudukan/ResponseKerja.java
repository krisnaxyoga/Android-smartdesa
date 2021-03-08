package com.smartdesa.demo.Model.kependudukan;

import java.util.List;

public class ResponseKerja {

    private int kode;
    private List<ModelKerja> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelKerja> getData() {
        return data;
    }

    public void setData(List<ModelKerja> data) {
        this.data = data;
    }
}
