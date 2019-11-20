package Clock;

import HotelWorldClockSystem.HotelWorldClockSystem;

public class PhoneClock extends Clock {
    private HotelWorldClockSystem clockSystem;
    private int time;

    public PhoneClock(int utcOffset) {
        super(utcOffset);
    }

    public void setTime(int time) {
        this.time = time;
        if (this.clockSystem == null){
            return;
        }
        for (CityClock cityClock : this.clockSystem.getCityClocks()) {
            cityClock.setUtcZeroTime(time - super.utcOffset);
        }
    }

    public void setClockSystem(HotelWorldClockSystem clockSystem) {
        this.clockSystem = clockSystem;
    }

    @Override
    public int getTime() {
        return this.time;
    }
}
