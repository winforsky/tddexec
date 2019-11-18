package tddmicroexercises.tirepressuremonitoringsystem;

public class StubSensor implements Transducer {
    private double nextPressurePsiValue;

    public void arrangeNextPressurePsiValue(double nextPressurePsiValue) {
        this.nextPressurePsiValue = nextPressurePsiValue;
    }

    @Override
    public double popNextPressurePsiValue() {
        return this.nextPressurePsiValue;
    }
}
