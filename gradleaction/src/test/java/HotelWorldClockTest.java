import CityClock.CityClock;
import PhoneClock.PhoneClock;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class HotelWorldClockTest {
    @Test
    public void test_london_time_should_be_1_after_phone_clock_set_to_beijing_time_9(){
        //Arrange
        CityClock londonClock = new CityClock(0);
        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        phoneClock.setCityClock(londonClock);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(1, londonClock.getTime());
    }
}
