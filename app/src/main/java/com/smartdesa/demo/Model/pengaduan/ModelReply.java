package com.smartdesa.demo.Model.pengaduan;

import com.google.gson.annotations.SerializedName;

public class ModelReply {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("desa_id")
    private String desa_id;
    @SerializedName("pengaduan_id")
    private String pengaduan_id;
    @SerializedName("user_type")
    private String user_type;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("content")
    private String content;
    @SerializedName("photo")
    private String photo;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public ModelReply(String id, String desa_id, String pengaduan_id, String user_type, String user_id, String content, String photo, String created_at, String updated_at) {
        this.id = id;
        this.desa_id = desa_id;
        this.pengaduan_id = pengaduan_id;
        this.user_type = user_type;
        this.user_id = user_id;
        this.content = content;
        this.photo = photo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

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

    public String getPengaduan_id() {
        return pengaduan_id;
    }

    public void setPengaduan_id(String pengaduan_id) {
        this.pengaduan_id = pengaduan_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
