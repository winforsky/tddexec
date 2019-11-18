package tddmicroexercises.textconvertor;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UnicodeFileToHtmlTextConverter
{
    private String fullFilenameWithPath;

    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    //TODO:新增特性：将一个unicode的纯文本字符串转化为HTML编码的字符串
    //TODO:用户意图：添加转换 & 字符串
    //TODO:用户意图：添加转换 > < 字符串
    //TODO:用户意图：添加转换 行分隔符 字符串
    public String convertToHtml() throws IOException
    {
        //TODO:依赖具体实现进行的编程，需要改成面向接口的编程，否则违反依赖倒置和开闭原则
        try (BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath)))
            {

            String line = reader.readLine();
            String html = "";
            while (line != null)
            {
                //TODO:直接依赖第三方库，违反依赖倒置和开闭原则，建议使用一个类来封装对第三方库的使用
                html += StringEscapeUtils.escapeHtml4(line);
                html += "<br />";
                line = reader.readLine();
            }
            return html;

        }
    }
}
