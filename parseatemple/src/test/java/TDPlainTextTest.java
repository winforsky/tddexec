import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TDPlainTextTest {

    @Test
    public void plainText() {
        String text ="abc def";
        Map<String, String> variables = new HashMap<String, String>();
        Assert.assertEquals(text, new TDPlainText(text).evaluate(variables));
    }
}
