package com.smartdesa.demo.Model.pengaduan;

import java.util.List;

public class ResponseModelCon {

    private int kode;
    private List<ModelCon> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelCon> getData() {
        return data;
    }

    public void setData(List<ModelCon> data) {
        this.data = data;
    }
}
