package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void testcheck() throws Exception {
        assertEquals(6, 2+4);
        //TODO:实现新特性：若前一次检查的胎压值在正常范围之外并保健，后一次检查的胎压值又回到正常范围，此时需要停止报警。

    }

}