package com.smartdesa.demo.Model.penduduk;

import com.google.gson.annotations.SerializedName;

public class ResponseModelPenduduk {

    @SerializedName("error")
    private boolean error;

    @SerializedName("data")
    private ModelPenduduk modelPenduduk;

    @SerializedName("message")
    private String message;

    public void setModelPenduduk(ModelPenduduk modelPenduduk){
        this.modelPenduduk = modelPenduduk;
    }

    public ModelPenduduk getModelPenduduk(){
        return modelPenduduk;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setError(boolean error){
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

}
