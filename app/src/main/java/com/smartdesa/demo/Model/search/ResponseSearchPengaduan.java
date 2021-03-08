package com.smartdesa.demo.Model.search;

import com.smartdesa.demo.Model.pengaduan.ModelDisposisi;

import java.util.List;

public class ResponseSearchPengaduan {

    private int kode;
    private List<ModelDisposisi> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelDisposisi> getData() {
        return data;
    }

    public void setData(List<ModelDisposisi> data) {
        this.data = data;
    }
}
