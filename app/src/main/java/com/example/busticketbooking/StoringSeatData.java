package com.example.busticketbooking;

import java.util.ArrayList;

public class StoringSeatData {
//    String BusID,Timings;
    ArrayList<Integer> BookedSeats=new ArrayList<>();

    public StoringSeatData(String busID, String timings, ArrayList<Integer> bookedSeats) {
//        BusID = busID;
//        Timings = timings;
        BookedSeats = bookedSeats;
    }

    public StoringSeatData(ArrayList<Integer> seatArrayList) {
    }

//    public String getBusID() {
//        return BusID;
//    }
//
//    public void setBusID(String busID) {
//        BusID = busID;
//    }
//
//    public String getTimings() {
//        return Timings;
//    }
//
//    public void setTimings(String timings) {
//        Timings = timings;
//    }

    public ArrayList<Integer> getBookedSeats() {
        return BookedSeats;
    }

    public void setBookedSeats(ArrayList<Integer> bookedSeats) {
        BookedSeats = bookedSeats;
    }
}
