package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.junit.Assert.*;

//测试代码
public class AlarmTest {
    @Test
    public void testcheck() throws Exception {
        assertEquals(6, 2+4);
        //TODO:实现新特性：若前一次检查的胎压值在正常范围之外并保健，后一次检查的胎压值又回到正常范围，此时需要停止报警。
        //TODO:the alarm will be turned off before each checking of pressure
        //TODO:a normal pressure value after a value outside the range should stop the alarm


        //TO DO:检查到正常的胎压值时不应该报警
        //TO DO:检查到正常范围之外的胎压值时应该报警
        //TO DO:跟随在正常范围之外的胎压值之后的正常胎压值应该不会让之前所引发的警报停止

    }

    @Test
    public void test_a_normal_pressure_value_should_not_raise_the_alarm(){
        //Arrange
        //因为Alarm依赖Sensor的具体实现，为了增加灵活性和可测试性，需要修改实现方式
//        Alarm alarm = new Alarm();
        StubSensor stubSensor = new StubSensor();
        stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD);
        Alarm alarm = new Alarm(stubSensor);

        //Action
        alarm.check();

        //Assert
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void test_a_pressure_value_outside_the_range_should_raise_the_alarm(){
        //Arrange
        //因为Alarm依赖Sensor的具体实现，为了增加灵活性和可测试性，需要修改实现方式
//        Alarm alarm = new Alarm();
        StubSensor stubSensor = new StubSensor();
        stubSensor.arrangeNextPressurePsiValue(Alarm.HIGH_PRESSURE_THRESHOLD+1);
        Alarm alarm = new Alarm(stubSensor);

        //Action
        alarm.check();

        //Assert
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void test_a_normal_pressure_value_after_a_pressure_value_outside_the_range_should_not_stop_the_alarm(){
        //Arrange
        //因为Alarm依赖Sensor的具体实现，为了增加灵活性和可测试性，需要修改实现方式
//        Alarm alarm = new Alarm();
        StubSensor stubSensor = new StubSensor();
        stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD - 1);
        Alarm alarm = new Alarm(stubSensor);

        //Action
        alarm.check();

        //Assert
        assertTrue(alarm.isAlarmOn());

        stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD);

        //Action
        alarm.check();

        //Assert
        assertTrue(alarm.isAlarmOn());
    }

}