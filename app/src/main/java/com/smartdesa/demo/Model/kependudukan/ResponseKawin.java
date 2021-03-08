package com.smartdesa.demo.Model.kependudukan;

import java.util.List;

public class ResponseKawin {

    private int kode;
    private List<ModelKawin> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelKawin> getData() {
        return data;
    }

    public void setData(List<ModelKawin> data) {
        this.data = data;
    }
}
