package com.smartdesa.demo.Model.pengaduan;

import com.google.gson.annotations.SerializedName;

public class ResponseKirimPengaduan {

    @SerializedName("data")
    private ModelKirimPengaduan modelKirimPengaduan;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public ModelKirimPengaduan getModelKirimPengaduan() {
        return modelKirimPengaduan;
    }

    public void setModelKirimPengaduan(ModelKirimPengaduan modelKirimPengaduan) {
        this.modelKirimPengaduan = modelKirimPengaduan;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
