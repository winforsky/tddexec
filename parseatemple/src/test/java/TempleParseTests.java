import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TempleParseTests {

    @Test
    public void oneVariable() throws Exception {
        TDTemplate template = new TDTemplate("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }
}
