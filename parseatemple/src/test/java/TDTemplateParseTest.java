import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TDTemplateParseTest {

    @Test
    public void emptyTemplateRendersAsEmptyString(){
        List<String> segments = parse("");
        Assert.assertEquals("Number of segments", 1, segments.size());
        Assert.assertEquals("", segments.get(0));
    }

    private List<String> parse(String templateText) {
        TDTemplateParse parse = new TDTemplateParse();
        return parse.parse(templateText);
    }

    @Test
    public void templateWithOnlyPlainText(){
        List<String> segments = parse("plain text only");
        Assert.assertEquals("Number of segments", 1, segments.size());
        Assert.assertEquals("plain text only", segments.get(0));
    }
}
