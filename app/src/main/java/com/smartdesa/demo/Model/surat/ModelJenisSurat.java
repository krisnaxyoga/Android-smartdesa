package com.smartdesa.demo.Model.surat;

import com.google.gson.annotations.SerializedName;

public class ModelJenisSurat {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("kode_surat")
    private String kode_surat;
    @SerializedName("judul")
    private String judul;

    public ModelJenisSurat(String id, String kode_surat, String judul) {
        this.id = id;
        this.kode_surat = kode_surat;
        this.judul = judul;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode_surat() {
        return kode_surat;
    }

    public void setKode_surat(String kode_surat) {
        this.kode_surat = kode_surat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

}
