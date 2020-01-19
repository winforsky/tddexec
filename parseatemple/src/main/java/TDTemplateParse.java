import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDTemplateParse {
    public List<String> parse(String templateText) {
        List<String> segments = new ArrayList<String>();

        //高级解析逻辑层
        int index = collectSegments(segments, templateText);
        addTail(segments, templateText, index);
        addEmptyStringIfTemplateWasEmpty(segments);

        return segments;
    }

    //收集变量和中间的纯文本
    private int collectSegments(List<String> segments, String src) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(src);
        int index = 0;
        while (matcher.find()) {
            //处理变量前面的文本
            addPrecedingPlainText(segments, src, matcher, index);
            //处理变量
            addVariable(segments, src, matcher);
            index = matcher.end();
        }
        return index;
    }

    //处理尾部，如果还有没有处理完的文本，直接补上
    private void addTail(List<String> segments, String src, int index) {
        if (index < src.length()) {
            segments.add(src.substring(index));
        }
    }

    private void addEmptyStringIfTemplateWasEmpty(List<String> segments) {
        if (segments.isEmpty()) {
            segments.add("");
        }
    }

    private void addVariable(List<String> segments, String src, Matcher matcher) {
        segments.add(src.substring(matcher.start(), matcher.end()));
    }

    private void addPrecedingPlainText(List<String> segments, String src, Matcher matcher, int index) {
        if (index != matcher.start()) {
            segments.add(src.substring(index, matcher.start()));
        }
    }

    public List<TDSegment> parseSegment(String src) {
        List<TDSegment> segments = new ArrayList<TDSegment>();
        List<String> strings = parse(src);
        for (String s : strings) {
            //注意这里，消除if-else的关键，提前判定，并非直接使用时再进行判定
            if (TDTemplate.isVariable(s)) {
                segments.add(new TDVariable(s.substring(2, s.length() - 1)));
            } else {
                segments.add(new TDPlainText(s));
            }
        }
        return segments;
    }
}
