package com.smartdesa.demo.Model.permohonan;

import com.google.gson.annotations.SerializedName;

public class ResponseModelPermohonan {

    @SerializedName("data")
    private ModelPermohonan modelPermohonan;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

//    @SerializedName("error")
//    private boolean error;

    public ModelPermohonan getModelPermohonan() {
        return modelPermohonan;
    }

    public void setModelPermohonan(ModelPermohonan modelPermohonan) {
        this.modelPermohonan = modelPermohonan;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public boolean isError() {
//        return error;
//    }
//
//    public void setError(boolean error) {
//        this.error = error;
//    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
