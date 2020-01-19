import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TDTemplateParseTest {

    @Test
    public void emptyTemplateRendersAsEmptyString(){
        TDTemplateParse parse = new TDTemplateParse();
        List<String> segments = parse.parse("");
        Assert.assertEquals("Number of segments", 1, segments.size());
        Assert.assertEquals("", segments.get(0));
    }
}
