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
//        this.variableValue = value;
        this.variables.put(variable, value);
    }

    public String evaluate() {

        TDTemplateParse parse = new TDTemplateParse();
        List<String> segments = parse.parse(templateText);
        StringBuilder result = new StringBuilder();
        for (String segment: segments){
            append(segment, result);
        }
        return result.toString();
    }

    private void append(String segment, StringBuilder result) {
        if (segment.startsWith("${") && segment.endsWith("}")){
            String var = segment.substring(2, segment.length()-1);
            if (!variables.containsKey(var)){
                throw new MissingValueException("No value for " + segment);
            }
            result.append(variables.get(var));
        }else {
            result.append(segment);
        }
    }

    private String replaceVariables() {
        String result = templateText;
        for (Map.Entry<String, String> entry :
                variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result) {
        Matcher matcher = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
        if (matcher.find()) {
            throw new MissingValueException("No value for " + matcher.group());
        }
    }
}
