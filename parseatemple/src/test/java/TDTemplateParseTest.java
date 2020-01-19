import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TDTemplateParseTest {

    //这里发现一个问题：
    //测试类中的方法并没有准备任何数据，也没有配置任何对象状态
    //所以：也许这个方法或许应该是静态方法

    @Test
    public void emptyTemplateRendersAsEmptyString(){
        List<String> segments = parse("");
        assertSegments(segments, "");
    }

    @Test
    public void templateWithOnlyPlainText(){
        List<String> segments = parse("plain text only");
        assertSegments(segments, "plain text only");
    }

    @Test
    public void templateWithMultiVariables(){
        List<String> segments = parse("${a}:${b}:${c}");
        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    @Test
    public void templateWithMultiVariablesIntoSegment(){
        //这里为了保持兼容原来的测试，保留原来的方法，新增需要的方法
        TDTemplateParse parse = new TDTemplateParse();
        List<TDSegment> segments = parse.parseSegment("a ${b} c ${d}");
        assertSegments(segments, new TDPlainText("a "), new TDVariable("b"), new TDPlainText(" c "), new TDVariable("d"));
    }


    //利用变长参数的语法糖来实现
    private void assertSegments(List<? extends  Object> actual, Object... expected) {
        Assert.assertEquals("Number of segments does not match", expected.length, actual.size());
        Assert.assertEquals(Arrays.asList(expected), actual);
    }

    private List<String> parse(String templateText) {
        TDTemplateParse parse = new TDTemplateParse();
        return parse.parse(templateText);
    }


}
