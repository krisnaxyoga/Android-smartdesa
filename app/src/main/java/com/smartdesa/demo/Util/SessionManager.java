package com.smartdesa.demo.Util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smartdesa.demo.Model.penduduk.ModelPenduduk;
import com.smartdesa.demo.updatefoto.FotoProfil;
import com.smartdesa.demo.fragment.Beranda;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID = "id";
    public static final String DESA_ID = "desa_id";
    public static final String NAMA = "nama";
    public static final String NIK = "nik";
    public static final String TEMPATLAHIR = "tempatlahir";
    public static final String TANGGALLAHIR = "tanggallahir";
    public static final String SEX = "sex";
    public static final String GOLONGANDARAH = "golongan_darah_id";
    public static final String DUSUN_ID = "dusun_id";
    public static final String ALAMAT = "alamat_sekarang";
    public static final String AYAH = "nama_ayah";
    public static final String IBU = "nama_ibu";
    public static final String FOTO = "foto";
    public static final String AGAMA = "agama_id";
    public static final String KAWIN = "status_kawin_id";
    public static final String PEKERJAAN = "pekerjaan_id";
    public static final String WARGANEGARA = "warganegara_id";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(ModelPenduduk user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, user.getId());
        editor.putString(DESA_ID, user.getDesa_id());
        editor.putString(NAMA, user.getNama());
        editor.putString(NIK, user.getNik());
        editor.putString(TEMPATLAHIR, user.getTempatlahir());
        editor.putString(TANGGALLAHIR, user.getTanggallahir());
        editor.putString(SEX, user.getSex());
        editor.putString(GOLONGANDARAH, user.getGolongan_darah_id());
        editor.putString(DUSUN_ID, user.getDusun_id());
        editor.putString(ALAMAT, user.getAlamat_sekarang());
        editor.putString(AYAH, user.getNama_ayah());
        editor.putString(IBU, user.getNama_ibu());
        editor.putString(FOTO, user.getFoto());
        editor.putString(AGAMA, user.getAgama_id());
        editor.putString(KAWIN, user.getStatus_kawin_id());
        editor.putString(PEKERJAAN, user.getPekerjaan_id());
        editor.putString(WARGANEGARA, user.getWarganegara_id());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID,null));
        user.put(DESA_ID, sharedPreferences.getString(DESA_ID,null));
        user.put(NAMA, sharedPreferences.getString(NAMA,null));
        user.put(NIK, sharedPreferences.getString(NIK,null));
        user.put(TEMPATLAHIR, sharedPreferences.getString(TEMPATLAHIR,null));
        user.put(TANGGALLAHIR, sharedPreferences.getString(TANGGALLAHIR,null));
        user.put(SEX, sharedPreferences.getString(SEX,null));
        user.put(GOLONGANDARAH, sharedPreferences.getString(GOLONGANDARAH,null));
        user.put(DUSUN_ID, sharedPreferences.getString(DUSUN_ID,null));
        user.put(ALAMAT, sharedPreferences.getString(ALAMAT,null));
        user.put(AYAH, sharedPreferences.getString(AYAH,null));
        user.put(IBU, sharedPreferences.getString(IBU,null));
        user.put(FOTO, sharedPreferences.getString(FOTO,null));
        user.put(AGAMA, sharedPreferences.getString(AGAMA,null));
        user.put(KAWIN, sharedPreferences.getString(KAWIN,null));
        user.put(PEKERJAAN, sharedPreferences.getString(PEKERJAAN,null));
        user.put(WARGANEGARA, sharedPreferences.getString(WARGANEGARA,null));

        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public void logoutData(){

        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, Beranda.class);
        _context.startActivity(i);
        ((FotoProfil) _context).finish();

    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }


}

