package com.example.busticketbooking;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BusRVModel implements Parcelable{
    private String busNum;
    private String src;
    private String dest;
    private String timings;
    private String price;
    private String BusID;

    public BusRVModel() {
    }

    public BusRVModel(String busNum, String src, String dest, String timings, String price, String busID ) {
        this.busNum = busNum;
        this.src = src;
        this.dest = dest;
        this.timings = timings;
        this.price = price;
        BusID = busID;
    }

    protected BusRVModel(Parcel in) {
        busNum = in.readString();
        src = in.readString();
        dest = in.readString();
        timings = in.readString();
        price = in.readString();
        BusID = in.readString();
    }

    public static final Creator<BusRVModel> CREATOR = new Creator<BusRVModel>() {
        @Override
        public BusRVModel createFromParcel(Parcel in) {
            return new BusRVModel(in);
        }

        @Override
        public BusRVModel[] newArray(int size) {
            return new BusRVModel[size];
        }
    };

    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String busID) {
        BusID = busID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(busNum);
        parcel.writeString(src);
        parcel.writeString(dest);
        parcel.writeString(timings);
        parcel.writeString(price);
        parcel.writeString(BusID);
    }
}
