package com.smartdesa.demo.Model.pengumuman;

import java.util.List;

public class ResponseModelPengumuman {

    private int kode;
    private List<ModelPengumuman> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelPengumuman> getData() {
        return data;
    }

    public void setData(List<ModelPengumuman> data) {
        this.data = data;
    }
}
