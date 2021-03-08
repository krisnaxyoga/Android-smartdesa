package com.smartdesa.demo.Model.kk;

import com.google.gson.annotations.SerializedName;
import com.smartdesa.demo.Model.penduduk.ModelPenduduk;

public class ResponseModelKK {

    @SerializedName("error")
    private boolean error;

    @SerializedName("data")
    private ModelKK modelKK;

    @SerializedName("message")
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ModelKK getModelKK() {
        return modelKK;
    }

    public void setModelKK(ModelKK modelKK) {
        this.modelKK = modelKK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
