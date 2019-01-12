package com.distributor_ikan.model;

public class list_ikan {
    String namaikan;
    String stok;

    public list_ikan() {
    }

    String harga;

    public list_ikan(String namaikan, String stok, String harga, String penjual) {
        this.namaikan = namaikan;
        this.stok = stok;
        this.harga = harga;
        this.penjual = penjual;
    }

    String penjual;


    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPenjual() {
        return penjual;
    }

    public void setPenjual(String penjual) {
        this.penjual = penjual;
    }

    public String getNamaikan() {
        return namaikan;
    }

    public void setNamaikan(String namaikan) {
        this.namaikan = namaikan;
    }


}
