import Clock.CityClock;
import HotelWorldClockSystem.HotelWorldClockSystem;
import Clock.PhoneClock;
import org.junit.Assert;
import org.junit.Test;

public class HotelWorldClockTest {
    @Test
    public void test_london_time_should_be_1_after_phone_clock_set_to_beijing_time_9(){
        //Arrange
        CityClock londonClock = new CityClock(0);
        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        HotelWorldClockSystem clockSystem = new HotelWorldClockSystem();
        clockSystem.attach(londonClock);
        phoneClock.setClockSystem(clockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(1, londonClock.getTime());
    }

    @Test
    public void test_newyork_time_should_be_20_after_phone_clock_set_to_beijing_time_9(){
        //Arrange
        CityClock newyourkClock = new CityClock(-5);
        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        HotelWorldClockSystem clockSystem = new HotelWorldClockSystem();
        clockSystem.attach(newyourkClock);
        phoneClock.setClockSystem(clockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(20, newyourkClock.getTime());
    }

    @Test
    public void test_london_time_should_be_1_newyork_time_should_be_20_after_phone_clock_set_to_beijing_time_9(){
        //Arrange
        CityClock londonClock = new CityClock(0);
        CityClock newyourkClock = new CityClock(-5);

        HotelWorldClockSystem clockSystem = new HotelWorldClockSystem();
        clockSystem.attach(londonClock);
        clockSystem.attach(newyourkClock);

        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        phoneClock.setClockSystem(clockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(1, londonClock.getTime());
        Assert.assertEquals(20, newyourkClock.getTime());
    }

    @Test
    public void test_phone_time_should_be_9_after_phone_clock_set_to_beijing_time_9(){
        //Arrange
        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(9, phoneClock.getTime());
    }

    @Test
    public void test_moscow_time_should_be_5_after_phone_clock_set_to_beijing_time_9(){
        //Arrange
        CityClock moscowClock = new CityClock(4);
        PhoneClock phoneClock = new PhoneClock(8);

        //Act
        HotelWorldClockSystem clockSystem = new HotelWorldClockSystem();
        clockSystem.attach(moscowClock);
        phoneClock.setClockSystem(clockSystem);
        phoneClock.setTime(9);

        //Assert
        Assert.assertEquals(5, moscowClock.getTime());
    }
}
