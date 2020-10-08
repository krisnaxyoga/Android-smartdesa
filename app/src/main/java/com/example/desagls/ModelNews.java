package com.example.desagls;

public class ModelNews {

    String judul, tanggal, kategori, teks;

    public ModelNews(){}

    public ModelNews(String judul, String tanggal, String kategori, String teks){
        this.judul = judul;
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.teks = teks;
    }
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }

}
