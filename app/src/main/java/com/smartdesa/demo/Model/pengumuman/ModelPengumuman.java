package com.smartdesa.demo.Model.pengumuman;

import com.google.gson.annotations.SerializedName;

public class ModelPengumuman {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("desa_id")
    private String desa_id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("ref_id")
    private String ref_id;
    @SerializedName("ref_type")
    private String ref_type;
    @SerializedName("photo")
    private String photo;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("type")
    private String type;

    public ModelPengumuman(String id, String desa_id, String title, String description, String ref_id, String ref_type, String photo, String created_at, String updated_at, String type) {
        this.id = id;
        this.desa_id = desa_id;
        this.title = title;
        this.description = description;
        this.ref_id = ref_id;
        this.ref_type = ref_type;
        this.photo = photo;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.type = type;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getRef_type() {
        return ref_type;
    }

    public void setRef_type(String ref_type) {
        this.ref_type = ref_type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
