package com.smartdesa.demo.Model.kependudukan;

import java.util.List;

public class ResponseGolonganDarah {

    private int kode;
    private List<ModelAgama> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelAgama> getData() {
        return data;
    }

    public void setData(List<ModelAgama> data) {
        this.data = data;
    }

}