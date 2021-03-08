package com.smartdesa.demo.Model.kadus;

import com.google.gson.annotations.SerializedName;

public class ModelKadus {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("dusun_id")
    private String dusun_id;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("phone")
    private String phone;
    @SerializedName("photo")
    private String photo;

    public ModelKadus(String id, String name, String dusun_id, String created_at, String updated_at, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.dusun_id = dusun_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.phone = phone;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDusun_id() {
        return dusun_id;
    }

    public void setDusun_id(String dusun_id) {
        this.dusun_id = dusun_id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
