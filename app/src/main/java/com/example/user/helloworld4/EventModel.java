package com.example.user.helloworld4;

/**
 * Created by user on 8/4/2016.
 */
public class EventModel {
    private String nama = "";
    private int image  = 0;
    private String tanggal = "";

    public EventModel(String nama, int image, String tanggal){
        this.nama = nama;
        this.image = image;
        this.tanggal = tanggal;
    }

    public String getNama(){
        return this.nama;
    }
    public int getImage(){
        return this.image;
    }

    public String getTanggal() {
        return tanggal;
    }
}
