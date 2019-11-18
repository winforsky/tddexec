package tddmicroexercises.textconvertor;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringEscaper {
    public String escapeHtml4(String line) {
        return StringEscapeUtils.escapeHtml4(line);
    }
}
