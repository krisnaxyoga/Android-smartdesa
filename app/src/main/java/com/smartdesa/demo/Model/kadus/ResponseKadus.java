package com.smartdesa.demo.Model.kadus;

import java.util.List;

public class ResponseKadus {

    private int kode;
    private List<ModelKadus> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelKadus> getData() {
        return data;
    }

    public void setData(List<ModelKadus> data) {
        this.data = data;
    }
}
