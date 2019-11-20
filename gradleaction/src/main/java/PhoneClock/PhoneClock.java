package PhoneClock;

import CityClock.CityClock;
import HotelWorldClockSystem.HotelWorldClockSystem;

public class PhoneClock {
    private int utcOffset;
    private HotelWorldClockSystem clockSystem;

    public PhoneClock(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public void setTime(int time) {
        for (CityClock cityClock : this.clockSystem.getCityClocks()) {
            cityClock.setUtcZeroTime(time - this.utcOffset);
        }
    }

    public void setClockSystem(HotelWorldClockSystem clockSystem) {
        this.clockSystem = clockSystem;
    }
}
