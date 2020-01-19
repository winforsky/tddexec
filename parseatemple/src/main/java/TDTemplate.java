import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDTemplate {
    private final Map<String, String> variables;
    private String variableValue;
    private String templateText;

    public TDTemplate(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String variable, String value) {
        this.variables.put(variable, value);
    }

    /*
    * 统一处理不同的片段类型
    * public String evaluate() {
        TDTemplateParse parse = new TDTemplateParse();
        List<TDSegment> segments = parse.parse(templateText);
        return concatenate(segments);
    }

    private String concatenate(List<TDSegment> segments) {
        StringBuilder result = new StringBuilder();
        for (TDSegment segment: segments){
            segment.append(result, variables);
        }
        return result.toString();
    }
    * */

    public String evaluate() {
        TDTemplateParse parse = new TDTemplateParse();
        List<String> segments = parse.parse(templateText);
        return concatenate(segments);
    }

    private String concatenate(List<String> segments) {
        StringBuilder result = new StringBuilder();
        for (String segment: segments){
            append(segment, result);
        }
        return result.toString();
    }

    private void append(String segment, StringBuilder result) {
        if (isVariable(segment)){
            evaluateVariable(segment, result);
        }else {
            result.append(segment);
        }
    }

    private void evaluateVariable(String segment, StringBuilder result) {
        String var = segment.substring(2, segment.length()-1);
        if (!variables.containsKey(var)){
            throw new MissingValueException("No value for " + segment);
        }
        result.append(variables.get(var));
    }

    private boolean isVariable(String segment) {
        return segment.startsWith("${") && segment.endsWith("}");
    }

}
