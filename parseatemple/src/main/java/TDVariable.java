import java.util.Map;

public class TDVariable implements TDSegment {
    private String text;

    public TDVariable(String text) {
        this.text = text;
    }
    @Override
    public boolean equals(Object obj) {
        return text.equals(((TDVariable)obj).text);
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        return null;
    }
}
