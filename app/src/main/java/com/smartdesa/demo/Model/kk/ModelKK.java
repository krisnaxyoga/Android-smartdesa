package com.smartdesa.demo.Model.kk;

import com.google.gson.annotations.SerializedName;

public class ModelKK {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("desa_id")
    private String desa_id;
    @SerializedName("no_kk")
    private String no_kk;
    @SerializedName("nik_kepala")
    private String nik_kepala;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesa_id() {
        return desa_id;
    }

    public void setDesa_id(String desa_id) {
        this.desa_id = desa_id;
    }

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getNik_kepala() {
        return nik_kepala;
    }

    public void setNik_kepala(String nik_kepala) {
        this.nik_kepala = nik_kepala;
    }
}
