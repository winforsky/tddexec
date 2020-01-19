import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TempleParseTests {

    @Test
    public void oneVariableWithReader() throws Exception {
        TDTemplate template = new TDTemplate("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void oneVariableWithWriter() throws Exception {
        TDTemplate template = new TDTemplate("Hello, ${name}");
        //用另一个值来做三角定位
        //去掉一个硬编码代码
        //三角法表示会从多个方向同时入手来确保出恰当的实现
        //三角法有助于防止过早优化、功能蔓延以及总体上的过度设计
        template.set("name", "Writer");
        assertEquals("Hello, Writer", template.evaluate());
    }

    @Test
    public void oneVariableTemplateWithReader() throws Exception {
        //用另一个值来做三角定位
        //去掉一个硬编码代码
        TDTemplate template = new TDTemplate("Hi, ${name}");
        template.set("name", "Reader");
        assertEquals("Hi, Reader", template.evaluate());
    }

    @Test
    public void multipleVariables() throws Exception {
        TDTemplate template = new TDTemplate("Hello, ${one}, ${two}, ${three}");
        template.set("one", "one");
        template.set("two", "two");
        template.set("three", "three");
        assertEquals("Hello, one, two, three", template.evaluate());
    }
}
