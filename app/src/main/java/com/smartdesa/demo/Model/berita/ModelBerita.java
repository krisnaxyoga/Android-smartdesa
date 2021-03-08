package com.smartdesa.demo.Model.berita;

import com.google.gson.annotations.SerializedName;

public class ModelBerita {

    @SerializedName("id")
    private String id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("konten")
    private String konten;
    @SerializedName("slug")
    private String slug;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("type")
    private String type;

    public ModelBerita(String id, String judul, String konten, String slug, String gambar, String created_at, String updated_at, String type) {
        this.id = id;
        this.judul = judul;
        this.konten = konten;
        this.slug = slug;
        this.gambar = gambar;
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

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
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
