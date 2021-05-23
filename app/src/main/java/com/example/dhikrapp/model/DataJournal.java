package com.example.dhikrapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataJournal implements Parcelable {
    private String ayat, deskripsi, nama_surah, tanggal;

    public DataJournal(){

    }
//    public DataJournal(String ayat, String deskripsi, String nama_surah, String tanggal){
//        this.ayat = ayat;
//        this.deskripsi = deskripsi;
//        this.nama_surah = nama_surah;
//        this.tanggal = tanggal;
//    }

    protected DataJournal(Parcel in) {
        ayat = in.readString();
        deskripsi = in.readString();
        nama_surah = in.readString();
        tanggal = in.readString();
    }

    public static final Creator<DataJournal> CREATOR = new Creator<DataJournal>() {
        @Override
        public DataJournal createFromParcel(Parcel in) {
            return new DataJournal(in);
        }

        @Override
        public DataJournal[] newArray(int size) {
            return new DataJournal[size];
        }
    };

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama_surah() {
        return nama_surah;
    }

    public void setNama_surah(String nama_surah) {
        this.nama_surah = nama_surah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ayat);
        parcel.writeString(deskripsi);
        parcel.writeString(nama_surah);
        parcel.writeString(tanggal);
    }
}
