package com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Erlangga on 18/10/22.
 */

public class CoffeeDrinkNote implements Parcelable {
    private int id;
    private String nama;
    private String deskripsi;
    private String kategori;
    private String makananPelengkap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getMakananPelengkap() {
        return makananPelengkap;
    }

    public void setMakananPelengkap(String makananPelengkap) {
        this.makananPelengkap = makananPelengkap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.deskripsi);
        dest.writeString(this.kategori);
        dest.writeString(this.makananPelengkap);
    }

    public CoffeeDrinkNote() {
    }

    public CoffeeDrinkNote(int id, String title, String deskripsi, String date, String makananPelengkap) {
        this.id = id;
        this.nama = title;
        this.deskripsi = deskripsi;
        this.kategori = date;
        this.makananPelengkap = makananPelengkap;
    }

    private CoffeeDrinkNote(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.deskripsi = in.readString();
        this.kategori = in.readString();
        this.makananPelengkap = in.readString();
    }

    public static final Parcelable.Creator<CoffeeDrinkNote> CREATOR = new Parcelable.Creator<CoffeeDrinkNote>() {
        @Override
        public CoffeeDrinkNote createFromParcel(Parcel source) {
            return new CoffeeDrinkNote(source);
        }

        @Override
        public CoffeeDrinkNote[] newArray(int size) {
            return new CoffeeDrinkNote[size];
        }
    };
}
