package com.smartdesa.demo.Model.kependudukan;

import com.google.gson.annotations.SerializedName;

public class ModelWilayah {

    @SerializedName("id")
    private String id;
    @SerializedName("dusun")
    private String dusun;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDusun() {
        return dusun;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
    }

}
