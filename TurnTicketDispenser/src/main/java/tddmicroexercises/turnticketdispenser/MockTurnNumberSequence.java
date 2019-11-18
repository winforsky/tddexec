package tddmicroexercises.turnticketdispenser;

public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
    }

    public void verifyMethodGetNextTurnNumberCalledOnce() {

    }
}
