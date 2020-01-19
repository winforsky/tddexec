import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TDVariableTest {
    @Test
    public void variableText() {
        String name ="myname";
        String value ="myvalue";
        Map<String, String> variables = new HashMap<String, String>();
        variables.put(name, value);
        Assert.assertEquals(value, new TDVariable(name).evaluate(variables));
    }
}
