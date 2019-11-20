package Clock;

public abstract class Clock {
    protected int utcOffset;

    public Clock(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public abstract int getTime();
}
