package com.smartdesa.demo.Model.penduduk;

import com.google.gson.annotations.SerializedName;

public class ModelPenduduk {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("desa_id")
    private String desa_id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("nik")
    private String nik;
    @SerializedName("tempatlahir")
    private String tempatlahir;
    @SerializedName("tanggallahir")
    private String tanggallahir;
    @SerializedName("sex")
    private String sex;
    @SerializedName("golongan_darah_id")
    private String golongan_darah_id;
    @SerializedName("dusun_id")
    private String dusun_id;
    @SerializedName("alamat_sekarang")
    private String alamat_sekarang;
    @SerializedName("nama_ayah")
    private String nama_ayah;
    @SerializedName("nama_ibu")
    private String nama_ibu;
    @SerializedName("foto")
    private String foto;
    @SerializedName("agama_id")
    private String agama_id;
    @SerializedName("status_kawin_id")
    private String status_kawin_id;
    @SerializedName("pekerjaan_id")
    private String pekerjaan_id;
    @SerializedName("warganegara_id")
    private String warganegara_id;


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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGolongan_darah_id() {
        return golongan_darah_id;
    }

    public void setGolongan_darah_id(String golongan_darah_id) {
        this.golongan_darah_id = golongan_darah_id;
    }

    public String getDusun_id() {
        return dusun_id;
    }

    public void setDusun_id(String dusun_id) {
        this.dusun_id = dusun_id;
    }

    public String getAlamat_sekarang() {
        return alamat_sekarang;
    }

    public void setAlamat_sekarang(String alamat_sekarang) {
        this.alamat_sekarang = alamat_sekarang;
    }

    public String getNama_ayah() {
        return nama_ayah;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAgama_id() {
        return agama_id;
    }

    public void setAgama_id(String agama_id) {
        this.agama_id = agama_id;
    }

    public String getStatus_kawin_id() {
        return status_kawin_id;
    }

    public void setStatus_kawin_id(String status_kawin_id) {
        this.status_kawin_id = status_kawin_id;
    }

    public String getPekerjaan_id() {
        return pekerjaan_id;
    }

    public void setPekerjaan_id(String pekerjaan_id) {
        this.pekerjaan_id = pekerjaan_id;
    }

    public String getWarganegara_id() {
        return warganegara_id;
    }

    public void setWarganegara_id(String warganegara_id) {
        this.warganegara_id = warganegara_id;
    }
}
