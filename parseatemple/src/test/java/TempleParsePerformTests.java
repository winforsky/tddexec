import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TempleParsePerformTests {
    private TDTemplate template;

    @Before
    public void setUp() throws Exception {
        //模版中包含100个单词，20个变量，每个变量长度大约为15个字符
        template = new TDTemplate("Hello, ${one}, ${two}, ${three}");
        template.set("one", "one");
        template.set("two", "two");
        template.set("three", "three");
    }

    @Test
    public void multipleVariables() throws Exception {
        long excepted = 200;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        Assert.assertTrue("Rendering the template book "+ time +" ms while the target was "+ excepted +" ms", time < excepted);
    }
}
