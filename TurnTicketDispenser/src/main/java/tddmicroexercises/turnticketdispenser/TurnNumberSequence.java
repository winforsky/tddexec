package tddmicroexercises.turnticketdispenser;

//DOC
public class TurnNumberSequence
{
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
