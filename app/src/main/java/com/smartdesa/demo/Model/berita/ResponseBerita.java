package com.smartdesa.demo.Model.berita;

import java.util.List;

public class ResponseBerita {

    private int current_page;
    private List<ModelBerita> data;

    public int getKode() {
        return current_page;
    }

    public void setKode(int kode) {
        this.current_page = kode;
    }

    public List<ModelBerita> getData() {
        return data;
    }

    public void setData(List<ModelBerita> data) {
        this.data = data;
    }
}
