package tddmicroexercises.turnticketdispenser;

//DOC
public class TurnNumberSequence
{
    public static final int REGULAR_FIRST_NUMBER = 2001;
    public static final int VIP_FIRST_NUMBER = 1001;
    private static int turnNumber = 0;

    public TurnNumberSequence(int firstNumber) {
        turnNumber = firstNumber;
    }

    public TurnNumberSequence() {
        this(0);
    }

    public int getNextTurnNumber()
    {
        return turnNumber++;
    }


}
