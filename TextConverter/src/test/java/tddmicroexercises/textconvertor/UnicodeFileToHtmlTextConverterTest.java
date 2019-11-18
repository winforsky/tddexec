package tddmicroexercises.textconvertor;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class UnicodeFileToHtmlTextConverterTest
{
    @Test
    public void testConvert(){
        Assert.assertEquals(3, 1+2);
    }

    @Test
    public void should_convert_empersand() throws IOException {
        //Arrange
        UnicodeFileToHtmlTextConverter convert = new UnicodeFileToHtmlTextConverter(new StringReader("H&M"));

        //Act

        //Assert
        Assert.assertEquals("H&amp;M<br />", convert.convertToHtml());
    }

    @Test
    public void should_convert_greater_or_less() throws IOException {
        //Arrange
        UnicodeFileToHtmlTextConverter convert = new UnicodeFileToHtmlTextConverter(new StringReader("H>_<M||"));

        //Act

        //Assert
        Assert.assertEquals("H&gt;_&lt;M||<br />", convert.convertToHtml());
    }

    @Test
    public void should_convert_line_break() throws IOException {
        //Arrange
        UnicodeFileToHtmlTextConverter convert = new UnicodeFileToHtmlTextConverter(new StringReader("H\nM||"));

        //Act

        //Assert
        Assert.assertEquals("H<br />M||<br />", convert.convertToHtml());
    }

    @Test
    public void should_convert_ampersand_using_String_Escaper() throws IOException {
        //Arrange
        StringEscaper stringEscaper = new StringEscaper();
        UnicodeFileToHtmlTextConverter convert = new UnicodeFileToHtmlTextConverter(new StringReader("H&M"), stringEscaper);

        //Act

        //Assert
        Assert.assertEquals("H&amp;M<br />", convert.convertToHtml());
    }


}
