public class TDPlainText extends TDSegment{
    private String text;

    public TDPlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        return text.equals(((TDPlainText)obj).text);
    }
}
