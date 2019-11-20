package Clock;

import Clock.Clock;

public class CityClock extends Clock {
    private int utcZeroTime;

    public CityClock(int utcOffset) {
        super(utcOffset);
    }

    @Override
    public int getLocalTime() {
        return (super.utcOffset + this.utcZeroTime + 24) % 24;
    }

    public void setUtcZeroTime(int utcZeroTime) {
        this.utcZeroTime = utcZeroTime;
    }
}
