package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void testcheck() throws Exception {
        assertEquals(6, 2+4);
        //TODO:实现新特性：若前一次检查的胎压值在正常范围之外并保健，后一次检查的胎压值又回到正常范围，此时需要停止报警。
        //TODO:the alarm will be turned off before each checking of pressure
        //TODO:a normal pressure value after a value outside the range should stop the alarm



    }

}