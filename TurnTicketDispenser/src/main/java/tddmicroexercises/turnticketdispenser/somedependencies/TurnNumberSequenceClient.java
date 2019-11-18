package tddmicroexercises.turnticketdispenser.somedependencies;

import tddmicroexercises.turnticketdispenser.TurnNumberSequence;

public class TurnNumberSequenceClient
{
    // A class with the only goal of simulating a dependency on TurnNumberSequence
    // that has impact on the refactoring.

    public TurnNumberSequenceClient()
    {
        int nextUniqueTicketNumber;
        nextUniqueTicketNumber = new TurnNumberSequence().getNextTurnNumber();
        nextUniqueTicketNumber = new TurnNumberSequence().getNextTurnNumber();
        nextUniqueTicketNumber = new TurnNumberSequence().getNextTurnNumber();
    }
}
