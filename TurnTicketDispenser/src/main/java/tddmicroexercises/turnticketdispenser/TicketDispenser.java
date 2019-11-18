package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    //TODO:拟新增特性：VIP客户的票号从1001开始
    //TODO:拟新增特性：普通客户的票号从2001开始

    public TurnTicket getTurnTicket()
    {
        //TODO: 属于针对具体实现编程，不是针对抽象编程，违反依赖倒置和开闭原则
        int newTurnNumber = TurnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
