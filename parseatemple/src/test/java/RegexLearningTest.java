import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearningTest {

    @Test
    public void testHowGroupCountWorks(){
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        Assert.assertEquals(2, matcher.groupCount());
    }

    @Test
    public void testFindStartAndEnd(){
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        Assert.assertTrue(matcher.find());
    }
}
