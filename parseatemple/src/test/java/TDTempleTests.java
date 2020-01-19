import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TDTempleTests {

    private TDTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TDTemplate("Hello, ${one}, ${two}, ${three}");
        template.set("one", "one");
        template.set("two", "two");
        template.set("three", "three");
    }

    @Test
    public void multipleVariables() throws Exception {
        //实现此模版的测试用例过程中发现：
        //当使用模版中的变量名进行模版变量赋值时，期望的是变量名，
        //如"Hello, ${one}, ${two}, ${three}" 赋值 "Hello, 1, ${two}, 3"
        assertTemplateEvaluateTo("Hello, one, two, three", template);
    }

    @Test
    public void unknownVariableAreIgnored() throws Exception {
        template.set("doesnotexist", "Hi");
        assertTemplateEvaluateTo("Hello, one, two, three", template);
    }

    @Test
    public void missingValueRaiseException() throws Exception {
        try {
            new TDTemplate("${foo}").evaluate();
            fail("evaluate() should throw an exception if a variable was left without a value!");
        }catch (MissingValueException expected){
            //异常中应该提供尽量多的信息
            assertEquals("No value for ${foo}", expected.getMessage());
        }
    }

    @Test
    public void variableGetProcessedJustOnce() throws Exception {
        template.set("one", "${one}");
        template.set("two", "${two}");
        template.set("three", "${three}");
        assertTemplateEvaluateTo("Hello, ${one}, ${two}, ${three}", template);
    }

    private void assertTemplateEvaluateTo(String result, TDTemplate template) {
        assertEquals(result, template.evaluate());
    }
}
