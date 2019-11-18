package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowPressureThreshold = 17;
    private final double highPressureThreshold = 21;

    //TODO:depend on a concrete Sensor violates the Dependency Inversion Principle and Open-Close Principle
    //TODO:此处依赖具体的Sensor类，违反依赖倒置原则和开闭原则
    private Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
