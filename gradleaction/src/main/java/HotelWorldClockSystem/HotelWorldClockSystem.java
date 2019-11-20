package HotelWorldClockSystem;

import CityClock.CityClock;

import java.util.ArrayList;

public class HotelWorldClockSystem {
    private ArrayList<CityClock> cityClocks =new ArrayList<CityClock>();

    public void attach(CityClock cityClock) {
        this.cityClocks.add(cityClock);
    }

    public ArrayList<CityClock> getCityClocks() {
        return this.cityClocks;
    }
}
