package com.smartdesa.demo.Model.permohonan;

import com.google.gson.annotations.SerializedName;

public class ModelPermohonan {

    //Field sesuai database
    @SerializedName("id")
    private String id;
    @SerializedName("desa_id")
    private String desa_id;
    @SerializedName("dusun_id")
    private String dusun_id;
    @SerializedName("keperluan")
    private String keperluan;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("penduduk_id")
    private String penduduk_id;
    @SerializedName("jenis_surat_id")
    private String jenis_surat_id;
    @SerializedName("nomor_surat")
    private String nomor_surat;
    @SerializedName("jenis_acara")
    private String jenis_acara;
    @SerializedName("berlaku_dari")
    private String berlaku_dari;
    @SerializedName("berlaku_sampai")
    private String berlaku_sampai;
    @SerializedName("staff_id")
    private String staff_id;
    @SerializedName("staff_sebagai_id")
    private String staff_sebagai_id;
    @SerializedName("no_surat_pengantar")
    private String no_surat_pengantar;
    @SerializedName("status")
    private String status;
    @SerializedName("is_mobile")
    private String is_mobile;
    @SerializedName("tanggal_pengajuan")
    private String tanggal_pengajuan;
    @SerializedName("tanggal_verifikasi")
    private String tanggal_verifikasi;
    @SerializedName("tanggal_cetak")
    private String tanggal_cetak;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("deleted_at")
    private String deleted_at;
    @SerializedName("remark_kadus")
    private String remark_kadus;
    @SerializedName("track_number")
    private String track_number;
    @SerializedName("nama_usaha")
    private String nama_usaha;
    @SerializedName("alamat_usaha")
    private String alamat_usaha;
    @SerializedName("jenis_usaha")
    private String jenis_usaha;
    @SerializedName("nama_pasangan")
    private String nama_pasangan;
    @SerializedName("tahun_kawin")
    private String tahun_kawin;
    @SerializedName("lokasi_kawin")
    private String lokasi_kawin;
    @SerializedName("pernyataan_status")
    private String pernyataan_status;
    @SerializedName("pindah_desa")
    private String pindah_desa;
    @SerializedName("pindah_kec")
    private String pindah_kec;
    @SerializedName("pindah_kab")
    private String pindah_kab;
    @SerializedName("pindah_prov")
    private String pindah_prov;
    @SerializedName("tanggal_pindah")
    private String tanggal_pindah;
    @SerializedName("tanggal_kk")
    private String tanggal_kk;
    @SerializedName("no_kk")
    private String no_kk;
    @SerializedName("tahun_menetap")
    private String tahun_menetap;
    @SerializedName("nama_dusun")
    private String nama_dusun;
    @SerializedName("nama_desa")
    private String nama_desa;
    @SerializedName("nama_kecamatan")
    private String nama_kecamatan;
    @SerializedName("nama_kabupaten")
    private String nama_kabupaten;
    @SerializedName("nama_provinsi")
    private String nama_provinsi;
    @SerializedName("tanggal_meninggal")
    private String tanggal_meninggal;
    @SerializedName("lokasi_meninggal")
    private String lokasi_meninggal;
    @SerializedName("penyebab_meninggal")
    private String penyebab_meninggal;
    @SerializedName("nama_pelapor")
    private String nama_pelapor;
    @SerializedName("nik_pelapor")
    private String nik_pelapor;
    @SerializedName("hubungan_pelapor")
    private String hubungan_pelapor;

    public ModelPermohonan(String id, String desa_id, String dusun_id, String keperluan, String keterangan, String penduduk_id, String jenis_surat_id, String nomor_surat, String jenis_acara, String berlaku_dari, String berlaku_sampai, String staff_id, String staff_sebagai_id, String no_surat_pengantar, String status, String is_mobile, String tanggal_pengajuan, String tanggal_verifikasi, String tanggal_cetak, String created_at, String updated_at, String deleted_at, String remark_kadus, String track_number, String nama_usaha, String alamat_usaha, String jenis_usaha, String nama_pasangan, String tahun_kawin, String lokasi_kawin, String pernyataan_status, String pindah_desa, String pindah_kec, String pindah_kab, String pindah_prov, String tanggal_pindah, String tanggal_kk, String no_kk, String tahun_menetap, String nama_dusun, String nama_desa, String nama_kecamatan, String nama_kabupaten, String nama_provinsi, String tanggal_meninggal, String lokasi_meninggal, String penyebab_meninggal, String nama_pelapor, String nik_pelapor, String hubungan_pelapor) {
        this.id = id;
        this.desa_id = desa_id;
        this.dusun_id = dusun_id;
        this.keperluan = keperluan;
        this.keterangan = keterangan;
        this.penduduk_id = penduduk_id;
        this.jenis_surat_id = jenis_surat_id;
        this.nomor_surat = nomor_surat;
        this.jenis_acara = jenis_acara;
        this.berlaku_dari = berlaku_dari;
        this.berlaku_sampai = berlaku_sampai;
        this.staff_id = staff_id;
        this.staff_sebagai_id = staff_sebagai_id;
        this.no_surat_pengantar = no_surat_pengantar;
        this.status = status;
        this.is_mobile = is_mobile;
        this.tanggal_pengajuan = tanggal_pengajuan;
        this.tanggal_verifikasi = tanggal_verifikasi;
        this.tanggal_cetak = tanggal_cetak;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.remark_kadus = remark_kadus;
        this.track_number = track_number;
        this.nama_usaha = nama_usaha;
        this.alamat_usaha = alamat_usaha;
        this.jenis_usaha = jenis_usaha;
        this.nama_pasangan = nama_pasangan;
        this.tahun_kawin = tahun_kawin;
        this.lokasi_kawin = lokasi_kawin;
        this.pernyataan_status = pernyataan_status;
        this.pindah_desa = pindah_desa;
        this.pindah_kec = pindah_kec;
        this.pindah_kab = pindah_kab;
        this.pindah_prov = pindah_prov;
        this.tanggal_pindah = tanggal_pindah;
        this.tanggal_kk = tanggal_kk;
        this.no_kk = no_kk;
        this.tahun_menetap = tahun_menetap;
        this.nama_dusun = nama_dusun;
        this.nama_desa = nama_desa;
        this.nama_kecamatan = nama_kecamatan;
        this.nama_kabupaten = nama_kabupaten;
        this.nama_provinsi = nama_provinsi;
        this.tanggal_meninggal = tanggal_meninggal;
        this.lokasi_meninggal = lokasi_meninggal;
        this.penyebab_meninggal = penyebab_meninggal;
        this.nama_pelapor = nama_pelapor;
        this.nik_pelapor = nik_pelapor;
        this.hubungan_pelapor = hubungan_pelapor;
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

    public String getDusun_id() {
        return dusun_id;
    }

    public void setDusun_id(String dusun_id) {
        this.dusun_id = dusun_id;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getPenduduk_id() {
        return penduduk_id;
    }

    public void setPenduduk_id(String penduduk_id) {
        this.penduduk_id = penduduk_id;
    }

    public String getJenis_surat_id() {
        return jenis_surat_id;
    }

    public void setJenis_surat_id(String jenis_surat_id) {
        this.jenis_surat_id = jenis_surat_id;
    }

    public String getNomor_surat() {
        return nomor_surat;
    }

    public void setNomor_surat(String nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

    public String getJenis_acara() {
        return jenis_acara;
    }

    public void setJenis_acara(String jenis_acara) {
        this.jenis_acara = jenis_acara;
    }

    public String getBerlaku_dari() {
        return berlaku_dari;
    }

    public void setBerlaku_dari(String berlaku_dari) {
        this.berlaku_dari = berlaku_dari;
    }

    public String getBerlaku_sampai() {
        return berlaku_sampai;
    }

    public void setBerlaku_sampai(String berlaku_sampai) {
        this.berlaku_sampai = berlaku_sampai;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_sebagai_id() {
        return staff_sebagai_id;
    }

    public void setStaff_sebagai_id(String staff_sebagai_id) {
        this.staff_sebagai_id = staff_sebagai_id;
    }

    public String getNo_surat_pengantar() {
        return no_surat_pengantar;
    }

    public void setNo_surat_pengantar(String no_surat_pengantar) {
        this.no_surat_pengantar = no_surat_pengantar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_mobile() {
        return is_mobile;
    }

    public void setIs_mobile(String is_mobile) {
        this.is_mobile = is_mobile;
    }

    public String getTanggal_pengajuan() {
        return tanggal_pengajuan;
    }

    public void setTanggal_pengajuan(String tanggal_pengajuan) {
        this.tanggal_pengajuan = tanggal_pengajuan;
    }

    public String getTanggal_verifikasi() {
        return tanggal_verifikasi;
    }

    public void setTanggal_verifikasi(String tanggal_verifikasi) {
        this.tanggal_verifikasi = tanggal_verifikasi;
    }

    public String getTanggal_cetak() {
        return tanggal_cetak;
    }

    public void setTanggal_cetak(String tanggal_cetak) {
        this.tanggal_cetak = tanggal_cetak;
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getRemark_kadus() {
        return remark_kadus;
    }

    public void setRemark_kadus(String remark_kadus) {
        this.remark_kadus = remark_kadus;
    }

    public String getTrack_number() {
        return track_number;
    }

    public void setTrack_number(String track_number) {
        this.track_number = track_number;
    }

    public String getNama_usaha() {
        return nama_usaha;
    }

    public void setNama_usaha(String nama_usaha) {
        this.nama_usaha = nama_usaha;
    }

    public String getAlamat_usaha() {
        return alamat_usaha;
    }

    public void setAlamat_usaha(String alamat_usaha) {
        this.alamat_usaha = alamat_usaha;
    }

    public String getJenis_usaha() {
        return jenis_usaha;
    }

    public void setJenis_usaha(String jenis_usaha) {
        this.jenis_usaha = jenis_usaha;
    }

    public String getNama_pasangan() {
        return nama_pasangan;
    }

    public void setNama_pasangan(String nama_pasangan) {
        this.nama_pasangan = nama_pasangan;
    }

    public String getTahun_kawin() {
        return tahun_kawin;
    }

    public void setTahun_kawin(String tahun_kawin) {
        this.tahun_kawin = tahun_kawin;
    }

    public String getLokasi_kawin() {
        return lokasi_kawin;
    }

    public void setLokasi_kawin(String lokasi_kawin) {
        this.lokasi_kawin = lokasi_kawin;
    }

    public String getPernyataan_status() {
        return pernyataan_status;
    }

    public void setPernyataan_status(String pernyataan_status) {
        this.pernyataan_status = pernyataan_status;
    }

    public String getPindah_desa() {
        return pindah_desa;
    }

    public void setPindah_desa(String pindah_desa) {
        this.pindah_desa = pindah_desa;
    }

    public String getPindah_kec() {
        return pindah_kec;
    }

    public void setPindah_kec(String pindah_kec) {
        this.pindah_kec = pindah_kec;
    }

    public String getPindah_kab() {
        return pindah_kab;
    }

    public void setPindah_kab(String pindah_kab) {
        this.pindah_kab = pindah_kab;
    }

    public String getPindah_prov() {
        return pindah_prov;
    }

    public void setPindah_prov(String pindah_prov) {
        this.pindah_prov = pindah_prov;
    }

    public String getTanggal_pindah() {
        return tanggal_pindah;
    }

    public void setTanggal_pindah(String tanggal_pindah) {
        this.tanggal_pindah = tanggal_pindah;
    }

    public String getTanggal_kk() {
        return tanggal_kk;
    }

    public void setTanggal_kk(String tanggal_kk) {
        this.tanggal_kk = tanggal_kk;
    }

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getTahun_menetap() {
        return tahun_menetap;
    }

    public void setTahun_menetap(String tahun_menetap) {
        this.tahun_menetap = tahun_menetap;
    }

    public String getNama_dusun() {
        return nama_dusun;
    }

    public void setNama_dusun(String nama_dusun) {
        this.nama_dusun = nama_dusun;
    }

    public String getNama_desa() {
        return nama_desa;
    }

    public void setNama_desa(String nama_desa) {
        this.nama_desa = nama_desa;
    }

    public String getNama_kecamatan() {
        return nama_kecamatan;
    }

    public void setNama_kecamatan(String nama_kecamatan) {
        this.nama_kecamatan = nama_kecamatan;
    }

    public String getNama_kabupaten() {
        return nama_kabupaten;
    }

    public void setNama_kabupaten(String nama_kabupaten) {
        this.nama_kabupaten = nama_kabupaten;
    }

    public String getNama_provinsi() {
        return nama_provinsi;
    }

    public void setNama_provinsi(String nama_provinsi) {
        this.nama_provinsi = nama_provinsi;
    }

    public String getTanggal_meninggal() {
        return tanggal_meninggal;
    }

    public void setTanggal_meninggal(String tanggal_meninggal) {
        this.tanggal_meninggal = tanggal_meninggal;
    }

    public String getLokasi_meninggal() {
        return lokasi_meninggal;
    }

    public void setLokasi_meninggal(String lokasi_meninggal) {
        this.lokasi_meninggal = lokasi_meninggal;
    }

    public String getPenyebab_meninggal() {
        return penyebab_meninggal;
    }

    public void setPenyebab_meninggal(String penyebab_meninggal) {
        this.penyebab_meninggal = penyebab_meninggal;
    }

    public String getNama_pelapor() {
        return nama_pelapor;
    }

    public void setNama_pelapor(String nama_pelapor) {
        this.nama_pelapor = nama_pelapor;
    }

    public String getNik_pelapor() {
        return nik_pelapor;
    }

    public void setNik_pelapor(String nik_pelapor) {
        this.nik_pelapor = nik_pelapor;
    }

    public String getHubungan_pelapor() {
        return hubungan_pelapor;
    }

    public void setHubungan_pelapor(String hubungan_pelapor) {
        this.hubungan_pelapor = hubungan_pelapor;
    }
}
