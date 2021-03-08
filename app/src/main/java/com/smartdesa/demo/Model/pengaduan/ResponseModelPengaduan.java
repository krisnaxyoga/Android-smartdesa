package com.smartdesa.demo.Model.pengaduan;

import java.util.List;

public class ResponseModelPengaduan {

    private int kode;
    private List<ModelPengaduan> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelPengaduan> getData() {
        return data;
    }

    public void setData(List<ModelPengaduan> data) {
        this.data = data;
    }
}
