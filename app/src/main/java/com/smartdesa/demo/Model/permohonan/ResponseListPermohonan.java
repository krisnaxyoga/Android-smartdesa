package com.smartdesa.demo.Model.permohonan;

import java.util.List;

public class ResponseListPermohonan {

    private int kode;
    private String message;
    private List<ModelPermohonan> data;

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

    public List<ModelPermohonan> getData() {
        return data;
    }

    public void setData(List<ModelPermohonan> data) {
        this.data = data;
    }
}
