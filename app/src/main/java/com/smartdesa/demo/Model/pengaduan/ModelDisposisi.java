package com.smartdesa.demo.Model.pengaduan;

import com.google.gson.annotations.SerializedName;

public class ModelDisposisi {

    //Field sesuai database
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
    @SerializedName("content2")
    private String content2;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("user_target")
    private String user_target;
    @SerializedName("user_id2")
    private String user_id2;
    @SerializedName("rating")
    private String rating;
    @SerializedName("status")
    private String status;
    @SerializedName("start_date")
    private String start_date;
    @SerializedName("end_date")
    private String end_date;
    @SerializedName("photo2")
    private String photo2;
    @SerializedName("created_at2")
    private String created_at2;

    public ModelDisposisi(String pengaduan_id, String user_type, String user_id, String content, String photo, String created_at, String updated_at, String id, String desa_id, String penduduk_id, String pengaduan_category_id, String no_pengaduan, String title, String content2, String lat, String lng, String user_target, String user_id2, String rating, String status, String start_date, String end_date, String photo2, String created_at2) {
        this.pengaduan_id = pengaduan_id;
        this.user_type = user_type;
        this.user_id = user_id;
        this.content = content;
        this.photo = photo;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.id = id;
        this.desa_id = desa_id;
        this.penduduk_id = penduduk_id;
        this.pengaduan_category_id = pengaduan_category_id;
        this.no_pengaduan = no_pengaduan;
        this.title = title;
        this.content2 = content2;
        this.lat = lat;
        this.lng = lng;
        this.user_target = user_target;
        this.user_id2 = user_id2;
        this.rating = rating;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.photo2 = photo2;
        this.created_at2 = created_at2;
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

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
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

    public String getUser_id2() {
        return user_id2;
    }

    public void setUser_id2(String user_id2) {
        this.user_id2 = user_id2;
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

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getCreated_at2() {
        return created_at2;
    }

    public void setCreated_at2(String created_at2) {
        this.created_at2 = created_at2;
    }
}
