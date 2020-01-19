import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TDVariableTest {
    private Map<String, String> variables;

    @Before
    public void setup() {
        variables = new HashMap<String, String>();
    }

    @Test
    public void variableText() {
        String name = "myname";
        String value = "myvalue";

        variables.put(name, value);
        Assert.assertEquals(value, new TDVariable(name).evaluate(variables));
    }

    @Test
    public void missingValueRaiseException() throws Exception {
        String name = "foo";
        try {
            new TDVariable(name).evaluate(variables);
            fail("evaluate() should throw an exception if a variable was left without a value!");
        } catch (MissingValueException expected) {
            //异常中应该提供尽量多的信息
            assertEquals("No value for ${" + name + "}", expected.getMessage());
        }
    }
}
