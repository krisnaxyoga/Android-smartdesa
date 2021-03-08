package com.smartdesa.demo.Model.pengaduan;

import com.google.gson.annotations.SerializedName;

public class ModelKirimPengaduan {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("desa_id")
    private String desa_id;
    @SerializedName("penduduk_id")
    private String penduduk_id;
    @SerializedName("pengaduan_category_id")
    private String pengaduan_category_id;
    @SerializedName("no_pengaduan")
    private String no_pengaduan;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("user_target")
    private String user_target;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("rating")
    private String rating;
    @SerializedName("status")
    private String status;
    @SerializedName("start_date")
    private String start_date;
    @SerializedName("end_date")
    private String end_date;
    @SerializedName("photo")
    private String photo;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public ModelKirimPengaduan(String id, String desa_id, String penduduk_id, String pengaduan_category_id, String no_pengaduan, String title, String content, String lat, String lng, String user_target, String user_id, String rating, String status, String start_date, String end_date, String photo, String created_at, String updated_at) {
        this.id = id;
        this.desa_id = desa_id;
        this.penduduk_id = penduduk_id;
        this.pengaduan_category_id = pengaduan_category_id;
        this.no_pengaduan = no_pengaduan;
        this.title = title;
        this.content = content;
        this.lat = lat;
        this.lng = lng;
        this.user_target = user_target;
        this.user_id = user_id;
        this.rating = rating;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public String getPenduduk_id() {
        return penduduk_id;
    }

    public void setPenduduk_id(String penduduk_id) {
        this.penduduk_id = penduduk_id;
    }

    public String getPengaduan_category_id() {
        return pengaduan_category_id;
    }

    public void setPengaduan_category_id(String pengaduan_category_id) {
        this.pengaduan_category_id = pengaduan_category_id;
    }

    public String getNo_pengaduan() {
        return no_pengaduan;
    }

    public void setNo_pengaduan(String no_pengaduan) {
        this.no_pengaduan = no_pengaduan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getUser_target() {
        return user_target;
    }

    public void setUser_target(String user_target) {
        this.user_target = user_target;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
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
