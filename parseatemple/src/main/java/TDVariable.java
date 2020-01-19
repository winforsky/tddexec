public class TDVariable extends TDSegment {
    private String text;

    public TDVariable(String text) {
        this.text = text;
    }
    @Override
    public boolean equals(Object obj) {
        return text.equals(((TDVariable)obj).text);
    }
}
