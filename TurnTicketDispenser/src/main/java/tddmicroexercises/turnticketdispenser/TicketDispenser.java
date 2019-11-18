package tddmicroexercises.turnticketdispenser;

//SUT system under test
public class TicketDispenser
{
    //TODO:拟新增特性：VIP客户的票号从1001开始
    //TODO:拟新增特性：普通客户的票号从2001开始


    private TurnNumberSequence turnNumberSequence;
    public TicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TicketDispenser() {
        this.turnNumberSequence = new TurnNumberSequence();
    }

    public TurnTicket getTurnTicket()
    {
        //TODO: 属于针对具体实现编程，不是针对抽象编程，违反依赖倒置和开闭原则
        int newTurnNumber = this.turnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }

    //TO DO: 新得到的票号 比 之前得到的票号 大
    //TO DO: 新得到的票号 比 另一台取号机上之前得到的票号 大
    //TODO: 给定取号机11号，那么取号机应该能得到11号
}
