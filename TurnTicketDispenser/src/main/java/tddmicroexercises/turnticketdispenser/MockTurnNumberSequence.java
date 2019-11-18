package tddmicroexercises.turnticketdispenser;

public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;
    private int callsCount;

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
    }

    public void verifyMethodGetNextTurnNumberCalledOnce() {
        if (this.callsCount != 1){
            //MOCK 比 STUB多一次校验
            throw new IllegalStateException("The method getNextTurnNumber() should be called one");
        }
    }

    @Override
    public int getNextTurnNumber() {
        this.callsCount++;
        return this.nextTurnNumber;
    }
}
