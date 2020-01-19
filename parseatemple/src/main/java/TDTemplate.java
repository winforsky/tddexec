public class TDTemplate {
    private String variableValue;

    public TDTemplate(String templateText) {

    }

    public void set(String variable, String value) {
        this.variableValue = value;
    }

    public String evaluate() {
        return "Hello, " + this.variableValue;
    }
}
