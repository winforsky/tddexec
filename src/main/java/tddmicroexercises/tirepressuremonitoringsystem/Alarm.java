package tddmicroexercises.tirepressuremonitoringsystem;




//SUT system under test
public class Alarm
{
    public static final double LOW_PRESSURE_THRESHOLD = 17;
    public static final double HIGH_PRESSURE_THRESHOLD = 21;
    //    private final double lowPressureThreshold = 17;
//    private final double highPressureThreshold = 21;

    //TO DO:depend on a concrete Sensor violates the Dependency Inversion Principle and Open-Close Principle
    //TO DO:此处依赖具体的Sensor类，违反依赖倒置原则和开闭原则

//    private Sensor sensor = new Sensor();
    private Transducer sensor;

    private boolean alarmOn = false;

    public Alarm(){
        this.sensor = new Sensor();
    }

    public Alarm(Transducer sensor) {
        this.sensor = sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
