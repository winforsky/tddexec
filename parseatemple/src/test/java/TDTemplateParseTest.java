import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TDTemplateParseTest {

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
