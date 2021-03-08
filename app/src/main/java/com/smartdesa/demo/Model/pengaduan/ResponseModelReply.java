package com.smartdesa.demo.Model.pengaduan;

import java.util.List;

public class ResponseModelReply {

    private int kode;
    private List<ModelReply> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<ModelReply> getData() {
        return data;
    }

    public void setData(List<ModelReply> data) {
        this.data = data;
    }
}
