package com.smartdesa.demo.Model.kependudukan;

import com.google.gson.annotations.SerializedName;

public class ModelKerja {

    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
