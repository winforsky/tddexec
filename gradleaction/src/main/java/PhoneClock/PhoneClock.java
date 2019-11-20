package PhoneClock;

import CityClock.CityClock;

public class PhoneClock {
    private int utcOffset;
    private CityClock cityClock;

    public PhoneClock(int utcOffset) {

        this.utcOffset = utcOffset;
    }

    public void setCityClock(CityClock cityClock) {

        this.cityClock = cityClock;
    }

    public void setTime(int time) {
        this.cityClock.setUtcZeroTime(time - this.utcOffset);
    }
}
