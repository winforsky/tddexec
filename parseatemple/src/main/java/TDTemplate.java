import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TDTemplate {
    private final Map<String, String> variables;
    private String templateText;

    public TDTemplate(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String variable, String value) {
        this.variables.put(variable, value);
    }

    public String evaluate() {
        TDTemplateParse parse = new TDTemplateParse();
        List<TDSegment> segments = parse.parseSegment(templateText);
        return concatenate(segments);
    }

    private String concatenate(List<TDSegment> segments) {
        StringBuilder result = new StringBuilder();
        for (TDSegment segment: segments){
            result.append(segment.evaluate(variables));
        }
        return result.toString();
    }
}
