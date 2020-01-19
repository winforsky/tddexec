import java.util.HashMap;
import java.util.Map;

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
//        return "Hello, " + this.variableValue;
        //注意这里的硬编码：遍历名
//        return templateText.replaceAll("\\$\\{name\\}", variableValue);
        String result = templateText;
        for (Map.Entry<String, String> entry :
                variables.entrySet()) {
            String regex = "\\$\\{"+entry.getKey()+"\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }
}
