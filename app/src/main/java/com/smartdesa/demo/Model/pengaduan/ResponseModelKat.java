package com.smartdesa.demo.Model.pengaduan;

import java.util.List;

public class ResponseModelKat {

    private int kode;
    private List<ModelKat> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelKat> getData() {
        return data;
    }

    public void setData(List<ModelKat> data) {
        this.data = data;
    }
}
