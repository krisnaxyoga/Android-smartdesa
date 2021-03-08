package com.smartdesa.demo.Model.search;

import com.smartdesa.demo.Model.berita.ModelBerita;

import java.util.List;

public class ResponseSearchBerita {

    private int kode;
    private String message;
    private List<ModelBerita> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelBerita> getData() {
        return data;
    }

    public void setData(List<ModelBerita> data) {
        this.data = data;
    }
}
