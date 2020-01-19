public class TDTemplate {
    private String variableValue;
    private String templateText;

    public TDTemplate(String templateText) {
        this.templateText = templateText;
    }

    public void set(String variable, String value) {
        this.variableValue = value;
    }

    public String evaluate() {
//        return "Hello, " + this.variableValue;
        return templateText.replaceAll("\\$\\{name\\}", variableValue);
    }
}
