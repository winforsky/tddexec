package tddmicroexercises.turnticketdispenser;

import org.junit.Assert;
import org.junit.Test;

public class TicketDispenserTest
{
    //TODO:拟新增特性：VIP客户的票号从1001开始
    //TODO:拟新增特性：普通客户的票号从2001开始

    @Test
    public void test_getTurnTicket()
    {
        //TODO: 属于针对具体实现编程，不是针对抽象编程，违反依赖倒置和开闭原则
        Assert.assertFalse ("false", false);
    }

    //TO DO: 新得到的票号 比 之前得到的票号 大
    //TO DO: 新得到的票号 比 另一台取号机上之前得到的票号 大
    //TO DO: 给定取号机11号，那么取号机应该能得到11号

    @Test
    public void test_a_new_ticket_number_should_bigger_than_previous_ticket_number(){
        //Arrange
        TicketDispenser ticketDispenser = new TicketDispenser();
        TurnTicket previousTicket = ticketDispenser.getTurnTicket();

        //ACTION
        TurnTicket lastTicket = ticketDispenser.getTurnTicket();

        //ASSERT
        Assert.assertEquals(1, lastTicket.getTurnNumber() - previousTicket.getTurnNumber());
    }

    @Test
    public void test_a_new_ticket_number_should_bigger_than_previous_ticket_number_from_another_ticket_dispenser(){
        //Arrange
        TicketDispenser anotherTicketDispenser = new TicketDispenser();
        TicketDispenser ticketDispenser = new TicketDispenser();
        TurnTicket previousTicket = anotherTicketDispenser.getTurnTicket();

        //ACTION
        TurnTicket lastTicket = ticketDispenser.getTurnTicket();

        //ASSERT
        Assert.assertEquals(1, lastTicket.getTurnNumber() - previousTicket.getTurnNumber());
    }

    @Test
    public void test_a_new_ticket_number_should_11_when_given_ticket_number_11_from_ticket_dispenser(){
        //Arrange
        MockTurnNumberSequence turnNumberSequence = new MockTurnNumberSequence();
        turnNumberSequence.arrangeNextTurnNumber(11);
        TicketDispenser ticketDispenser = new TicketDispenser(turnNumberSequence);

        //ACTION
        TurnTicket ticket = ticketDispenser.getTurnTicket();

        //ASSERT
        Assert.assertEquals(11, ticket.getTurnNumber());
        turnNumberSequence.verifyMethodGetNextTurnNumberCalledOnce();
    }

    @Test
    public void test_ticket_number_sequence_of_the_vip_customer_starts_from_1001(){
        //Arrange
        TurnNumberSequence vipTurnNumberSequence = new TurnNumberSequence(1001);
        TicketDispenser ticketDispenser = new TicketDispenser(vipTurnNumberSequence);

        //ACTION
        TurnTicket ticket = ticketDispenser.getTurnTicket();

        //ASSERT
        Assert.assertEquals(1001, ticket.getTurnNumber());
    }
}
