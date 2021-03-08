package com.smartdesa.demo.Model.pengaduan;

import com.google.gson.annotations.SerializedName;

public class ModelCon {

    @SerializedName("id")
    private String id;
    @SerializedName("content")
    private String content;

    public ModelCon(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
