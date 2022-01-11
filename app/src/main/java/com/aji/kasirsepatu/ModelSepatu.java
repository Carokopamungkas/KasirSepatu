package com.aji.kasirsepatu;

public class ModelSepatu {
    private String nama;
    private String merk;
    private String key;

    public  ModelSepatu(){

    }

    public ModelSepatu(String nama, String merk) {
        this.nama = nama;
        this.merk = merk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
