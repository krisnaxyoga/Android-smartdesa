package com.smartdesa.demo.Model.kependudukan;

import java.util.List;

public class ResponsePendSex {

    private int kode;
    private List<ModelPendSex> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelPendSex> getData() {
        return data;
    }

    public void setData(List<ModelPendSex> data) {
        this.data = data;
    }
}
