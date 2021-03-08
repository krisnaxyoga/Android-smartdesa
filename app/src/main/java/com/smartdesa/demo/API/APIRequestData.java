package com.smartdesa.demo.API;

import com.smartdesa.demo.Model.kadus.ResponseKadus;
import com.smartdesa.demo.Model.kependudukan.ResponseGolonganDarah;
import com.smartdesa.demo.Model.kependudukan.ResponseKawin;
import com.smartdesa.demo.Model.kependudukan.ResponsePendWni;
import com.smartdesa.demo.Model.kependudukan.ResponseWilayah;
import com.smartdesa.demo.Model.kk.ResponseModelKK;
import com.smartdesa.demo.Model.penduduk.ResponseModelPenduduk;
import com.smartdesa.demo.Model.pengaduan.ResponseDisposisi;
import com.smartdesa.demo.Model.pengaduan.ResponseKirimPengaduan;
import com.smartdesa.demo.Model.pengaduan.ResponseModelCon;
import com.smartdesa.demo.Model.pengaduan.ResponseModelKat;
import com.smartdesa.demo.Model.pengaduan.ResponseModelPengaduan;
import com.smartdesa.demo.Model.pengumuman.ResponseModelPengumuman;
import com.smartdesa.demo.Model.permohonan.ResponseListPermohonan;
import com.smartdesa.demo.Model.search.ResponseSearchBerita;
import com.smartdesa.demo.Model.search.ResponseSearchPengaduan;
import com.smartdesa.demo.Model.search.ResponseSearchSurat;
import com.smartdesa.demo.Model.slider.ResponseModelSlider;
import com.smartdesa.demo.Model.surat.ResponseJenisSurat;
import com.smartdesa.demo.Model.permohonan.ResponseModelPermohonan;
import com.smartdesa.demo.Model.berita.ResponseBerita;
import com.smartdesa.demo.Model.kependudukan.ResponseAgama;
import com.smartdesa.demo.Model.kependudukan.ResponseKerja;
import com.smartdesa.demo.Model.kependudukan.ResponsePendSex;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {

    //API LARAVEL
    @FormUrlEncoded
    @POST("penduduk/login")
    Call<ResponseModelPenduduk> userLogin(
            @Field("nik") String nik,
            @Field("dob") String tanggal);

    //API LARAVEL
    @FormUrlEncoded
    @POST("validation.php")
    Call<ResponseModelKK> userValidasi(
            @Field("no_kk") String kk,
            @Field("nik_kepala") String nik);

    //MENAMPILKAN LIST JENIS SURAT
    @GET("jenis-surat")
    Call<ResponseJenisSurat> getResponseJenisSurat();

    //BERITA
    @GET("berita")
    Call<ResponseBerita> getResponseBerita();

    //PHP NATIVE
    //MENAMPILKAN LIST PENGADUAN MASYARAKAT
    @GET("jenispengaduan.php")
    Call<ResponseModelPengaduan> getResponseModelPengaduan();

    //MENAMPILKAN DETAIL PENGADUAN MASYARAKAT
    @FormUrlEncoded
    @POST("detaildisposisi.php")
    Call<ResponseDisposisi> getResponseDisposisi(@Field("penduduk_id") String penduduk_id);

    //KIRIM PENGADUAN
    @FormUrlEncoded
    @POST("pengaduan.php")
    Call<ResponseKirimPengaduan> pengaduanResponse(
            @Field("desa_id") String desa_id,
            @Field("penduduk_id") String penduduk_id,
            @Field("pengaduan_category_id") String pengaduan_category_id,
            @Field("title") String title,
            @Field("content") String content,
            @Field("photo") String photo);

    //MENAMPILKAN PENGUMUMAN
    @GET("notification.php")
    Call<ResponseModelPengumuman> getResponseModelPengumuman();

    //MENAMPILKAN SLIDER
    @GET("slider.php")
    Call<ResponseModelSlider> getResponseModelSlider();

    //MENAMPILKAN LIST SURAT SUDAH DICETAK
    @FormUrlEncoded
    @POST("tampilriwayat.php")
    Call<ResponseListPermohonan> getResponseRiwayat(@Field("id") String id);

    //MENAMPILKAN LIST NOTIF SURAT BELUM DI ACC
    @FormUrlEncoded
    @POST("notifsurat.php")
    Call<ResponseListPermohonan> getResponseNotif(@Field("id") String id);

    //MENAMPILKAN LIST SURAT BELUM DICETAK
    @FormUrlEncoded
    @POST("cetaksurat.php")
    Call<ResponseListPermohonan> getResponseCetak(@Field("id") String id);

    //MENAMPILKAN HASIL SEARCH BERITA
    @FormUrlEncoded
    @POST("searchberita.php")
    Call<ResponseSearchBerita> getResponseSearchBerita(@Field("keyword") String keyword);

    //MENAMPILKAN HASIL SEARCH ARSIP SURAT
    @FormUrlEncoded
    @POST("searcharsurat.php")
    Call<ResponseSearchSurat> getResponseSearchSurat(@Field("id") String id, @Field("keyword") String keyword);

    //MENAMPILKAN HASIL SEARCH ARSIP PENGADUAN
    @FormUrlEncoded
    @POST("searcharpengaduan.php")
    Call<ResponseSearchPengaduan> getResponseSearchPengaduan(@Field("penduduk_id") String penduduk_id, @Field("keyword") String keyword);

    //MENAMPILKAN HASIL SEARCH PENGUMUMAN
    @FormUrlEncoded
    @POST("searchpengumuman.php")
    Call<ResponseModelPengumuman> getResponseSearchPengumuman(@Field("keyword") String keyword);

    //LOAD PENDUDUK BACKUP
    @FormUrlEncoded
    @POST("kepala_dusun.php")
    Call<ResponseKadus> getModelKadus(@Field("dusun_id") String dusun_id);

    @FormUrlEncoded
    @POST("penduduk_sex.php")
    Call<ResponsePendSex> getModelPendSex(@Field("id") String id);

    @FormUrlEncoded
    @POST("kat.php")
    Call<ResponseModelKat> getModelKat(@Field("id") String id);

    @FormUrlEncoded
    @POST("pengaduan_coment.php")
    Call<ResponseModelCon> getModelCon(@Field("id") String id);

    @FormUrlEncoded
    @POST("penduduk_warganegara.php")
    Call<ResponsePendWni> getModelPendWNI(@Field("id") String id);

    @FormUrlEncoded
    @POST("golongan_darah.php")
    Call<ResponseGolonganDarah> getModelGolongan(@Field("id") String id);

    @FormUrlEncoded
    @POST("wilayah.php")
    Call<ResponseWilayah> getModelWilayah(@Field("id") String id);

    @FormUrlEncoded
    @POST("penduduk_agama.php")
    Call<ResponseAgama> getModelPendAgama(@Field("id") String id);

    @FormUrlEncoded
    @POST("penduduk_pekerjaan.php")
    Call<ResponseKerja> getModelPendKerja(@Field("id") String id);

    @FormUrlEncoded
    @POST("penduduk_kawin.php")
    Call<ResponseKawin> getModelPendKawin(@Field("id") String id);

    //KONFIRMASI SURAT
    @FormUrlEncoded
    @POST("konfirmasisurat.php")
    Call<ResponseModelPermohonan> konfirmasiResponse(
            @Field("id") String id);

    //KIRIM PERMOHONAN
    @FormUrlEncoded
    @POST("permohonan.php")
    Call<ResponseModelPermohonan> permohonanResponse(
            @Field("desa_id") String desa_id,
            @Field("dusun_id") String dusun_id,
            @Field("keperluan") String keperluan,
            @Field("kode_surat") String kode_surat,
            @Field("penduduk_id") String penduduk_id,
            @Field("jenis_surat_id") String jenis_surat_id,
            @Field("jenis_acara") String jenis_acara,
            @Field("berlaku_dari") String berlaku_dari,
            @Field("berlaku_hingga") String berlaku_hingga,
            @Field("nama_pasangan") String nama_pasangan,
            @Field("tahun_kawin") String tahun_kawin,
            @Field("lokasi_kawin") String lokasi_kawin,
            @Field("pernyataan_sebagai") String pernyataan_sebagai,
            @Field("nama_usaha") String nama_usaha,
            @Field("jenis_usaha") String jenis_usaha,
            @Field("alamat_usaha") String alamat_usaha,
            @Field("no_kk") String no_kk);

    //GANTI FOTO PROFIL
    @FormUrlEncoded
    @POST("foto.php")
    Call<ResponseModelPenduduk> fotoResponse(
            @Field("id") String id,
            @Field("foto") String foto);

}
