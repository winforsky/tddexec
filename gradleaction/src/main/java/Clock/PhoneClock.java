package Clock;

import HotelWorldClockSystem.HotelWorldClockSystem;

public class PhoneClock extends Clock {
    private HotelWorldClockSystem clockSystem;
    private int localTime;

    public PhoneClock(int utcOffset) {
        super(utcOffset);
    }

    public void setLocalTime(int localTime) {
        this.localTime = localTime;
        if (this.clockSystem == null){
            return;
        }
        for (CityClock cityClock : this.clockSystem.getCityClocks()) {
            cityClock.setUtcZeroTime(localTime - super.utcOffset);
        }
    }

    public void setClockSystem(HotelWorldClockSystem clockSystem) {
        this.clockSystem = clockSystem;
    }

    @Override
    public int getLocalTime() {
        return this.localTime;
    }
}