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
        //实现此模版的测试用例过程中发现：
        //当使用模版中的变量名进行模版变量赋值时，期望的是变量名，
        //如"Hello, ${one}, ${two}, ${three}" 赋值 "Hello, 1, ${two}, 3"
        TDTemplate template = new TDTemplate("Hello, ${one}, ${two}, ${three}");
        template.set("one", "one");
        template.set("two", "two");
//        template.set("two", "${two}");
        //先记录问题，并专心完成当前的代码编写
        template.set("three", "three");
        assertEquals("Hello, one, two, three", template.evaluate());
    }

    @Test
    public void unknownVariableAreIgnored() throws Exception {
        TDTemplate template = new TDTemplate("Hello, ${name}");
        template.set("name", "Reader");
        template.set("doesnotexist", "Hi");
        assertEquals("Hello, Reader", template.evaluate());
    }
}
