package tddmicroexercises.turnticketdispenser;

//DOC
public class TurnNumberSequence
{
    private static int turnNumber = 0;

    public int getNextTurnNumber()
    {
        return turnNumber++;
    }


}
