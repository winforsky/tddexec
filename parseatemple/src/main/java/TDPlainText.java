import java.util.Map;

public class TDPlainText implements TDSegment {
    private String text;

    public TDPlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        return text.equals(((TDPlainText)obj).text);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return text;
    }
}
