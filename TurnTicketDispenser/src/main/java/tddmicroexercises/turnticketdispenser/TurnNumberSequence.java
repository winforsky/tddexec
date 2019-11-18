package tddmicroexercises.turnticketdispenser;

//DOC
public class TurnNumberSequence
{
    private static int turnNumber = 0;

    public static int getNextTurnNumber()
    {
        return turnNumber++;
    }
}
